package org.uma.mbd.mdTest.test;

import java.util.Objects;

public record Test(String nombre, int aciertos, int errores) {
    @Override
    public boolean equals(Object o) {
        return o instanceof Test t
                && t.nombre.equalsIgnoreCase(nombre)
                && t.aciertos == aciertos
                && t.errores == errores;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, aciertos, errores);
    }

    public double calificacion(double valAc, double valErr) {
        return aciertos*valAc + errores*valErr;
    }
}
