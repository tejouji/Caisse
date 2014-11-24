package fr.uha.miage.caisse.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande {
	@Id
	@GeneratedValue
	@Column(name="id_cm")
	private long id;
	@OneToMany(fetch = FetchType.EAGER,mappedBy="commande",cascade=CascadeType.ALL)
	private Collection<LigneCommande> ligne ;
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clt")
	Client client ;
	
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Employe employe;
	@Column(name="date")
	private String date;
	@Column(name="montant")
	private double montant;
	
	public Commande()
	{}
	
	public Commande(Collection<LigneCommande> ligne, Client client,
			Employe employe, String date, double montant) {
		
		this.ligne = ligne;
		this.client = client;
		this.employe = employe;
		this.date = date;
		this.montant = montant;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Collection<LigneCommande> getLigne() {
		return ligne;
	}
	public void setLigne(Collection<LigneCommande> ligne) {
		this.ligne = ligne;
	}

	/*@Override
	public String toString() {
		return "Commande [id=" + id + ", ligne=" + ligne + ", client=" + client
				+ ", employe=" + employe + ", date=" + date + ", montant="
				+ montant + "]";
	}*/
	

}
