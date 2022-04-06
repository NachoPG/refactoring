package com.kreitek.refactor.bien;

public class Main {

    public static void main(String[] args) {
        printInitializeApp();

        DocumentationValidator documentationValidator = new DocumentationValidator();
        documentationValidator.validarDNI(TypeDocumentation.DNI, "11111111H", null);
        documentationValidator.validarDNI(TypeDocumentation.DNI, "24324356A", null);
        documentationValidator.validarDNI(TypeDocumentation.NIE, "X0932707B", null);
        documentationValidator.validarDNI(TypeDocumentation.NIE, "Z2691139Z", null);
        documentationValidator.validarDNI(TypeDocumentation.CIF, "W9696294I", null);
        documentationValidator.validarDNI(TypeDocumentation.CIF, "W9696294A", null);

    }

    public static void printInitializeApp() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }
}
