package org.uma.mbd.mdIndicePalabrasv1;

import org.uma.mbd.mdIndicePalabrasv1.indices.Indice;
import org.uma.mbd.mdIndicePalabrasv1.indices.Indice1aLinea;
import org.uma.mbd.mdIndicePalabrasv1.indices.IndiceLineas;
import org.uma.mbd.mdIndicePalabrasv1.indices.IndicePosicionesEnLineas;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Collection<String> noSignificativas = new HashSet<>(Arrays.asList("A","buen", "con", "de", "ha", "hubiera", "la", "NO", "pero", "Por", "porque", "qué", "si", "tenía", "una", "y"));
        Indice indice = new IndicePosicionesEnLineas();

        indice.agregarLinea("Guerra tenía una jarra y Parra tenía una perra, pero la perra de Parra rompió la jarra de Guerra.");
        indice.agregarLinea("Guerra pegó con la porra a la perra de Parra ¡Oiga usted buen hombre de Parra! Por qué ha pegado con la porra a la perra de Parra");
        indice.agregarLinea("Porque si la perra de Parra no hubiera roto la jarra de Guerra, Guerra no hubiera pegado con la porra a la perra de Parra.");
        indice.resolver("[ .,:;-[!][¡][?][¿]]+", noSignificativas);
        indice.presentarIndiceConsola();

    }

}
