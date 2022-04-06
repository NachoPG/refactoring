package com.kreitek.refactor.bien.models;

import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public class NIE {

    private boolean isValid = false;
    private final char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    private TypeDocumentation enumTipo;
    private String numDNI;
    private Date fchValidez;

    public NIE(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
        this.fchValidez = fchValidez;
    }

    public int checkFormatNie() {

        final boolean isLetter = Character.isLetter(this.numDNI.charAt(8));
        final boolean isLetterX = this.numDNI.substring(0, 1).toUpperCase().equals("X");
        final boolean isLetterY = this.numDNI.substring(0, 1).toUpperCase().equals("Y");
        final boolean isLetterZ = this.numDNI.substring(0, 1).toUpperCase().equals("Z");

        if (this.numDNI.length() == 9 && isLetter && isLetterX || isLetterY || isLetterZ) {
            int i = 1;
            do {
                int caracterASCII = this.numDNI.codePointAt(i);
                isValid = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } while (i < this.numDNI.length() - 1 && isValid);
        }
        return validateNie(isLetterX, isLetterY, isLetterZ);

    }

    private int validateNie(boolean isLetterX, boolean isLetterY, boolean isLetterZ) {
        addNumberDependOfLetter(isLetterX, isLetterY, isLetterZ);
        if (isValid) {
            char letra = getLastLetter();
            int miNIE = Integer.parseInt(this.numDNI.substring(1, 8));
            int resto = miNIE % 23;
            isValid = (letra == asignacionLetra[resto]);
            return isValid ? 1 : 0;
        } else {
            return 0;
        }


    }

    private void addNumberDependOfLetter(boolean isLetterX, boolean isLetterY, boolean isLetterZ) {
        if (isValid && isLetterX) {
            this.numDNI = "0" + this.numDNI.substring(1, 9);
        }
        if (isValid && isLetterY) {
            this.numDNI = "1" + this.numDNI.substring(1, 9);
        }
        if (isValid && isLetterZ) {
            this.numDNI = "2" + this.numDNI.substring(1, 9);
        }
    }

    private char getLastLetter() {
        return Character.toUpperCase(this.numDNI.charAt(8));
    }
}


