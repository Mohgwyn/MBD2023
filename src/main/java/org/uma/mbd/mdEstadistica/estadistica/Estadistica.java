package org.uma.mbd.mdEstadistica.estadistica;

public class Estadistica {

    private int numElementos;
    private double sumaX, sumaX2;

    public Estadistica() {
        numElementos = 0;
        sumaX = 0;
        sumaX2 = 0;
    }

    public void agrega(double d) {
        numElementos ++;
        sumaX += d;
        sumaX2 += d*d;
    }
    public void agrega(double d, int n) {
        numElementos += n;
        sumaX += n*d;
        sumaX2 += n*(d*d);
    }
    public double media() {
        return sumaX/numElementos;
    }
    public double varianza() {
        double media = this.media();
        return ((sumaX2/numElementos)-Math.pow(media,2));
    }
    public double desviacionTipica() {
        return Math.sqrt(this.varianza());
    }
}
