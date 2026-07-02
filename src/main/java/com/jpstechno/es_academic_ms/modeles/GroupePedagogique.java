/**
 * Pour une annee scolaire donnee et dans une ecole en particulier
 * Permet de savoir les groupe pedagogique existant 
 * 
 * @author: Jean-Pierre S.
 */

package com.jpstechno.es_academic_ms.modeles;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GroupePedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AnneeScolaires anneeScolaire;

    @ManyToOne
    private NiveauScolaires niveau;

    @ManyToOne
    private DivisionClasse groupe;

    private boolean isActive;

    private long ecoleId;

    private LocalDate createdAt;

    private Long createdBy; // id de l'acteur ayant fait la creation

}
