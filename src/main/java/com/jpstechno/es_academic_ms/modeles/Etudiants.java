package com.jpstechno.es_academic_ms.modeles;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Etudiants extends EcoleAnneeActeur {

    private String matricule;

    private boolean isEtudiantActif; /*
                                      * Indique si l'étudiant est actif ou non
                                      * permet aux administrateurs de valider ou non les inscriptions des
                                      * étudiants
                                      */

    private List<Parents> parents;

    public Etudiants() {
        super();
        this.parents = new ArrayList<Parents>();

    }

    public Etudiants(String nom, String prenom, String email, String telephone, String motDePasse,
            Ecoles ecole, String matricule) {
        // super(nom, prenom, email, telephone, motDePasse, ecole);
        this.matricule = matricule;
        this.isEtudiantActif = false;
        this.parents = new ArrayList<Parents>();
    }

    public Etudiants(long id, String nom, String prenom, String email, String telephone, String motDePasse,
            Ecoles ecole, String matricule) {
        // super(id, nom, prenom, email, telephone, motDePasse, ecole);
        this.matricule = matricule;
        this.isEtudiantActif = false;
        this.parents = new ArrayList<Parents>();
    }

}
