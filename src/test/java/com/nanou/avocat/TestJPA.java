package com.nanou.avocat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nanou.avocat.entities.*;
import com.nanou.avocat.metier.IAvocatMetier;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
public class TestJPA {
    @Before
    public void setUp() throws Exception {}
    
	@Test
	public void test1() {
			try {
			ClassPathXmlApplicationContext context=
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAvocatMetier metier=(IAvocatMetier) context.getBean("metier");
		//	Ville v = metier.listVille().get(0);
			//Avocat a=metier.listAvocat().get(0);
			//a.setVille(v);
			//metier.updateAvocat(a);

			Ville kenitra=metier.listVille().get(0);
			Ville rabat=metier.listVille().get(1);
			Ville casablanca=metier.listVille().get(2);
			
			Domaine dom=metier.listDomaine().get(0);
			Domaine domm=metier.listDomaine().get(1);
			Domaine dommm=metier.listDomaine().get(2);
			
			Avocat a1=new Avocat("gharibi","","","","","","","","",LocalDate.now(),"","","",kenitra);
			List<Domaine> list1=new ArrayList<Domaine>(); list1.add(dom); list1.add(domm);
		//	List<Avocat> lista=new ArrayList<Avocat>(); lista.add(a1); 
			a1.setListDomaine(list1);
		//	dom.setListAvocat(lista);
			
			
			Avocat a2=new Avocat("mrihy","","","","","","","","",LocalDate.now(),"","","",casablanca);
			List<Domaine> list2=new ArrayList<Domaine>(); list2.add(dommm); list2.add(domm);
			a2.setListDomaine(list2);
			
			
			Avocat a3=new Avocat("dbiba","","","","","","","","",LocalDate.now(),"","","",kenitra);
			List<Domaine> list3=new ArrayList<Domaine>(); list3.add(dom); 
			a3.setListDomaine(list3);
			
			
			
			metier.ajouterAvocat(a1); metier.ajouterAvocat(a2); metier.ajouterAvocat(a3);
			
		//	List<Avocat> av=metier.avocatParNomEtDomaine("dbiba", "droit de travail");
		//	System.out.println(av.get(0).getNomAvocat()); 
			
			List<Avocat> av=metier.avocatParDomaine("Divorce");
			System.out.println(av.size());
			System.out.println(av.get(0).getNomAvocat());
			System.out.println(av.get(1).getNomAvocat());
			
			
		/* 	List<Avocat> av=metier.avocatParVille("kenitra");
			    System.out.println(av.size());
				System.out.println(av.get(0).getNomAvocat());
				System.out.println(av.get(1).getNomAvocat()); */
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
