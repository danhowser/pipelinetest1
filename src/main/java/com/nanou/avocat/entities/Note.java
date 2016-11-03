package com.nanou.avocat.entities;

import java.io.*;

import javax.persistence.*;
@Entity
public class Note implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNote;
	private int note;
	private String descriptioNote;
	private boolean approbation;
	 @ManyToOne
	 @JoinColumn(name="idClient")
	private Utilisateur utilisateur;
	 @ManyToOne
	 @JoinColumn(name="idAvocat")
	private Avocat avocat;
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getDescriptioNote() {
		return descriptioNote;
	}
	public void setDescriptioNote(String descriptioNote) {
		this.descriptioNote = descriptioNote;
	}
	public boolean isApprobation() {
		return approbation;
	}
	public void setApprobation(boolean approbation) {
		this.approbation = approbation;
	}
	public int getIdNote() {
		return idNote;
	}
	
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Avocat getAvocat() {
		return avocat;
	}
	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Note(int note, String descriptioNote, Utilisateur utilisateur, Avocat avocat) {
		super();
		this.note = note;
		this.descriptioNote = descriptioNote;
		this.approbation = false;
		this.utilisateur=utilisateur;
		this.avocat=avocat;
	}

	
	
	
}
