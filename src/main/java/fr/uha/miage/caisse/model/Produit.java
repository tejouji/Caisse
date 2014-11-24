package fr.uha.miage.caisse.model;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "Produit")
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id_p")
	Long id;
	@NotEmpty
	@Column(name="designation_pd")
	String designation_pd;
	@Column(name="prix_ht")
	Double prix_ht;
	@Column(name="codbar")
	long codbar;
	
	@Column(name="testcb")
	String testcb;
	 
	   
	@Column(name="quantite")
	int quantite;
	
	
	@JsonBackReference
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cat")
	CategorieProduit categorie ;
	
	
	public Produit() {
		
	}
	
	public Produit(String designation_pd, Double prix_ht, long codbar,
			String testcb, int quantite, CategorieProduit categorie,
			Collection<LigneCommande> ligne, Double tva) {
		super();
		this.designation_pd = designation_pd;
		this.prix_ht = prix_ht;
		this.codbar = codbar;
		this.testcb = testcb;
		this.quantite = quantite;
		this.categorie = categorie;
		this.ligne = ligne;
		this.tva = tva;
	}

	public CategorieProduit getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieProduit categorie) {
		this.categorie = categorie;
	}
	 @JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,mappedBy="produit",cascade=CascadeType.ALL)
	private Collection<LigneCommande> ligne ;
	@Column(name="tva")
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
	
	public Collection<LigneCommande> getLigne() {
		return ligne;
	}
	public void setLigne(Collection<LigneCommande> ligne) {
		this.ligne = ligne;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation_pd=" + designation_pd
				+ ", prix_ht=" + prix_ht + ", codbar=" + codbar + ", testcb="
				+ testcb + ", quantite=" + quantite + ", categorie="
				+ categorie + ", tva=" + tva + "]";
	}
	public long getCodbar() {
		return codbar;
	}
	public void setCodbar(long codbar) {
		this.codbar = codbar;
	}
	public String getTestcb() {
		return testcb;
	}
	public void setTestcb(String testcb) {
		this.testcb = testcb;
	}
	
	

}
