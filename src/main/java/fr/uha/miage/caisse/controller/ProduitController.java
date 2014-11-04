package fr.uha.miage.caisse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;

import fr.uha.miage.caisse.repository.ProduitRepository;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository prodRepository;
	
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	@RequestMapping(value = "/fichepd", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("produit", new Produit());
	
	model.addAttribute("categorieProduits",catProdRepository.findAll());
//	model.addAttribute("categorieProduit", new CategorieProduit());
	model.addAttribute("produits", prodRepository.findAll());
	
		return "fichepd";
	}	
	
	@RequestMapping(value = "/fichepd", method = RequestMethod.POST)
	public String listpd(@Valid Produit produit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "fichepd";
        }
	model.addAttribute("produit", new Produit());
	prodRepository.save(produit);
	System.out.println(produit);
	model.addAttribute("produits", prodRepository.findAll());
		return "fichepd";
	}	
	 @ResponseBody
		@RequestMapping(value = "/loaddatapd", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<Produit> allPhones() {
	List<Produit> json = (List<Produit>) prodRepository.findAll() ;
		return json;
	    }
		  
		 
		 
		 @ResponseBody
			@RequestMapping(value = "/deletedatapd", method = RequestMethod.POST,
					
					
					headers="Accept=application/json")

		   

		    public List<Produit> supprimer(@RequestParam("id") Long id) {
			prodRepository.delete(id);
		List<Produit> json = (List<Produit>) prodRepository.findAll() ;
		
			return json;
		    }
		 
		 @ResponseBody
			@RequestMapping(value = "/updatedatapd", method = RequestMethod.POST,
					
					
					headers="Accept=application/json")

		   

		    public List<Produit> modifier(@ModelAttribute Produit product, Model model) {
			prodRepository.save(product);
		List<Produit> json = (List<Produit>) prodRepository.findAll() ;
		
			return json;
		    }

	

}
