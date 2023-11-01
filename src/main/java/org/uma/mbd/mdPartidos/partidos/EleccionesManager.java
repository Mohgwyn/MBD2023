package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.util.Map;

public class EleccionesManager {

    private String[] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola = false;

    public EleccionesManager(Elecciones elecciones) {
        this.elecciones = elecciones;
    }
    public EleccionesManager setDatos(String[] datos) {
        this.datos = datos;
        return this;
    }
    public EleccionesManager setCriteriosSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }
    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
    }
    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }
    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }
    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    public void build() throws IOException {
        verify();
        if (datos == null) {
            elecciones.leeDatos(fEntrada);
        } else {
            elecciones.leeDatos(datos);
        }
        Map<Partido, Integer> resultados = elecciones.generaResultados(cs, numEsc);
        if (fEntrada != null) {
            elecciones.presentaResultados(fSalida, resultados);
        }
        if (consola) {
            for (Partido partido : resultados.keySet()) {
                System.out.printf("%s : %d, ", partido.getNombre(), partido.getVotos());
                int esc = resultados.get(partido);
                if(esc == 0) {
                    System.out.println("Sin representación");
                } else {
                    System.out.println(esc);
                }
            }
        }

    }
    private void verify() {
        if((datos == null && fEntrada == null) || (!(datos==null) && !(fEntrada == null))) {
            throw new ExceptionElecciones("La entrada de datos no es unica");
        }
        if(cs == null) {
            throw new ExceptionElecciones("Debe haber un criterio de seleccion");
        }
        if(numEsc <= 0) {
            throw new ExceptionElecciones("No hay escaños a repartir");
        }
        if(fSalida == null && !consola) {
            throw new ExceptionElecciones("No hay salida de datos");
        }
    }
}
