package org.uma.mbd.mdBuses.buses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
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
                try {
                    String[] bus = sc.nextLine().split("(<>,)+");
                    if (bus.length != 3) throw new InvalidPropertiesFormatException();
                    buses.add(new Bus(Integer.parseInt(bus[0]),bus[1]));
                    buses.get(buses.size()-1).setCodLiena(Integer.parseInt(bus[2]));
                }
                catch (InvalidPropertiesFormatException()) {

                }

            }
        }
    }
}
