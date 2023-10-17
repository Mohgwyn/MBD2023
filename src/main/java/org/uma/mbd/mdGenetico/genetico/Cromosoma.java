package org.uma.mbd.mdGenetico.genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cromosoma {

    protected List<Integer> datos = new ArrayList<>();
    protected final int GEN_POR_DEFECTO = 0;
    protected Random gna = new Random();

    public Cromosoma(int longitud, boolean flagAleatorio) {
        if (flagAleatorio) {
            for (int i=0; i<longitud; i++) {
                datos.add(gna.nextInt(2));
            }
        } else {
            for (int i=0; i<longitud; i++) {
                datos.add(GEN_POR_DEFECTO);
            }
        }
    }
    public Cromosoma(Cromosoma c) {
        for (int i=0; i<c.datos.size(); i++) {
            datos.add(c.getGen(i));
        }
    }

    public void setGen(int pos, int val) {
        datos.set(pos,val);
    }
    public int getLongitud() { return datos.size(); }
    public int getGen(int pos) { return datos.get(pos); }
    public void mutar(double probabilidad) {
        for (int i=0; i<datos.size(); i++) {
            if( gna.nextDouble() >= probabilidad/100 ) {
                datos.set(i, (datos.get(i)-1)*-1);
            }
        }
    }
    public String toString() {
        return datos.toString();
    }
}
