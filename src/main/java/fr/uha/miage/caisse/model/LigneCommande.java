package fr.uha.miage.caisse.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ligne")
public class LigneCommande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id_l")
	private long id;
	@Column(name="quantite")
	private long quatite;
	@Column(name="montprd")
	private double montprd;
	@JsonBackReference
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="id_p")
	Produit produit ; 
	@JsonBackReference
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cm")
	Commande commande ; 
	public LigneCommande(){}
	public LigneCommande(long quatite, double montprd, Produit produit) {
		
		this.quatite = quatite;
		this.montprd = montprd;
		this.produit = produit;
		
	}
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
	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quatite=" + quatite
				+ ", montprd=" + montprd + ", produit=" + produit
				+ "]";
	}
	
	

}
