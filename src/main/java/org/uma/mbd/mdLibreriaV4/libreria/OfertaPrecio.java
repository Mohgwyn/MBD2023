package org.uma.mbd.mdLibreriaV4.libreria;

public class OfertaPrecio implements OfertaFlex{

    private double descuento;
    private double umbral;

    public OfertaPrecio(double descuento, double umbral) {
        this.descuento = descuento;
        this.umbral = umbral;
    }

    @Override
    public double getDescuento(Libro libro) {
        if (libro.getPrecioBase() >= umbral) {
            return descuento;
        } else {
            return 0;
        }
    }
    public String toString() {
        return descuento + "%(" + umbral + ")";
    }
}
