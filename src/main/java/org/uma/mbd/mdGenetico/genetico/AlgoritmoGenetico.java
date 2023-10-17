package org.uma.mbd.mdGenetico.genetico;

public abstract class AlgoritmoGenetico {

    private Problema problema;
    private double probMutacion;
    private Poblacion poblacion;
    private int pasos;

    //public AlgoritmoGenetico(int, int, int, double, Problema) {}

    //public Individuo ejecuta() {}
    protected abstract Cromosoma recombinar(Cromosoma c1, Cromosoma c2);

}
