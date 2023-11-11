package com.example.projetfinal2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public Mode mode = Mode.STANDARD;

    @FXML
    private Button boutonExposant2;
    @FXML
    private Button boutonExposantn;
    @FXML
    private Button boutonRacineCarre;
    @FXML
    private Button boutonRacineNieme;
    @FXML
    private Button boutonParaGauche;
    @FXML
    private Button boutonParaDroit;
    @FXML
    private Button boutonFois;
    @FXML
    private Button boutonDiviser;
    @FXML
    private Button boutonPlus;
    @FXML
    private Button boutonMoins;
    @FXML
    private Button boutonInverserSigne;
    @FXML
    private Button boutonVirgule;
    @FXML
    private Button bouton1_xMod;
    @FXML
    private Label expressionLabel;

    @FXML
    protected void changerModeScientifique() {
        mode = Mode.SCIENTIFIQUE;
        mettreAJourBouton();
    }

    @FXML
    protected void changerModeProgrammeur() {
        mode = Mode.PROGRAMMEUR;
        mettreAJourBouton();
    }

    @FXML
    protected void changerModeStandard() {
        mode = Mode.STANDARD;
        mettreAJourBouton();
    }
    private void mettreAJourBouton() {
        bouton1_xMod.setText(mode.valeursDeBouton.get(0));
        boutonExposant2.setText(mode.valeursDeBouton.get(1));
        boutonExposantn.setText(mode.valeursDeBouton.get(2));
        boutonRacineCarre.setText(mode.valeursDeBouton.get(3));
        boutonRacineNieme.setText(mode.valeursDeBouton.get(4));
        boutonParaGauche.setText(mode.valeursDeBouton.get(5));
        boutonParaDroit.setText(mode.valeursDeBouton.get(6));
        boutonFois.setText(mode.valeursDeBouton.get(7));
        boutonDiviser.setText(mode.valeursDeBouton.get(8));
        boutonPlus.setText(mode.valeursDeBouton.get(9));
        boutonMoins.setText(mode.valeursDeBouton.get(10));
        boutonInverserSigne.setText(mode.valeursDeBouton.get(11));
        boutonVirgule.setText(mode.valeursDeBouton.get(12));
    }

    public void appuyerBoutonChangeant(ActionEvent actionEvent) {
        int numeroDeBouton = mode.valeursDeBouton.indexOf(((Button) (actionEvent.getSource())).getText());
        expressionLabel.setText(expressionLabel.getText() + mode.symboles.get(numeroDeBouton));
    }


    public void effacer(ActionEvent actionEvent) {
        expressionLabel.setText("");
    }

    public void egal(ActionEvent actionEvent) {
        System.out.println(expressionLabel.getText());
        expressionLabel.setText(String.valueOf(MathArtisanal.calculer(expressionLabel.getText().trim())));

    }

    public void appuyerBoutonNumerique(ActionEvent actionEvent) {
        expressionLabel.setText(expressionLabel.getText() + ((Button) actionEvent.getSource()).getText());
    }
}