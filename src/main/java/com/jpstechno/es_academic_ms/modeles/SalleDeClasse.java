package com.jpstechno.es_academic_ms.modeles;

import jakarta.validation.constraints.NotBlank;

public class SalleDeClasse {
    private Long id;

    @NotBlank(message = "Vous devez saisir le code de la salle")
    private String codeSalle; // exemple B2A pour batiment B etage 2 salle A

    @NotBlank(message = "Vous devez indiquer l'appelation de la salle")
    private String AppelationSalle; // Salle Marie-ange ou Salle sixieme M5, ...
}
