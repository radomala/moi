package postgre.mediatheque.controleur;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.metier.IMembreMetier;
import postgre.mediatheque.util.MediathequeException;



@Controller
public class MediathequeController {

	
	private static final Logger monlog = Logger.getLogger(MediathequeController.class);
	
@Autowired
	private IMembreMetier imembreMetier;

	/*public void setImembreMetier(IMembreMetier imembreMetier) {
		this.imembreMetier = imembreMetier;
	}*/

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) throws MediathequeException {
		Membre membre = new Membre();
		map.put("membre", membre);
		map.put("membreAll", imembreMetier.getMembreAll());
		return "membre";
	}

	@RequestMapping(value = "/membre.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Membre membre, BindingResult result, @RequestParam int action,
			Map<String, Object> map) throws MediathequeException {
		Membre membreResult = new Membre();

		switch (action) {
		case 1:
			try {
				imembreMetier.add(membre);
				membreResult = membre;
				monlog.warn("membre crée" + membre.getMail());
				break;
			} catch (Exception e) {
				monlog.warn(e.toString() + "membre n'est pas crée " + membre.getMail());
				throw new MediathequeException("membre n'est pas crée");
				
			}
			
			
		case 2:
			imembreMetier.edit(membre);
			membreResult = membre;
			break;
		case 3:
			imembreMetier.delete(membre.getMail());;
			membreResult = new Membre();
			break;

		case 4:
			Membre m= imembreMetier.getMembreByMail(membre.getMail());
			membreResult = m!=null ? m : new Membre();
			break;
		
		case 5:
			Membre m2= imembreMetier.getMembreByName(membre.getNom());
			membreResult = m2!=null ? m2 : new Membre();
			break;
		}
		map.put("membre", membreResult);
		map.put("membreAll", imembreMetier.getMembreAll());
		return "membre";
	}

}
