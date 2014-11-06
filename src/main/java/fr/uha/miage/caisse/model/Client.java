package fr.uha.miage.caisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id = (long) -1;
	@NotEmpty
	private String nom,prenom,email,adress;
	private String date_naissance,sexe; 
	private int telephone;
	
	private int nbr_point;
	private long cartefid;
   
	
	


	

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
