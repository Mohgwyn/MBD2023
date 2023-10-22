package org.uma.mbd.mdBusV1L.busV1L;

public class EnMatricula implements Criterio{

    private String cadena;

    public EnMatricula(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.matricula.contains(cadena);
    }

    @Override
    public String toString() {
        return "Autobuses cuya matricula contiene " + cadena;
    }
}