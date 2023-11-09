package com.example.projetfinal2;

public class MathArtisanal {

    public static final double PI = 3.14159265358979323846;

    public static final double E = 2.7182818284590452354;

    public static int factoriel(int n) {
        int s = 1;
        if (n>0)
            s = n*factoriel(n-1);
        return s;
    }
}

