package org.uma.mbd.mdLibreriaV5.libreria;

import java.util.Objects;

public class Libro {

    private static double IVA;
    private double precioBase, precioFinal;
    private String autor, titulo;

    public Libro(String autor, String titulo, double precioBase) {
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.precioFinal = getPrecioFinal();
    }

    public double getIVA() { return Libro.IVA; }
    public double getPrecioBase() { return precioBase; }
    public double getPrecioFinal() {
        return precioBase + precioBase*(Libro.IVA/100);
    }
    public String getAutor() { return autor; }
    public String getTitulo() { return titulo; }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }

    @Override
    public String toString() {
        return "{" + autor + ";" + titulo + ";" + precioBase + ";" + Libro.IVA + ";" + getPrecioFinal() + "}";
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof Libro libro
                && libro.autor.equalsIgnoreCase(autor)
                && libro.titulo.equalsIgnoreCase(titulo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(autor.toLowerCase(), titulo.toUpperCase());
    }
}
