package com.jpstechno.es_academic_ms.modeles;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrateurs extends ActeurEcole {

    @Enumerated(EnumType.STRING)
    private Fonctions fonction;

    @ManyToOne
    private Ecoles ecole; // Relation avec l'école à laquelle l'administrateur est associé

    public Administrateurs() {
        super();

    }

    public Administrateurs(String nom, String prenom, String email, String telephone, String motDePasse,
            Ecoles ecole, Fonctions fonction) {
        super(nom, prenom, email, telephone, motDePasse, ecole);
        this.fonction = fonction;
    }

    public Administrateurs(long id, String nom, String prenom, String email, String telephone, String motDePasse,
            Ecoles ecole, Fonctions fonction) {
        super(id, nom, prenom, email, telephone, motDePasse, ecole);
        this.fonction = fonction;
    }

}
