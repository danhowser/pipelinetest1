package com.nanou.avocat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nanou.avocat.metier.IAvocatMetier;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
		private IAvocatMetier metier;
		
		@RequestMapping("/index")
		public String home(){
			return "login";
		
		}
		
		
	}

