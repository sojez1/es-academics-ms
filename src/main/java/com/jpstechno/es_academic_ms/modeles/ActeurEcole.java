package com.jpstechno.es_academic_ms.modeles;

import com.jpstechno.es_academic_ms.enumerations.Sexes;

import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ActeurEcole {

    private Long acteurId;

    private String nom;

    private String prenom;

    private String username;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    private Sexes sexe;

    private String email;

    private String telephone;

    private String motDePasse;

    private boolean isActif;

    private boolean isEmailVerified;

    @ManyToOne(optional = false)
    private Ecoles ecole; // Relation avec l'école à laquelle l'acteur est associé

    public ActeurEcole() {

    }

    // constructeur avec paramètres (sans id)
    public ActeurEcole(String nom, String prenom, String email, String telephone, String motDePasse, Ecoles ecole) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.ecole = ecole;
    }

    // constructeur avec paramètres (avec id)
    public ActeurEcole(long id, String nom, String prenom, String email, String telephone, String motDePasse,
            Ecoles ecole) {
        this(nom, prenom, email, telephone, motDePasse, ecole);
        this.acteurId = id;
    }
}
