package com.nanou.avocat.entities;

import java.io.*;
import java.time.*;

import javax.persistence.*;

@Entity
public class Plan implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idPlan;
	private String nomPlan;
	private Duration dure;
	private long prix;
	
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(String nomPlan, Duration dure, long prix) {
		super();
		this.nomPlan = nomPlan;
		this.dure = dure;
		this.prix = prix;
	}
	public String getNomPlan() {
		return nomPlan;
	}
	public void setNomPlan(String nomPlan) {
		this.nomPlan = nomPlan;
	}
	public Duration getDure() {
		return dure;
	}
	public void setDure(Duration dure) {
		this.dure = dure;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	
	
	

}
