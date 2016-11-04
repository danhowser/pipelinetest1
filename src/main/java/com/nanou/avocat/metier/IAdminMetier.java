package com.nanou.avocat.metier;
import java.util.*;

import com.nanou.avocat.entities.*;

public interface IAdminMetier extends IUserMetier, IAvocatMetier{
	public void deleteAvocat(Long id);
	public void deleteUser(Long id);
	public List<Utilisateur> userParNom(String nom);
	public Utilisateur userParMail(String mail);
	public List<Utilisateur> listUser();
	public List<Message> messageParUser(Long idUser);
	public List<Message> messageParAvocat(Long idAvocat);
	public List<Message> listMessage();  
}
