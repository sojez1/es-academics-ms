package com.jpstechno.es_academic_ms.controlleurs;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.services.AnneeScolaireService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/anneescolaires")
@RequiredArgsConstructor
public class AnneeScolaireControl {

    private final AnneeScolaireService anneeService;

    /*
     * public AnneeScolaireControl(AnneeScolaireService anneeService) {
     * this.anneeService = anneeService;
     * }
     */

    @GetMapping("/courante")
    public ResponseEntity<AnneeScolaires> getCurrentAnneeScolaire(@RequestParam long ecoleId) {
        AnneeScolaires anneRep = anneeService.getCurrentAnneeScolaire(ecoleId);
        return new ResponseEntity<>(anneRep, HttpStatus.OK);
    }

    @PostMapping("/enregistrer/nouveau")
    public ResponseEntity<AnneeScolaires> enregistrerAnneeScolaire(@RequestBody AnneeScolaires annee) {
        AnneeScolaires anneRep = anneeService.saveAnneeScolaire(annee);
        return new ResponseEntity<>(anneRep, HttpStatus.CREATED);

    }

    @GetMapping("/liste")
    public ResponseEntity<?> listeAnneeScolaire(@RequestParam long ecoleId) {
        List<AnneeScolaires> liste = anneeService.getAllAnneeScolaires(ecoleId);
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
}
