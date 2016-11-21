package com.nanou.avocat;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nanou.avocat.entities.Avocat;
import com.nanou.avocat.entities.Domaine;
import com.nanou.avocat.entities.Langue;
import com.nanou.avocat.entities.Ville;
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
	@RequestMapping(value = "/detailAvocat")
	public String profile(Model model, @ModelAttribute("id")Long id) {
		model.addAttribute("avocat", metier.getAvocat(id));
		return "profile";
	}
	
	@RequestMapping(value = "/chercher")
	public String chercher(HttpServletRequest request, ModelMap model, @ModelAttribute("ville")String ville, @ModelAttribute("domaine")String domaine, @ModelAttribute("nom")String nom) {
		
		model.addAttribute("villeList", metier.listVille());
		model.addAttribute("domaineList", metier.listDomaine());
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
	
@RequestMapping(value="/photoAvocat",produces=MediaType.IMAGE_JPEG_VALUE)
@ResponseBody
	public byte[] getPhoto(Long idAvocat) throws IOException{
		Avocat c = metier.getAvocat(idAvocat);
		if(c.getPhoto()==null) return new byte[0];
		else return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
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
	for(Ville v : metier.listVille())
		if(v.getNomVille().equals(idA))
			a.setVille(v);
	
	ArrayList<Domaine> lesDomaines=(ArrayList<Domaine>) a.getListDomaine();
	ArrayList<Domaine> domaineAvocat=new ArrayList<Domaine>();
	for(Domaine d : lesDomaines){
	//	System.out.println(d.getNomDomaine());
		for(Domaine dd : metier.listDomaine())
			if(d.getNomDomaine().equals(dd.getNomDomaine()))
				domaineAvocat.add(dd);}
	a.setListDomaine(domaineAvocat);
			
	ArrayList<Langue> lesLangues=(ArrayList<Langue>) a.getListLangue();
	ArrayList<Langue> langueAvocat=new ArrayList<Langue>();
	for(Langue d : lesLangues){
	//	System.out.println(d.getNomDomaine());
		for(Langue dd : metier.listLangue())
			if(d.getNomLangue().equals(dd.getNomLangue()))
				langueAvocat.add(dd);}
	a.setListLangue(langueAvocat);
		
	metier.ajouterAvocat(a);
	model.addAttribute("avocat",new Avocat());
	model.addAttribute("villes", metier.listVille());
	model.addAttribute("domaines", metier.listDomaine());
	model.addAttribute("langues", metier.listLangue());
	return "ajoutAvocat";
}
	
}
