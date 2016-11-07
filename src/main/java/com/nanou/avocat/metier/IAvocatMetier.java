package com.nanou.avocat.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Domaine;
import com.nanou.avocat.entities.Horaire;
import com.nanou.avocat.entities.Langue;
import com.nanou.avocat.entities.Message;
import com.nanou.avocat.entities.Note;
import com.nanou.avocat.entities.Utilisateur;
import com.nanou.avocat.entities.Ville;


public interface IAvocatMetier {

	  public Long ajouterAvocat(Avocat a);
	  public void updateAvocat(Avocat a);
	  public void deleteAvocat(Long id);
	  public List<Avocat> avocatParVille(String nomVille);
	  public List<Avocat> avocatParDomaine(String nomDomaine);
	  public List<Avocat> avocatParNom(String nom);
	  public List<Avocat> listAvocat();
	  
	  
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
