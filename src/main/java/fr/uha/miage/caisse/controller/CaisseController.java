package fr.uha.miage.caisse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CaisseRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;



@Controller
public class CaisseController {
@Autowired
ProduitRepository prodRepository;
@Autowired
CaisseRepository caisseRepository;
	@RequestMapping(value = "/caisse", method = RequestMethod.GET)
	public String getCaisse(Model model) {
	
		return "caisse";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getCode", method = RequestMethod.POST)

   

    public Long modifier(@RequestParam("term") String term, Model model) {
	
Produit json = (Produit) prodRepository.FIND_des(term);

	return json.getId();
    }
	
	@ResponseBody
	@RequestMapping(value = "/verif", method = RequestMethod.POST)

   

    public String verif(@RequestParam("term") Long term,@RequestParam("term1") int quantite, Model model) {
	String s=null;
Produit p = (Produit) caisseRepository.FIND_quant(term);
if(p.getQuantite()>quantite)
s="passe";
else
	s="nn";
System.out.println(s);
	return s;
    }
}
