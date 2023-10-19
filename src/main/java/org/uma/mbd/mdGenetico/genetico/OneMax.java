package org.uma.mbd.mdGenetico.genetico;


public class OneMax implements Problema {

	/**
	 * El fitness de un individuo es el número de unos que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */
	@Override
	public double evalua(Cromosoma cromosoma) {
		double fitness = 0;

		for (int i=0; i<cromosoma.getLongitud(); i++) {
			if(cromosoma.getGen(i) == 1) {
				fitness++;
			}
		}
		return fitness;
	}
}
