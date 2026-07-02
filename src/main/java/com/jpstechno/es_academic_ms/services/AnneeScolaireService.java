package com.jpstechno.es_academic_ms.services;

import java.util.List;
import java.util.Optional;

import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.modeles.PeriodeAcademique;

public interface AnneeScolaireService {

    AnneeScolaires saveAnneeScolaire(AnneeScolaires annee);

    AnneeScolaires modifyAnneeScolaire(long id, AnneeScolaires annee);

    AnneeScolaires setAsCurrentAnneeScolaire(long anneeId);

    AnneeScolaires getCurrentAnneeScolaire(long ecoleId);

    boolean changeAnneeScolaireStatut(long id);

    List<AnneeScolaires> getAllAnneeScolaires(long ecoleId);

    List<AnneeScolaires> rechercherAnneeScolaires(String motCle);

    Optional<AnneeScolaires> retrouverUneAnneeScolaire(long id);

    Optional<AnneeScolaires> retrouverUneAnneeScolaire(String annee);

    // Metier pour peride scolaire
    PeriodeAcademique ajouterPeriode(PeriodeAcademique periode);

    PeriodeAcademique modifierPeriode(Long periodeId, PeriodeAcademique periode);

    List<PeriodeAcademique> listePeriodePourUneAnnee(AnneeScolaires annee);

}
