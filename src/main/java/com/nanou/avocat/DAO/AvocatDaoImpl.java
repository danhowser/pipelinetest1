package com.nanou.avocat.DAO;

import java.util.List;

import javax.persistence.*;


import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Domaine;
import com.nanou.avocat.entities.Horaire;
import com.nanou.avocat.entities.Langue;
import com.nanou.avocat.entities.Message;
import com.nanou.avocat.entities.Note;
import com.nanou.avocat.entities.Utilisateur;
import com.nanou.avocat.entities.Ville;

public class AvocatDaoImpl implements IAvocatDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long ajouterAvocat(Avocat a) {
		em.persist(a);
		return a.getIdAvocat();
	}

	@Override
	public void updateAvocat(Avocat a) {
		em.merge(a);
		
	}

	@Override
	public void deleteAvocat(Long id) {
		Avocat a=em.find(Avocat.class, id);
		em.remove(a);
		
	}

	@Override
	public List<Avocat> avocatParVille(String nomVille) {
		Query req=em.createQuery("select v.listAvocat from Ville v where v.nomVille=:x ");
		req.setParameter("x", nomVille);
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParDomaine(String nomDomaine) {
		Query req=em.createQuery("select d.listAvocat from Domaine d where d.nomDomaine=:x ");
		req.setParameter("x", nomDomaine);
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParNom(String nom) {
		Query req=em.createQuery("select a from Avocat a where a.nomAvocat like :x or a.prenomAvocat like :x");
		req.setParameter("x", "%"+nom+"%");
		return req.getResultList();
	}

	@Override
	public List<Avocat> listAvocat() {
		Query req=em.createQuery("select a from Avocat a");
		return req.getResultList();
	}

	@Override
	public Long ajouterUser(Utilisateur a) {
		em.persist(a);
		return a.getIdClient();
	}

	@Override
	public void updateUser(Utilisateur a) {
		em.merge(a);
		
	}

	@Override
	public void deleteUser(Long id) {
		Utilisateur a=em.find(Utilisateur.class, id);
		em.remove(a);
		
	}

	@Override
	public List<Utilisateur> userParNom(String nom) {
		Query req=em.createQuery("select a from Utilisateur a where a.nomClient like:x");
		req.setParameter("x", "%"+nom+"%");
		return req.getResultList();
	}
	

	@Override
	public Utilisateur userParMail(String mail) {
		
		return em.find(Utilisateur.class, mail);
	}
	

	@Override
	public List<Utilisateur> listUser() {
		Query req=em.createQuery("select a from Utilisateur a");
		return req.getResultList();
	}

	@Override
	public Long ajouterMessage(Message m) {
		em.persist(m);
		return m.getIdMessage();
		
	}

	@Override
	public List<Message> messageParUser(Long idUser) {
		Query req=em.createQuery("select a.listMessage from Utilisateur a where a.idClient=:x ");
		req.setParameter("x", idUser);
		return req.getResultList();
	}

	@Override
	public List<Message> messageParAvocat(Long idAvocat) {
		Query req=em.createQuery("select a.listMessage from Avocat a where a.idAvocat=:x ");
		req.setParameter("x", idAvocat);
		return req.getResultList();
	}

	@Override
	public List<Message> listMessage() {
		Query req=em.createQuery("select m from Message m");
		return req.getResultList();
	}

	@Override
	public void updateReview(Note n) {
		Query req = em.createQuery("select n from Note n where n.idNote=:x");
		req.setParameter("x", n.getIdNote());
		if(req == null){
			em.persist(n);
		}else{
			em.merge(n);
		}	
	}

	@Override
	public void ajouterHoraire(Horaire h) {
		em.persist(h);
		
		
	}

	@Override
	public void updateHoraire(Horaire h) {
		em.merge(h);
		
	}

	@Override
	public List<Ville> listVille() {
		Query req=em.createQuery("select v from Ville v");
		return req.getResultList();
	}

	@Override
	public List<Langue> listLangue() {
		Query req=em.createQuery("select l from Langue l");
		return req.getResultList();
	}

	@Override
	public List<Domaine> listDomaine() {
		Query req=em.createQuery("select d from Domaine d");
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParNomEtVille(String nom, String nomVille) {
		Query req=em.createQuery("select a from Avocat a where a.nomAvocat=:x AND a.ville.nomVille=:y");
		req.setParameter("x", nom);
		req.setParameter("y", nomVille);
		
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParNomEtDomaine(String nom, String nomDomaine) {
		Query req=em.createQuery("select  a from Domaine d join d.listAvocat a where a.nomAvocat=:x AND d.nomDomaine=:y");
		req.setParameter("x", nom);
		req.setParameter("y", nomDomaine);
		
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParNomEtVilleEtDomaine(String nom, String nomVille, String nomDomaine) {
		Query req=em.createQuery("select a from Domaine d join d.listAvocat a  where a.nomAvocat=:x AND a.ville.nomVille=:y AND d.nomDomaine=:z");
		req.setParameter("x", nom);
		req.setParameter("y", nomVille);
		req.setParameter("z", nomDomaine);
		
		return req.getResultList();
	}

	@Override
	public List<Avocat> avocatParVilleEtDomaine(String nomVille, String nomDomaine) {
		Query req=em.createQuery("select a from Domaine d join d.listAvocat a where d.nomDomaine=:x AND a.ville.nomVille=:y");
		req.setParameter("x", nomDomaine);
		req.setParameter("y", nomVille);
		
		return req.getResultList();
	}

}