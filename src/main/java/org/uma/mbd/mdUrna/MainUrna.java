package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) {

        Urna urna = new Urna(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        Urna.ColorBola color;

        while(urna.totalBolas() > 1) {
            if (urna.extraerBola() == urna.extraerBola()) {
                urna.ponerBlanca();
            } else {
                urna.ponerNegra();
            }
        }
        System.out.println(urna.extraerBola());
    }
}
