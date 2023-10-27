package org.uma.mbd.mdBusV2.buses;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class  Servicio {

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
                String bus = sc.nextLine();
                String[] sepBus = bus.split(",");
                try {
                    if (sepBus.length != 3) throw new InputMismatchException();
                    buses.add(new Bus(Integer.parseInt(sepBus[0]),sepBus[1]));
                    buses.get(buses.size()-1).setCodLinea(Integer.parseInt(sepBus[2]));
                }
                catch (InputMismatchException e) {
                    System.err.println("Error, faltan datos en " + bus);
                }
                catch (NumberFormatException e) {
                    System.err.println("Error en dato numérico en " + bus);
                }
            }
        }
    }

    public TreeSet<Bus> filtra(Criterio criterio, Comparator<Bus> comparator) {
        TreeSet<Bus> filtered = new TreeSet<>(comparator);
        for(Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                filtered.add(bus);
            }
        }
        return filtered;
    }

    public void guarda(String file, Criterio criterio, Comparator<Bus> cb) {
        try(PrintWriter writer = new PrintWriter(file)) {
            guarda(writer, criterio, cb);
        } catch (IOException e) {
            System.err.println("Cannot find file: " + file);
        }
    }
    public void guarda(PrintWriter pw, Criterio criterio, Comparator<Bus> cb) {
        Set<Bus> filtered = filtra(criterio, cb);
        filtered.forEach(
                bus -> pw.println(bus.toString())
        );
    }
}
