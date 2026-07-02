package com.jpstechno.es_academic_ms.controlleurTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpstechno.es_academic_ms.controlleurs.AnneeScolaireControl;
import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.serviceImplementation.AnneeScolaireImplementation;

@WebMvcTest(AnneeScolaireControl.class)
public class AnneeControlleurTest {

    @MockitoBean
    private AnneeScolaireImplementation anneeScolaireImpl;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllAnneeScolaires() throws Exception {
        // arrange
        AnneeScolaires annee1 = AnneeScolaires.builder()
                .appelationAnnee("2023-2024")
                .anneeCourante(true)
                .ecoleId(1L)
                .build();

        AnneeScolaires annee2 = AnneeScolaires.builder()
                .appelationAnnee("2024-2025")
                .anneeCourante(false)
                .ecoleId(1L)
                .build();

        when(anneeScolaireImpl.getAllAnneeScolaires(1L)).thenReturn(List.of(annee1, annee2));

        // Act & Assert:
        mockMvc.perform(get("/anneescolaires/liste").param("ecoleId", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].appelationAnnee").value("2023-2024"))
                .andExpect(jsonPath("$[1].appelationAnnee").value("2024-2025"));

    }

}
