package com.kreitek.refactor.bien.models;

import com.kreitek.refactor.bien.TipoUltCaracter;
import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CIF {

    private TypeDocumentation enumTipo;
    private String numDNI;
    private Date fchValidez;

    public CIF(TypeDocumentation tipo, String numDNI, Date fchValidez) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
        this.fchValidez = fchValidez;
    }

    private TipoUltCaracter checkFinalLetter(char primerCar, char ultimoCar) {
        TipoUltCaracter tipUltCar;
        if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
            tipUltCar = TipoUltCaracter.LETRA;
            if (ultimoCar < 'A' || ultimoCar > 'Z') {
                return TipoUltCaracter.NINGUNO;
            }
        } else if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E' || primerCar == 'H') {
            tipUltCar = TipoUltCaracter.NUMERO;
            if (ultimoCar < '0' || ultimoCar > '9') {
                return TipoUltCaracter.NINGUNO;
            }
        } else {
            tipUltCar = TipoUltCaracter.AMBOS;
        }
        return tipUltCar;
    }

    private Integer sumEvenNumbers(String digitos) {
        int sumaPares = 0;
        for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
        }
        return sumaPares;
    }

    private Integer sumOddenNumbers(String digitos) {
        int sumaImpares = 0;
        for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
            int cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
            if (Integer.toString(cal).length() > 1) {
                cal = Integer.parseInt(Integer.toString(cal).substring(0, 1))
                        + Integer.parseInt(Integer.toString(cal).substring(1, 2));
            }
            sumaImpares += cal;
        }

        return sumaImpares;
    }

    private char getCarControl(Integer total) {
        Integer numControl = getNumControl(total);
        int pos = getPositionOfNumControl(numControl);

        return "JABCDEFGHI".charAt(pos);
    }

    private Integer getNumControl(Integer total) {
        return 10 - (total % 10);
    }

    private Integer getPositionOfNumControl(Integer numControl) {
        return numControl == 10 ? 0 : numControl;
    }


    private Integer totalNumbers(Integer sumaPares, Integer sumaImpares) {
        return sumaPares + sumaImpares;
    }


    private int validateNumberCif(Integer total, TipoUltCaracter tipUltCar, char ultimoCar) {
        final int numControl = getNumControl(total);
        final int pos = getPositionOfNumControl(numControl);
        final char carControl = getCarControl(total);


        if (tipUltCar == TipoUltCaracter.NUMERO) {
            final int ultCar = Integer.parseInt(Character.toString(ultimoCar));
            if (pos != ultCar) {
                return 0;
            }
        }
        if (tipUltCar == TipoUltCaracter.LETRA && carControl != ultimoCar) {
            return 0;
        } else {
            int ultCar = -1;
            ultCar = "JABCDEFGHI".indexOf(ultimoCar);

            if (ultCar < 0) {
                ultCar = Integer.parseInt(Character.toString(ultimoCar));
                if (pos != (int) ultCar) {
                    return 0;
                }
            }
            if (pos != (int) ultCar && carControl != ultimoCar) {
                return 0;
            }
        }
        return 1;

    }

    public int correctCif() {
        final String cifUP = this.numDNI.toUpperCase();
        final String CHARACTERS = "ABCDEFGHJKLMNPQRSUVW";
        final boolean isNotFirstCharacter = CHARACTERS.indexOf(cifUP.charAt(0)) == -1;
        if (isNotFirstCharacter) return 0;
        Matcher patternCif = getPatternCif(cifUP);
        if (!patternCif.matches()) return 0;
        TipoUltCaracter tipUltCar = checkFinalLetter(cifUP.charAt(0), cifUP.charAt(cifUP.length() - 1));
        final String digitos = cifUP.substring(1, cifUP.length() - 1);
        final Integer total = totalNumbers(sumEvenNumbers(digitos), sumOddenNumbers(digitos));
        return validateNumberCif(total, tipUltCar, cifUP.charAt(cifUP.length() - 1));
    }

    private Matcher getPatternCif(String cifUP) {
        final Pattern mask = Pattern.compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        return mask.matcher(cifUP);
    }

}
