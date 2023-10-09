package org.uma.mbd.mdRectas.rectas;

public class Recta {

    private Vector direccion;
    private Punto pto;
    private implicita implicita;

    public Recta(Vector v, Punto p) {
        direccion = v;
        pto = p;
        implicita = new implicita(direccion.getComponenteX(), -direccion.getComponenteY(), pto.getY()*direccion.getComponenteY()-pto.getX()*direccion.getComponenteY());
    }
    public Recta(Punto p, Punto q) {
        this(new Vector(p,q), new Punto(p));
    }
    public Recta(Recta r) {
        this(new Vector(r.direccion), new Punto(r.pto));
    }

    private record implicita(double a, double b, double c) {}
    // Determinante es un método de clase (static?)
    private double determinante(double a11, double a12, double a21, double a22) {
        return a11*a22 - a12*a21;
    }
    public double distanciaDesde(Punto p) {
        Recta r = new Recta(new Vector(direccion.ortogonal()),new Punto(p));
        Punto q = interseccionCon(r);
        return q.distancia(p);
    }
    public Punto interseccionCon(Recta r) {
        if (determinante(implicita.a, implicita.b, r.implicita.a, r.implicita.b)==0) {
            throw new IllegalArgumentException("Las rectas son paralelas");
        } else {
            double x = determinante(-implicita.c, implicita.b, -r.implicita.c, r.implicita.b)/determinante(implicita.a, implicita.b, r.implicita.a, r.implicita.b);
            double y = determinante(implicita.a, -implicita.c, r.implicita.a, -r.implicita.c)/determinante(implicita.a, implicita.b, r.implicita.a, r.implicita.b);
            return new Punto(x,y);
        }
    }
    public boolean paralelaA(Recta r) {
        return r.direccion.paraleloA(direccion);
        //return determinante(implicita.a, implicita.b, r.implicita.a, r.implicita.b)==0;
    }
    public Recta paralelaPor(Punto p) {
        return new Recta(new Vector(direccion.getComponenteX(), direccion.getComponenteY()),p);
    }
    public boolean pasaPor(Punto p) {
        return direccion.paraleloA(new Vector(p, pto));
    }
    public Recta perpendicularPor(Punto p) {
        Vector v = direccion.ortogonal();
        return new Recta(v, p);
    }

    @Override
    public String toString() {
        return "R(" + direccion + ", " + pto + ")";
    }

}
