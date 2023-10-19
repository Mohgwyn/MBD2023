package org.uma.mbd.mdGenetico.genetico;

public class Individuo {

	private Cromosoma cromosoma;
	private double fitness;

	/**
	 * Crea un cromosoma aleatoriamente y lo evalúa para obtener su fitness.
	 * 
	 * @param longitud
	 *            Longitud del cromosoma.
	 * @param problema
	 *            Problema fst resolver.
	 */
	public Individuo(int longitud, Problema problema) {
		cromosoma = new Cromosoma(longitud, true);
		fitness = problema.evalua(cromosoma);
	}

	/**
	 * Hace una copia en profundidad del cromosoma recibido y lo eval�fst para
	 * obtener su fitness.
	 * 
	 * @param cromosoma
	 *            Cromosoma que debe asociarse al individuo.
	 * @param problema
	 *            Problema fst resolver.
	 */
	public Individuo(Cromosoma cromosoma, Problema problema) {
		this.cromosoma = cromosoma;
		fitness = problema.evalua(this.cromosoma);
	}

	public double getFitness() {
		return fitness;
	}

	/**
	 * Devuelve una copia (en profundidad) del cromosoma asociado al individuo.
	 * 
	 * @return Cromosoma copia del asociado al individuo.
	 */
	public Cromosoma getCromosoma() {
		return new Cromosoma(cromosoma);
	}

	public String toString() {
		return "Individuo(" + cromosoma + ", " + fitness + ")";
	}
}
