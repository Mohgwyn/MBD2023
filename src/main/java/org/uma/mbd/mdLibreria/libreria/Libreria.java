package org.uma.mbd.mdLibreria.libreria;

public class Libreria {

    private Libro [] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria() {
        this(Libreria.TAM_DEFECTO);
    }
    public Libreria(int tam) {
        libros = new Libro[tam];
        numLibros = 0;
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }
    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos < 0) {
            // El libro no esta
        } else {
            // El libro está
        }
    }
    private int posicionLibro(String autor, String titulo) {
        return 0;
    }
    public void remLibro(String autor, String titulo) {}
    public double getPrecioBase(String autor, String titulo) {
        return 0;
    }
    public double getPrecioFinal(String autor, String titulo) {
        return 0;
    }
}
