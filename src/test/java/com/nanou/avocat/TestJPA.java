package com.nanou.avocat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nanou.avocat.entities.*;
import com.nanou.avocat.metier.*;
import java.time.*;
import java.util.List;
public class TestJPA {
    @Before
    public void setUp() throws Exception {}
    
	@Test
	public void test1() {
			try {
			ClassPathXmlApplicationContext context=
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminMetier metier=(IAdminMetier) context.getBean("metier");

		/*	List<Utilisateur> use1=metier.listUser();
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			List<Utilisateur> use2=metier.listUser();
			System.out.println(use1.get(0).getDateCreation());
			assertTrue(use1.size()+2==use2.size()); */
			

//			Ville kenitra=metier.listVille().get(0);
//			Ville rabat=metier.listVille().get(1);
//			Ville casablanca=metier.listVille().get(2);
			
//			Domaine dom=metier.listDomaine().get(0);
//			Domaine domm=metier.listDomaine().get(1);
//			Domaine dommm=metier.listDomaine().get(2); 
//			
//			Langue lan=metier.listLangue().get(0);
//			Langue lann=metier.listLangue().get(1);
//			Langue lannn=metier.listLangue().get(2);
//			System.out.println(kenitra.getNomVille());
//			System.out.println(rabat.getNomVille());
//			System.out.println(casablanca.getNomVille());
		/*	Avocat a1=new Avocat("gharibi","","","","","","","","",LocalDate.now(),"","","",kenitra);
			List<Domaine> list1=new ArrayList<Domaine>(); list1.add(dom); list1.add(domm);
			//List<Avocat> lista=new ArrayList<Avocat>(); lista.add(a1); 
			a1.setListDomaine(list1);
		//	dom.setListAvocat(lista);
			
			
			Avocat a2=new Avocat("mrihy","","","","","","","","",LocalDate.now(),"","","",casablanca);
			List<Domaine> list2=new ArrayList<Domaine>(); list2.add(dommm); list2.add(domm);
			a2.setListDomaine(list2);
			
			
			Avocat a3=new Avocat("dbiba","","","","","","","","",LocalDate.now(),"","","",kenitra);
			List<Domaine> list3=new ArrayList<Domaine>(); list3.add(dom); 
			a3.setListDomaine(list3);  
			
			
			
			metier.ajouterAvocat(a1); metier.ajouterAvocat(a2); metier.ajouterAvocat(a3); */
			
		//	List<Avocat> av=metier.avocatParNomEtDomaine("dbiba", "droit de travail");
		//	System.out.println(av.get(0).getNomAvocat()); 
		//	List<Avocat> av=metier.avocatParDomaine("droit de travail");
		//	List<Avocat> av=metier.avocatParNomEtVilleEtDomaine("gharibi","kenitra","droit de travail");
		//	List<Avocat> av=metier.avocatParVilleEtDomaine("kenitra","droit de travail");
			//System.out.println(av.size());
		//	System.out.println(av.get(0).getNomAvocat());
		//	System.out.println(av.get(1).getNomAvocat());
			
			
		/* 	List<Avocat> av=metier.avocatParVille("kenitra");
			    System.out.println(av.size());
				System.out.println(av.get(0).getNomAvocat());
				System.out.println(av.get(1).getNomAvocat()); */
			
		/*	Avocat a1=metier.listAvocat().get(0);
				System.out.println(a1.getListDomaine().get(0).getNomDomaine());
				List<Domaine> list=a1.getListDomaine();
				list.add(dommm);
		        a1.setListDomaine(list);  
			//	a1.setListDomaine(list1);
				//domm.getListAvocat().add(a1);
		        metier.updateAvocat(a1);
				System.out.println(a1.getListDomaine().get(2).getNomDomaine());
				
				
		//		System.out.println(metier.listAvocat().get(0).getListDomaine().get(0).getNomDomaine());
		//		System.out.println(metier.listAvocat().get(0).getListDomaine().get(1).getNomDomaine());    */
			
//			Avocat a1=metier.listAvocat().get(0);
//			System.out.println(a1.getListLangue().get(1).getNomLangue());
			
			
			
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
