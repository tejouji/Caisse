package fr.uha.miage.caisse.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import org.springframework.web.multipart.MultipartFile;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.model.ProduitCat;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository prodRepository;
	
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	CategorieProduit cat;
	
	@RequestMapping(value = "/fichepd", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("produit", new Produit());
	
	model.addAttribute("categorieProduits",catProdRepository.findAll());
//	model.addAttribute("categorieProduit", new CategorieProduit());
	model.addAttribute("produits", prodRepository.findAll());
	
		return "fichepd";
	}	
	
	@RequestMapping(value = "/fichepd", method = RequestMethod.POST)
	public String listpd(@Valid Produit produit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "fichepd";
        }
	model.addAttribute("produit", new Produit());
	prodRepository.save(produit);
	//System.out.println(produit);
	model.addAttribute("produits", prodRepository.findAll());
	model.addAttribute("categorieProduits",catProdRepository.findAll());
		return "fichepd";
	}	
	 @ResponseBody
		@RequestMapping(value = "/loaddatapd", method = RequestMethod.POST,
				
				
				headers="Accept=application/json")

	   

	    public List<ProduitCat> allPhones() {
	//List<Produit> json = (List<Produit>) prodRepository.findAll() ;
	List<ProduitCat> json1 = new ArrayList<ProduitCat>() ;
		
		
		
	Object[] tab= new Object[7];
	 List<Object[]> groupList = (List<Object[]>) prodRepository.FIND_BY_ALL() ;
	 

	for(int i=0;i<groupList.size();i++)
	{tab=groupList.get(i);
	//Double d = (Double) tab[2];
	Long id=Long.parseLong(tab[0].toString());
	String designation_pd=String.valueOf(tab[1]);
	Double prix_ht=Double.parseDouble(String.valueOf(tab[2]));
	int quantite=Integer.parseInt(String.valueOf(tab[3]));
	String categorie=String.valueOf(tab[6]);
Double tva=Double.parseDouble(String.valueOf(tab[4]));
	
	Long idcat=Long.parseLong(String.valueOf(tab[5]));
	
	ProduitCat pc= new ProduitCat(id, designation_pd, prix_ht, quantite, tva, idcat, categorie);
	json1.add(pc);
	
	}
	
	//System.out.println(json1);
		return json1;
	    }
		  
		 
		 
		 @ResponseBody
			@RequestMapping(value = "/deletedatapd", method = RequestMethod.POST,
					
					
					headers="Accept=application/json")

		   

		    public List<Produit> supprimer(@RequestParam("id") Long id) {
			prodRepository.delete(id);
		List<Produit> json = (List<Produit>) prodRepository.findAll() ;
		
			return json;
		    }
		 
		 @ResponseBody
			@RequestMapping(value = "/updatedatapd", method = RequestMethod.POST,
					
					
					headers="Accept=application/json")

		   

		   
		 public List<ProduitCat> modifier(@ModelAttribute ProduitCat product, Model model) {
		System.out.println("test");
			 System.out.println("test"+product);
			 
			 
		List<ProduitCat> json1 = new ArrayList<ProduitCat>() ;
		CategorieProduit c=catProdRepository.FIND_BY_des(product.getCategorie());
		Produit p= new Produit();
		p.setId(product.getId());
		p.setCategorie(c);
	p.setDesignation_pd(product.getDesignation_pd());
	p.setPrix_ht(product.getPrix_ht());
	p.setQuantite(product.getQuantite());
	p.setTva(product.getTva());
	prodRepository.save(p);
		
		
	Object[] tab= new Object[7];
	 List<Object[]> groupList = (List<Object[]>) prodRepository.FIND_BY_ALL() ;
	 

	for(int i=0;i<groupList.size();i++)
	{tab=groupList.get(i);
	//Double d = (Double) tab[2];
	Long id=Long.parseLong(tab[0].toString());
	String designation_pd=String.valueOf(tab[1]);
	Double prix_ht=Double.parseDouble(String.valueOf(tab[2]));
	int quantite=Integer.parseInt(String.valueOf(tab[3]));
	String categorie=String.valueOf(tab[6]);
Double tva=Double.parseDouble(String.valueOf(tab[4]));
	
	Long idcat=Long.parseLong(String.valueOf(tab[5]));
	
	ProduitCat pc= new ProduitCat(id, designation_pd, prix_ht, quantite, tva, idcat, categorie);
	json1.add(pc);
	
	}
	
	//System.out.println(json1);
		return json1;
		    }

	
		 @SuppressWarnings("null")
			@ResponseBody
				@RequestMapping(value = "/autoproduit", method = RequestMethod.GET,
						
						
						headers="Accept=application/json")

			   

			    public List<String> allcatauto(@RequestParam("term") String term) {
			
				
				 List<Produit> l = (List<Produit>) prodRepository.FIND_BY_desauto(term) ;
				

					List<String> json1 =new ArrayList<String>();
					for(int i=0;i<l.size();i++)
						
					{
						json1.add(l.get(i).getDesignation_pd());
						
					}
					
					
					
			
				return json1;
		 }
}
