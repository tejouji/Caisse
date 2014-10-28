package fr.uha.miage.caisse.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@SuppressWarnings("serial")
@Entity
public class CategorieProduit implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	

	@NotEmpty
	private String designation;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produit ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	@Override
	public String toString() {
		return "CategorieProduit [id=" + id + ", designation=" + designation
				+ "]";
	}


}
