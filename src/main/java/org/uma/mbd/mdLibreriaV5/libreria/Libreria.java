package org.uma.mbd.mdLibreriaV5.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    protected List<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }
    protected void addLibro(Libro libro) {
        int pos = libros.indexOf(libro);
        if (pos < 0) {
            libros.add(libro);
        } else {
            libros.set(pos, libro);
        }
    }
    public void remLibro(String autor, String titulo) {
        Libro libro = new Libro(autor, titulo, 0);
        libros.remove(libro);
    }
    public double getPrecioBase(String autor, String titulo) {
        int pos = libros.indexOf(new Libro(autor, titulo, 0));
        return (pos>=0) ? libros.get(pos).getPrecioBase() : 0;
    }
    public double getPrecioFinal(String autor, String titulo) {
        int pos = libros.indexOf(new Libro(autor, titulo, 0));
        return (pos>=0) ? libros.get(pos).getPrecioFinal() : 0;
    }
    @Override
    public String toString() {
        return libros.toString();
    }
}