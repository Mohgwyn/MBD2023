package org.uma.mbd.mdBusV.buses;

import java.util.Objects;

public class Bus {

    int codBus;
    String matricula;
    int codLinea;

    public Bus(int codBus, String matricula) {
        this.codBus = codBus;
        this.matricula = matricula;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }
    public int getCodBus() { return codBus; }
    public String getMatricula() { return matricula; }
    public int getCodLinea() { return codLinea; }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Bus bus) && bus.codBus == codBus && bus.matricula.equalsIgnoreCase(matricula);
    }
    @Override
    public int hashCode() {
        return Objects.hash(matricula.toLowerCase(), codBus);
    }
    @Override
    public String toString() {
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }


}
