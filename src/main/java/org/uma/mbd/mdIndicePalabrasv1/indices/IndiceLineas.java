package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class IndiceLineas extends Indice{

    private Map<String, Set<Integer>> palabras;

    public IndiceLineas() {
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
            Scanner sc = new Scanner(line);
            sc.useDelimiter(delimitadores);
            String palabra;
            while (sc.hasNext()) {
                palabra = sc.next().toLowerCase();
                if (!noSig.contains(palabra)) {
                    if (!palabras.containsKey(palabra)) {
                        palabras.put(palabra, new TreeSet<>());
                    }
                    palabras.get(palabra).add(lineNum);
                }
            }
            lineNum++;
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            System.out.printf("%-20s", key);
            for (int linea : palabras.get(key)) {
                System.out.printf("%d.", linea);
            }
            System.out.println();
        }
    }

}