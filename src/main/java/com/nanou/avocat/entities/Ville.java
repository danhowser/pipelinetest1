package com.nanou.avocat.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Ville implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idVille;
	 private String nomVille;
	 @OneToMany(mappedBy="ville")
	 private List<Avocat> listAvocat;

	public String getNomVille() {
		return nomVille;
	}

	
	public List<Avocat> getListAvocat() {
		return listAvocat;
	}


	public void setListAvocat(List<Avocat> listAvocat) {
		this.listAvocat = listAvocat;
	}


	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
		listAvocat=new ArrayList<Avocat>();
	}

	
	
}