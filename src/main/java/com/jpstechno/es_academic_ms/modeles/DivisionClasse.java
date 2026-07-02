/**
 * Un niveau scolaire peut etre decouper en plusieurs divisions M1, M2, A, B, C
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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DivisionClasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Veuillez indiquer le code de la division, ex: A, M1, M2, C, D")
    private String code;

    @NotBlank(message = "Veuillez indiquer l'appelation. Ex: groupe A, Groupe M1, ")
    private String appelation;

    @OneToMany(mappedBy = "groupe")
    private List<GroupePedagogique> listeClasse;

}
