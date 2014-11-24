package fr.uha.miage.caisse.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employe")
public class Employe implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id_emp")
	private Long id;
	@NotEmpty
	@Column(name="nom_emp")
	private String nom_emp;
	@Column(name="pre_emp")
	private String pre_emp;
	@Column(name="dat_nai_emp")
	private String dat_nai_emp;
	@Column(name="sex_emp")
	private String sex_emp;
	@Column(name="tel_emp")
	private String tel_emp;
	@Column(name="mail_emp")
	private String mail_emp;
	@Column(name="adr_emp")
	private String adr_emp;
	@Column(name="mp_emp")
	private String mp_emp;
	 @JsonManagedReference
	@OneToMany(mappedBy="employe",cascade=CascadeType.ALL)
	private Collection<Commande> commande ;
	
	public Employe() {
		
	}
	
	public Employe(String nom_emp, String pre_emp, String dat_nai_emp,
			String sex_emp, String tel_emp, String mail_emp, String adr_emp,
			String mp_emp, Collection<Commande> commande) {
	
		this.nom_emp = nom_emp;
		this.pre_emp = pre_emp;
		this.dat_nai_emp = dat_nai_emp;
		this.sex_emp = sex_emp;
		this.tel_emp = tel_emp;
		this.mail_emp = mail_emp;
		this.adr_emp = adr_emp;
		this.mp_emp = mp_emp;
		this.commande = commande;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public String getPre_emp() {
		return pre_emp;
	}
	public void setPre_emp(String pre_emp) {
		this.pre_emp = pre_emp;
	}
	public String getDat_nai_emp() {
		return dat_nai_emp;
	}
	public void setDat_nai_emp(String dat_nai_emp) {
		this.dat_nai_emp = dat_nai_emp;
	}
	public String getSex_emp() {
		return sex_emp;
	}
	public void setSex_emp(String sex_emp) {
		this.sex_emp = sex_emp;
	}
	public String getTel_emp() {
		return tel_emp;
	}
	public void setTel_emp(String tel_emp) {
		this.tel_emp = tel_emp;
	}
	public String getMail_emp() {
		return mail_emp;
	}
	public void setMail_emp(String mail_emp) {
		this.mail_emp = mail_emp;
	}
	public String getAdr_emp() {
		return adr_emp;
	}
	public void setAdr_emp(String adr_emp) {
		this.adr_emp = adr_emp;
	}
	public String getMp_emp() {
		return mp_emp;
	}
	public void setMp_emp(String mp_emp) {
		this.mp_emp = mp_emp;
	}
	
	public Collection<Commande> getCommande() {
		return commande;
	}
	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom_emp=" + nom_emp + ", pre_emp="
				+ pre_emp + ", dat_nai_emp=" + dat_nai_emp + ", sex_emp="
				+ sex_emp + ", tel_emp=" + tel_emp + ", mail_emp=" + mail_emp
				+ ", adr_emp=" + adr_emp + ", mp_emp=" + mp_emp + "]";
	}


}
