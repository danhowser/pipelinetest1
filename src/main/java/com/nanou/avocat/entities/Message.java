package com.nanou.avocat.entities;

import java.io.*;
import java.time.*;
import javax.persistence.*;


@Entity
public class Message implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;
	 private LocalDate dateMessage;
	private String message;
	 @ManyToOne
	 @JoinColumn(name="idAvocat")
	private Avocat avocat;
	 @ManyToOne
	 @JoinColumn(name="idClient")
	private Utilisateur utilisateur;
	
	
	public Avocat getAvocat() {
		return avocat;
	}
	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String message, Avocat avocat, Utilisateur utilisateur) {
		super();
		this.message = message;
		this.avocat = avocat;
		this.utilisateur = utilisateur;
		dateMessage=LocalDate.now();
		
	}
	public LocalDate getDateMessage() {
		return dateMessage;
	}
	public void setDateMessage(LocalDate dateMessage) {
		this.dateMessage = dateMessage;
	}
	
	
	
	
	
	

}
