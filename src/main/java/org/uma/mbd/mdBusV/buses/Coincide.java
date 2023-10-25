package org.uma.mbd.mdBusV.buses;

public class Coincide implements Criterio {

    private Bus busCriterio;

    public Coincide(Bus bus) {
        busCriterio = bus;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.equals(busCriterio);
    }

    @Override
    public String toString() {
        return "Autobús " + busCriterio;
    }
}
