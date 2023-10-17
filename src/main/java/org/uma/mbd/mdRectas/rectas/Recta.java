package org.uma.mbd.mdRectas.rectas;

public class Recta {

    private Vector direccion;
    private Punto pto;

    public Recta(Vector v, Punto p) {
        direccion = v;
        pto = p;
    }
    public Recta(Punto p, Punto q) {
        this(new Vector(p,q), new Punto(p));
    }
    public Recta(Recta r) {
        this(new Vector(r.direccion), new Punto(r.pto));
    }

    private record Implicita(double a, double b, double c) {}
    private Implicita implicita() {
        double a = direccion.getComponenteY();
        double b = -direccion.getComponenteX();
        double c = pto.getY()*direccion.getComponenteX()-pto.getX()*direccion.getComponenteY();
        return new Implicita(a,b,c);
    }
    // Determinante es un método de clase (static?)
    private static double determinante(double a11, double a12, double a21, double a22) {
        return a11*a22 - a12*a21;
    }
    public double distanciaDesde(Punto p) {
        Recta r = new Recta(direccion.ortogonal(),new Punto(p));
        Punto q = interseccionCon(r);
        return q.distancia(p);
    }
    public Punto interseccionCon(Recta r) {
        Implicita i1 = implicita();
        Implicita i2 = r.implicita();
        if (paralelaA(r)) {
            throw new IllegalArgumentException("Las rectas son paralelas");
        } else {
            double x = determinante(-i1.c, i1.b, -i2.c, i2.b)/determinante(i1.a, i1.b, i2.a, i2.b);
            double y = determinante(i1.a, -i1.c, i2.a, -i2.c)/determinante(i1.a, i1.b, i2.a, i2.b);
            return new Punto(x,y);
        }
    }
    public boolean paralelaA(Recta r) {
        return direccion.paraleloA(r.direccion);
    }
    public Recta paralelaPor(Punto p) {
        return new Recta(new Vector(direccion), new Punto(p));
    }
    public boolean pasaPor(Punto p) {
        return implicita().a*p.getX()+implicita().b*p.getY()+implicita().c == 0;
    }
    public Recta perpendicularPor(Punto p) {
        Vector v = direccion.ortogonal();
        return new Recta(v, new Punto(p));
    }

    @Override
    public String toString() {
        return "R(" + direccion + ", " + pto + ")";
    }

}
