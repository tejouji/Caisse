package fr.uha.miage.caisse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employe {
	@Id
	@GeneratedValue
	private Long Id_Employe;

	private String Nom_Employe;
	private String Prenom_Employe;
	private String Date_Naissance_E;
	private String Sexe_Employe;
	private String Telephone_Employe;
	private String Email_Employe;
	private String Adress_Employe;
	private String Password;

	public String getTelephone_Employe() {
		return Telephone_Employe;
	}

	public void setTelephone_Employe(String telephone_Employe) {
		Telephone_Employe = telephone_Employe;
	}

	public String getDate_Naissance_E() {
		return Date_Naissance_E;
	}

	public void setDate_Naissance_E(String date_Naissance_E) {
		Date_Naissance_E = date_Naissance_E;
	}

	public String getSexe_Employe() {
		return Sexe_Employe;
	}

	public void setSexe_Employe(String sexe_Employe) {
		Sexe_Employe = sexe_Employe;
	}

	public String getAdress_Employe() {
		return Adress_Employe;
	}

	public void setAdress_Employe(String adress_Employe) {
		Adress_Employe = adress_Employe;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Long getId_Employe() {
		return Id_Employe;
	}

	public void setId_Employe(Long id_Employe) {
		Id_Employe = id_Employe;
	}

	public String getNom_Employe() {
		return Nom_Employe;
	}

	public void setNom_Employe(String nom_Employe) {
		Nom_Employe = nom_Employe;
	}

	public String getPrenom_Employe() {
		return Prenom_Employe;
	}

	public void setPrenom_Employe(String prenom_Employe) {
		Prenom_Employe = prenom_Employe;
	}

	public String getEmail_Employe() {
		return Email_Employe;
	}

	public void setEmail_Employe(String email_Employe) {
		Email_Employe = email_Employe;
	}

}
