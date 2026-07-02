package com.jpstechno.es_academic_ms.modeles;

import java.time.LocalDate;

import com.jpstechno.es_academic_ms.enumerations.Sexes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enseignants extends EcoleAnneeActeur {

    private String matricule;
    private String nom;
    private String prenom;
    private Sexes sexe;
    private String email;
    private String telephone;
    private LocalDate dateEmbauche;
    private String diplome;

}
