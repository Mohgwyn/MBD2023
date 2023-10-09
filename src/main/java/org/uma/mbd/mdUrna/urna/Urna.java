package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {

    static public enum ColorBola {Blanca, Negra};

    private int blancas, negras;
    private static final Random ale = new Random();

    public Urna(int blancas, int negras){
        if (negras <= 0 || blancas < 0) {
            throw new IllegalArgumentException("No puede haber bolas negativas");
        }
        this.blancas = blancas;
        this.negras = negras;
    }

    public ColorBola extraerBola() {
        ColorBola bolaSacada = null;
        if (totalBolas() == 0) {
            throw new NoSuchElementException("No hay bolas que sacar");
        }
        if (ale.nextInt(totalBolas()) <= blancas) {
            bolaSacada = ColorBola.Blanca;
            blancas--;
        } else {
            bolaSacada = ColorBola.Negra;
            negras--;
        }
        return bolaSacada;
    }
    public int totalBolas() { return blancas+negras; }
    public void ponerBlanca() {
        blancas++;
    }
    public void ponerNegra() {
        negras++;
    }

}
