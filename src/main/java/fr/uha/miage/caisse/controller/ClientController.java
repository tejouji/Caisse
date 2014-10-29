package fr.uha.miage.caisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.RequestParam;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.repository.ClientRepository;


@Controller
public class ClientController {
	
	@Autowired
	ClientRepository clientrepository;
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("client", new Client());
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String Add(@ModelAttribute Client client, Model model) {
		clientrepository.save(client);
		//pour afficher sur la meme page 
		model.addAttribute("clients", clientrepository.findAll());
	  	return "client";
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String deleteClient(@RequestParam("Id") Long Id_Client, Model model) {
		
		clientrepository.delete(Id_Client);
		
		return "client";
	}
	
	

}
