package org.uma.mbd.mdBusV1L.busV1L;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servicio {

    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciudad) {
        this.ciudad = ciudad;
        buses = new ArrayList<>();
    }

    public String getCiudad() { return ciudad; }
    public List<Bus> getBuses() { return buses; }
    public void leeBuses(String file) throws IOException {
        try (Scanner sc = new Scanner(Paths.get(file))){
            while(sc.hasNextLine()) {
                String[] bus = sc.nextLine().split("(<>,)+");
                try {
                    if (bus.length != 3) throw new IOException();
                    buses.add(new Bus(Integer.parseInt(bus[0]),bus[1]));
                    buses.get(buses.size()-1).setCodLiena(Integer.parseInt(bus[2]));
                }
                catch (IOException e) {
                    System.err.println("Cannot format data: " + bus.toString());
                }

            }
        }
    }

    public List<Bus> filtra(Criterio criterio) {
        return buses.stream()
                .filter(bus -> criterio.esSeleccionable(bus))
                .toList();
    }

    public void guarda(String file, Criterio criterio) {
        try(PrintWriter writer = new PrintWriter(file)) {
            guarda(writer,criterio);
        } catch (IOException e) {
            System.err.println("Cannot find file: " + file);
        }
    }
    public void guarda(PrintWriter pw, Criterio criterio) {
        List<Bus> filtered = filtra(criterio);
        for (Bus bus : filtered) {
            pw.println(bus.toString());
        }
    }
}
