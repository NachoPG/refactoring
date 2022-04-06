package com.kreitek.refactor.bien.controllers;

import com.kreitek.refactor.bien.models.NIE;
import com.kreitek.refactor.bien.interfaces.Controller;
import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public class ControllerNie implements Controller {

    public boolean validarDNI(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        NIE nie = new NIE(tipo, numDNI, fchValidez);
        final boolean isCorrectFormatNie = nie.checkFormatNie() == 1;
        System.out.println("NIE " + numDNI + " es: " + isCorrectFormatNie);
        return isCorrectFormatNie;
    }
}
