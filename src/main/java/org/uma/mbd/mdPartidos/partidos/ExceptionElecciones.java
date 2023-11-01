package org.uma.mbd.mdPartidos.partidos;

public class ExceptionElecciones extends RuntimeException{
    public ExceptionElecciones(){
        super();
    }
    public ExceptionElecciones(String e) {
        super(e);
    }
}
