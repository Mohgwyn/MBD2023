package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public record Pareja(Persona uno, Persona otro) {
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pareja p) {
            if ( (uno.equals(p.uno) && otro.equals(p.otro)) || (uno.equals(p.otro) && otro.equals(p.uno))) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(uno, otro) + Objects.hash(otro, uno);
    }
}
