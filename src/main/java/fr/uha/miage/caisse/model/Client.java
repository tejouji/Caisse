package fr.uha.miage.caisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long Id_Client = (long) -1;
	@NotEmpty
	private String Nom,Prenom,Email,Adress;
	private String Date_Naissance,Sexe; 
	private int Telephone;
	
	private int Nbr_point;
	private long cartefid;
   
	
	


	public long getCartefid() {
		return cartefid;
	}

	public void setCartefid(long cartefid) {
		this.cartefid = cartefid;
	}

	public String getDate_Naissance() {
		return Date_Naissance;
	}

	public void setDate_Naissance(String date_Naissance) {
		Date_Naissance = date_Naissance;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public int getNbr_point() {
		return Nbr_point;
	}

	public void setNbr_point(int nbr_point) {
		Nbr_point = nbr_point;
	}

	public Long getId_Client() {
		return Id_Client;
	}

	public void setId_Client(Long id_Client) {
		Id_Client = id_Client;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getTelephone() {
		return Telephone;
	}

	public void setTelephone(int telephone) {
		Telephone = telephone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
