package fr.uha.miage.caisse.controller;

import java.util.ArrayList;
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

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.model.ProduitCat;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;

@Controller
public class CategorieProduitController {
	
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	
	@RequestMapping(value = "/newcat", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("categorieProduit", new CategorieProduit());
	System.out.println(catProdRepository.findOne((long) 1).getProduit().toString());
		return "newcat";
	}	
	@RequestMapping(value = "/newcat", method = RequestMethod.POST)
	public String checkPersonInfo(@Valid CategorieProduit categorie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newcat";
        }
	model.addAttribute("categorieProduit", new CategorieProduit());
	catProdRepository.save(categorie);
	model.addAttribute("categorieProduits", catProdRepository.findAll());
		return "newcat";
	}
	 @ResponseBody
	@RequestMapping(value = "/loaddata", method = RequestMethod.POST,
			
			
			headers="Accept=application/json")

   

    public List<CategorieProduit> allPhones() {
List<CategorieProduit> json = (List<CategorieProduit>) catProdRepository.findAll() ;
	return json;
    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @ResponseBody
		@RequestMapping(value = "/deletedata", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<CategorieProduit> supprimer(@RequestParam("id") Long id) {
		catProdRepository.delete(id);
	List<CategorieProduit> json = (List<CategorieProduit>) catProdRepository.findAll() ;
	
		return json;
	    }
	 
	 @ResponseBody
		@RequestMapping(value = "/updatedata", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<CategorieProduit> modifier(@ModelAttribute CategorieProduit product, Model model) {
		catProdRepository.save(product);
	List<CategorieProduit> json = (List<CategorieProduit>) catProdRepository.findAll() ;
	
		return json;
	    }

	 
	 
	 
	 
	 @ResponseBody
		@RequestMapping(value = "/getcat", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<CategorieProduit> allcat() {
	
		
		
		
	
			List<CategorieProduit> json1 = (List<CategorieProduit>) catProdRepository.findAll() ;
	 
			
	
		return json1;
	    }
		  
		 
		
}
