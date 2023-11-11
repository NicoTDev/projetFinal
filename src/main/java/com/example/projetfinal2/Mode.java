package com.example.projetfinal2;

import java.util.ArrayList;
import java.util.Arrays;

public enum Mode {
    STANDARD (new ArrayList<>(Arrays.asList(new String[]{"1/x","x²","xⁿ","²√x","ⁿ√x","(",")","x","÷","+","-","-x",","})),
              new ArrayList<>(Arrays.asList(new String[]{"1 /"," ^ 2 "," ^ "," ²√ ( "," ⁿ√x ","( "," )"," x "," ÷ "," + "," - "," -",","}))),
    SCIENTIFIQUE (new ArrayList<>(Arrays.asList(new String[]{"mod","eⁿ","ln","log","fact","sin","arcsin","cos","arccos","tan","arctan","π","e"})),
                  new ArrayList<>(Arrays.asList(new String[]{" mod ","e ^ "," ln ( ","log"," fact ( "," sin ( "," arcsin ( "," cos ( "," arccos ( ","tan ( ","arctan ( ","π","e"}))),
    PROGRAMMEUR (new ArrayList<>(), new ArrayList<>());
    public final ArrayList<String> valeursDeBouton;

    public final ArrayList<String> symboles;

    Mode(ArrayList<String> valeursDeBouton, ArrayList<String> symboles) {
        this.valeursDeBouton = valeursDeBouton;
        this.symboles = symboles;
    }

}
