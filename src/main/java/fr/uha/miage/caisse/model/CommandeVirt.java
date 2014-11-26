package fr.uha.miage.caisse.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CommandeVirt {

	@Id

	Long id;
	
	String designation_pd;

	Double prix_ht;
	
	int quantite;
	
	 double total;
long codbar;
	
	String categorie ;
	Double tva;
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public long getCodbar() {
		return codbar;
	}
	public void setCodbar(long codbar) {
		this.codbar = codbar;
	}
	

}
