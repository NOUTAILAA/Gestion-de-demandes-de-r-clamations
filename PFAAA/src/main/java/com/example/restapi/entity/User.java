package com.example.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@Column
private String nom; 
@Column
private String mdp;
@Column
private String filiere ; 
@Column
private int group_id;
@Column
private float note;

public User(String nom, String mdp, String filiere, int group_id, float note) {
	super();
	this.nom = nom;
	this.mdp = mdp;
	this.filiere = filiere;
	this.group_id = group_id;
	this.note = note;
}

public User() {}

@Override
public String toString() {
	return "Student [id=" + id + ", nom=" + nom + ", mdp=" + mdp + ", filiere=" + filiere + ", group=" + group_id
			+ ", note=" + note + "]";
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
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getFiliere() {
	return filiere;
}
public void setFiliere(String filiere) {
	this.filiere = filiere;
}
public int getGroup() {
	return group_id;
}
public void setGroup(int group) {
	this.group_id = group;
}
public float getNote() {
	return note;
}
public void setNote(float note) {
	this.note = note;
}
}
