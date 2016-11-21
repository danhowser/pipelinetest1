package com.nanou.avocat.entities;

import java.io.*;
import java.util.*;
import java.time.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Avocat implements Serializable{
	
	
	// manque photo et coordones
	
   //information avocat
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAvocat;
	private String nomAvocat;
	private String prenomAvocat;
	private String adresseAvocat;
	private String adresseAvocat2;
	private String telCabinet;
	private String telPortableAvocat;
	private String telAvocat2;
	private String sexe;
	private String diplome;
	private String startedPractice;
	private String description;
	private double noteGlobal;
	private double latitude;
	private double longitude;
	 @OneToMany(mappedBy="avocat")
	private List<Facture> listFacture;
	 @ManyToMany
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @JoinTable(joinColumns=@JoinColumn(name="idAvocat"), inverseJoinColumns=@JoinColumn(name="idLangue"))
	private List<Langue> listLangue;
	 @ManyToMany
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @JoinTable(joinColumns=@JoinColumn(name="idAvocat"), inverseJoinColumns=@JoinColumn(name="idDomaine"))
	private List<Domaine> listDomaine;
	 @OneToMany(mappedBy="avocat")
	private List<Horaire> listHoraire;
	 @OneToMany(mappedBy="avocat")
	private List<Note> listNote;
	 @OneToMany
	 @JoinColumn(name="idAvocat")
	private List<Message> listMessage;
	 @ManyToOne
	 @JoinColumn(name="idVille")
	private Ville ville;
	 @Lob
	 private byte[] photo;
	 private String nomPhoto;
	
	//information utiles
	private LocalDateTime derniereConnection;
	private LocalDateTime dateConfirmation;
	private LocalDateTime dateCreation;
	private long nbrConnection;
	private int nbrVisiteurs;
	
	
	//connection
	private String motDePasse;
	private String emailAvocat;
	
	//
	private boolean confirme;
	private boolean premium;
	public String getNomAvocat() {
		return nomAvocat;
	}
	public void setNomAvocat(String nomAvocat) {
		this.nomAvocat = nomAvocat;
	}
	public String getPrenomAvocat() {
		return prenomAvocat;
	}
	public void setPrenomAvocat(String prenomAvocat) {
		this.prenomAvocat = prenomAvocat;
	}
	public String getAdresseAvocat() {
		return adresseAvocat;
	}
	public void setAdresseAvocat(String adresseAvocat) {
		this.adresseAvocat = adresseAvocat;
	}
	public String getAdresseAvocat2() {
		return adresseAvocat2;
	}
	public void setAdresseAvocat2(String adresseAvocat2) {
		this.adresseAvocat2 = adresseAvocat2;
	}
	public String getTelCabinet() {
		return telCabinet;
	}
	public void setTelCabinet(String telCabinet) {
		this.telCabinet = telCabinet;
	}
	public String getTelPortableAvocat() {
		return telPortableAvocat;
	}
	public void setTelPortableAvocat(String telPortableAvocat) {
		this.telPortableAvocat = telPortableAvocat;
	}
	public String getTelAvocat2() {
		return telAvocat2;
	}
	public void setTelAvocat2(String telAvocat2) {
		this.telAvocat2 = telAvocat2;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getStartedPractice() {
		return startedPractice;
	}
	public void setStartedPractice(String startedPractice) {
		this.startedPractice = startedPractice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDerniereConnection() {
		return derniereConnection;
	}
	public void setDerniereConnection(LocalDateTime derniereConnection) {
		this.derniereConnection = derniereConnection;
	}
	public LocalDateTime getDateConfirmation() {
		return dateConfirmation;
	}
	public void setDateConfirmation(LocalDateTime dateConfirmation) {
		this.dateConfirmation = dateConfirmation;
	}
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	public long getNbrConnection() {
		return nbrConnection;
	}
	public void setNbrConnection(long nbrConnection) {
		this.nbrConnection = nbrConnection;
	}
	public int getNbrVisiteurs() {
		return nbrVisiteurs;
	}
	public void setNbrVisiteurs(int nbrVisiteurs) {
		this.nbrVisiteurs = nbrVisiteurs;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getEmailAvocat() {
		return emailAvocat;
	}
	public void setEmailAvocat(String emailAvocat) {
		this.emailAvocat = emailAvocat;
	}
	public boolean isConfirme() {
		return confirme;
	}
	public void setConfirme(boolean confirme) {
		this.confirme = confirme;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public long getIdAvocat() {
		return idAvocat;
	}
	
	public double getNoteGlobal() {
		return noteGlobal;
	}
	public void setNoteGlobal(double noteGlobal) {
		this.noteGlobal = noteGlobal;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Avocat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avocat(String nomAvocat) {
		super();
		this.nomAvocat = nomAvocat;
		// TODO Auto-generated constructor stub
	}
	public Avocat(String nomAvocat, String prenomAvocat, String adresseAvocat, String telCabinet,
			String telPortableAvocat, String diplome,
			String description, String motDePasse, String emailAvocat, String startedPractice, byte[] photo, String nomPhoto, double latitude, double longitude) {
		super();
		this.nomAvocat = nomAvocat;
		this.prenomAvocat = prenomAvocat;
		this.adresseAvocat = adresseAvocat;
	//	this.adresseAvocat2 = adresseAvocat2;
		this.telCabinet = telCabinet;
		this.telPortableAvocat = telPortableAvocat;
	//	this.telAvocat2 = telAvocat2;
	//	this.sexe = sexe;
		this.diplome = diplome;
		this.startedPractice = startedPractice;
		this.description = description;
		this.dateCreation = LocalDateTime.now();
		this.motDePasse = motDePasse;
		this.emailAvocat = emailAvocat;
		this.confirme = false;
		this.premium = false;
		listFacture=new ArrayList<Facture>();
		listLangue=new ArrayList<Langue>();
		listDomaine=new ArrayList<Domaine>();
		listHoraire=new ArrayList<Horaire>();
		listMessage=new ArrayList<Message>();
		listNote=new ArrayList<Note>();
	//	this.ville=ville;
		this.photo=photo;
		this.nomPhoto=nomPhoto;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public List<Facture> getListFacture() {
		return listFacture;
	}
	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}
	public List<Langue> getListLangue() {
		return listLangue;
	}
	public void setListLangue(List<Langue> listLangue) {
		this.listLangue = listLangue;
	}
	public List<Domaine> getListDomaine() {
		return listDomaine;
	}
	public void setListDomaine(List<Domaine> listDomaine) {
		this.listDomaine = listDomaine;
	}
	public List<Horaire> getListHoraire() {
		return listHoraire;
	}
	public void setListHoraire(List<Horaire> listHoraire) {
		this.listHoraire = listHoraire;
	}
	public List<Note> getListNote() {
		return listNote;
	}
	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}
	public List<Message> getListMessage() {
		return listMessage;
	}
	public void setListMessage(List<Message> listMessage) {
		this.listMessage = listMessage;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
		
}