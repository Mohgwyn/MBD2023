package org.uma.mbd.mdPartidos.partidos;

import com.sun.source.tree.Tree;

import java.util.*;

public class DHontSimple implements CriterioSeleccion{

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tks = creaTokens(partidos, numEsc);
        tks = Token.seleccioneTokens(tks, numEsc);
        return Token.generaResultados(tks);
    }
    private Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        Set<Token> tks = new TreeSet<>();
        for (Partido p : partidos) {
            for (int i=0; i<numEsc; i++) {
                tks.add(new Token(p, (double)p.getVotos()/(double)i+1));
            }
        }
        return tks;
    }
}
