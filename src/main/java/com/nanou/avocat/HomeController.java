package com.nanou.avocat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nanou.avocat.entities.Avocat;
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
	public String chercher(HttpServletRequest request, ModelMap model, @ModelAttribute("ville")String ville, @ModelAttribute("domaine")String domaine, @ModelAttribute("nom")String nom) {
		if(ville.equals("")){
			if(domaine.equals("")){
				if(nom.equals("")){
					PagedListHolder pagedListHolder=new PagedListHolder(metier.listAvocat());
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
					
				}else{
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParNom(nom));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
		
				}
			}else{
				if(nom.equals("")){
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParDomaine(domaine));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
	
				}else{
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParNomEtDomaine(nom, domaine));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
					
				}
			}
		}else{
			if(domaine.equals("")){
				if(nom.equals("")){
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParVille(ville));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
					
				}else{
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParNomEtVille(nom, ville));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
	
				}
			}else{
				if(nom.equals("")){
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParVilleEtDomaine(ville, domaine));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);

				}else{
					PagedListHolder pagedListHolder=new PagedListHolder(metier.avocatParNomEtVilleEtDomaine(nom, ville, domaine));
					int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			        pagedListHolder.setPage(page);
			        pagedListHolder.setPageSize(4);
			        model.put("pagedListHolder", pagedListHolder);
				}
			}
			
		}
		return "avocats";
	}
	
	
}
