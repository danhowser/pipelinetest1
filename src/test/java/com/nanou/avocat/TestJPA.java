package com.nanou.avocat;

import static org.junit.Assert.*;

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
			Long l=metier.ajouterUser(new Utilisateur("dab", "h", "r", "g", "e"));
			System.out.println(l);
			
			}
			catch(Exception e){
				assertTrue(e.getMessage(),false);
			}
		}
	}
