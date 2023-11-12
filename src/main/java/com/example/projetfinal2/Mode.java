package com.example.projetfinal2;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Map.entry;
import java.util.HashMap;
import java.util.Map;

public enum Mode {
    STANDARD (new ArrayList<>(Arrays.asList(new String[]{"1/x","x²","xⁿ","²√x","ⁿ√x","(",")","x","÷","+","-","-x",","})),
              new ArrayList<>(Arrays.asList(new String[]{"1 / "," ^ 2 "," ^ "," ²√ ( ","√ ( ","( "," )"," x "," ÷ "," + "," - "," -",","}))),

    SCIENTIFIQUE (new ArrayList<>(Arrays.asList(new String[]{"mod","eⁿ","ln","log","fact","sin","arcsin","cos","arccos","tan","arctan","π","e"})),
                  new ArrayList<>(Arrays.asList(new String[]{" mod ","e ^ ","ln ( ","log ( ","fact ( ","sin ( ","arcsin ( ","cos ( ","arccos ( ","tan ( ","arctan ( ","π","e"}))),
    PROGRAMMEUR (new ArrayList<>(), new ArrayList<>());
    public final ArrayList<String> valeursDeBouton;

    public final ArrayList<String> symboles;

    Mode(ArrayList<String> valeursDeBouton, ArrayList<String> symboles) {
        this.valeursDeBouton = valeursDeBouton;
        this.symboles = symboles;
    }

}

//public enum Mode2 {
//    STANDARD (Map.ofEntries(
//            entry("1/x", "1 /"),entry("x²", " ^ 2 "),entry("xⁿ", " ^ "),entry("²√x", " ²√ ( "),
//            entry("ⁿ√x", "√x ( "),entry("(", "( "),entry(")", " )"),entry("x", " x "),
//            entry("÷", " ÷ "),entry("+", " + "),entry("-", " - "),entry("-x", "-"),
//           entry(",", ","))),
//    SCIENTIFIQUE (Map.ofEntries(
//            entry("mod", " mod "),entry("eⁿ", "e ^ "),entry("ln", "ln ( "),entry("log", "log ( "),
//            entry("fact", "fact ( "),entry("sin", " sin ( "),entry("arcsin", " arcsin ( "),entry("cos", "cos ( "),
//           entry("arccos", "arccos ( "),entry("tan", "tan ( "),entry("arctan", "arctan ( "),entry("π", "π"),
//            entry("e", "e"))),
//    PROGRAMMEUR (new ArrayList<>(), new ArrayList<>());
//    public final Map<String,String> valeursDeBouton;
//
//    Mode2(Map<String, String> valeurs) {
//        this.valeursDeBouton = valeurs;
//   }
//}
