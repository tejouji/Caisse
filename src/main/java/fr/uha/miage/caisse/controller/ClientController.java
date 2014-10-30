package fr.uha.miage.caisse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.RequestParam;

import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.repository.ClientRepository;


@Controller
public class ClientController {
	
	@Autowired
	ClientRepository clientrepository;
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String Auth(Model model) {
	model.addAttribute("client", new Client());
	Client c= new Client();
	long l;
	if(clientrepository.count()!=0)
	{
	
	c=clientrepository.findOne(clientrepository.count());
	l=c.getId_Client();
	

		System.out.println("pleine");
		System.out.println("count="+clientrepository.count());
	}
	else 
	{
		System.out.println("vide");
		l=1;	
	}
	
	String idForme = null;
	String nbaleForme=null;
	long nombreAleatoire = 0;
	if(l<10)
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
	}
	if(l>10 && l<100 )
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 100000 + (int)(Math.random() * ((999999 - 100000) + 1));
	}
	if(l>100 && l<1000 )
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
	}
	if(l>1000 && l<10000 )
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
	}
	if(l>10000 && l<100000 )
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
	}
	if(l>100000 && l<1000000 )
	{
	idForme=String.valueOf(l);
	nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
	}
	System.out.println("pleine");
	System.out.println(clientrepository.count());
	System.out.println("id"+l);
	 
	System.out.println("nbaler"+nombreAleatoire);
	nbaleForme=String.valueOf(nombreAleatoire);
	String f=nbaleForme+idForme;
	long cartefid=Long.valueOf(f);
	System.out.print(cartefid);
c.setCartefid(cartefid);
	model.addAttribute("client",c );
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String Add(@ModelAttribute Client client, Model model) {
		clientrepository.save(client);
	
		//pour afficher sur la meme page 
		Client c= new Client();
		long l;
		c=clientrepository.findOne(clientrepository.count());
		l=c.getId_Client()+1;
		String idForme = null;
		String nbaleForme=null;
		long nombreAleatoire = 0;
		if(l<10)
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 1000000 + (int)(Math.random() * ((9999999 - 1000000) + 1));
		}
		if(l>10 && l<100 )
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 100000 + (int)(Math.random() * ((999999 - 100000) + 1));
		}
		if(l>100 && l<1000 )
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
		}
		if(l>1000 && l<10000 )
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
		}
		if(l>10000 && l<100000 )
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
		}
		if(l>100000 && l<1000000 )
		{
		idForme=String.valueOf(l);
		nombreAleatoire = 10000 + (int)(Math.random() * ((99999 - 10000) + 1));
		}
		System.out.println("pleine");
		System.out.println(clientrepository.count());
		System.out.println("id"+l);
		 
		System.out.println("nbaler"+nombreAleatoire);
		nbaleForme=String.valueOf(nombreAleatoire);
		String f=nbaleForme+idForme;
		long cartefid=Long.valueOf(f);
		System.out.print(cartefid);
		c.setCartefid(cartefid);
		model.addAttribute("client", c);
		model.addAttribute("clients", clientrepository.findAll());
	  	return "client";
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String deleteClient(@RequestParam("Id") Long Id_Client, Model model) {
		
		clientrepository.delete(Id_Client);
		
		return "client";
	}
	
	

}
