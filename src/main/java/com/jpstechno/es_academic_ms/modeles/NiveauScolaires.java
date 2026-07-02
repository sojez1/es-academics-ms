/**
 * Cette classe permet de repertorier les niveaux scolaire (6eme, 5eme, CE1, CM2, ...)
 * indique les niveaux qui viennent avant ce niveau
 * de meme que les niveaux qui viennent apres
 * 
 * @author: Jean-Pierre S.
 */

package com.jpstechno.es_academic_ms.modeles;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NiveauScolaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigle; // 6eme, 3eme, 2nde, Tle, ...

    private String appelation; // sixieme, secondaire 1, troisieme, secondaire 4, ...

    @OneToMany(mappedBy = "niveau")
    private List<GroupePedagogique> listeClasse;

    // private List<NiveauScolaires> niveauxPrecedent;

    // private List<NiveauScolaires> niveauxSuivant;

    private Long ecoleId;

}
