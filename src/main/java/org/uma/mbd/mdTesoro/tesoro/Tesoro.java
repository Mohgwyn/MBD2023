package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.*;

public class Tesoro {

    private Punto rosa, amarilla, azul;
    private Punto estacaAmarilla, estacaAzul, tesoro;

    public Tesoro(double a, double b, double c, double d, double e, double f) {
        setRosa(a,b);
        setAmarilla(c,d);
        setAzul(e,f);
        calculaPosiciones();
    }

    private void calculaPosiciones() {
        Vector v = new Vector(rosa,amarilla);
        estacaAmarilla = v.ortogonal().extremoDesde(amarilla);
        v = new Vector(rosa,azul);
        estacaAzul = v.ortogonal().ortogonal().ortogonal().extremoDesde(azul);
        tesoro = new Punto((estacaAmarilla.getX()+estacaAzul.getX())/2, (estacaAmarilla.getY()+estacaAzul.getY())/2);
    }
    public Punto getEstacaAmarilla() {
        return estacaAmarilla;
    }
    public Punto getEstacaAzul() {
        return estacaAzul;
    }
    public Punto getTesoro() {
        return tesoro;
    }

    public void setRosa(double a, double b) {
        rosa = new Punto(a,b);
    }
    public void setAmarilla(double a, double b) {
        amarilla = new Punto(a,b);
    }
    public void setAzul(double a, double b) {
        azul = new Punto(a,b);
    }

    public String toString() {
        return "Tesoro: " + tesoro;
    }
}
