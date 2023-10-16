package org.uma.mbd.mdLibreria.libreria;

import java.util.ArrayList;
import java.util.List;

public class LibreriaV2 {

    private List<Libro> libros;

    public LibreriaV2(int tam) {
        libros = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }
    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos < 0) {
            libros.add(libro);
        } else {
            libros.set(pos, libro);
        }
    }
    private int posicionLibro(String autor, String titulo) {
        int pos = 0;
        while (pos < libros.size() && !(autor.equals(libros.get(pos).getAutor()) && titulo.equals(libros.get(pos).getTitulo()))) {
            pos++;
        }
        return (pos == libros.size()) ? -1 : pos;
    }

    public void remLibro(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        if (pos >= 0) {
            libros.remove(pos);
        }
    }
    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos>=0) ? libros.get(pos).getPrecioBase() : 0;
    }
    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos>=0) ? libros.get(pos).getPrecioFinal() : 0;
    }
    @Override
    public String toString() {
       return libros.toString();
    }

}
