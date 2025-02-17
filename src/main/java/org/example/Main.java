package org.example;

import polinom.controller.CalcController;
import polinom.model.CalcModel;
import polinom.view.Interfata;

public class Main {
    public static void main(String[] args) {

        CalcModel      model      = new CalcModel();
        Interfata       view       = new Interfata();
        CalcController controller = new CalcController(model, view);

    }
}