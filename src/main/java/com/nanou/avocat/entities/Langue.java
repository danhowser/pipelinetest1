package com.nanou.avocat.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Langue implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idLangue;
	private String nomLangue;
	 @ManyToMany(fetch = FetchType.EAGER, mappedBy="listLangue", cascade = CascadeType.ALL)
	private List<Avocat> listAvocat;

	public String getNomLangue() {
		return nomLangue;
	}

	
	
	public List<Avocat> getListAvocat() {
		return listAvocat;
	}



	public void setListAvocat(List<Avocat> listAvocat) {
		this.listAvocat = listAvocat;
	}



	public void setNomLangue(String nomVille) {
		this.nomLangue = nomVille;
	}

	public Langue() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Langue(String nomLangue) {
		super();
		this.nomLangue = nomLangue;
		listAvocat=new ArrayList<Avocat>();
	}

	
	
}