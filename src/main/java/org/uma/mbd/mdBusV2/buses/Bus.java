package org.uma.mbd.mdBusV2.buses;

import java.util.Objects;

public class Bus implements Comparable<Bus>{

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
    @Override
    public int compareTo(Bus b) {
        int result = Integer.compare(codLinea, b.codLinea);
        if (result == 0) {
            result = Integer.compare(codBus, b.codBus);
        }
        return result;
    }
}