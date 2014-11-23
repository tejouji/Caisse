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
import fr.uha.miage.caisse.model.CommandeVirt;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CaisseRepository;
import fr.uha.miage.caisse.repository.CommandeVirRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;



@Controller
public class CaisseController {
@Autowired
ProduitRepository prodRepository;
@Autowired
CaisseRepository caisseRepository;
@Autowired
CommandeVirRepository cmdVirRepository;

	@RequestMapping(value = "/caisse", method = RequestMethod.GET)
	public String getCaisse(Model model) {
		
		return "caisse";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getCode", method = RequestMethod.POST)

   

    public Long modifier(@RequestParam("term") String term, Model model) {
	long l=0;
		try{
Produit json = (Produit) prodRepository.FIND_des(term);
l=json.getId();
	}
	catch(Exception e)
	{
		
	}
	return l;
    }
	
	
	@ResponseBody
	@RequestMapping(value = "/verif", method = RequestMethod.POST)

   

    public String verif(@RequestParam("term") Long term,@RequestParam("term1") int quantite, Model model) {
	String s=null;
	try
	{
Produit p = (Produit) caisseRepository.FIND_quant(term);
boolean testadd=true,testmodif=true;

List<CommandeVirt> lcv =(List<CommandeVirt>) cmdVirRepository.findAll();
int i=0;
while(lcv.size()>i && testadd==true)

{
	if(lcv.get(i).getId()==term)
	{
	testadd=false;
	if(lcv.get(i).getQuantite()+term>p.getQuantite())
		testmodif=false;
	else
		quantite=lcv.get(i).getQuantite()+quantite;
	}
	i++;
}
	
if(p.getQuantite()>quantite)
{
	
	CommandeVirt cmd= new CommandeVirt();
	cmd.setCategorie(p.getCategorie().getDesignation());
	cmd.setId(term);
	cmd.setDesignation_pd(p.getDesignation_pd());
	cmd.setPrix_ht(p.getPrix_ht());
	cmd.setQuantite(quantite);
	cmd.setTva(p.getTva());
	 double  p1 = Math.pow(10.0, 2);
	 
	double total=quantite*p.getPrix_ht()*(1+p.getTva()/100);
	total=Math.floor(total*p1)/p1;
	cmd.setTotal(total);
	cmdVirRepository.save(cmd);
	
s="bien";
	
}
else
	s="Quantité supérieur";
	}
	catch(Exception e)
	{
		s="Saisir de nouveau la désignation ou le code du produit";
	}
	return s;
    }
	
	@ResponseBody
	@RequestMapping(value = "/loaddatacmd", method = RequestMethod.POST,
			
			
			headers="Accept=application/json")

   

    public List<CommandeVirt> modifier( Model model) {
	
List<CommandeVirt> json = (List<CommandeVirt>) cmdVirRepository.findAll() ;

	return json;
    }
	
	@ResponseBody
	@RequestMapping(value = "/getsum", method = RequestMethod.POST)

   

    public String verif( Model model)
    {
		double tot=0;
    
		try
		{
		
		tot=cmdVirRepository.FIND_total();
		}
		catch(Exception e)
		{}
		return String.valueOf(tot);
		
    }
	
	 @ResponseBody
		@RequestMapping(value = "/updatecmd", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<CommandeVirt> modifier(@ModelAttribute CommandeVirt cmd, Model model) {
		 
		 Produit p = (Produit) caisseRepository.FIND_quant(cmd.getId());
		 if(p.getQuantite()>cmd.getQuantite())
		 {
		 double  p1 = Math.pow(10.0, 2);
		 
			double total=cmd.getQuantite()*cmd.getPrix_ht()*(1+cmd.getTva()/100);
			total=Math.floor(total*p1)/p1;
			cmd.setTotal(total);
		cmdVirRepository.save(cmd);
		 }
	List<CommandeVirt> json = (List<CommandeVirt>) cmdVirRepository.findAll() ;
	
		return json;
	    }
}
