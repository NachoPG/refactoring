package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.controllers.ControllerFactory;
import com.kreitek.refactor.bien.interfaces.Controller;

import java.util.Date;

public class DocumentationValidator {

    ControllerFactory controllerFactory = new ControllerFactory();

    public int validarDNI(TypeDocumentation enumTipo, String numDNI, Date fchValidez) {
        switch (enumTipo) {
            case DNI:
                Controller controllerDni = controllerFactory.ControllerDni();
                return !controllerDni.validarDNI(enumTipo, numDNI, fchValidez) ? 0 : 1;
            case CIF:
                Controller controllerCif = controllerFactory.ControllerCif();
                if (numDNI != null) {
                    return !controllerCif.validarDNI(enumTipo, numDNI, fchValidez) ? 0 : 1;
                }
                return 0;
            case NIE:
                Controller controllerNie = controllerFactory.ControllerNie();
                return !controllerNie.validarDNI(enumTipo, numDNI, fchValidez) ? 0 : 1;
            default:
                return -99;
        }
    }
}
