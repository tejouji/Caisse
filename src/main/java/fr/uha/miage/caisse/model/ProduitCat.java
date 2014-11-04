package fr.uha.miage.caisse.model;

public class ProduitCat {
	Long id;
	String designation_pd;
	Double prix_ht;
	int quantite;
	String categorie;
	
	public ProduitCat(Long id, String designation_pd, Double prix_ht,
			int quantite, String categorie) {
		super();
		this.id = id;
		this.designation_pd = designation_pd;
		this.prix_ht = prix_ht;
		this.quantite = quantite;
		this.categorie = categorie;
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
	

}
