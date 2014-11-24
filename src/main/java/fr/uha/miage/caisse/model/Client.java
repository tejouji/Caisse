package fr.uha.miage.caisse.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "Client")
public class Client {
	@Id
	@GeneratedValue
	@Column(name="id_clt")
	private Long id ;
	@NotEmpty
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	
	
	public Client() {
		
	}

	public Client(String nom, String prenom, String email, String adress,
			String date_naissance, String sexe, int telephone, int nbr_point,
			Collection<Commande> commande) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adress = adress;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.telephone = telephone;
		this.nbr_point = nbr_point;
		this.commande = commande;
	}

	public Collection<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}

	@Column(name="email")
		private String email;
		@Column(name="adress")
	private String adress;
	@Column(name="date_naissance")
	private String date_naissance;
	@Column(name="sexe")
	private String sexe;
	@Column(name="telephone")
	private int telephone;
	@Column(name="nbr_point")
	private int nbr_point;
	@Column(name="cartefid")
	private long cartefid;
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	private Collection<Commande> commande ;
	
	


	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getNbr_point() {
		return nbr_point;
	}

	public void setNbr_point(int nbr_point) {
		this.nbr_point = nbr_point;
	}

	public long getCartefid() {
		return cartefid;
	}

	public void setCartefid(long cartefid) {
		this.cartefid = cartefid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
