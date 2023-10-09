package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdTesoro.tesoro.Tesoro;

public class MainTesoro {
    public static void main(String[] args) {
        double a = Integer.parseInt(args[0]);
        double b = Integer.parseInt(args[1]);
        Tesoro tesoro = new Tesoro(a, b, 4, 0, -4, 0);

        System.out.println(tesoro.getTesoro());
    }
}
