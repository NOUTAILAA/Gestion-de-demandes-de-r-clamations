package com.sjprogramming.restapi.entity;

import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@Column
private String nom; 
@Column
private String prenom;
@Column
private String mdp ; 
@Column
private String role;
@Column
private String tele;
@Column
private String email;


private User() {}






public User(String nom, String prenom, String mdp, String role, String tele, String email) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.mdp = mdp;
	this.role = role;
	this.tele = tele;
	this.email = email;
}





@Override
public String toString() {
	return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", role=" + role + ", tele="
			+ tele + ", email=" + email + "]";
}





public int getId() {
	return id;
}


public void setId(int id) {
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


public String getMdp() {
	return mdp;
}


public void setMdp(String mdp) {
	this.mdp = mdp;
}


public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}


public String getTele() {
	return tele;
}


public void setTele(String tele) {
	this.tele = tele;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Demande> demandes;

public List<Demande> getDemandes() {
    return demandes;
}

public void setDemandes(List<Demande> demandes) {
    this.demandes = demandes;
}






}

