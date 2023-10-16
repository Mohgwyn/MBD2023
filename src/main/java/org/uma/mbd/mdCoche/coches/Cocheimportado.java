package org.uma.mbd.mdCoche.coches;

public class Cocheimportado extends Coche{

    private double homologacion;

    public Cocheimportado(String nombre, double precio, double homologacion) {
        super(nombre, precio);
        this.homologacion = homologacion;
    }

    @Override
    public double precioTotal() {
        return super.precioTotal() + homologacion;
    }
}
