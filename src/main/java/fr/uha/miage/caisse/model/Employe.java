package fr.uha.miage.caisse.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employe {
	

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String nom_emp;
	private String pre_emp;
	
	private String dat_nai_emp;
	private String sex_emp;
	private String tel_emp;
	private String mail_emp;
	private String adr_emp;
	private String mp_emp;
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
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom_emp=" + nom_emp + ", pre_emp="
				+ pre_emp + ", dat_nai_emp=" + dat_nai_emp + ", sex_emp="
				+ sex_emp + ", tel_emp=" + tel_emp + ", mail_emp=" + mail_emp
				+ ", adr_emp=" + adr_emp + ", mp_emp=" + mp_emp + "]";
	}


}
