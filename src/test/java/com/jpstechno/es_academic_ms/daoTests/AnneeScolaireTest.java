package com.jpstechno.es_academic_ms.daoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.repositories.AnneeScolaireRepo;

@DataJpaTest
public class AnneeScolaireTest {

    @Autowired
    private AnneeScolaireRepo anneeScolaireRepo;

    @Test
    @DisplayName("Test 1 : Enregistrement d'une nouvelle année scolaire")
    public void testSaveNewAnneeScolaire() {
        // Arrange: Création d'une instance d'AnneeScolaires avec les données
        // nécessaires pour le test.
        AnneeScolaires annee = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        // Act: Appel de la méthode saveAnneeScolaire pour persister l'année scolaire
        AnneeScolaires savedAnnee = anneeScolaireRepo.save(annee);

        // Assert: Vérification que l'année scolaire a été correctement persistée
        assertNotNull(savedAnnee);
        assertEquals("2023-2024", savedAnnee.getAppelationAnnee());
        assertTrue(savedAnnee.isAnneeCourante());

    }

}
