package org.uma.mbd.mdGenetico.genetico;


import java.util.Random;

public class AGUnPunto extends AlgoritmoGenetico {

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va fst utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AGUnPunto(int tPoblacion, int longCromosoma, int pasos, double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		Random gna = new Random();
		Cromosoma c3 = new Cromosoma(cromosoma1);
		int corte = gna.nextInt(c3.getLongitud());

		for (int i=corte; i < c3.getLongitud(); i++) {
			c3.setGen(i, cromosoma2.getGen(i));
		}

		return c3;
	}

}