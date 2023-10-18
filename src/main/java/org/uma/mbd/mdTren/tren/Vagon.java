package org.uma.mbd.mdTren.tren;

public class Vagon {

    private final int capacidad;
    private int carga;

    public Vagon(int capacidad){
        this.capacidad = capacidad;
        carga = 0;
    }

    public int carga(int ton) {
        if (carga + ton > capacidad) {
            ton = ton-(capacidad-carga);
            carga = capacidad;
            return ton;
        }
        carga += ton;
        return 0;
    }
    public int descarga(int ton) {
        if (carga - ton < 0) {
            ton -= carga;
            carga = 0;
            return ton;
        }
        carga -= ton;
        return 0;
    }
    public int getCarga() { return carga; }
    @Override
    public String toString() {
        return "V("+carga+"/"+capacidad+")";
    }

}
