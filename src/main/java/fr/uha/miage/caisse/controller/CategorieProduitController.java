package fr.uha.miage.caisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;

@Controller
public class CategorieProduitController {
	
	
	
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("categorieProduit", new CategorieProduit());
		return "newcat";
	}	
	@RequestMapping(value = "/newcat", method = RequestMethod.POST)
	public String Add(Model model) {
	model.addAttribute("categorieProduit", new CategorieProduit());
		return "newcat";
	}	


}
