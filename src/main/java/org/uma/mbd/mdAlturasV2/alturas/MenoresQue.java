package org.uma.mbd.mdAlturasV2.alturas;

public class MenoresQue implements Seleccion {

    private double alturaMax;

    public MenoresQue(double altura) {
        this.alturaMax = altura;
    }
    public boolean test(Pais pais) {
        return pais.altura() <= alturaMax;
    }
}
