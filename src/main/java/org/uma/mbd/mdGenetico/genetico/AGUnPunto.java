package org.uma.mbd.mdGenetico.genetico;

public class AGUnPunto extends AlgoritmoGenetico{

    //public AGUnPunto(int, int, int, double, Problema) {}

    @Override
    protected Cromosoma recombinar(Cromosoma c1, Cromosoma c2) {
        return c1;
    }

}
