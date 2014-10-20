package fr.uha.miage.caisse.repository;

import org.springframework.data.repository.CrudRepository;

import fr.uha.miage.caisse.model.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Long> {

	
}
