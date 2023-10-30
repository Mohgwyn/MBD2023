package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubPareja extends Club{

    private Set<Pareja> parejas;
    public ClubPareja() {
        super();
        parejas = new HashSet<>();
    }

    @Override
    protected void creaSocioDesdeString(String nombre) {
        try(Scanner sc = new Scanner(nombre)) {
            sc.useDelimiter("-");
            socios.add(new Persona(sc.next()));
            if (sc.hasNext()) {
                socios.add(new Persona(sc.next()));
                Pareja pareja = new Pareja(socios.get(socios.size()-1), socios.get(socios.size()-2));
                parejas.add(pareja);
            }
        }
    }
    @Override
    protected void hacerAmigos() {
        List<Integer> listaAmigos = new ArrayList<>();
        for (int i=0; i<socios.size(); i++) {
            listaAmigos.add(i);
        }

        while(hayCoincidencias(listaAmigos) || hayParejas(listaAmigos)) {
            Collections.shuffle(listaAmigos);
        }

        for (int i=0; i<socios.size(); i++) {
            socios.get(i).setAmigo(socios.get(listaAmigos.get(i)));
        }
    }
    private static boolean hayCoincidencias(List<Integer> lista) {
        for (int pos : lista) {
            if(lista.get(pos) == pos) {
                return true;
            }
        }
        return false;
    }
    private boolean hayParejas(List<Integer> lista) {
        int i = 0;
        for (int pos : lista) {
            Pareja pareja = new Pareja(
                    socios.get(i),
                    socios.get(pos)
            );
            if(parejas.contains(pareja)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
