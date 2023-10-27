package org.uma.mbd.mdAlturasV2.alturas;

public class MayoresQue implements Seleccion {

    private double alturaMin;

    public MayoresQue(double altura) {
        this.alturaMin = altura;
    }
    public boolean test(Pais pais) {
        return pais.altura() >= alturaMin;
    }
}
