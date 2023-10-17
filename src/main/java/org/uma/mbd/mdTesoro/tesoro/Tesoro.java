package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.*;

public class Tesoro {

    private Punto rosa, amarilla, azul;
    private Punto estacaAmarilla, estacaAzul, tesoro;

    public Tesoro(Punto a, Punto b, Punto c) {
        setRosa(a);
        setAmarilla(b);
        setAzul(c);
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

    public void setRosa(Punto pto) {
        rosa = pto;
    }
    public void setAmarilla(Punto pto) {
        amarilla = pto;
    }
    public void setAzul(Punto pto) {
        azul = pto;
    }

    public String toString() {
        return "Tesoro: " + tesoro;
    }
}
