package com.jpstechno.es_academic_ms.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.repositories.AnneeScolaireRepo;
import com.jpstechno.es_academic_ms.repositories.PeriodeAcademiqueRepo;
import com.jpstechno.es_academic_ms.serviceImplementation.AnneeScolaireImplementation;

@ExtendWith(MockitoExtension.class)
public class AnneeScolaireServiceTest {

    @Mock
    private AnneeScolaireRepo anneeScolaireRepo;

    @Mock
    private PeriodeAcademiqueRepo periodeAcademiqueRepo; // Assuming you have this repository as well

    @InjectMocks
    private AnneeScolaireImplementation anneeScolaireService;

    @Test
    @DisplayName("save annee scolaire: cas annee courante = true et aucune annee courante n'existe encore pour l'école donnée")
    void saveNewAnneeScolaireTest1() {

        // Arrange: Création d'une instance d'AnneeScolaires avec les données
        AnneeScolaires annee = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        when(anneeScolaireRepo.getCurrentAnneeScolaire(1L)).thenReturn(Optional.empty());
        when(anneeScolaireRepo.save(any(AnneeScolaires.class))).thenReturn(annee);

        // Act: Appel de la méthode saveAnneeScolaire pour persister l'année scolaire
        AnneeScolaires savedAnnee = anneeScolaireService.saveAnneeScolaire(annee);

        // Assert: Vérification que l'année scolaire a été correctement persistée
        assertNotNull(savedAnnee);
        assertEquals(annee.getAppelationAnnee(), savedAnnee.getAppelationAnnee());
        assertTrue(savedAnnee.isAnneeCourante());

    }

    @Test
    @DisplayName("save annee scolaire: cas annee courante = true et une annee courante existait deja pour l'école donnée")
    void saveNewAnneeScolaireTest2() {

        // Arrange: Création d'une instance d'AnneeScolaires avec les données
        AnneeScolaires oldCurrentAnnee = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        AnneeScolaires newCurrentAnnee = AnneeScolaires.builder()
                .appelationAnnee("2024-2025")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        when(anneeScolaireRepo.getCurrentAnneeScolaire(1L)).thenReturn(Optional.of(oldCurrentAnnee));
        when(anneeScolaireRepo.save(any(AnneeScolaires.class))).thenReturn(newCurrentAnnee);

        // Act: Appel de la méthode saveAnneeScolaire pour persister l'année scolaire
        AnneeScolaires savedAnnee = anneeScolaireService.saveAnneeScolaire(newCurrentAnnee);

        // Assert: Vérification que l'année scolaire a été correctement persistée
        assertNotNull(savedAnnee);
        assertEquals(newCurrentAnnee.getAppelationAnnee(), savedAnnee.getAppelationAnnee());
        assertTrue(savedAnnee.isAnneeCourante());
        assertFalse(oldCurrentAnnee.isAnneeCourante());

    }

    @Test
    @DisplayName("save annee scolaire: cas annee courante = false ")
    void saveNewAnneeScolaireTest3() {

        // Arrange: Création d'une instance d'AnneeScolaires avec les données
        AnneeScolaires annee = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(false)
                .ecoleId(1L)
                .build();

        when(anneeScolaireRepo.save(any(AnneeScolaires.class))).thenReturn(annee);

        // Act: Appel de la méthode saveAnneeScolaire pour persister l'année scolaire
        AnneeScolaires savedAnnee = anneeScolaireService.saveAnneeScolaire(annee);

        // Assert: Vérification que l'année scolaire a été correctement persistée
        assertNotNull(savedAnnee);
        assertEquals(annee.getAppelationAnnee(), savedAnnee.getAppelationAnnee());
        assertFalse(savedAnnee.isAnneeCourante());
    }

    @Test
    @DisplayName("recuperer toutes les années scolaires pour une école donnée")
    void getAllAnneeScolairesTest() {
        // Arrange: Création d'une instance d'AnneeScolaires avec les données
        AnneeScolaires annee1 = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(false)
                .ecoleId(1L)
                .build();
        AnneeScolaires annee2 = AnneeScolaires.builder()
                .appelationAnnee("2024-2025")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        AnneeScolaires annee3 = AnneeScolaires.builder()
                .appelationAnnee("2024-2025")
                .anneeCourante(true)
                .ecoleId(2L)
                .build();

        when(anneeScolaireRepo.findAll(any(Sort.class))).thenReturn(List.of(annee1, annee2, annee3));

        // Act: Appel de la méthode getAllAnneeScolaires pour récupérer les années
        // scolaires
        List<AnneeScolaires> result = anneeScolaireService.getAllAnneeScolaires(1L);

        // Assert: Vérification que les années scolaires ont été correctement récupérées
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(annee -> annee.getEcoleId().equals(1L)));

    }

}
