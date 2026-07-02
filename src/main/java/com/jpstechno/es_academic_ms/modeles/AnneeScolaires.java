package com.jpstechno.es_academic_ms.modeles;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnneeScolaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ecoleId;

    @NaturalId(mutable = true)
    private String appelationAnnee; // ex: 2025-2026 ou 2022-2023

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private boolean anneeCourante; // si c'est l'annee en cours

    private boolean isAnneeActive;

    @OneToMany(mappedBy = "annee")
    private List<PeriodeAcademique> listePeriodeAcademique;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<GroupePedagogique> listeClasse;

}
