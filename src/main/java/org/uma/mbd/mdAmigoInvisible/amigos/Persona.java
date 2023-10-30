package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private Persona amigo;
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void setAmigo(Persona am) {
        this.amigo = am;
    }
    public String getNombre() { return nombre; }
    public Persona getAmigo() { return amigo; }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Persona p) {
            return nombre.equalsIgnoreCase(p.nombre);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    @Override
    public int compareTo(Persona p) {
        return nombre.compareTo(p.nombre);
    }
    @Override
    public String toString() {
        if (amigo == null) {
            return nombre + " --> sin amigo";
        }
        return nombre + " --> " + amigo.nombre;
    }
}