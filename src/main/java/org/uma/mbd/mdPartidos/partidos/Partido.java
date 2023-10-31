package org.uma.mbd.mdPartidos.partidos;

import java.util.Objects;

public class Partido {

    private String nombre;
    private int votos;
    public Partido(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() { return nombre; }
    public int getVotos() { return votos; }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Partido p) {
            return p.nombre.equalsIgnoreCase(nombre);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    @Override
    public String toString() {
        return nombre + " : " + votos;
    }
}
