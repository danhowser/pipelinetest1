package com.nanou.avocat.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Ville;
import com.nanou.avocat.metier.*;

@Controller

public class UserController {
	
	@Autowired
	private IUserMetier metier;
	@RequestMapping(value = "/index")
	public String index(Model model){
		model.addAttribute("villes", metier.listVille());
		model.addAttribute("domaines", metier.listDomaine());
		return "user";
	}
	
	@RequestMapping(value = "/ajoutAvocat")
	public String ajoutAvocat(Model model){
		model.addAttribute("avocat",new Avocat());
		model.addAttribute("villes", metier.listVille());
		model.addAttribute("domaines", metier.listDomaine());
		model.addAttribute("langues", metier.listLangue());
		return "ajoutAvocat";
	}
	
	
	
	@RequestMapping(value = "/ajouterAvocat")
	public String ajouterAvocat(@ModelAttribute("avocat") Avocat a, Model model, MultipartFile file) throws IOException{
		
		if(!file.isEmpty()){
			BufferedImage bi=ImageIO.read(file.getInputStream());
			a.setPhoto(file.getBytes());
			a.setNomPhoto(file.getOriginalFilename());
		}
		String idA=a.getVille().getNomVille();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    "+idA);
		for(Ville v : metier.listVille())
			if(v.getNomVille().equals(idA))
				a.setVille(v);
			
		metier.ajouterAvocat(a);
		model.addAttribute("avocat",new Avocat());
		model.addAttribute("villes", metier.listVille());
		model.addAttribute("domaines", metier.listDomaine());
		model.addAttribute("langues", metier.listLangue());
		return "ajoutAvocat";
	}
	
	
	
}
