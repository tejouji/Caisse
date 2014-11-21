package fr.uha.miage.caisse.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.LigneCommande;

public interface LigneRepository extends CrudRepository<LigneCommande, Long> {
	

}
