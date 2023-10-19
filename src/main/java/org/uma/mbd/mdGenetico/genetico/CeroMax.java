package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema{

    /**
     * El fitness de un individuo es el número de ceros que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */
    @Override
    public double evalua(Cromosoma cromosoma) {
        double fitness = 0;

        for (int i=0; i<cromosoma.getLongitud(); i++) {
            if(cromosoma.getGen(i) == 0) {
                fitness++;
            }
        }
        return fitness;
    }
}