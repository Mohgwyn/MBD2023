package org.uma.mbd.mdGenetico.genetico;

@FunctionalInterface
public interface Problema {
    double evalua(Cromosoma cromosoma);
}
