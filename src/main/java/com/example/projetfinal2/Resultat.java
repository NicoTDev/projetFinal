package com.example.projetfinal2;

import javafx.beans.property.SimpleStringProperty;

public class Resultat {
    private final SimpleStringProperty equation;
    private final SimpleStringProperty resultat;
    private final SimpleStringProperty mode;

    public Resultat(String equation, String resultat, String mode) {
        this.equation = new SimpleStringProperty(equation);
        this.resultat = new SimpleStringProperty(resultat);
        this.mode = new SimpleStringProperty(mode);
    }
    public String getEquation() {
        return equation.get();
    }

    public String getResultat() {
        return resultat.get();
    }

    public String getMode() {
        return mode.get();
    }

    public void setEquation(String equation) {
        this.equation.set(equation);
    }
    public void setResultat(String resultat) {
        this.resultat.set(resultat);
    }
}
