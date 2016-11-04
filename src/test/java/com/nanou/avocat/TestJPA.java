package com.nanou.avocat;

import static org.junit.Assert.*;

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
		//	Ville v = metier.listVille().get(0);
			//Avocat a=metier.listAvocat().get(0);
			//a.setVille(v);
			//metier.updateAvocat(a);

			
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
