package fr.uha.miage.caisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.repository.EmployeRepository;


@Controller
public class EmployeController {

	@Autowired
	EmployeRepository employeRepository; 
	@RequestMapping(value = "/employe", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("employe", new Employe());
		return "employe";
	}
	
	@RequestMapping(value = "/employe", method = RequestMethod.POST)
	public String Add(@ModelAttribute Employe employe, Model model) {
		employeRepository.save(employe);
		//pour afficher sur la meme page 
		model.addAttribute("employes", employeRepository.findAll());
	  	return "employe";
	}
	
	/*@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String deleteEmploye(@RequestParam("Id") Long Id_Employe, Model model) {
		
		employeRepository.delete(Id_Employe);
		
		return "employe";
	}*/
	
}
