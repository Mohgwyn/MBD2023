package org.uma.mbd.mdLibreria.libreria;

import java.util.Arrays;

public class LibreriaOferta extends LibreriaV3{

    private double descuento;
    private String[] autoresEnOferta;

    public LibreriaOferta(double descuento, String[] autores) {
        setOferta(descuento, autores);
    }

    public void setOferta(double descuento, String[] autores) {
        this.descuento = descuento;
        autoresEnOferta = autores;
    }
    public String[] getOferta() {
        return autoresEnOferta;
    }
    public double getDescuento() {
        return descuento;
    }
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = null;

        if (esAutorEnOferta(autor))
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
        else
            libro = new Libro(autor, titulo, precioBase);

        addLibro(libro);
        super.addLibro(autor, titulo, precioBase);
    }
    private boolean esAutorEnOferta(String autor) {
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor)) {
            pos++;
        }

        return pos < autoresEnOferta.length;
    }
    @Override
    public String toString() {
        return descuento + "%" + Arrays.toString(autoresEnOferta) + super.toString();
    }

}
