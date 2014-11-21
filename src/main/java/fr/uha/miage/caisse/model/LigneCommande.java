package fr.uha.miage.caisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Commande commande;
	private long quatite;
	private double montprd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public long getQuatite() {
		return quatite;
	}
	public void setQuatite(long quatite) {
		this.quatite = quatite;
	}
	public double getMontprd() {
		return montprd;
	}
	public void setMontprd(double montprd) {
		this.montprd = montprd;
	}
	

}
