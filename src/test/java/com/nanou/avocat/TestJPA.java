package com.nanou.avocat;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nanou.avocat.entities.*;
import com.nanou.avocat.metier.IAvocatMetier;

public class TestJPA {
    @Before
    public void setUp() throws Exception {}
    
	@Test
	public void test1() {
			try {
			ClassPathXmlApplicationContext context=
		new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAvocatMetier metier=(IAvocatMetier) context.getBean("metier");
			List<Utilisateur> use1=metier.listUser();
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			List<Utilisateur> use2=metier.listUser();
			System.out.println(use1.get(0).getDateCreation());
			assertTrue(use1.size()+2==use2.size());
			
			
			}
			catch(Exception e){
				assertTrue(e.getMessage(),false);
			}
		}
	}
