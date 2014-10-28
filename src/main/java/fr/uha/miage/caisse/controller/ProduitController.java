package fr.uha.miage.caisse.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository prodRepository;
	@Autowired
	private CategorieProduitRepository catProdRepository;
	
	@RequestMapping(value = "/fichepd", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("produit", new Produit());
	
	model.addAttribute("categorieProduits",catProdRepository.findAll());
//	model.addAttribute("categorieProduit", new CategorieProduit());
	model.addAttribute("produits", prodRepository.findAll());
	
		return "fichepd";
	}	
	/*
	@RequestMapping(value = "/listpd", method = RequestMethod.POST)
	public String listpd(@Valid Produit produit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "fichepd";
        }
	model.addAttribute("produit", new Produit());
	prodRepository.save(produit);
	System.out.println(produit);
	model.addAttribute("produits", prodRepository.findAll());
		return "fichepd";
	}	
	*/
	 @RequestMapping(value="/listpd", method=RequestMethod.POST)
	    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
	            @RequestParam("picture") MultipartFile file,@Valid Produit produit, BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
	            return "fichepd";
	        } 
		 if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
	                stream.write(bytes);
	                model.addAttribute("produit", new Produit());
	            	prodRepository.save(produit);
	            	System.out.println(produit);
	            	model.addAttribute("produits", prodRepository.findAll());
	                stream.close();
	                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
	            
	            
	            } catch (Exception e) {
	                return "You failed to upload " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload " + name + " because the file was empty.";
	        }
	    }

}
