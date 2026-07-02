package com.jpstechno.es_academic_ms.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpstechno.es_academic_ms.exceptions.AnneeScolaireNotFoundException;
import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;
import com.jpstechno.es_academic_ms.modeles.PeriodeAcademique;
import com.jpstechno.es_academic_ms.repositories.AnneeScolaireRepo;
import com.jpstechno.es_academic_ms.repositories.PeriodeAcademiqueRepo;
import com.jpstechno.es_academic_ms.services.AnneeScolaireService;

import jakarta.transaction.Transactional;

@Service
public class AnneeScolaireImplementation implements AnneeScolaireService {

    private final AnneeScolaireRepo anneeRepo;
    private final PeriodeAcademiqueRepo periodeRepo;

    public AnneeScolaireImplementation(AnneeScolaireRepo anneeRepo, PeriodeAcademiqueRepo periodeRepo) {
        this.anneeRepo = anneeRepo;
        this.periodeRepo = periodeRepo;
    }

    @Override
    @Transactional
    public AnneeScolaires saveAnneeScolaire(AnneeScolaires annee) {
        // Vérifier si l'année scolaire est marquée comme courante
        if (annee.isAnneeCourante()) {
            Optional<AnneeScolaires> anneeCouranteExistante = anneeRepo.getCurrentAnneeScolaire(annee.getEcoleId());
            if (anneeCouranteExistante.isPresent()) { // Si une année scolaire courante existe déjà, la mettre à jour
                                                      // pour qu'elle ne soit plus courante
                AnneeScolaires anneeCourante = anneeCouranteExistante.get();
                anneeCourante.setAnneeCourante(false);
                anneeRepo.save(anneeCourante);
            }
        }
        return anneeRepo.save(annee);
    }

    @Override
    public AnneeScolaires modifyAnneeScolaire(long id, AnneeScolaires annee) {
        AnneeScolaires anneeToBeModify = findAnneeById(id);
        anneeToBeModify.setAppelationAnnee(annee.getAppelationAnnee());
        return anneeRepo.save(anneeToBeModify);

    }

    @Override
    public AnneeScolaires setAsCurrentAnneeScolaire(long anneeId) {
        AnneeScolaires annee = findAnneeById(anneeId);
        annee.setAnneeCourante(true);
        return anneeRepo.save(annee);
    }

    @Override
    public boolean changeAnneeScolaireStatut(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeAnneeScolaireStatut'");
    }

    @Override
    public List<AnneeScolaires> getAllAnneeScolaires(long ecoleId) {
        Sort trieAnnee = Sort.by(Sort.Direction.DESC, "anneeScolaire");
        return anneeRepo.findAll(trieAnnee)
                .stream().filter(annee -> annee.getEcoleId().equals(ecoleId))
                .toList();

    }

    @Override
    public List<AnneeScolaires> rechercherAnneeScolaires(String motCle) {
        return null;
    }

    @Override
    public Optional<AnneeScolaires> retrouverUneAnneeScolaire(long id) {
        return null;
    }

    @Override
    public Optional<AnneeScolaires> retrouverUneAnneeScolaire(String annee) {
        return null;
    }

    private AnneeScolaires findAnneeById(long anneeId) {
        return anneeRepo.findById(anneeId).orElseThrow(() -> new AnneeScolaireNotFoundException());
    }

    @Override
    public AnneeScolaires getCurrentAnneeScolaire(long ecoleId) {
        return anneeRepo.getCurrentAnneeScolaire(ecoleId)
                .orElseThrow(() -> new AnneeScolaireNotFoundException(
                        "Aucune année scolaire courante trouvée pour l'école avec l'ID : " + ecoleId));
    }

    @Override
    public PeriodeAcademique ajouterPeriode(PeriodeAcademique periode) {
        return periodeRepo.save(periode);
    }

    @Override
    public PeriodeAcademique modifierPeriode(Long periodeId, PeriodeAcademique periode) {
        return null;
    }

    @Override
    public List<PeriodeAcademique> listePeriodePourUneAnnee(AnneeScolaires annee) {

        return periodeRepo.findAll();
    }

}
