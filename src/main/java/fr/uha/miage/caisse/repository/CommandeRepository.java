package fr.uha.miage.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import fr.uha.miage.caisse.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	public final static String FIND_BY_CMD="Select cmd From Commande cmd WHERE cmd.id =(Select max(id)from Commande)";
	@Query(FIND_BY_CMD)
	 public Commande FIND_BY_CMD();

}
