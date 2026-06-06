package com.jpstechno.es_academic_ms.controlleurs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anneescolaires")
public class AnneeScolaireControl {

    @GetMapping("/courante")
    public String getCurrentAnneeScolaire() {
        return "2023-2024";
    }

}
