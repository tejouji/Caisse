package fr.uha.miage.caisse.model;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue
	Long id;
	@NotEmpty
	String designation_pd;
	
	Double prix_ht;
	
	 
	   
	    
	int quantite;
	
	 private String name;
	
	public String getFilename() {
		return name;
	}
	public void setFilename(String filename) {
		this.name = filename;
	}

	@ManyToOne
	CategorieProduit categorie ;
	public CategorieProduit getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
	}
	Double tva;
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation_pd() {
		return designation_pd;
	}
	public void setDesignation_pd(String designation_pd) {
		this.designation_pd = designation_pd;
	}
	public Double getPrix_ht() {
		return prix_ht;
	}
	public void setPrix_ht(Double prix_ht) {
		this.prix_ht = prix_ht;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation_pd=" + designation_pd
				+ ", prix_ht=" + prix_ht + ", quantite=" + quantite
				+ ", categorie=" + categorie + ", tva=" + tva + "]";
	}
	

}
