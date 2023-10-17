package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdTesoro.tesoro.Tesoro;

public class MainTesoro {
    public static void main(String[] args) {
        double a = Integer.parseInt(args[0]);
        double b = Integer.parseInt(args[1]);
        Tesoro tesoro = new Tesoro(new Punto(a,b), new Punto(5,0), new Punto(-5,0));

        System.out.println(tesoro.getTesoro());
    }
}
