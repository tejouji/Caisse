package fr.uha.miage.caisse.controller;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.miage.caisse.model.Commande;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CommandeRepository;

@Controller
public class histoController {
	@Autowired
	CommandeRepository cmdR;

	@RequestMapping(value = "/histo", method = RequestMethod.GET)
	public String HistoForm(Model model,@RequestParam (defaultValue="" ) String term ) {
	String nom;
	String prenom;
	String str[]=term.split("!");
	String dat=str[0];

	try{
		String str1[]=str[1].split(" ");
		nom=str1[0];
		prenom=str1[1];
		if(term=="")
		{
			
		}
			
		System.out.println("nom"+nom);
		System.out.println("prenom"+prenom);
		System.out.println("dat"+dat);
		model.addAttribute("cm", new Commande());
		model.addAttribute("cms" ,cmdR.FIND_BY_date(dat,nom,prenom));
	}
	catch(Exception e)
	{
		nom="";
		prenom="";
		model.addAttribute("cm", new Commande());
		model.addAttribute("cms" ,cmdR.findAll());
	}
		System.out.println("kkkkkkkk"+cmdR.FIND_BY_date(dat,nom,prenom));
			
		
		
		
		
		
		return "histo";
	}
	@SuppressWarnings("null")
	@ResponseBody
		@RequestMapping(value = "/autoemp", method = RequestMethod.GET,
				
				
				headers="Accept=application/json")

	   

	    public List<String> allcatauto(@RequestParam("term") String term) {
	
		
		 List<Employe> l = (List<Employe>) cmdR.FIND_BY_emp(term) ;
		System.out.println(l);

			List<String> json1 =new ArrayList<String>();
			for(int i=0;i<l.size();i++)
				
			{
				json1.add(l.get(i).getNom_emp()+" "+l.get(i).getPre_emp());
				
			}
			
			
			
	
		return json1;
 }



}
