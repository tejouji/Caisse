package fr.uha.miage.caisse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.uha.miage.caisse.model.Commande;
import fr.uha.miage.caisse.model.Employe;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
	public final static String FIND_BY_CMD="Select cmd From Commande cmd WHERE cmd.id =(Select max(id)from Commande)";
	@Query(FIND_BY_CMD)
	 public Commande FIND_BY_CMD();
	
	public final static String FIND_BY_date="SELECT cmd from Commande cmd WHERE ( cmd.date Like concat(:term,'%') AND cmd.employe=(Select emp from Employe emp WHERE emp.nom_emp=:nom And emp.pre_emp=:prenom))";
	
	@Query(FIND_BY_date)
	
	 public List<Commande> FIND_BY_date(@Param("term") String term ,@Param("nom") String nom,@Param("prenom") String prenom);	

	public final static String FIND_BY_emp="SELECT emp from Employe emp WHERE emp.nom_emp Like concat(:term,'%') ";
	
	@Query(FIND_BY_emp)
	
	 public List<Employe> FIND_BY_emp(@Param("term") String term);	
}
