package org.uma.mbd.mdPartidos.partidos;

import java.util.*;
import java.util.stream.Collectors;

public class Token implements Comparable<Token>{

    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio) {
        this.partido = partido;
        this.ratio = ratio;
    }
    public Partido getPartido() { return partido; }
    public double getRatio() { return ratio; }
    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc) {
        return tks.stream()
                .sorted()
                .limit(numEsc)
                .collect(Collectors.toSet());
    }
    public static Map<Partido, Integer> generaResultados(Set<Token> tks) {
        Map<Partido, Integer> resultado = new HashMap<>();
        for (Token tk : tks) {
            if (!resultado.containsKey(tk.partido)) {
                resultado.put(tk.partido, 0);
            }
            int valor = resultado.get(tk.partido);
            resultado.replace(tk.partido, valor+1);
        }
        return resultado;
    }
    @Override
    public int compareTo(Token t) {
        int resultado;
        resultado = Double.compare(t.ratio, ratio);
        if (resultado == 0) {
            resultado = partido.getNombre().compareToIgnoreCase(t.partido.getNombre());
        }
        return resultado;
    }

}
