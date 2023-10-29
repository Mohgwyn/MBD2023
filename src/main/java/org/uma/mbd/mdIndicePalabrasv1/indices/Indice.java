package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

abstract public class Indice {

    protected List<String> texto;

    public Indice() {
        texto = new ArrayList<>();
    }

    public void agregarLinea(String entrada) {
        Scanner sc = new Scanner(entrada);
        sc.useDelimiter("\n");
        while(sc.hasNextLine()) {
            texto.add(sc.nextLine());
        }
    }
    abstract public void resolver(String delimitadores, Collection<String> noSignificativas);
    abstract public void presentarIndiceConsola();

}