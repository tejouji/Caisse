package fr.uha.miage.caisse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.CategorieProduit;

public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long> {
	
	

}
