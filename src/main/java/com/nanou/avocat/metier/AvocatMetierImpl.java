package com.nanou.avocat.metier;

import java.util.List;

import com.nanou.avocat.DAO.IAvocatDAO;
import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Domaine;
import com.nanou.avocat.entities.Horaire;
import com.nanou.avocat.entities.Langue;
import com.nanou.avocat.entities.Message;
import com.nanou.avocat.entities.Note;
import com.nanou.avocat.entities.Utilisateur;
import com.nanou.avocat.entities.Ville;

public class AvocatMetierImpl implements IAdminMetier{
	
	private IAvocatDAO dao;
	

	public void setDao(IAvocatDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterAvocat(Avocat a) {
		return dao.ajouterAvocat(a);
	}

	@Override
	public void updateAvocat(Avocat a) {
         dao.updateAvocat(a);		
	}

	@Override
	public void deleteAvocat(Long id) {
		dao.deleteAvocat(id);
		
	}

	@Override
	public List<Avocat> avocatParVille(String nomVille) {
		
		return dao.avocatParVille(nomVille);
	}

	@Override
	public List<Avocat> avocatParDomaine(String nomDomaine) {
		
		return dao.avocatParDomaine(nomDomaine);
	}

	@Override
	public List<Avocat> avocatParNom(String nom) {
		
		return dao.avocatParNom(nom);
	}

	@Override
	public List<Avocat> listAvocat() {
		
		return dao.listAvocat();
	}

	@Override
	public Long ajouterUser(Utilisateur a) {
		
		return dao.ajouterUser(a);
	}

	@Override
	public void updateUser(Utilisateur a) {
		dao.updateUser(a);
		
	}

	@Override
	public void deleteUser(Long id) {
		dao.deleteUser(id);
		
	}

	@Override
	public List<Utilisateur> userParNom(String nom) {
		
		return dao.userParNom(nom);
	}

	@Override
	public Utilisateur userParMail(String mail) {
		
		return dao.userParMail(mail);
	}

	@Override
	public List<Utilisateur> listUser() {
		
		return dao.listUser();
	}

	@Override
	public Long ajouterMessage(Message m) {
		
		return dao.ajouterMessage(m);
	}

	@Override
	public List<Message> messageParUser(Long idUser) {
		
		return dao.messageParUser(idUser);
	}

	@Override
	public List<Message> messageParAvocat(Long idAvocat) {
		
		return dao.messageParAvocat(idAvocat);
	}

	@Override
	public List<Message> listMessage() {
		// TODO Auto-generated method stub
		return dao.listMessage();
	}

	@Override
	public void updateReview(Note n) {
		dao.updateReview(n);
		
	}

	@Override
	public void ajouterHoraire(Horaire h) {
		dao.ajouterHoraire(h);
		
	}

	@Override
	public void updateHoraire(Horaire h) {
		dao.updateHoraire(h);
		
	}

	@Override
	public List<Ville> listVille() {
		// TODO Auto-generated method stub
		return dao.listVille();
	}

	@Override
	public List<Langue> listLangue() {
		// TODO Auto-generated method stub
		return dao.listLangue();
	}

	@Override
	public List<Domaine> listDomaine() {
		// TODO Auto-generated method stub
		return dao.listDomaine();
	}

}
