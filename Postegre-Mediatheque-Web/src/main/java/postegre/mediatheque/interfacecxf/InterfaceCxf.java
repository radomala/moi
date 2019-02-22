package postegre.mediatheque.interfacecxf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import postgre.mediatheque.entite.Membre;
import postgre.mediatheque.util.MediathequeException;

@WebService

public interface InterfaceCxf {


	public abstract void add(Membre membre) throws MediathequeException;


	public abstract void edit(Membre membre) throws MediathequeException;


	public abstract void delete(String mail) throws MediathequeException;


	public abstract Membre getMembreByMail(String mail) throws MediathequeException;


	public abstract List getMembreAll() throws MediathequeException;


	public abstract Membre getMembreByName(String nom) throws MediathequeException;


	public abstract void deleteAllMembre() throws MediathequeException;


	public abstract boolean existMembre(Membre membre) throws MediathequeException;
}


