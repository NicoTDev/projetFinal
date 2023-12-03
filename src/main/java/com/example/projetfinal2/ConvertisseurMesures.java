package com.example.projetfinal2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

public class ConvertisseurMesures {

    public static double convertirMetriqueToMetrique(String uniteDeBase, double item, String uniteRecherchee) {
        //enlever tous les suffixes
        uniteDeBase = uniteDeBase.replaceAll(uniteDeBase.replaceAll("(micro|milli|centi|deci|deca|hecto|kilo|mega)", ""), "");
        uniteRecherchee = uniteRecherchee.replaceAll(uniteRecherchee.replaceAll("(micro|milli|centi|deci|deca|hecto|kilo|mega)", ""), "");
        ArrayList<String> prefix = new ArrayList<>(Arrays.asList("micro", "NA", "NA", "milli", "centi", "deci", "", "deca", "hecto", "kilo", "NA", "NA", "mega"));
        return item * Math.pow(10, prefix.indexOf(uniteDeBase) - prefix.indexOf(uniteRecherchee));
    }

    //LONGUEUR
    public static double convertirLongueur(String uniteDeBase, double item, String uniteRecherchee) {
        switch (uniteDeBase) {
            case "pieds" -> item /= 3.28084;
            case "pouces" -> item /= 39.3701;
            default -> item = convertirMetriqueToMetrique(uniteDeBase,item,"mètres");
        }
        switch (uniteRecherchee) {
            case "pieds" -> {return item*3.28084;}
            case "pouces" -> {return item*39.3701;}
            default -> {return convertirMetriqueToMetrique("mètres",item,uniteRecherchee);}
        }
    }

    //ANGLE
    public static double convertirAngle(String uniteDeBase, double item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;

        ArrayList<String> mesuresPossibles = new ArrayList<>(Arrays.asList("radians","degrés"));
        return item*Math.pow(Math.PI/180,(uniteDeBase.equals("radians") ? -1 : 1));
    }

    //TEMPÉRATURE
    public static double convertirTemperature(String uniteDeBase, double item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;
        if (uniteDeBase.equals("kelvin"))
            item = item - 273.15;
        else if (uniteDeBase.equals("fahrenheit"))
            item = (item - 32) * 5/9;
        switch (uniteRecherchee) {
            case "fahrenheit" -> {return ((item * 9/5) + 32);}
            case "kelvin" -> {return item+273.15;}
        }
        return item;
    }

