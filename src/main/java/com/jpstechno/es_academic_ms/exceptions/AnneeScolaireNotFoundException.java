package com.jpstechno.es_academic_ms.exceptions;

public class AnneeScolaireNotFoundException extends RuntimeException {

    public AnneeScolaireNotFoundException() {
        super("Cette annee scolaire n'existe pas dans le systeme");
    }

    public AnneeScolaireNotFoundException(String message) {
        super(message);
    }

}
