package com.nanou.avocat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nanou.avocat.metier.IUserMetier;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IUserMetier metier;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Model model, @ModelAttribute("ville")String ville, @ModelAttribute("domaine")String domaine, @ModelAttribute("nom")String nom) {
		model.addAttribute("villeList", metier.listVille());
		model.addAttribute("domaineList", metier.listDomaine());
		return "home";
	}
	@RequestMapping(value = "/chercher")
	public String chercher(Model model, @ModelAttribute("ville")String ville, @ModelAttribute("domaine")String domaine, @ModelAttribute("nom")String nom) {
		if(ville.equals("")){
			if(domaine.equals("")){
				if(nom.equals("")){
					model.addAttribute("listAvocat",metier.listAvocat());
				}else{
					model.addAttribute("listAvocat",metier.avocatParNom(nom));
				}
			}else{
				if(nom.equals("")){
					model.addAttribute("listAvocat",metier.avocatParDomaine(domaine));
				}else{
					model.addAttribute("listAvocat",metier.avocatParNomEtDomaine(nom, domaine));
				}
			}
		}else{
			if(domaine.equals("")){
				if(nom.equals("")){
					model.addAttribute("listAvocat",metier.avocatParVille(ville));
				}else{
					model.addAttribute("listAvocat",metier.avocatParNomEtVille(nom, ville));
				}
			}else{
				if(nom.equals("")){
					model.addAttribute("listAvocat",metier.avocatParVilleEtDomaine(ville, domaine));
				}else{
					model.addAttribute("listAvocat",metier.avocatParNomEtVilleEtDomaine(nom, ville, domaine));
				}
			}
			
		}
		return "user";
	}
	
}
