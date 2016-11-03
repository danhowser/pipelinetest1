package com.nanou.avocat.entities;
import java.io.*;

import javax.persistence.*;


@Entity
public class Facture implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFacture;
	 @ManyToOne
	 @JoinColumn(name="idAvocat")
	private Avocat avocat;
	 @ManyToOne
	 @JoinColumn(name="idPlan")
	private Plan plan;
	public Avocat getAvocat() {
		return avocat;
	}
	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}
	public int getIdFacture() {
		return idFacture;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Avocat avocat, Plan plan) {
		super();
		this.avocat = avocat;
		this.plan = plan;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	 
	 
	
}
