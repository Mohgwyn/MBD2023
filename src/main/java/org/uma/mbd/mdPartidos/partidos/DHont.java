package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;

public class DHont extends DHontSimple implements CriterioSeleccion{

    private double minPor;

    public DHont(double minPor) {
        super();
        if (minPor < 0 || minPor >= 15) {
            throw new EleccionesException("Minimo porcentaje invalido.");
        }
        this.minPor = minPor;
    }
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        int votos = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
        List<Partido> partidosFiltrados = partidos.stream()
                .filter(p -> ((double)p.getVotos()/votos)*100 > minPor)
                .toList();
        return super.ejecuta(partidosFiltrados, numEsc);
    }
}
