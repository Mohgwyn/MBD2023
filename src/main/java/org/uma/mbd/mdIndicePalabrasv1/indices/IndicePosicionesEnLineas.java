package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class IndicePosicionesEnLineas extends Indice {

    private Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas() {
        super();
        palabras = new TreeMap<>();
    }

    public void agregarLinea(String linea) {
        super.agregarLinea(linea);
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSig = noSignificativas.stream()
                .map(p -> p.toLowerCase())
                .collect(Collectors.toSet());
        int lineNum = 1;

        for (String line : texto) {
            int pos = 1;
            Scanner sc = new Scanner(line);
            sc.useDelimiter(delimitadores);
            String palabra;
            while (sc.hasNext()) {
                palabra = sc.next().toLowerCase();
                if (!noSig.contains(palabra)) {
                    Map<Integer, Set<Integer>> lineas = palabras.computeIfAbsent(palabra, key -> new TreeMap<>());
                    Set<Integer> posiciones = lineas.computeIfAbsent(lineNum, key -> new HashSet<>());
                    posiciones.add(pos);
                }
                pos++;
            }
            lineNum++;
        }
    }
    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            System.out.println(key);
            for (int linea : palabras.get(key).keySet()) {
                System.out.printf("%10d     ", linea);
                for (int pos :  palabras.get(key).get(linea)) {
                    System.out.printf("%d.", pos);
                }
                System.out.println();
            }
        }
    }
}
