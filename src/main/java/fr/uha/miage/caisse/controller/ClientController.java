package fr.uha.miage.caisse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.ClientRepository;
import fr.uha.miage.caisse.repository.EmployeRepository;

@Controller
public class ClientController {

	@Autowired
	ClientRepository clientrepository;
	@Autowired
	EmployeRepository employeRepository;
	long cartefid=0;
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String Auth(Model model,HttpSession session) {
		
		Client c = new Client();
		
		long l;
		
		if (clientrepository.count() != 0) {

			Client cl = clientrepository.findOne(clientrepository.count());
			l = cl.getId()+1;
			System.out.println(l);
			System.out.println("count=" + clientrepository.findAll());
		} else {
			System.out.println("vide");
			l = 1;
		}
		
		String idForme = null;
		String nbaleForme = null;
		long nombreAleatoire = 0;
		if (l < 10) {
			idForme = String.valueOf(l);
			nombreAleatoire = 1000000 + (int) (Math.random() * ((9999999 - 1000000) + 1));
		}
	
		System.out.println("pleine");
		System.out.println(clientrepository.count());
		System.out.println("id" + l);

		System.out.println("nbaler" + nombreAleatoire);
		nbaleForme = String.valueOf(nombreAleatoire);
		String f = nbaleForme + idForme;
		 cartefid = Long.valueOf(f);
		System.out.print(cartefid);
		c.setCartefid(cartefid);
		
		model.addAttribute("client", c);
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
	    String name = auth.getName(); // get logged in username
		session.getAttribute(name);
		Employe em = (Employe) employeRepository.FIND_BY_EM(name);
		if(em.getRole().equals("admin")){
			return "client";
		}
		else{
			return"userClt";
		}	
		
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String Add(@Valid Client client, BindingResult bindingResult,
			Model model) {
		System.out.println("getcarte"+cartefid);
	//	clientrepository.save(client);

		// pour afficher sur la meme page
	
		client.setCartefid(cartefid);
	client.setNbr_point(0);
		clientrepository.save(client);
		//c.setCartefid(cartefid);
	//	model.addAttribute("client", c);
		System.out.println("liste   **" + clientrepository.findAll());
		model.addAttribute("clients", clientrepository.findAll());
		Client cc = new Client();
		cc.setCartefid(client.getCartefid()+1);
		model.addAttribute("client", cc);
		
		System.out.println(clientrepository.findAll());
		return "redirect:/client";
	}



	@ResponseBody
	@RequestMapping(value = "/loaddataClt", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<Client> allPhones() {
		List<Client> json = (List<Client>) clientrepository.findAll();
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/deletedataClt", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<Client> supprimer(@RequestParam("id") Long id) {
		clientrepository.delete(id);
		List<Client> json = (List<Client>) clientrepository.findAll();

		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/updatedataClt", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<Client> modifier(@ModelAttribute Client client, Model model) {
		clientrepository.save(client);
		List<Client> json = (List<Client>) clientrepository.findAll();

		return json;
	}
	
	
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	public String getCaisse(Model model) {
		
		return "sendmail";
	}
	@SuppressWarnings("null")
	@ResponseBody
		@RequestMapping(value = "/autocarte", method = RequestMethod.GET,
				
				
				headers="Accept=application/json")

	   

	    public List<String> allcatauto(@RequestParam("term") String term) {
	
		
		 @SuppressWarnings("unchecked")
		List<Client> l = (List<Client>) clientrepository.FIND_BY_carte(Long.parseLong(term)) ;
		

			List<String> json1 =new ArrayList<String>();
			for(int i=0;i<l.size();i++)
				
			{
				json1.add(String.valueOf(l.get(i).getCartefid()));
				
			}
			
			
			
	
		return json1;
 }
}
