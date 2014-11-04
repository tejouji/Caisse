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

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.model.Produit;
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
	public String listpd(@Valid Employe emp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employe";
        }
	model.addAttribute("employe", new Employe());
	employeRepository.save(emp);
	System.out.println(emp);
	System.out.println("liste   **"+employeRepository.findAll());
	model.addAttribute("employes", employeRepository.findAll());
		return "employe";
	}	
	
	 @ResponseBody
	@RequestMapping(value = "/loaddataem", method = RequestMethod.POST,
			
			
			headers="Accept=application/json")

  

   public List<Employe> allPhones() {
List<Employe> json = (List<Employe>) employeRepository.findAll() ;
	return json;
   }
	 
	
	 
	 
	 
	 
	 
	 @ResponseBody
		@RequestMapping(value = "/deletedataem", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<Employe> supprimer(@RequestParam("id") Long id) {
		employeRepository.delete(id);
	List<Employe> json = (List<Employe>) employeRepository.findAll() ;
	
		return json;
	    }
	 
	 @ResponseBody
		@RequestMapping(value = "/updatedataem", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<Employe> modifier(@ModelAttribute Employe employe, Model model) {
	employeRepository.save(employe);
	List<Employe> json = (List<Employe>) employeRepository.findAll() ;
	
		return json;
	    }

	
}
