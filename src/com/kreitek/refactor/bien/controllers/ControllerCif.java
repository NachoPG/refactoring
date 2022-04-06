package com.kreitek.refactor.bien.controllers;

import com.kreitek.refactor.bien.models.CIF;
import com.kreitek.refactor.bien.interfaces.Controller;
import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public class ControllerCif implements Controller {

    public boolean validarDNI(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        CIF cif = new CIF(tipo, numDNI, fchValidez);
        final boolean isCorrectFormatCif = cif.correctCif() == 1;
        System.out.println("CIF " + numDNI + " es: " + isCorrectFormatCif);
        return isCorrectFormatCif;
    }
}
