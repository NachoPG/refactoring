package com.kreitek.refactor.bien.models;

import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public class DNI {

    private TypeDocumentation enumTipo;
    private String numDNI;
    private Date fchValidez;

    public DNI(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
        this.fchValidez = fchValidez;
    }

    public boolean checkDNI() {
        final String DNI_CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";
        String intPartDNI = this.numDNI.trim().replaceAll(" ", "").substring(0, 8);
        char ltrDNI = this.numDNI.charAt(8);
        int valNumDni = Integer.parseInt(intPartDNI) % 23;
        return this.numDNI.length() == 9 && isNumeric(intPartDNI) && DNI_CHARS.charAt(valNumDni) == ltrDNI;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
