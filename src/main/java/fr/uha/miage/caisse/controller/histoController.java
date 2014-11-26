package fr.uha.miage.caisse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.miage.caisse.model.Commande;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.repository.CommandeRepository;

@Controller
public class histoController {
	@Autowired
	CommandeRepository cmdR;

	@RequestMapping(value = "/histo", method = RequestMethod.GET)
	public String HistoForm(Model model) {
		model.addAttribute(" histo", new Commande());
		return "histo";
	}

	@ResponseBody
	@RequestMapping(value = "/loaddataCMD", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<Commande> allCommande() {
		List<Commande> json = (List<Commande>) cmdR.findAll();
		return json;
	}

}