    //TEMPS
    public static double convertirTemps(String uniteDeBase, double item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;
        //transformer en seconde
        switch (uniteDeBase) {
            case "années" -> item *= (3.154*Math.pow(10,7));
            case "mois" -> item *= (2.628*Math.pow(10,6));
            case "semaines" -> item *= 604800;
            case "jours" -> item *= 86400;
            case "heures" -> item *= 3600;
            case "minutes" -> item *= 60;
            case "millisecondes" -> item /= 1000;
            case "microsecondes" -> item /= Math.pow(10,6);
            case "nanosecondes" -> item /= Math.pow(10,9);
        }
        switch (uniteRecherchee) {
            case "années" -> {return item/(3.154*Math.pow(10,7));}
            case "mois" -> {return item/(2.628*Math.pow(10,6));}
            case "semaines" -> {return item / 604800;}
            case "jours" -> {return item / 86400;}
            case "heures" -> {return item / 3600;}
            case "minutes" -> {return item / 60;}
            case "millisecondes" -> {return item * 1000;}
            case "microsecondes" -> {return item * Math.pow(10,6);}
            case "nanosecondes" -> {return item * Math.pow(10,9);}
        }
        return item;
    }
    public static double convertirArgent(String uniteDeBase, double item, String uniteRecherchee) {
        //tout mettre sur le dollar canadien
        switch (uniteDeBase) {
            case "dollar américain" -> item*=1.35;
            case "franc suisse" -> item*=1.55;
            case "peso mexicain" -> item*=.079;
            case "rouble russe" -> item*= .015;
            case "won sud-coréen" -> item*=.0010;
            case "roupie indienne" -> item *= .016;
            case "euro" -> item *= 1.47;
            case "couronne suédoise" -> item *= .13;
            case "couronne islandaise" -> item *= .0098;
            case "yen" -> item *= .0092;
            case "V-Bucks Fortnite" -> item *= 0.01079;
        }
        switch (uniteRecherchee) {
            case "dollar américain" -> {return item/1.35;}
            case "franc suisse" -> {return item/1.55;}
            case "peso mexicain" -> {return item/.079;}
            case "rouble russe" -> {return item/ .015;}
            case "won sud-coréen" -> {return item/.0010;}
            case "roupie indienne" -> {return item / .016;}
            case "euro" -> {return item / 1.47;}
            case "couronne suédoise" -> {return item / .13;}
            case "couronne islandaise" -> {return item / .0098;}
            case "yen" -> {return item / .0092;}
            case "V-Bucks Fortnite" -> {return item / 0.01079;}
        }
        return item;
    }
    public static double convertirPoidsEtMasse(String uniteDeBase, double item, String uniteeRecherchee) {
        //transformer en gramme
        switch (uniteDeBase) {
            case "newtons" -> item *= 101.97162129779;
            case "tonnes métriques" -> item *= Math.pow(10,6);
            case "tonnes longues" -> item *= 1.016*Math.pow(10,6);
            case "stones" -> item *= 6350.29;
            case "livres" -> item *= 453.592;
            case "onces" -> item *= 28.3495;
            default -> item = convertirMetriqueToMetrique(uniteDeBase,item,"grammes");
        }
        switch (uniteeRecherchee) {
            case "newtons" -> {return item / 101.97162129779;}
            case "tonnes métriques" -> {return item / Math.pow(10,6);}
            case "tonnes longues" -> {return item / 1.016*Math.pow(10,6);}
            case "stones" -> {return item / 6350.29;}
            case "livres" -> {return item / 453.592;}
            case "onces" -> {return item / 28.3495;}
            default -> {return convertirMetriqueToMetrique("grammes",item,uniteeRecherchee);}
        }
    }
    public static double convertirVitesse(String uniteDeBase, double item, String uniteRecherchee) {
        switch (uniteDeBase) {
            case "noeuds" -> item /= 1.944;
            case "kilomètres par heure" -> item /= 3.6;
            case "pieds par seconde" -> item *= 0.3048;
            case "miles par seconde" -> item *= 0.44704;
        }
        switch (uniteRecherchee) {
            case "noeuds" -> {return item * 1.944;}
            case "kilomètres par heure" -> {return item * 3.6;}
            case "pieds par seconde" -> {return item / 0.3048;}
            case "miles par seconde" -> {return item / 0.44704;}
        }
        return item;
    }

    public static double convertirVolume(String uniteDeBase, double item, String uniteRecherchee) {
        //transformer tout en litre
        switch (uniteDeBase) {
            case "gallon américain" -> item *= 3.78541;
            case "quart américain" -> item *= 0.946353;
            case "pinte américaine liquide" -> item *= 0.473176;
            case "tasse américaine" -> item *= 0.24;
            case "once liquide américaine" -> item *= 0.0295735;
            case "cuillère à soupe américaine" -> item *= 0.00492892;
            case "mètre cube" -> item *= 1000;
            case "gallon impérial" -> item *= 4.54609;
            case "quart impérial" -> item *= 1.13652;
            case "pinte impériale" -> item *= 0.568261;
            case "tasse impériale" -> item *= 0.284131;
            case "once liquide impériale" -> item *= 0.0284131;
            case "cuillère à soupe impériale" -> item *= 0.0177582;
            case "cuillère à café impériale" -> item *= 0.00591939;
            case "pied cube" -> item *= 28.3168;
            case "pouce cube" -> item *= 0.0163871;
            default -> convertirMetriqueToMetrique(uniteDeBase,item,"litre");

        }
        System.out.println(item);
        //return dans la bonne unité
        switch (uniteRecherchee) {
            case "gallon américain" -> {return item / 3.78541;}
            case "quart américain" -> {return item / 0.946353;}
            case "pinte américaine liquide" -> {return item / 0.473176;}
            case "tasse américaine" -> {return item / 0.24;}
            case "once liquide américaine" -> {return item / 0.0295735;}
            case "cuillère à soupe américaine" -> {return item / 0.00492892;}
            case "mètre cube" -> {return item / 1000;}
            case "gallon impérial" -> {return item / 4.54609;}
            case "quart impérial" -> {return item / 1.13652;}
            case "pinte impériale" -> {return item / 0.568261;}
            case "tasse impériale" -> {return item / 0.284131;}
            case "once liquide impériale" -> {return item / 0.0284131;}
            case "cuillère à soupe impériale" -> {return item / 0.0177582;}
            case "cuillère à café impériale" -> {return item / 0.00591939;}
            case "pied cube" -> {return item / 28.3168;}
            case "pouce cube" -> {return item / 0.0163871;}
            default -> {return convertirMetriqueToMetrique("litre",item,uniteRecherchee);}
        }
    }
}
