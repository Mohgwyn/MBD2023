package org.uma.mbd.mdLibreriaV4.libreria;

public class LibreriaOfertaFlexible extends Libreria{

    private OfertaFlex oferta;

    public LibreriaOfertaFlexible(OfertaFlex oferta) {
        this.oferta = oferta;
    }

    public void setOferta(OfertaFlex oferta) {
        this.oferta = oferta;
        for (Libro libro: libros) {
            addLibro(libro.getAutor(), libro.getTitulo(), libro.getPrecioBase());
        }
    }
    public OfertaFlex getOferta() {
        return oferta;
    }
    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        double des = oferta.getDescuento(libro);
        if(des > 0)
            libro = new LibroEnOferta(autor, titulo, precioBase, des);
        addLibro(libro);
    }
}