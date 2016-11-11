package com.nanou.avocat.DAO;
import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import com.nanou.avocat.entities.*;

@Transactional
public interface IAvocatDAO {
	  public Long ajouterAvocat(Avocat a);
	  public void updateAvocat(Avocat a);
	  public void deleteAvocat(Long id);
	  public List<Avocat> avocatParVille(String nomVille);
	  public List<Avocat> avocatParDomaine(String nomDomaine);
	  public List<Avocat> avocatParNom(String nom);
	  public List<Avocat> avocatParNomEtVille(String nom, String nomVille);
	  public List<Avocat> avocatParNomEtDomaine(String nom, String nomDomaine);
	  public List<Avocat> avocatParNomEtVilleEtDomaine(String nom, String nomVille, String nomDomaine);
	  public List<Avocat> avocatParVilleEtDomaine(String nomVille, String nomDomaine);
	  public List<Avocat> listAvocat();
	  public Avocat getAvocat(Long id);
	  
	  
	  public Long ajouterUser(Utilisateur a);
	  public void updateUser(Utilisateur a);
	  public void deleteUser(Long id);
	  public List<Utilisateur> userParNom(String nom);
	  public Utilisateur userParMail(String mail);
	  public List<Utilisateur> listUser();
	  
	  
	  public Long ajouterMessage(Message m);
	  public List<Message> messageParUser(Long idUser);
	  public List<Message> messageParAvocat(Long idAvocat);
	  public List<Message> listMessage();
	  
	  
	  public void updateReview(Note n);
	  
	  
	  public void ajouterHoraire(Horaire h);
	  public void updateHoraire(Horaire h);
	  
	  
	  public List<Ville> listVille();
	  
	  public List<Langue> listLangue();
	  
	  public List<Domaine> listDomaine();
	  
	  
	  
	  
	  

}
