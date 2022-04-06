package com.kreitek.refactor.bien.interfaces;

import com.kreitek.refactor.bien.TypeDocumentation;

import java.util.Date;

public interface Controller {
    boolean validarDNI(TypeDocumentation tipo, String numDNI, Date fchValidez);
}
