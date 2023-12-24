package com.example.projetfinal2;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertisseurMesures {

    //Systeme Internationnal
    public static float convertirInterToInter(String uniteDeBase, float item, String uniteRecherchee) {
        //enlever tous les suffixes
        uniteDeBase = uniteDeBase.replaceAll(uniteDeBase.replaceAll("(micro|milli|centi|deci|deca|hecto|kilo|mega)", ""), "");
        uniteRecherchee = uniteRecherchee.replaceAll(uniteRecherchee.replaceAll("(micro|milli|centi|deci|deca|hecto|kilo|mega)", ""), "");
        ArrayList<String> prefix = new ArrayList<>(Arrays.asList("micro", "NA", "NA", "milli", "centi", "deci", "", "deca", "hecto", "kilo", "NA", "NA", "mega"));
        return (float) (item * Math.pow(10, prefix.indexOf(uniteDeBase) - prefix.indexOf(uniteRecherchee)));
    }

    //LONGUEUR
    public static float convertirLongueur(String uniteDeBase, float item, String uniteRecherchee) {
        switch (uniteDeBase) {
            case "pieds" -> item /= 3.28084;
            case "pouces" -> item /= 39.3701;
            default -> item = convertirInterToInter(uniteDeBase,item,"mètres");
        }
        switch (uniteRecherchee) {
            case "pieds" -> {return item*3.28084f;}
            case "pouces" -> {return item*39.3701f;}
            default -> {return convertirInterToInter("mètres",item,uniteRecherchee);}
        }
    }
    //ANGLE
    public static float convertirAngle(String uniteDeBase, float item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;
        return (float) (item*Math.pow(Math.PI/180,(uniteDeBase.equals("radians") ? -1 : 1)));
    }

    //TEMPÉRATURE
    public static float convertirTemperature(String uniteDeBase, float item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;
        if (uniteDeBase.equals("kelvin"))
            item = item - 273.15f;
        else if (uniteDeBase.equals("fahrenheit"))
            item = (item - 32) * 5/9;
        switch (uniteRecherchee) {
            case "fahrenheit" -> {return ((item * 9/5) + 32);}
            case "kelvin" -> {return item+273.15f;}
        }
        return item;
    }

    //TEMPS
    public static float convertirTemps(String uniteDeBase, float item, String uniteRecherchee) {
        if (uniteRecherchee.equals(uniteDeBase))
            return item;
        //transformer en seconde
        switch (uniteDeBase) {
            case "années" -> item *= (float) (3.154*Math.pow(10,7));
            case "mois" -> item *= (float) (2.628*Math.pow(10,6));
            case "semaines" -> item *= 604800;
            case "jours" -> item *= 86400;
            case "heures" -> item *= 3600;
            case "minutes" -> item *= 60;
            case "millisecondes" -> item /= 1000;
            case "microsecondes" -> item /= (float) Math.pow(10,6);
            case "nanosecondes" -> item /= (float) Math.pow(10,9);
        }
        switch (uniteRecherchee) {
            case "années" -> {return (float) (item/(3.154*Math.pow(10,7)));}
            case "mois" -> {return (float) (item/(2.628*Math.pow(10,6)));}
            case "semaines" -> {return item / 604800;}
            case "jours" -> {return item / 86400;}
            case "heures" -> {return item / 3600;}
            case "minutes" -> {return item / 60;}
            case "millisecondes" -> {return item * 1000;}
            case "microsecondes" -> {return (float) (item * Math.pow(10,6));}
            case "nanosecondes" -> {return (float) (item * Math.pow(10,9));}
        }
        return item;
    }

    //DEVISES
    public static float convertirArgent(String uniteDeBase, float item, String uniteRecherchee) {
        //tout mettre sur le dollar canadien
        switch (uniteDeBase) {
            case "dollar américain" -> item*=1.35f;
            case "franc suisse" -> item*=1.55f;
            case "peso mexicain" -> item*=.079f;
            case "rouble russe" -> item*= .015f;
            case "won sud-coréen" -> item*=.0010f;
            case "roupie indienne" -> item *= .016f;
            case "euro" -> item *= 1.47f;
            case "couronne suédoise" -> item *= .13f;
            case "couronne islandaise" -> item *= .0098f;
            case "yen" -> item *= .0092f;
            case "V-Bucks Fortnite" -> item *= 0.01079f;
        }
        switch (uniteRecherchee) {
            case "dollar américain" -> {return item/1.35f;}
            case "franc suisse" -> {return item/1.55f;}
            case "peso mexicain" -> {return item/.079f;}
            case "rouble russe" -> {return item/ .015f;}
            case "won sud-coréen" -> {return item/.0010f;}
            case "roupie indienne" -> {return item / .016f;}
            case "euro" -> {return item / 1.47f;}
            case "couronne suédoise" -> {return item / .13f;}
            case "couronne islandaise" -> {return item / .0098f;}
            case "yen" -> {return item / .0092f;}
            case "V-Bucks Fortnite" -> {return item / 0.01079f;}
        }
        return item;
    }

    //POIDS
    public static float convertirPoidsEtMasse(String uniteDeBase, float item, String uniteeRecherchee) {
        //transformer en gramme
        switch (uniteDeBase) {
            case "newtons" -> item *= 101.97162129779;
            case "tonnes métriques" -> item *= Math.pow(10,6);
            case "tonnes longues" -> item *= 1.016*Math.pow(10,6);
            case "stones" -> item *= 6350.29;
            case "livres" -> item *= 453.592;
            case "onces" -> item *= 28.3495;
            default -> item = convertirInterToInter(uniteDeBase,item,"grammes");
        }
        switch (uniteeRecherchee) {
            case "newtons" -> {return  (item / 101.97162129779f);}
            case "tonnes métriques" -> {return (float) (item / Math.pow(10,6));}
            case "tonnes longues" -> {return (float) (item / 1.016*Math.pow(10,6));}
            case "stones" -> {return  (item / 6350.29f);}
            case "livres" -> {return  (item / 453.592f);}
            case "onces" -> {return  (item / 28.3495f);}
            default -> {return convertirInterToInter("grammes",item,uniteeRecherchee);}
        }
    }

    public static String convertirProgrammeur(String uniteDeBase, String item, String uniteeRecherchee) {
        //transformer en gramme
        switch (uniteDeBase) {
            case "Binaire"-> item = String.valueOf(Integer.parseInt(item,2));
            case "Octa" -> item = String.valueOf(Integer.parseInt(item,8));
            case "Décimal" -> item = String.valueOf(Integer.parseInt(item,10));
            case "Hexadécimal" -> item = String.valueOf(Integer.parseInt(item,16));
        }
        switch (uniteeRecherchee) {
            case "Binaire" -> { return Integer.toBinaryString(Integer.parseInt(item)); }
            case "Octa" -> { return Integer.toOctalString(Integer.parseInt(item)); }
            case "Hexadécimal" -> { return Integer.toHexString(Integer.parseInt(item)); }
            default -> { return item; }

        }
    }
    //VITESSE
    public static float convertirVitesse(String uniteDeBase, float item, String uniteRecherchee) {
        switch (uniteDeBase) {
            case "noeuds" -> item /= 1.944f;
            case "kilomètres par heure" -> item /= 3.6f;
            case "pieds par seconde" -> item *= 0.3048f;
            case "miles par seconde" -> item *= 0.44704f;
        }
        switch (uniteRecherchee) {
            case "noeuds" -> {return item * 1.944f;}
            case "kilomètres par heure" -> {return item * 3.6f;}
            case "pieds par seconde" -> {return item / 0.3048f;}
            case "miles par seconde" -> {return item / 0.44704f;}
        }
        return item;
    }

    //VOLUME
    public static float convertirVolume(String uniteDeBase, float item, String uniteRecherchee) {
        //transformer tout en litre
        switch (uniteDeBase) {
            case "gallon américain" -> item *= 3.78541f;
            case "quart américain" -> item *= 0.946353f;
            case "pinte américaine liquide" -> item *= 0.473176f;
            case "tasse américaine" -> item *= 0.24f;
            case "once liquide américaine" -> item *= 0.0295735f;
            case "cuillère à soupe américaine" -> item *= 0.00492892f;
            case "mètre cube" -> item *= 1000;
            case "gallon impérial" -> item *= 4.54609f;
            case "quart impérial" -> item *= 1.13652f;
            case "pinte impériale" -> item *= 0.568261f;
            case "tasse impériale" -> item *= 0.284131f;
            case "once liquide impériale" -> item *= 0.0284131f;
            case "cuillère à soupe impériale" -> item *= 0.0177582f;
            case "cuillère à café impériale" -> item *= 0.00591939f;
            case "pied cube" -> item *= 28.3168f;
            case "pouce cube" -> item *= 0.0163871f;
            default -> convertirInterToInter(uniteDeBase,item,"litre");
        }
        //return dans la bonne unité
        switch (uniteRecherchee) {
            case "gallon américain" -> {return item / 3.78541f;}
            case "quart américain" -> {return item / 0.946353f;}
            case "pinte américaine liquide" -> {return item / 0.473176f;}
            case "tasse américaine" -> {return item / 0.24f;}
            case "once liquide américaine" -> {return item / 0.0295735f;}
            case "cuillère à soupe américaine" -> {return item / 0.00492892f;}
            case "mètre cube" -> {return item / 1000;}
            case "gallon impérial" -> {return item / 4.54609f;}
            case "quart impérial" -> {return item / 1.13652f;}
            case "pinte impériale" -> {return item / 0.568261f;}
            case "tasse impériale" -> {return item / 0.284131f;}
            case "once liquide impériale" -> {return item / 0.0284131f;}
            case "cuillère à soupe impériale" -> {return item / 0.0177582f;}
            case "cuillère à café impériale" -> {return item / 0.00591939f;}
            case "pied cube" -> {return item / 28.3168f;}
            case "pouce cube" -> {return item / 0.0163871f;}
            default -> {return convertirInterToInter("litre",item,uniteRecherchee);}
        }
    }
}
