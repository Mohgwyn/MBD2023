package org.uma.mbd.mdAlturas.alturas;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Mundo {

    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }
    public void leePaises(String file) throws IOException {
        try (Scanner sc = new Scanner(Paths.get(file))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineSep = line.split(",");
                try {
                    if (lineSep.length != 3) throw new InputMismatchException();
                    paises.add(new Pais(lineSep[0], lineSep[1], Double.parseDouble(lineSep[2])));
                }
                catch (InputMismatchException e) {
                    System.err.println("Error, faltan datos en " + line);
                }
                catch (NumberFormatException e) {
                    System.err.println("Error en dato numérico en " + line);
                }
            }
        }
    }
    public List<Pais> selecciona(Seleccion sel) {
        return paises.stream()
                .filter(p -> sel.test(p))
                .toList();
    }

}
