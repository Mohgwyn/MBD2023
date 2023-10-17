package org.uma.mbd.mdCoche.coches;

public class Coche {

    private String nombre;
    private double precio;
    private static double PIVA=0.16;

    public Coche(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double precioTotal() {
        return precio + precio*PIVA;
    }
    public static void setPiva(double piva) {
        PIVA = piva;
    }
    @Override
    public String toString() {
        return nombre + " -> " + precioTotal();
    }
}
