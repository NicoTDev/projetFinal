package com.example.projetfinal2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public VBox fenetreStandard;

    public VBox fenetreProgrammeur;

    public VBox fenetreConversion;
    public VBox fenetreScientifque;
    public Label labelStandard;
    public Label labelScientifique;
    public Label labelProgrammeur;


    public ChoiceBox choiceBoxTypeConversion;
    public ChoiceBox choiceBoxConversionBase;
    public ChoiceBox choiceBoxConversionRecherchee;
    public TextField fieldMesures;
    public Label labelResultat;


    ArrayList symboles = new ArrayList<>(Arrays.asList("1/x","x²","xⁿ","²√x","ⁿ√x","(",")","x","÷","+","-","-x",",",
            "mod","eⁿ","ln","log","fact","sin","arcsin","cos","arccos","tan","arctan","π","e",
            "ToBin","ToOct","ToDec","ToHex","<<",">>","Or","Xor","Not","And"));
    ArrayList valeurs = new ArrayList<>(Arrays.asList("1 / "," ^ 2 "," ^ ","²√ ( ","√ ( ","( "," )"," x "," ÷ "," + "," - ","-",",",
            " mod ","e ^ ","ln ( ","log ( ","fact ( ","sin ( ","arcsin ( ","cos ( ","arccos ( ","tan ( ","arctan ( ","π","e",
            "bin ( ","oct ( ","dec ( ","hex ( ",""," << "," >> "," OR "," XOR "," NOT "," AND "));


    @FXML
    Label labelActif;

    Runnable fonctionALancer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            labelActif = labelStandard;

            choiceBoxTypeConversion.getItems().addAll("Température", "Poids et masse", "Longueurs", "Vitesses", "Angles", "Volumes", "Devises", "Temps");

            choiceBoxTypeConversion.setOnAction(n -> {
                switch (choiceBoxTypeConversion.getValue().toString()) {
                    case "Température":
                        choiceBoxConversionBase.getItems().setAll("fahrenheit", "kelvin", "celcius");
                        choiceBoxConversionRecherchee.getItems().setAll("fahrenheit", "kelvin", "celcius");
                        choiceBoxConversionBase.setValue("celcius");
                        choiceBoxConversionRecherchee.setValue("celcius");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirTemperature(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Poids et masse":
                        choiceBoxConversionBase.getItems().setAll("nanogrammes", "milligrammes", "centigrammes", "grammes", "kilogrammes", "newtons", "tonnes métriques", "tonnes longues", "stones", "livres", "onces");
                        choiceBoxConversionRecherchee.getItems().setAll("microgrammes", "milligrammes", "centigrammes", "grammes", "kilogrammes", "newtons", "tonnes métriques", "tonnes longues", "stones", "livres", "onces");
                        choiceBoxConversionBase.setValue("grammes");
                        choiceBoxConversionRecherchee.setValue("grammes");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirPoidsEtMasse(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Longueurs":
                        choiceBoxConversionBase.getItems().setAll("pieds", "pouces", "micromètres", "millimètres", "centimètres", "mètres", "decimètres", "decamètres", "hectomètres", "kilomètres", "megamètres");
                        choiceBoxConversionRecherchee.getItems().setAll("pieds", "pouces", "micromètres", "millimètres", "centimètres", "mètres", "decimètres", "decamètres", "hectomètres", "kilomètres", "megamètres");
                        choiceBoxConversionBase.setValue("mètres");
                        choiceBoxConversionRecherchee.setValue("mètres");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirLongueur(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Vitesses":
                        choiceBoxConversionBase.getItems().setAll("noeuds", "kilomètres par heure", "pieds par seconde", "miles par seconde", "mètres par seconde");
                        choiceBoxConversionRecherchee.getItems().setAll("noeuds", "kilomètres par heure", "pieds par seconde", "miles par seconde", "mètres par seconde");
                        choiceBoxConversionBase.setValue("mètres par seconde");
                        choiceBoxConversionRecherchee.setValue("mètres par seconde");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirVitesse(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Angles":
                        choiceBoxConversionBase.getItems().setAll("degrés", "radians");
                        choiceBoxConversionRecherchee.getItems().setAll("degrés", "radians");
                        choiceBoxConversionBase.setValue("degrés");
                        choiceBoxConversionRecherchee.setValue("degrés");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirAngle(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Volumes":
                        choiceBoxConversionBase.getItems().setAll("microlitre", "millilitre", "centilitre", "decilitre", "litre", "kilolitre", "megalitre", "gallon américain", "quart américain", "pinte américaine liquide", "tasse américain", "once liquide américaine", "cuillère à soupe américaine",
                                "mètre cube", "gallon impérial", "quart impérial", "pinte impériale", "tasse impériale", "once liquide impériale", "cuillère à soupe impériale",
                                "cuillère à café impériale", "pied cube", "pouce cube");
                        choiceBoxConversionRecherchee.getItems().setAll("microlitre", "millilitre", "centilitre", "decilitre", "litre", "kilolitre", "megalitre", "gallon américain", "quart américain", "pinte américaine liquide", "tasse américain", "once liquide américaine", "cuillère à soupe américaine",
                                "mètre cube", "gallon impérial", "quart impérial", "pinte impériale", "tasse impériale", "once liquide impériale", "cuillère à soupe impériale",
                                "cuillère à café impériale", "pied cube", "pouce cube");
                        choiceBoxConversionBase.setValue("litre");
                        choiceBoxConversionRecherchee.setValue("litre");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirVolume(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Devises":
                        choiceBoxConversionBase.getItems().setAll("dollar canadien","dollar américain","franc suisse","peso mexicain","rouble russe","won sud-coréen","roupie indienne",
                                                                  "euro","couronne suédoise","couronne islandaise","yen","V-Bucks Fortnite");
                        choiceBoxConversionRecherchee.getItems().setAll("dollar canadien","dollar américain","franc suisse","peso mexicain","rouble russe","won sud-coréen","roupie indienne",
                                "euro","couronne suédoise","couronne islandaise","yen","V-Bucks Fortnite");
                        choiceBoxConversionBase.setValue("dollar canadien");
                        choiceBoxConversionRecherchee.setValue("dollar canadien");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirArgent(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                    case "Temps":
                        choiceBoxConversionBase.getItems().setAll("nanosecondes","microsecondes","millisecondes","secondes","minutes","heures","jours","semaines","mois","années");
                        choiceBoxConversionRecherchee.getItems().setAll("nanosecondes","microsecondes","millisecondes","secondes","minutes","heures","jours","semaines","mois","années");
                        choiceBoxConversionBase.setValue("secondes");
                        choiceBoxConversionRecherchee.setValue("secondes");
                        fonctionALancer = () -> labelResultat.setText(String.valueOf(ConvertisseurMesures.convertirTemps(choiceBoxConversionBase.getValue().toString()
                                , Double.valueOf(fieldMesures.getText()), choiceBoxConversionRecherchee.getValue().toString())));
                        break;
                }
            });

            fieldMesures.textProperty().addListener(n -> {
                try {
                    fonctionALancer.run();
                }catch (NumberFormatException e) {
                    labelResultat.setText("N/A");
                }
            });

            choiceBoxTypeConversion.setValue("Température");
            labelResultat.setText("N/A");

            choiceBoxConversionBase.setOnAction(v -> {
                try {
                    fonctionALancer.run();
                } catch (NumberFormatException e) {
                    labelResultat.setText("N/A");
                }
            });
            choiceBoxConversionRecherchee.setOnAction(v-> {
                try {
                    fonctionALancer.run();
                } catch (NumberFormatException e) {
                    labelResultat.setText("N/A");
                }
            });
        }
        catch (NumberFormatException e) {
            System.out.println("CRASH");
        }



    }

    public void appuyerBoutonChangeant(ActionEvent actionEvent) {
        int numeroDeBouton = symboles.indexOf(((Button) (actionEvent.getSource())).getText());
        labelActif.setText(labelActif.getText() + valeurs.get(numeroDeBouton));
    }


    @FXML
    public void changerModeStandard() {
        labelActif = labelStandard;
        fenetreStandard.toFront();
    }

    @FXML
    public void changerModeConversion() {
        fenetreConversion.toFront();
    }

    @FXML
    public void changerModeProgrammeur() {
        labelActif = labelProgrammeur;
        fenetreProgrammeur.toFront();
    }

    @FXML
    public void changerModeScientifique() {
        labelActif = labelScientifique;
        fenetreScientifque.toFront();
    }

    @FXML
    public void changerModeGraphique() {}

    @FXML
    public void effacer(ActionEvent actionEvent) {
        labelActif.setText("");
    }

    @FXML
    public void egalPrio(ActionEvent actionEvent) {
        labelActif.setText(String.valueOf(MathArtisanal.calculer(labelActif.getText().trim(),true)));
    }
    @FXML
    public void egalPasPrio(ActionEvent actionEvent) {
        labelActif.setText(String.valueOf(MathArtisanal.calculer(labelActif.getText().trim(),false)));
    }

    public void appuyerBoutonNumerique(ActionEvent actionEvent) {
        labelActif.setText(labelActif.getText() + ((Button) actionEvent.getSource()).getText());
    }
}