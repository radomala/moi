package postgre.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.entiteDao.IMembreDao;
import postgre.mediatheque.metier.IMembreMetier;
import postgre.mediatheque.util.MediathequeException;



public class main {



	public static void main(String[] args) throws MediathequeException {
		ListableBeanFactory bfa = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
		IMembreDao membredao= (IMembreDao) bfa.getBean("iMembreDao");
		
		ListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("persistance-context.xml"));
		IMembreMetier membremetier=(IMembreMetier) bf.getBean("iMembreMetier");
		
		 
		try{
		//*****************************ADD VIA DAO*********************************** 
		/*Membre membre= new Membre("tatata","alteca","alteca","alteca","alteca","alteca");
		membredao.add(membre);
		System.out.println("est creer");*/
			
		//******************************GET UN MEMBRE VIA DAO********************************** 	
		//Membre m= new Membre();
		//m=membredao.getMembre("onyrady@yahoo.fr");
		//System.out.println(m.getAdresse() + m.getMail()+ m.getMotdepasse()+ m.getPhone());
			
		//******************************GET ALL MAMBRE VIA DAO********************************** 
		List <Membre> allMembre = new ArrayList<Membre>();
		allMembre=membredao.getMembreAll();
		for(Membre m : allMembre){
			System.out.println(m.getMail() +" "+ m.getAdresse()+ " " + m.getNom());
		}
		
		
		//******************************GET ALL MAMBRE VIA DAO********************************** 	
		/*membredao.delete("alteca");
		List <Membre> allMembre = new ArrayList<Membre>();
		allMembre=membredao.getMembreAll();
		for(Membre m : allMembre){
			System.out.println(m.getMail() +" "+ m.getAdresse()+ " " + m.getNom());
		}
		*/
		
		
		//Membre membre= new Membre("alt@agpi.fr","1234","rado","alteca","alteca","alteca");
		//membremetier.add(membre);
		
			//******************************GET UN MEMBRE VIA METIER********************************** 	
			/*Membre m= new Membre();
			m=membremetier.getMembreByMail("onyrady@yahoo.fr");
			System.out.println(m.getAdresse() + m.getMail()+ m.getMotdepasse()+ m.getPhone());
			*/
			
			//******************************GET UN MEMBRE VIA METIer ********************************** 	
			/*Membre m2= new Membre();
			m2=membredao.getMembreByName("Rado");
			System.out.println(m2.getAdresse() + m2.getMail()+ m2.getMotdepasse()+ m2.getPhone());
			
			
			Membre membre= new Membre("lolol","alteca","alteca","alteca","alteca","alteca");
			membredao.existMembre(membre);*/
		
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new MediathequeException("erreur oh");
		}
		
		
		
	}

}
