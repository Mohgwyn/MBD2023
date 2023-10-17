package org.uma.mbd.mdGenetico.genetico;

public class Individuo {

    private double fitness;
    private Cromosoma cromosoma;
    private Problema prob;

    public Individuo(int longitud, Problema prob) {
        this.cromosoma = new Cromosoma(longitud, true);
        this.prob = prob;
    }
    public Individuo(Cromosoma c, Problema prob) {
        this.cromosoma = new Cromosoma(c);
        this.prob = prob;
    }

    public Cromosoma getCromosoma() { return cromosoma; }
    public double getFitness() { return prob.evalua(cromosoma); }
    public String toString() {
        return cromosoma.toString();
    }

}
