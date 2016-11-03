package com.nanou.avocat.entities;

import java.io.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;

@Entity
public class Utilisateur implements Serializable{
	
	//info client
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idClient;
	private String nomClient;
	private String prenomClient;
	//private int ageClient;
	private String telClient;
	 @OneToMany(mappedBy="utilisateur")
	private List<Note> listNote;
	 @OneToMany(mappedBy="utilisateur")
	private List<Message> listMessage;
	
	//info connection
	private String emailClient;
	private String motDePasse;
	
	//info utile
	private LocalDateTime dateCreation;
	private long nombreConnection;
	private LocalDateTime derniereConnection;
	
	
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public long getIdClient() {
		return idClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	public long getNombreConnection() {
		return nombreConnection;
	}
	public void setNombreConnection(long nombreConnection) {
		this.nombreConnection = nombreConnection;
	}
	public LocalDateTime getDerniereConnection() {
		return derniereConnection;
	}
	public void setDerniereConnection(LocalDateTime derniereConnection) {
		this.derniereConnection = derniereConnection;
	}

	
	
	public List<Message> getListMessage() {
		return listMessage;
	}
	public void setListMessage(List<Message> listMessage) {
		this.listMessage = listMessage;
	}
	public List<Note> getListNote() {
		return listNote;
	}
	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}
	public Utilisateur(String nomClient, String prenomClient,  String telClient, String emailClient,
			String motDePasse) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.telClient = telClient;
		this.emailClient = emailClient;
		this.motDePasse = motDePasse;
		this.dateCreation = LocalDateTime.now();
		listNote=new ArrayList<Note>();
		listMessage=new ArrayList<Message>();
		
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
