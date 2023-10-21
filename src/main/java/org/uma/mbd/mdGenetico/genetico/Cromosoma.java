package org.uma.mbd.mdGenetico.genetico;
import java.util.Random;
import java.util.StringJoiner;

public class Cromosoma {

	protected int[] datos;
	protected static Random gna = new Random();
	protected static int GEN_POR_DEFECTO = 0;

	public Cromosoma(int longitud, boolean aleatorio) {
		if (longitud <= 0) {
			throw new IllegalArgumentException("longitud no válida");
		}
		datos = new int[longitud];
		if(aleatorio) {
			for (int i=0; i<longitud; i++) {
				datos[i] = gna.nextInt(2);
			}
		} else {
			for (int i=0; i<longitud; i++) {
				datos[i] = GEN_POR_DEFECTO;
			}
		}
	}

	public Cromosoma(Cromosoma cromosoma) {
		datos = new int[cromosoma.getLongitud()];
        System.arraycopy(cromosoma.datos, 0, datos, 0, cromosoma.getLongitud());
	}

	public int getGen(int i) {
		if (i < 0 || i >= datos.length) {
			throw new ArrayIndexOutOfBoundsException("Cannot access index " + i + " in gen array");
		}
		return datos[i];
	}

	public void setGen(int i, int val) {
		if ((i < 0 || i >= datos.length) || (val != 0 && val != 1)) {
			throw new IllegalArgumentException("Cannot set gen " + i + " to " + val);
		}
		datos[i] = val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if (probMutacion < 0 || probMutacion > 100) {
			throw new IllegalArgumentException("Mutation probability is not valid");
		}
		for (int i=0; i<getLongitud(); i++) {
			if( gna.nextDouble() <= probMutacion/100 ) {
				datos[i] = (datos[i]-1)*(-1);
			}
		}
	}

	public int getLongitud() {
		return datos.length;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",","[","]");
		for (int i = 0; i < datos.length; i++)
			sj.add(Integer.toString(datos[i]));
		return "Cromosoma(" + sj + ")";	}
}
