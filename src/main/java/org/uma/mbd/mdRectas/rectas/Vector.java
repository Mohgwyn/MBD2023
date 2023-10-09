package org.uma.mbd.mdRectas.rectas;

public class Vector {

    private Punto extremo;

    public Vector(Punto pto) {
        extremo = pto;
    }
    public Vector(Punto p, Punto q) {
        this(new Punto(q.getX()-p.getX(), q.getY()-p.getY()));
    }
    public Vector(double x, double y) {
        this(new Punto(x,y));
    }
    public Vector(Vector v) {
        this(v.extremo);
    }

    public Punto extremoDesde(Punto p) {
        return new Punto(getComponenteX()+p.getX(), getComponenteY()+p.getY());
    }
    public double getComponenteX() { return extremo.getX(); }
    public double getComponenteY() { return extremo.getY(); }
    public double modulo() {
        return Math.sqrt(Math.pow(getComponenteX(),2)+Math.pow(getComponenteY(),2));
    }
    public Vector ortogonal() {
        return new Vector(-getComponenteY(), getComponenteX());
    }
    public boolean paraleloA(Vector v) {
        return (getComponenteX()*v.getComponenteY() == getComponenteY()*v.getComponenteX());
    }
    @Override
    public String toString() {
        return "V("+getComponenteX()+", "+getComponenteY()+")";
    }

}
