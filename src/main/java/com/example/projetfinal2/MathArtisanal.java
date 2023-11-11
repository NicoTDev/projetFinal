package com.example.projetfinal2;

public class MathArtisanal {

    public static final double PI = 3.14159265358979323846;

    public static final double E = 2.7182818284590452354;

    public static int factoriel(int n) {
        int s = 1;
        if (n>0)
            s = n * factoriel(n-1);
        return s;
    }

    private static ArrayList<String> mettreSousNotation(String s) {

        //mettre la string sous la forme de programmation
        s = s.replaceAll("÷", "/").replaceAll(",",".").replaceAll("x","*");
        //initialiser les variables
        final String PRIORITE = "+-*/^";
        ArrayList<String> expression = new ArrayList<>();
        Stack<String> operateurs = new Stack<>();
        //pour chaque element
        for (String element : s.split(" ")) {
            System.out.println(expression);
            //si c'est un nombre, l'ajouter à la sortie
            if (Pattern.matches("\\d+(\\.(\\d)+)?",element))
                expression.add(element);
                //si c'est une paranthèse ouvrante, mettre sur le top de la pile
            else if (element.equals("("))
                operateurs.add(element);
                //si le token est une parenthèse fermante, deplier jusqu'à la paranthese ouvrante
            else if (element.equals(")")) {
                while (!operateurs.peek().equals("("))
                    expression.add(operateurs.pop());
                operateurs.pop();
            }
            //sinon, faire la priorité des opérateurs
            else {
                //si c’est un opérateur o1 alors
                if (operateurs.isEmpty())
                    operateurs.add(element);
                else {
                    while (PRIORITE.indexOf(element) <= PRIORITE.indexOf(operateurs.peek())) {
                        expression.add(operateurs.pop());
                        if (operateurs.isEmpty())
                            break;
                    }
                    operateurs.add(element);
                }
            }
        }
        //à la fin, ajouter les pauvres opérateurs coincés
        while (!operateurs.isEmpty())
            expression.add(operateurs.pop());
        return expression;
    }

    public static Double calculer(String expression) {
        ArrayList<String> listeTerme = mettreSousNotation(expression);
        while (listeTerme.size() > 1)
            for (int i = 0 ; i < listeTerme.size(); i++) {
                if (Pattern.matches("[+\\-*/^]", listeTerme.get(i))) {
                    double nombre1 = Double.parseDouble(listeTerme.get(i - 2));
                    double nombre2 = Double.parseDouble(listeTerme.get(i - 1));
                    String operateur = listeTerme.get(i);
                    Double reponse = 0.0;
                    switch (operateur) {
                        case "+" -> reponse = nombre1 + nombre2;
                        case "-" -> reponse = nombre1 - nombre2;
                        case "*" -> reponse = nombre1 * nombre2;
                        case "/" -> reponse = nombre1 / nombre2;
                        case "^" -> reponse = Math.pow(nombre1,nombre2);
                    }
                    listeTerme.set(i, String.valueOf(reponse));
                    listeTerme.remove(i-1);
                    listeTerme.remove(i-2);
                    break;
                }
            }
        return Double.parseDouble(listeTerme.get(0));
    }
}

