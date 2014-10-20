package fr.uha.miage.caisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class CategorieProduit {
	
	@Id
	@GeneratedValue
	private long id;
	

	
	private String designation;
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
