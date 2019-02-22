package postegre.mediatheque.webCxf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import postegre.mediatheque.interfacecxf.InterfaceCxf;
import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.metier.IMembreMetier;
import postgre.mediatheque.util.MediathequeException;

//@WebService(targetNamespace="http://www.mediatheque.fr/ws/media", endpointInterface = "postegre.mediatheque.interfacecxf.InterfaceCxf")
@WebService(serviceName="mediathequeMmebre",targetNamespace="http://www.mediatheque.fr/ws/media")
public class MediathequeWebService  implements InterfaceCxf{
	
	@Autowired
	IMembreMetier iMembreMetier;
	
	@WebMethod(exclude=true)
	public void setiMembreMetier(IMembreMetier iMembreMetier) {
		this.iMembreMetier = iMembreMetier;
	}
	
	
	
	@WebMethod(operationName="add")
	public void add(@WebParam(name="membre")Membre membre) throws MediathequeException {	
		iMembreMetier.add(membre);
	}
	
	@WebMethod(operationName="edit")
	public void edit(@WebParam(name="membre")Membre membre) throws MediathequeException {
		iMembreMetier.edit(membre);

	}
	@WebMethod(operationName="delete")
	public void delete(@WebParam(name="mail")String mail) throws MediathequeException {
		iMembreMetier.delete(mail);

	}
	@WebMethod(operationName="getMembreByMail")
	public Membre getMembreByMail(@WebParam(name="mail")String mail) throws MediathequeException {
		return iMembreMetier.getMembreByMail(mail);
		
	}
	@WebMethod(operationName="getMembreAll")
	public List getMembreAll() throws MediathequeException {
		
		return iMembreMetier.getMembreAll();
	}

	@Override
	@WebMethod(operationName="getMembreByName")
	public Membre getMembreByName(@WebParam(name="nom")String nom) throws MediathequeException {
	
		return iMembreMetier.getMembreByName(nom);
	}

	@Override
	@WebMethod(operationName="deleteAllMembre")
	public void deleteAllMembre() throws MediathequeException {
		iMembreMetier.deleteAllMembre();
		
	}


	@Override
	@WebMethod(operationName="existMembre")
	public boolean existMembre(@WebParam(name="membre")Membre membre) throws MediathequeException {
		
		return iMembreMetier.existMembre(membre);
	}

	
	/*public void add(Membre membre) throws MediathequeException {	
	iMembreMetier.add(membre);
}

public void edit(Membre membre) throws MediathequeException {
	iMembreMetier.edit(membre);

}

public void delete(String mail) throws MediathequeException {
	iMembreMetier.delete(mail);

}
public Membre getMembreByMail(String mail) throws MediathequeException {
	return iMembreMetier.getMembreByMail(mail);
	
}

public List getMembreAll() throws MediathequeException {
	
	return iMembreMetier.getMembreAll();
}



public Membre getMembreByName(String nom) throws MediathequeException {

	return iMembreMetier.getMembreByName(nom);
}



public void deleteAllMembre() throws MediathequeException {
	iMembreMetier.deleteAllMembre();
	
}




public boolean existMembre(Membre membre) throws MediathequeException {
	
	return iMembreMetier.existMembre(membre);
}*/
}

