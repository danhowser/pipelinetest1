package com.nanou.avocat.DAO;
import java.util.*;
import com.nanou.avocat.entities.*;

public interface IAvocatDAO {
	  public Long ajouterAvocat(Avocat a);
	  public void updateAvocat(Avocat a);
	  public void deleteAvocat(long id);
	  public List<Avocat> avocatParVille(Long idVille);
	  public List<Avocat> avocatParDomaine(Long idDomaine);
	  public List<Avocat> avocatParNom(String nom);
	  public List<Avocat> listAvocat();
	  
	  
	  public Long ajouterUser(Utilisateur a);
	  public void updateUser(Utilisateur a);
	  public void deleteUser(long id);
	  public List<Avocat> userParNom(String nom);
	  public List<Avocat> userParMail(String mail);
	  public List<Avocat> listUser();
	  
	  
	  public void ajouterMessage(Message m);
	  public List<Message> messageParUser(Long idUser);
	  public List<Avocat> messageParAvocat(Long idAvocat);
	  public List<Avocat> listMessage();
	  
	  
	  public void updateReview(Note n);
	  
	  
	  public void ajouterHoraire(Horaire h);
	  public void updateHoraire(Horaire h);
	  
	  
	  public List<Ville> listVille();
	  
	  public List<Langue> listLangue();
	  
	  public List<Domaine> listDomaine();
	  
	  
	  
	  
	  

}
