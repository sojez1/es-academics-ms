package com.jpstechno.es_academic_ms.modeles;

import java.util.List;

import jakarta.persistence.OneToMany;

public class CoursParNiveaux {

    private Long id;

    private Long ecoleId;

    private NiveauScolaires niveau;

    @OneToMany(mappedBy = "")
    private List<Cours> listeCoursParNiveau; // liste des cours d'un niveau donnee
}
