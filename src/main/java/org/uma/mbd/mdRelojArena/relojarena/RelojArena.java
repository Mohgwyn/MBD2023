package org.uma.mbd.mdRelojArena.relojarena;

public class RelojArena {

    private int capacidad, inferior, superior;

    public RelojArena(int capacidadMax) {
        capacidad = capacidadMax;
        inferior = capacidad;
        superior = 0;
    }
    public void gira() {
        superior += inferior;
        inferior = superior - inferior;
        superior -= inferior;
    }
    public void pasaTiempo () {
        if (superior != 0) {
            superior = 0;
            inferior = capacidad;
        }
    }
    public void pasaTiempo(RelojArena reloj) {
        superior -= reloj.superior;
        inferior += reloj.superior;
        if (superior < 0) {
            superior = 0;
            inferior = capacidad;
        }
        reloj.superior = 0;
        reloj.inferior = reloj.capacidad;
    }
    public int getTiempoRestante() { return superior; }
    @Override
    public String toString() {
        return "R(" + superior + "/" + inferior + ")";
    }
}
