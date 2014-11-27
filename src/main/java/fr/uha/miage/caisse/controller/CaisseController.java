package fr.uha.miage.caisse.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Commande;
import fr.uha.miage.caisse.model.CommandeVirt;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.model.LigneCommande;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CaisseRepository;
import fr.uha.miage.caisse.repository.ClientRepository;
import fr.uha.miage.caisse.repository.CommandeRepository;
import fr.uha.miage.caisse.repository.CommandeVirRepository;
import fr.uha.miage.caisse.repository.EmployeRepository;
import fr.uha.miage.caisse.repository.LigneRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;

@Controller
public class CaisseController {
	@Autowired
	ProduitRepository prodRepository;
	@Autowired
	CaisseRepository caisseRepository;
	@Autowired
	CommandeVirRepository cmdVirRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	LigneRepository lignrep;
	@Autowired
	CommandeRepository cmdrep;
	@Autowired
	ClientRepository clre;
	String name ;
	
	@RequestMapping(value = "/caisse", method = RequestMethod.GET)

	public String getCaisse(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
	    name = auth.getName(); // get logged in username
		session.getAttribute(name);
		System.out.println(clre.findAll().toString());
		System.out.println(clre.findAll().size());
		
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		return "caisse";
	}

	public String getCaisse(Model model) {
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 //String name = auth.getName(); //get logged in username
		 //System.out.println(name);	

		return "caisse";
	}

	@ResponseBody
	@RequestMapping(value = "/getCode", method = RequestMethod.POST)
	public String[] modifier(@RequestParam("term") String term, Model model) {
		long l = 0;
		String[] tab= new String[2];
		try {
			Produit json = (Produit) prodRepository.FIND_des(term);
			tab[0]=String.valueOf(json.getCodbar());
			tab[1]=String.valueOf(json.getId());
		} catch (Exception e) {

		}
		return tab;
	}

	@ResponseBody
	@RequestMapping(value = "/verif", method = RequestMethod.POST)
	public String verif(@RequestParam("term") Long term,
			@RequestParam("term1") int quantite, Model model) {
		String s = null;
		try {
			Produit p = (Produit) caisseRepository.FIND_quant(term);
			boolean testadd = true, testmodif = true;

			List<CommandeVirt> lcv = (List<CommandeVirt>) cmdVirRepository
					.findAll();
			int i = 0;
			while (lcv.size() > i && testadd == true)

			{
				if (lcv.get(i).getId() == term) {
					testadd = false;
					if (lcv.get(i).getQuantite() + term > p.getQuantite())
						testmodif = false;
					else
						quantite = lcv.get(i).getQuantite() + quantite;
				}
				i++;
			}

			if (p.getQuantite() > quantite) {

				CommandeVirt cmd = new CommandeVirt();
				cmd.setCategorie(p.getCategorie().getDesignation());
				cmd.setId(term);
				cmd.setDesignation_pd(p.getDesignation_pd());
				cmd.setPrix_ht(p.getPrix_ht());
				cmd.setQuantite(quantite);
				cmd.setTva(p.getTva());
				cmd.setCodbar(p.getCodbar());
				double p1 = Math.pow(10.0, 2);

				double total = quantite * p.getPrix_ht()
						* (1 + p.getTva() / 100);
				total = Math.floor(total * p1) / p1;
				cmd.setTotal(total);
				cmdVirRepository.save(cmd);

				s = "bien";

			} else
				s = "Quantité supérieur";
		} catch (Exception e) {
			s = "Saisir de nouveau la désignation ou le code du produit";
		}
		return s;
	}

