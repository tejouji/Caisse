package fr.uha.miage.caisse.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.model.ProduitCat;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	public final static String FIND_BY_ALL_QUERY="SELECT p.id,p.designation_pd,p.prix_ht,p.quantite,p.tva,c.id,c.designation,p.codbar from Produit p ,CategorieProduit c where p.categorie=c";
	@Query(FIND_BY_ALL_QUERY)
	 public List<Object[]> FIND_BY_ALL();

	 public final static String FIND_BY_des="SELECT p from Produit p WHERE p.designation_pd Like concat(:term,'%')";
		
		@Query(FIND_BY_des)
		
		 public List<Produit> FIND_BY_desauto(@Param("term") String term);	
		
		
		
		 public final static String FIND_des="SELECT p from Produit p WHERE p.designation_pd = :term)";
			
			@Query(FIND_des)
			
			 public Produit FIND_des(@Param("term") String term);	
			
			
			 public final static String FIND_SANS_CB="SELECT p from Produit p WHERE p.testcb = 'non')";
				
				@Query(FIND_SANS_CB)
				
				 public List<Produit> FIND_SANS_CB();	

}
