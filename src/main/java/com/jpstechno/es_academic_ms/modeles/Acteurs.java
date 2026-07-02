package com.jpstechno.es_academic_ms.modeles;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;

import jakarta.persistence.Enumerated;

import jakarta.persistence.Inheritance;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
@DiscriminatorColumn(name = "typeActeur", discriminatorType = jakarta.persistence.DiscriminatorType.STRING)
public class Acteurs {

    private Long acteurId;

    @NotBlank(message = "Vous devez saisir un nom")
    private String nom;

    @NotBlank(message = "Vous devez saisir un prenom")
    private String prenom;

    @NotBlank(message = "vous devez indiquer le sexe")
    private String sexe;

    @Email(message = "email invalide")
    @NotBlank(message = "Vous devez saisir une adresse email")
    private String emailPersonnel;

    private String telephone;

    private boolean isActif;

    private boolean isEmailVerified;

    private List<Long> listeEcoleDeActeur; // Liste des ecoles ou l'acteur est enregistree

    public Acteurs() {

    }

    // constructeur avec paramètres (sans id)
    public Acteurs(String nom, String prenom, String sexe, String email, String telephone, String motDePasse,
            Ecoles ecole) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.emailPersonnel = email;
        this.telephone = telephone;

    }

    // constructeur avec paramètres (avec id)
    public Acteurs(long id, String nom, String prenom, String sexe, String email, String telephone, String motDePasse,
            Ecoles ecole) {
        this(nom, prenom, sexe, email, telephone, motDePasse, ecole);
        this.acteurId = id;
    }
}
