package com.jpstechno.es_academic_ms.modeles;

import com.jpstechno.es_academic_ms.enumerations.LienParent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parents extends EcoleAnneeActeur {

    private LienParent lienAvecEtudiant;

    private Etudiants etudiant;

}
