package org.uma.mbd.mdAlturasV2.alturas;

public class EnContinente implements Seleccion {

    private String continente;

    public EnContinente(String continente) {
        this.continente = continente;
    }
    public boolean test(Pais pais) {
        return pais.continente().equals(continente);
    }
}
