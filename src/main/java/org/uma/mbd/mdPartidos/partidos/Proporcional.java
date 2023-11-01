package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Proporcional implements CriterioSeleccion{

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tks = creaTokens(partidos, numEsc);
        tks = Token.seleccioneTokens(tks, numEsc);
        return Token.generaResultados(tks);
    }
    private Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        int votos = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
        double vpe = (double)votos/numEsc;
        Set<Token> tks = new TreeSet<>();
        partidos.forEach(p -> {
            for (int i=0; i<numEsc; i++) {
                tks.add(new Token(p, (double)p.getVotos()-(vpe*i)));
            }
        });
        return tks;
    }
}
