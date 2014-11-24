package fr.uha.miage.caisse.model;

import java.io.Serializable;

public class ProduitCat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String designation_pd;
	Double prix_ht;
	int quantite;
	String categorie;
	Double tva;
	Long idcat;
	
	public ProduitCat(Long id, String designation_pd, Double prix_ht,
			int quantite,Double tva, Long idcat,String categorie) {
	
		this.id = id;
		this.designation_pd = designation_pd;
		this.prix_ht = prix_ht;
		this.quantite = quantite;
		this.categorie = categorie;
		this.idcat=idcat;
		this.tva=tva;
	}
	 public ProduitCat() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "ProduitCat [id=" + id + ", designation_pd=" + designation_pd
				+ ", prix_ht=" + prix_ht + ", quantite=" + quantite
				+ ", categorie=" + categorie + ", tva=" + tva + ", idcat="
				+ idcat + "]";
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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public Double getTva() {
		return tva;
	}


	public void setTva(Double tva) {
		this.tva = tva;
	}


	public Long getIdcat() {
		return idcat;
	}


	public void setIdcat(Long idcat) {
		this.idcat = idcat;
	}
	

}
