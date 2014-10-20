package fr.uha.miage.caisse.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.Client;



public interface ClientRepository extends CrudRepository<Client, Long> {

}
