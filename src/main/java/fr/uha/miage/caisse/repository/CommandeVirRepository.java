package fr.uha.miage.caisse.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fr.uha.miage.caisse.model.CommandeVirt;


	
	public interface CommandeVirRepository extends JpaRepository<CommandeVirt, Long> {
		 public final static String FIND_total="SELECT sum(p.total) from CommandeVirt p";
			
			@Query(FIND_total)
			
			 public double FIND_total();	


	}



