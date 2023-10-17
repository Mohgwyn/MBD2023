package org.uma.mbd.mdLibreriaV4.libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{

    private double descuento;
    private String[] autoresEnOferta;

    public OfertaAutor(double descuento, String[] autores) {
        this.descuento = descuento;
        this.autoresEnOferta = autores;
    }

    @Override
    public double getDescuento(Libro libro) {
        if (autorEnOferta(libro.getAutor())) {
            return descuento;
        } else {
            return 0;
        }
    }
    private boolean autorEnOferta(String autor) {
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor)) {
            pos++;
        }
        return pos < autoresEnOferta.length;
    }
    @Override
    public String toString() {
        return descuento + "%" + Arrays.toString(autoresEnOferta);
    }
}
