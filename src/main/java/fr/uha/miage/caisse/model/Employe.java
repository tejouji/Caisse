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
	private String Email_Employe;

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
