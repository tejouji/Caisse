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

import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.repository.ClientRepository;

@Controller
public class ClientController {

	@Autowired
	ClientRepository clientrepository;

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String Auth(Model model) {
		model.addAttribute("client", new Client());
		Client c = new Client();
		long l;
		if (clientrepository.count() != 0) {

			c = clientrepository.findOne(clientrepository.count());
			l = c.getId();

			System.out.println("pleine");
			System.out.println("count=" + clientrepository.count());
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
		if (l > 10 && l < 100) {
			idForme = String.valueOf(l);
			nombreAleatoire = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));
		}
		if (l > 100 && l < 1000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 1000 && l < 10000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 10000 && l < 100000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 100000 && l < 1000000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		System.out.println("pleine");
		System.out.println(clientrepository.count());
		System.out.println("id" + l);

		System.out.println("nbaler" + nombreAleatoire);
		nbaleForme = String.valueOf(nombreAleatoire);
		String f = nbaleForme + idForme;
		long cartefid = Long.valueOf(f);
		System.out.print(cartefid);
		c.setCartefid(cartefid);
		model.addAttribute("client", c);
		model.addAttribute("clients", clientrepository.findAll());
		return "client";
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String Add(@Valid Client client, BindingResult bindingResult,
			Model model) {
		clientrepository.save(client);

		// pour afficher sur la meme page
		Client c = new Client();
		long l;
		c = clientrepository.findOne(clientrepository.count());
		l = c.getId() + 1;
		String idForme = null;
		String nbaleForme = null;
		long nombreAleatoire = 0;
		if (l < 10) {
			idForme = String.valueOf(l);
			nombreAleatoire = 1000000 + (int) (Math.random() * ((9999999 - 1000000) + 1));
		}
		if (l > 10 && l < 100) {
			idForme = String.valueOf(l);
			nombreAleatoire = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));
		}
		if (l > 100 && l < 1000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 1000 && l < 10000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 10000 && l < 100000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		if (l > 100000 && l < 1000000) {
			idForme = String.valueOf(l);
			nombreAleatoire = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
		}
		System.out.println("pleine");
		System.out.println(clientrepository.count());
		System.out.println("id" + l);

		System.out.println("nbaler" + nombreAleatoire);
		nbaleForme = String.valueOf(nombreAleatoire);
		String f = nbaleForme + idForme;
		long cartefid = Long.valueOf(f);
		System.out.print(cartefid);
		c.setCartefid(cartefid);
		model.addAttribute("client", c);
		System.out.println("liste   **" + clientrepository.findAll());
		model.addAttribute("clients", clientrepository.findAll());
		Client cc = new Client();
		cc.setCartefid(cartefid);
		model.addAttribute("client", cc);
		return "client";
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

}
