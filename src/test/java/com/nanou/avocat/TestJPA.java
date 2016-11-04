package com.nanou.avocat;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nanou.avocat.entities.*;
import com.nanou.avocat.metier.IAvocatMetier;
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
			IAvocatMetier metier=(IAvocatMetier) context.getBean("metier");
<<<<<<< HEAD
			List<Utilisateur> use1=metier.listUser();
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			List<Utilisateur> use2=metier.listUser();
			System.out.println(use1.get(0).getDateCreation());
			assertTrue(use1.size()+2==use2.size());
			
=======
		//	Ville v = metier.listVille().get(0);
			//Avocat a=metier.listAvocat().get(0);
			//a.setVille(v);
			//metier.updateAvocat(a);

>>>>>>> 81e608e20514339d2b8ca6eedc0f392f4390968e
			
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
