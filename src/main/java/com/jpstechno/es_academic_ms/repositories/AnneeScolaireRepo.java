package com.jpstechno.es_academic_ms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpstechno.es_academic_ms.modeles.AnneeScolaires;

public interface AnneeScolaireRepo extends JpaRepository<AnneeScolaires, Long> {

    @Query("SELECT an FROM AnneeScolaires an WHERE an.anneeCourante = true and an.ecoleId = :ecoleId")
    Optional<AnneeScolaires> getCurrentAnneeScolaire(@Param("ecoleId") Long ecoleId);

}
