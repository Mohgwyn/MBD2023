package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion{

    private String continente;

    public EnContinente(String continente) {
        this.continente = continente;
    }
    public boolean test(Pais pais) {
        return pais.continente().equals(continente);
    }
}
