package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Elecciones {

    private List<Partido> partidos;

    static private Partido stringToPartido(String dato) {
        try (Scanner sc = new Scanner(dato)){
            sc.useDelimiter(",+");
            String nombre = sc.next();
            int votos = sc.nextInt();
            if (sc.hasNext()) {
                throw new EleccionesException("Demasiados datos en: " + dato);
            }
            return new Partido(nombre, votos);
        } catch(InputMismatchException e) {
            throw new EleccionesException("El número de votos no es un numero en: " + dato);
        } catch(NoSuchElementException e) {
            throw new EleccionesException("Faltan datos en: " + dato);
        }
    }

    public void leeDatos(String[] datos) {
        partidos = new ArrayList<>();
        for (String dato : datos) {
            partidos.add(stringToPartido(dato));
        }
        System.out.println(partidos);
    }
    public void leeDatos(String nombreFichero) throws IOException{
        partidos = new ArrayList<>();
        Path file = Path.of(nombreFichero);
        for (String line : Files.readAllLines(file)) {
            partidos.add(stringToPartido(line));
        }
    }
    public Map<Partido,Integer> generaResultados(CriterioSeleccion cs, int numEsc) {
        return cs.ejecuta(partidos, numEsc);
    }
    public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws IOException {
        try (PrintWriter pw = new PrintWriter(nombreFichero)) {
            presentaResultados(pw, map);
        }
    }
    public void presentaResultados(PrintWriter pw, Map<Partido, Integer> map) {
        for (Partido partido : partidos) {
            pw.printf("%s : %d, ", partido.getNombre(), partido.getVotos());
            if(!map.containsKey(partido)) {
                pw.println("Sin representación");
            } else {
                pw.println(map.get(partido));
            }
        }
    }

}
