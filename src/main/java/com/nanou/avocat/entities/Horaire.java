package com.nanou.avocat.entities;
import java.io.*;
import java.time.*;
import javax.persistence.*;

@Entity
public class Horaire implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHoraire;
	private String jour;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	@ManyToOne
	 @JoinColumn(name="idAvocat")
	private Avocat avocat;
	public String getJour() {
		return jour;
	}
	public Avocat getAvocat() {
		return avocat;
	}
	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
	public Horaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Horaire(String jour, LocalTime heureDebut, LocalTime heureFin, Avocat avocat) {
		super();
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.avocat = avocat;
	}


}
