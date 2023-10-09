package org.uma.mbd.mdNPI.npi;

public class NPI {

    // Atributos
    private double x, y, z, t;

    // Constructor //
    public NPI() {
        x=0;
        y=0;
        z=0;
        t=0;
    }

    // Métodos //
    public void entra(double valor) {
        t = z;
        z = y;
        y = x;
        x = valor;
    }
    public void suma() {
        x += y;
        y = z;
        z = t;
        t = 0;
    }
    public void resta() {
        x = y - x;
        y = z;
        z = t;
        t = 0;
    }
    public void multiplica() {
        x *= y;
        y = z;
        z = t;
        t = 0;
    }
    public void divide() {
        x = y / x;
        y = z;
        z = t;
        t = 0;
    }
    public double getResultado() {
        return x;
    }

    @Override
    public String toString() {
        return "NPI(x=" + x + ", y=" + y + ", z=" + z + ", t=" + t;
    }

}
