package com.nanou.avocat.metier;

import java.util.List;

import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Domaine;
import com.nanou.avocat.entities.Langue;
import com.nanou.avocat.entities.Message;
import com.nanou.avocat.entities.Note;
import com.nanou.avocat.entities.Utilisateur;
import com.nanou.avocat.entities.Ville;

public interface IUserMetier {
		public Long ajouterUser(Utilisateur a);
		public void updateUser(Utilisateur a);
		
		public List<Avocat> avocatParVille(String nomVille);
		public List<Avocat> avocatParDomaine(String nomDomaine);
		public List<Avocat> avocatParNom(String nom);
		public List<Avocat> avocatParNomEtVille(String nom, String nomVille);
		public List<Avocat> avocatParNomEtDomaine(String nom, String nomDomaine);
		public List<Avocat> avocatParNomEtVilleEtDomaine(String nom, String nomVille, String nomDomaine);
		public List<Avocat> avocatParVilleEtDomaine(String nomVille, String nomDomaine);
		public List<Avocat> listAvocat();
		
		public Long ajouterAvocat(Avocat a);
		
		public Long ajouterMessage(Message m);
		
		public void updateReview(Note n);
		
		public List<Ville> listVille();
		  
		public List<Langue> listLangue();
		  
		public List<Domaine> listDomaine();
		

}
