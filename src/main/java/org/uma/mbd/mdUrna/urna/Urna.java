package org.uma.mbd.mdUrna.urna;

import java.util.Random;

public class Urna {

    static public enum ColorBola {Blanca, Negra};

    private int nBlancas, nNegras;
    private static Random ale = new Random();

    public ColorBola sacaBola() {
        ColorBola bolaSacada = null;
        //double probabilidadBlanca = (double)nBlancas / (double)(nBlancas + nNegras);
        if (ale.nextInt(nNegras+nBlancas) <= nBlancas-1) {
            bolaSacada = ColorBola.Blanca;
            nBlancas--;
        } else {
            bolaSacada = ColorBola.Negra;
            nNegras--;
        }
        return bolaSacada;
    }
}
