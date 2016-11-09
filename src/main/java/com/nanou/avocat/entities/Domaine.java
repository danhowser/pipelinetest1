package com.nanou.avocat.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Domaine implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idDomaine;
	private String nomDomaine;
	 @ManyToMany(fetch = FetchType.EAGER, mappedBy="listDomaine")
	private List<Avocat> listAvocat;
	
	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomVille) {
		this.nomDomaine = nomVille;
		
	}

	
	
	public List<Avocat> getListAvocat() {
		return listAvocat;
	}

	public void setListAvocat(List<Avocat> listAvocat) {
		this.listAvocat = listAvocat;
	}

	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domaine(String nomDomaine) {
		super();
		this.nomDomaine = nomDomaine;
		listAvocat=new ArrayList<Avocat>();
	}

	
	
	
	
}