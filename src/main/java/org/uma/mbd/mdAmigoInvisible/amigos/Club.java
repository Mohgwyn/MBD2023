package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Club {

    protected List<Persona> socios;
    public Club() {
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException {
        Scanner sc = new Scanner(Path.of(fEntrada));
        while (sc.hasNextLine()) {
            leeSocios(sc.nextLine(),delim);
        }
    }
    private void leeSocios(String linea, String delim) {
        Scanner sc = new Scanner((linea));
        sc.useDelimiter(delim);
        while(sc.hasNext()) {
            creaSocioDesdeString(sc.next());
        }
    }
    protected void creaSocioDesdeString(String nombre) {
        socios.add(new Persona(nombre));
    }
    protected void hacerAmigos() {
        List<Integer> listaAmigos = new ArrayList<>();
        for (int i=0; i<socios.size(); i++) {
            listaAmigos.add(i);
        }

        while(hayCoincidencias(listaAmigos)) {
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
    public void presentaAmigos(String fSalida) throws FileNotFoundException{
        try(PrintWriter writer = new PrintWriter(fSalida)) {
            presentaAmigos(writer);
        } catch (IOException e) {
            System.err.println("Cannot find file: " + fSalida);
        }
    }
    public void presentaAmigos(PrintWriter pw) {
        Collections.sort(socios);
        for (Persona socio : socios) {
            pw.println(socio);
        }
    }

}
