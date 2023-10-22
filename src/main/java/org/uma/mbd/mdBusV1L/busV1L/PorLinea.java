package org.uma.mbd.mdBusV1L.busV1L;

public class PorLinea implements Criterio{

    private int codigo;

    public PorLinea(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.codLinea == codigo;
    }

    @Override
    public String toString() {
        return "Autobuses de la linea " + codigo;
    }
}