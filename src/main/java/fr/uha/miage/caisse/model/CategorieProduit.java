package fr.uha.miage.caisse.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@SuppressWarnings("serial")
@Entity
@Table(name = "categorie")
public class CategorieProduit implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id_cat")
	private long id;
	

	@NotEmpty
	@Column(name="designation")
	private String designation;
	 @JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy="categorie",cascade=CascadeType.ALL)
	private Collection<Produit> produit ;
	
	
	
	public CategorieProduit() {
		
	}
	public CategorieProduit(String designation,
			Collection<Produit> produit) {
		
		
		this.designation = designation;
		this.produit = produit;
	}
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
	
	
	public Collection<Produit> getProduit() {
		return produit;
	}
	public void setProduit(Collection<Produit> produit) {
		this.produit = produit;
	}
	@Override
	public String toString() {
		return "CategorieProduit [id=" + id + ", designation=" + designation
				+ "]";
	}


}
