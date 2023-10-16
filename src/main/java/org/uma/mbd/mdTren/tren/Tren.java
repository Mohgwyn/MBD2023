package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.List;

public class Tren {

    private List<Vagon> vagones = new ArrayList<>();
    private final int CAPACIDAD;

    public Tren(int tam, int capacidad) {
        CAPACIDAD = capacidad;
        for(int i=0; i<tam; i++) {
            vagones.add(new Vagon(CAPACIDAD));
        }
    }

    public void carga(int ton) {
        while (ton > 0) {
            ton = vagones.get(vagones.size()-1).carga(ton);
            if (ton > 0) {
                vagones.add(new Vagon(CAPACIDAD));
            }
        }
    }
    public void gasta(int ton) {
        while (ton > 0) {
            ton = vagones.get(vagones.size()-1).descarga(ton);
            if (ton > 0) {
                vagones.remove(vagones.size()-1);
            }
        }
    }
    public void optimiza() {
        for (int i=vagones.size()-1; i>=0; i--) {
            if(vagones.get(i).getCarga() == 0) {
                vagones.remove(i);
            }
        }
    }
    public String toString() {
        String salida = "Tren[";
        for (int i=0; i<vagones.size(); i++) {
            salida += vagones.get(i);
            if (i < vagones.size()-1) {
                salida += ", ";
            }
        }
        return salida;
    }



}
