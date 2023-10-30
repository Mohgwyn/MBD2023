package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class Indice1aLinea extends Indice{

    private Map<String, Integer> palabras;

    public Indice1aLinea() {
        super();
        palabras = new TreeMap<>();
    }

    public void agregarLinea(String linea) {
        super.agregarLinea(linea);
        palabras.clear();
    }
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSig = noSignificativas.stream()
                .map(p -> p.toLowerCase())
                .collect(Collectors.toSet());
        int lineNum = 1;

        for (String line : texto) {
            Scanner sc = new Scanner(line);
            sc.useDelimiter(delimitadores);
            while (sc.hasNext()) {
                String palabra = sc.next().toLowerCase();
                if (!noSig.contains(palabra))
                    if (!palabras.containsKey(palabra)) {
                        palabras.put(palabra, lineNum);
                    }
            }
            lineNum++;
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            System.out.printf("%-20s%d\n",key,palabras.get(key));
        }
    }
}