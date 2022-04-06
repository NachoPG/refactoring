package com.kreitek.refactor.bien.controllers;

import com.kreitek.refactor.bien.models.DNI;
import com.kreitek.refactor.bien.interfaces.Controller;
import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public class ControllerDni implements Controller {

    public boolean validarDNI(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        DNI dni = new DNI(tipo,numDNI,fchValidez);
        System.out.println("DNI " + numDNI + " es: " + dni.checkDNI());
        return dni.checkDNI();
    }
}
