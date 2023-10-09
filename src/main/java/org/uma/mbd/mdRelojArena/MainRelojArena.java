package org.uma.mbd.mdRelojArena;

import org.uma.mbd.mdRelojArena.relojarena.MedidorTiempo;

public class MainRelojArena {
    public static void main(String[] args) {

        MedidorTiempo medidor = new MedidorTiempo(5,7);

        System.out.println(medidor);
        medidor.giraAmbos();
        System.out.println(medidor);
        medidor.giraDerecho();
        System.out.println(medidor);
        medidor.giraAmbos();
        System.out.println(medidor);
        System.out.println(medidor.getTiempoTotal());

    }
}
