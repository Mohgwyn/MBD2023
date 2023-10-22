package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;

import static java.lang.Character.isDigit;

public class MasterMind {

    public static int TAMANO_POR_DEFECTO = 4;
    private static Random alea = new Random();
    protected String combinacionSecreta = "";

    public MasterMind(int longitud) {
        if (longitud > 10 || longitud <= 0) {
            throw new MasterMindException("Not a valid size");
        }
        generaCombinacionSecreta(longitud);
    }
    public MasterMind() {
        this(TAMANO_POR_DEFECTO);
    }

    private void generaCombinacionSecreta(int longitud) {
        while (combinacionSecreta.length() < longitud) {
            int v = alea.nextInt(0,10);

            if (!combinacionSecreta.contains(Integer.toString(v))) {
                combinacionSecreta += Integer.toString(v);
            }
        }
    }
    public int getLongitud() {return combinacionSecreta.length();}
    private boolean validaCombinacion(String cifras) {
        if (cifras.length() != combinacionSecreta.length()) return false;
        for (int i=0; i<cifras.length(); i++) {
            if(!isDigit(cifras.charAt(i)) || cifras.indexOf(cifras.charAt(i)) != cifras.lastIndexOf(cifras.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public Movimiento intento(String cifras) {
        int colocadas = 0;
        int descolocadas = 0;
        if (!validaCombinacion(cifras))
            throw new MasterMindException("Not a valid combination");

        for (int i=0; i<cifras.length(); i++) {
            if (combinacionSecreta.indexOf(cifras.charAt(i)) == i) {
                colocadas++;
            } else if (combinacionSecreta.indexOf(cifras.charAt(i)) != -1) {
                descolocadas++;
            }
        }
        return new Movimiento(cifras, colocadas, descolocadas);
    }
    public String getSecreto() { return combinacionSecreta; }
}
