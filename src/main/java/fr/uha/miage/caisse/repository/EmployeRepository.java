package fr.uha.miage.caisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.uha.miage.caisse.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	public final static String FIND_BY_EM="SELECT em from Employe em where em.pre_emp=:pre_emp";
	@Query(FIND_BY_EM)
	 public Employe FIND_BY_EM(@Param("pre_emp") String pre_emp);
	
}
