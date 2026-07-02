/**
 * Permet de creer une periode de l'annee scolaire pour une ecole donnee
 * la periode peut etre 1er trimestre, 2eme semestre, ...
 * 
 * exemple de periode academique: 1er semestre de l'annee 2025-2026
 */

package com.jpstechno.es_academic_ms.modeles;

import java.time.LocalDate;

import com.jpstechno.es_academic_ms.enumerations.PeriodeType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodeAcademique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long periodeId;

    @ManyToOne
    private AnneeScolaires annee;

    @NotBlank(message = "Vous devez renseigner l'appelation de la periode. ex: 1er semestre, 2eme trimestre")
    private String appelation; // 1er semetre ou 3eme trimestre, ...

    @Enumerated(EnumType.STRING)
    private PeriodeType type;

    private LocalDate dateDebut;

    private LocalDate dateFin;

}
