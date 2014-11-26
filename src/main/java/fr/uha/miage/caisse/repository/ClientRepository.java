package fr.uha.miage.caisse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.uha.miage.caisse.model.Client;




public interface ClientRepository extends JpaRepository<Client, Long> {
	public final static String FIND_BY_CLT="SELECT clt from Client clt where clt.cartefid=:cartefid";
	@Query(FIND_BY_CLT)
	 public Client FIND_BY_CLT(@Param("cartefid") long cartefid);
	public final static String FIND_BY_carte="SELECT clt from Client clt where clt.cartefid Like concat(:term,'%')";
	@Query(FIND_BY_carte)
	 public List<Client> FIND_BY_carte(@Param("term") long cartefid);

}
