package org.uma.mbd.mdEstadistica;

import org.uma.mbd.mdEstadistica.estadistica.Estadistica;
import java.util.Random;

public class EjemploUso {
    public static void main(String[] args) {

        Random random = new Random();
        Estadistica estadistica = new Estadistica();

        for (int i=0; i<100000; i++) {
            estadistica.agrega(random.nextGaussian());
        }

        System.out.println(estadistica.media());
        System.out.println(estadistica.desviacionTipica());
        System.out.println(estadistica.varianza());
    }
}