package fr.uha.miage.caisse.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.Produit;
import fr.uha.miage.caisse.model.ProduitCat;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	public final static String FIND_BY_ALL_QUERY="SELECT p.id,p.designation_pd,p.prix_ht,p.quantite,p.tva,c.id,c.designation from Produit p ,CategorieProduit c where p.categorie=c";
	@Query(FIND_BY_ALL_QUERY)
	 public List<Object[]> FIND_BY_ALL();

	
}
