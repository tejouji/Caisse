package fr.uha.miage.caisse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CaisseController {


	@RequestMapping(value = "/caisse", method = RequestMethod.GET)
	public String getCaisse(Model model) {
	
		return "caisse";
	}	
}
