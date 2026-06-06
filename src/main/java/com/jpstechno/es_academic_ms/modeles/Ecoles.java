package com.jpstechno.es_academic_ms.modeles;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ecoles {

    private Long id;

    private String nomEcole;

    private String adresseEcole;

    private boolean isEcoleActif;

    private String logoEcole; // URL ou chemin vers le logo de l'école

    private List<Administrateurs> promoteurs; // Relation avec l'administrateur de l'école

    private List<ActeurEcole> acteurs; // Relation avec les acteurs de l'école (étudiants, enseignants, etc.)
}
