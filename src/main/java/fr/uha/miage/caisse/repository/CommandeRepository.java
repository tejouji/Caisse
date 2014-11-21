package fr.uha.miage.caisse.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Long> {

}
