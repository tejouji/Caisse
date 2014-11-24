package fr.uha.miage.caisse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fr.uha.miage.caisse.model.CategorieProduit;
import fr.uha.miage.caisse.model.Client;
import fr.uha.miage.caisse.model.Commande;
import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.model.LigneCommande;
import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.repository.CategorieProduitRepository;
import fr.uha.miage.caisse.repository.ClientRepository;
import fr.uha.miage.caisse.repository.CommandeRepository;
import fr.uha.miage.caisse.repository.EmployeRepository;
import fr.uha.miage.caisse.repository.LigneRepository;
import fr.uha.miage.caisse.repository.ProduitRepository;


@ComponentScan
@EnableAutoConfiguration
public class Application {
	
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = SpringApplication
				.run(Application.class);
		EmployeRepository employeRepository = context
				.getBean(EmployeRepository.class);
		ClientRepository clientRepository=context.getBean(ClientRepository.class);
		CategorieProduitRepository catprdRepository=context.getBean(CategorieProduitRepository.class);
		ProduitRepository prdRepository=context.getBean(ProduitRepository.class);
		LigneRepository lrep=context.getBean(LigneRepository.class);
		CommandeRepository cmdrep=context.getBean(CommandeRepository.class);
		// ------------------- échantillon de données------------------
		
		Client c=new Client("ff", "nn", "ff", "fff", "2014-11-27", "jj", 554, 445, null);
		clientRepository.save(c);
		Employe em=new Employe("Benkhabcheche", "tedj",
				"02/04/1989", "Homme", "077777", "b.tedj@gmail.com",
				"mulhouse", "test",null);
		employeRepository.save(em);
		employeRepository.save(new Employe("BenAttouche", "Mohamed",
				"12/03/1989", "Homme", "05555", "b.med@gmail.com", "mulhouse",
				"test",null));
		CategorieProduit cr=new CategorieProduit(1, "sport", null);
		catprdRepository.save(cr);
		Produit p= new Produit("addidas", (double) 11, 0, "non", 5, cr, null, 15.00);
		prdRepository.save(p);
		Commande cmd= new Commande(null, c, em, "12/09/2014", (double)444);
		cmdrep.save(cmd);
		LigneCommande lcmd=new LigneCommande(14, (double)100, p, cmd);
		lrep.save(lcmd);
	     Iterable<Commande> customers = cmdrep.findAll();
	        System.out.println("Customers found with findAll():");
	        System.out.println("-------------------------------");
	        for (Commande customer : customers) {
	        	 Iterable<LigneCommande> l = customer.getLigne();
	        	 for (LigneCommande li : l) {
	            System.out.println(li.getQuatite());
	        }}
	        System.out.println();

	
    }
    
}
