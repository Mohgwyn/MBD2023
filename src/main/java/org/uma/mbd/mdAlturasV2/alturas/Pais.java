package org.uma.mbd.mdAlturasV2.alturas;

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais>{
    @Override
    public int compareTo(Pais p) {
        int result = Double.compare(altura, p.altura);
        if (result == 0) {
            result = nombre.compareTo(p.nombre);
        }
        return result;
    }
}
