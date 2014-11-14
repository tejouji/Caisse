package fr.uha.miage.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.uha.miage.caisse.model.Produit;



public interface CaisseRepository extends JpaRepository<Produit, Long> {
	
	 public final static String FIND_quant="SELECT p from Produit p WHERE p.id = :term)";
		
		@Query(FIND_quant)
		
		 public Produit FIND_quant(@Param("term") Long term);	

}