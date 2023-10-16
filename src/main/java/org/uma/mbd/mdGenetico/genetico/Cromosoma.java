package org.uma.mbd.mdGenetico.genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cromosoma {

    protected List<Integer> datos = new ArrayList<>();
    protected final int GEN_POR_DEFECTO;
    protected Random gna = new Random();

    public Cromosoma(int longitud, boolean inic) {}
    public Cromosoma(Cromosoma) {
        this.datos = Cromosoma.getGen();
        this.ini
    }

    public void setGen(int, int) {}
    public int getLongitud() { return datos.size(); }
    public int getGen(int pos) { return datos.get(pos); }
    public void mutar(double) {}
    public String toString() {}
}
