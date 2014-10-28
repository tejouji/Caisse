package fr.uha.miage.caisse.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;

@Controller
public class CategorieProduitController {
	
	
	
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	
	@RequestMapping(value = "/newcat", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("categorieProduit", new CategorieProduit());
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


}