	@ResponseBody
	@RequestMapping(value = "/loaddatacmd", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<CommandeVirt> modifier(Model model) {

		List<CommandeVirt> json = (List<CommandeVirt>) cmdVirRepository
				.findAll();

		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/getsum", method = RequestMethod.POST)
	public String verif(Model model) {
		double tot = 0;

		try {

			tot = cmdVirRepository.FIND_total();
		} catch (Exception e) {
		}
		return String.valueOf(tot);

	}

	@ResponseBody
	@RequestMapping(value = "/updatecmd", method = RequestMethod.POST,

	headers = "Accept=application/json")
	public List<CommandeVirt> modifier(@ModelAttribute CommandeVirt cmd,
			Model model) {

		Produit p = (Produit) caisseRepository.FIND_quant(cmd.getId());
		if (p.getQuantite() > cmd.getQuantite()) {
			double p1 = Math.pow(10.0, 2);

			double total = cmd.getQuantite() * cmd.getPrix_ht()
					* (1 + cmd.getTva() / 100);
			total = Math.floor(total * p1) / p1;
			cmd.setTotal(total);
			cmdVirRepository.save(cmd);
		}
		List<CommandeVirt> json = (List<CommandeVirt>) cmdVirRepository
				.findAll();

		return json;
	}
	@ResponseBody
	@RequestMapping(value="/valider", method = RequestMethod.POST)
	public void validerC(@RequestParam("cartefid") String cartefid ,@RequestParam("montant") double montant ,Model model){
	
		System.out.println(cartefid);
		List<CommandeVirt> liste = cmdVirRepository.findAll();
	Authentication auth = SecurityContextHolder.getContext()
			.getAuthentication();
    String nam = auth.getName();
	System.out.println(nam);
	// récupération de l'employe de la session actuelle
	Employe em =(Employe) employeRepository.FIND_BY_EM(nam);
	System.out.println(em.toString());
	 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	String da=   String.valueOf((dateFormat.format(date)));
	
	// Création de la commande
	Commande cmd =new Commande(null, null, em, da,montant); 
	cmdrep.save(cmd);
	System.out.println(cmd);
	// troucer le dernier enregistrement pour l'ajoute des ligneCommende
	Commande cmdd= (Commande) cmdrep.FIND_BY_CMD(); 
	System.out.println(cmd.getId()+"************************************************************************");
	ArrayList<LigneCommande> lgc = new ArrayList<LigneCommande>();
	for (CommandeVirt commandeVirt : liste) {
		Produit p = (Produit) prodRepository.FIND_des(commandeVirt.getDesignation_pd());
		p.setQuantite(p.getQuantite()-commandeVirt.getQuantite());
		prodRepository.save(p);
		LigneCommande lc=new LigneCommande(commandeVirt.getQuantite(), commandeVirt.getTotal(),p);	
		lc.setCommande(cmdd);
		lgc.add(lc);
		lignrep.save(lc);
	}
	//finalisation de la Commande
	
	System.out.println(lignrep.findAll().toString());
	// dans le cas ou on a un client enregistrer 
	Commande cmdp= (Commande) cmdrep.FIND_BY_CMD(); 
	cmdp.setLigne(lgc);
	if(String.valueOf(cartefid )!=""){
		Client clt = (Client) clientRepository.FIND_BY_CLT(Long.parseLong(cartefid));
		int nb = (int) (5 * montant);
		System.out.println("nombre de pointttttttt"+nb);
		clt.setNbr_point(nb+clt.getNbr_point());
		if(clt.getNbr_point()>1500){
			sendmail(clt);
		}
		cmdp.setClient(clt);
	}
   cmdrep.save(cmdp);
cmdVirRepository.deleteAll();
    System.out.println("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah"+cmdp);
    
		
	}

	public String sendmail(Client clt) {
		JavaMailSenderImpl j= new JavaMailSenderImpl();
		int mont=clt.getNbr_point()/100;
	
		String s="";
		
		try
		{
			j.setHost("smtp.free.fr");
			String sex="";
		if(clt.getSexe()=="Homme")
		{
			sex="Mr";
		}
		else
			sex="Mme";
		sex=sex+" "+clt.getNom()+" "+clt.getPrenom();
		MimeMessage message = j.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);	 
		helper.setTo(clt.getEmail());
		helper.setFrom("mohamed.benattouche@gmail.com","CIGA");
		helper.setSubject("sujet");
		 String text="<img  src='http://www.ciga.fr/assets/shop_resources/79/docs/carte-fidelite_1.jpg' style='width: 200px;height: 200px'/><b style='color:#000066;font-size:48px;font-family: fantasy;'> Magasin CIGA</b>"+
		 "<p style='color: #003399;font-family: monospace;font-size: 36px'> Bonjour"+sex+"</p>"
		+" <p style='color: #003399;font-family: monospace;font-size: 36px'> Grâce à votre fidélité vous avez atteint "+ clt.getNbr_point() +"d’une valeur de"+mont +" euros</p>"+
		" <img  src='http://www.lactolerance.fr/img/bloc%20fidelite.jpg' style='display: block; margin-left: auto; margin-right: auto;width: 400px;height: 150px;'/>"
		+" <p style='color: #003399;font-family: monospace;font-size: 36px'> Merci pour votre confiance à bientôt</p>";
		helper.setText(text,true);

		j.send(message);
		s="mail envoyé";
		}
		catch(Exception e)
		{ s=e.getMessage();}
		System.out.println(s);
		return s;
	}
}
