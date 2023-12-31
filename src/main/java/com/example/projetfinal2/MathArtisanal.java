package com.example.projetfinal2;

import java.util.*;
import java.util.regex.Pattern;

public class MathArtisanal {

    public static final double PI = 3.14159265358979323846;

    public static final double E = 2.7182818284590452354;

    public static int factoriel(int n) {
        int s = 1;
        if (n>0)
            s = n * factoriel(n-1);
        return s;
    }

    private static ArrayList<String> mettreSousNotation(String s, boolean priorite, double ancienneReponse) {

        //mettre la string sous la forme de programmation
        s = s.replaceAll("÷", "/").replaceAll(",",".").replaceAll(" x"," *")
             .replaceAll("π",String.valueOf(PI)).replaceAll("e ",String.valueOf(Math.E)+" ").replaceAll("ANS", String.valueOf(ancienneReponse));

        //initialiser les variables
        final String PRIORITE = "-+/*^";
        ArrayList<String> expression = new ArrayList<>();
        Stack<String> operateurs = new Stack<>();

        //pour chaque element
        for (String element : s.split(" ")) {
            //si c'est un nombre, l'ajouter à la sortie
            if (Pattern.matches("-?(\\d+(\\.(\\d)+)?)",element.replaceAll("E",""))) {
                expression.add(element);
                //si y'a pas de priorité, on ajoute l'operateur tout suite après
                if (!priorite && !operateurs.isEmpty())
                    expression.add(operateurs.pop());
            }


            //si c'est une paranthèse ouvrante, mettre sur le top de la pile
            else if (element.equals("("))
                operateurs.add(element);

            //si le token est une parenthèse fermante, deplier jusqu'à la paranthese ouvrante
            else if (element.equals(")")) {
                while (!operateurs.peek().equals("(")) {
                    expression.add(operateurs.pop());
                }
                operateurs.pop();

                //regarder à la fin si le sommet de la pile est une fonction
                if (!operateurs.isEmpty())
                    if (!Pattern.matches("-?(\\d+(\\.(\\d)+)?)",element))
                        expression.add(operateurs.pop());
            }

            //sinon, faire la priorité des opérateurs (ou pas)
            else if (PRIORITE.contains(element)) {

                //si c’est un opérateur o1 alors
                if (priorite) {
                    if (operateurs.isEmpty())
                        operateurs.add(element);
                    else {

                        //On fait le calcul pour savoir quand enlever
                        while (PRIORITE.indexOf(element) <= PRIORITE.indexOf(operateurs.peek())) {
                            expression.add(operateurs.pop());
                            if (operateurs.isEmpty()) {
                                break;
                            }
                        }
                        operateurs.add(element);
                    }
                }
                else
                    operateurs.add(element);
            }
            //else, si c'est une fonction
            else
                operateurs.add(element);

        }
        //à la fin, ajouter les pauvres opérateurs coincés
        if (priorite)
            while (!operateurs.isEmpty()) {
                expression.add(operateurs.pop());
            }
        return expression;
    }

    public static Double calculer(String expression, boolean priorite, double ancienneReponse) {
        ArrayList<String> listeTerme;
        listeTerme = mettreSousNotation(expression, priorite,ancienneReponse);
        String[] operateursDouble = new String[]{"mod",">>","<<","OR","XOR","AND"};
        while (listeTerme.size() > 1) {
            for (int i = 0; i < listeTerme.size(); i++) {//si c'est un operateur double (qui a besoin de plusieurs valeurs)
                if (Pattern.matches("[+\\-*/^]", listeTerme.get(i)) || Arrays.stream(operateursDouble).toList().contains(listeTerme.get(i))) {
                    //gérer l'expression par exemple "6+", qui créerait une boucle infinie
                    if (listeTerme.size() > 2) {
                        double nombre1 = Double.parseDouble(listeTerme.get(i - 2));
                        double nombre2 = Double.parseDouble(listeTerme.get(i - 1));
                        String operateur = listeTerme.get(i);
                        Double reponse = 0.0;
                        switch (operateur) {
                            //mode normal
                            case "+" -> reponse = nombre1 + nombre2;
                            case "-" -> reponse = nombre1 - nombre2;
                            case "*" -> reponse = nombre1 * nombre2;
                            case "/" -> reponse = nombre1 / nombre2;
                            case "^" -> reponse = Math.pow(nombre1, nombre2);
                            case "mod" -> reponse = nombre1 % nombre2;

                            //mode programmeur
                            case ">>" -> reponse = (double) ((int) nombre1 >> (int) nombre2);
                            case "<<" -> reponse = (double) ((int) nombre1 << (int) nombre2);
                            case "OR" -> reponse = (double) ((int) nombre1 | (int) nombre2);
                            case "XOR" -> reponse = (double) ((int) nombre1 ^ (int) nombre2);
                            case "AND" -> reponse = (double) (((int) nombre1) & ((int) nombre2));
                        }
                        listeTerme.set(i, String.valueOf(reponse));
                        listeTerme.remove(i - 1);
                        listeTerme.remove(i - 2);
                        break;
                    }
                    else
                        throw new IllegalArgumentException();
                }
                //si c'est un operateur simple, simplement l'appliquer au nombre
                //appliquer l'exception de la racine n ieme
                else if (Pattern.matches("(\\d{1,}√)", listeTerme.get(i))) {
                    double nombre = Double.parseDouble(listeTerme.get(i - 1));
                    double reponse = Math.pow(nombre, (1 / Double.parseDouble(listeTerme.get(i).substring(0, listeTerme.get(i).length() - 1))));
                    listeTerme.set(i, String.valueOf(reponse));
                    listeTerme.remove(i - 1);
                    break;
                }
                //si c'est un nombre, on le skip
                else if (Pattern.matches("-?(\\d+(\\.(\\d)+)?)", listeTerme.get(i).replaceAll("E",""))) {
                }

                //si c'est un operateur simple, on l'applique
                else {
                    double nombre = Double.parseDouble(listeTerme.get(i - 1));
                    String operateur = listeTerme.get(i);
                    Double reponse = 0.0;
                    switch (operateur) {
                        //mode scientifique / standard
                        case "²√" -> reponse = Math.sqrt(nombre);
                        case "ln" -> reponse = Math.log(nombre) / Math.log(E);
                        case "log" -> reponse = Math.log(nombre);
                        case "fact" -> reponse = (double) factoriel((int) nombre);
                        case "sin" -> reponse = Math.sin(nombre);
                        case "cos" -> reponse = Math.cos(nombre);
                        case "tan" -> reponse = Math.tan(nombre);
                        case "arcsin" -> reponse = Math.asin(nombre);
                        case "arccos" -> reponse = Math.acos(nombre);
                        case "arctan" -> reponse = Math.atan(nombre);
                        case "NOT" -> reponse = (double) ( ~((int) nombre) );
                    }
                    //si le calcul est un calcul normal, on transforme en string avant
                    listeTerme.set(i, String.valueOf(reponse));
                    listeTerme.remove(i - 1);
                    break;
                }
            }
        }
        return Double.parseDouble(listeTerme.get(0));
    }
}

