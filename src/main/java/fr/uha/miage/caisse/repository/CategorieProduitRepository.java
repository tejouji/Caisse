package fr.uha.miage.caisse.repository;

import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.uha.miage.caisse.model.CategorieProduit;

public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long> {
	
	public final static String FIND_BY_des="SELECT c from CategorieProduit c where c.designation=:designation";
	@Query(FIND_BY_des)
	
	 public CategorieProduit FIND_BY_des(@Param("designation") String designation);






}
