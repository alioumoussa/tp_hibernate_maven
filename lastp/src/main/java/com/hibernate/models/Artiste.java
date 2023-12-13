package com.hibernate.models;

import jakarta.persistence.*;

@Entity
public class Artiste {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
@Column
 private String nom;
@Column
 private String prenom;
@Column
 private Integer annee_naissance;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
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
public Integer getAnnee_naissance() {
	return annee_naissance;
}
public void setAnnee_naissance(Integer annee_naissance) {
	this.annee_naissance = annee_naissance;
}


}
