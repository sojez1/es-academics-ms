package com.jpstechno.es_academic_ms.modeles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parents extends ActeurEcole {

    private LienParent lienAvecEtudiant;

    private Etudiants etudiant;

}
