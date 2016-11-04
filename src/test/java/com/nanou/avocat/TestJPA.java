package com.nanou.avocat;

import static org.junit.Assert.*;
import java.time.*;
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
	Long l = metier.ajouterAvocat(new Avocat( "dab", "h", "r", "g", "e","d","d","h","d",LocalDate.now(),"i","i","o",metier.listVille().get(0)));
			System.out.println(l);
//	Utilisateur a=metier.listUser().get(0);
		//	System.out.println(a);	
			}
			catch(Exception e){
				assertTrue(e.getMessage(),false);
			}
		}
	}
