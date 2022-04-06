package com.kreitek.refactor.bien.controllers;

import com.kreitek.refactor.bien.interfaces.Controller;

public class ControllerFactory {

    public Controller ControllerDni() {
        return new ControllerDni();
    }

    public Controller ControllerCif() {
        return new ControllerCif();
    }

    public Controller ControllerNie() {
        return new ControllerNie();
    }
}
