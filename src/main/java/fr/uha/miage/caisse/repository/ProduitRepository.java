package fr.uha.miage.caisse.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

}
