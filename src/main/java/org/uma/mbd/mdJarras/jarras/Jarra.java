package org.uma.mbd.mdJarras.jarras;

public class Jarra {

    // Atributos //
    private final int capacidad;
    private int contenido;

    // Constructor //
    public Jarra(int capacidadMax) {
        if (capacidadMax <= 0){
            throw new IllegalArgumentException("No se puede crear una jarra con capacidad " + capacidadMax);
        }
        capacidad = capacidadMax;
        contenido = 0;
    }

    // Métodos //
    public int getCapacidad() { return capacidad; }
    public int getContenido() { return contenido; }

    public void llena() {
        contenido = capacidad;
    }
    public void vacia() {
        contenido = 0;
    }
    public void llenaDesde(Jarra jarra) {
        if (this == jarra) {
            throw new IllegalArgumentException("No se puede volcar una jarra sobre sí misma");
        }
        if (jarra.contenido > (capacidad - contenido)) {
            jarra.contenido -= (capacidad - contenido);
            this.llena();
        } else {
            contenido += jarra.contenido;
            jarra.vacia();
        }
    }
    @Override
    public String toString() {
        return("J(capacidad: " + capacidad + ", contenido: " + contenido + ")");
    }

}