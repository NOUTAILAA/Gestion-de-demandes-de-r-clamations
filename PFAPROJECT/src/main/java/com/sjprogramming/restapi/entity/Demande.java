package com.sjprogramming.restapi.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demande")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String sujet;

    @Column(nullable = false)
    private String description;

    // Pour le type Date, il est recommandé d'utiliser le type approprié.
    // Si vous avez besoin d'un String, assurez-vous que le format est correct lors de l'enregistrement et la lecture.
    @Column(nullable = false)
    private String dateReclamation;

    @Column(nullable = false)
    private String etat;

    // Relation avec User (clé étrangère)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateReclamation() {
		return dateReclamation;
	}

	public void setDateReclamation(String dateReclamation) {
		this.dateReclamation = dateReclamation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Demande() {
    }

    public Demande(String sujet, String description, String dateReclamation, String etat, User user) {
        this.sujet = sujet;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.etat = etat;
        this.user = user;
    }

    // Getters et Setters ici
}
