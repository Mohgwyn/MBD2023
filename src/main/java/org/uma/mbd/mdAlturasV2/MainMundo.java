package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.EnContinente;
import org.uma.mbd.mdAlturasV2.alturas.MenoresQue;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class MainMundo {

    public static void main(String args[]) throws IOException {

        Comparator<Pais> OrdenAltura =
                (p1, p2) -> Double.compare(p1.altura(), p2.altura());
        Comparator<Pais> OrdenAlfabetico =
                (p1, p2) -> p1.nombre().compareTo(p2.nombre());
        Comparator<Pais> OrdenContinente =
                (p1, p2) -> p1.continente().compareTo(p2.continente());

        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }

    }
}