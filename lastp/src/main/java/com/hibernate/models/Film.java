package com.hibernate.models;

import javax.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	public class Film {
	@Id
	private Integer id;
	public void setId(Integer i) {id = i;}
	@Column
	String titre;
	public void setTitre(String t) {titre= t;}
	public String getTitre() {return titre;}
	@Column
	Integer annee;
	public void setAnnee(Integer a) {annee = a;}
	public Integer getAnnee() {return annee;}
	@Column
	Integer id_realisateur;
	public Integer getId_realisateur() {
		return id_realisateur;
	}
	public void setId_realisateur(Integer id_realisateur) {
		this.id_realisateur = id_realisateur;
	}
	@Column
	String 	genre;
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Column
	String 	resume;
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column
	String 	code_pays;
	public String getCode_pays() {
		return code_pays;
	}
	public void setCode_pays(String code_pays) {
		this.code_pays = code_pays;
	}

//	@ManyToOne
//	@JoinColumn (name="code")
//	Pays pays;
//	public void setPays(Pays p) {pays = p;}
//	public Pays getPays() {return pays;}


	}


