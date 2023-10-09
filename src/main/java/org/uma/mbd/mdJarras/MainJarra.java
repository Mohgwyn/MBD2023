package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Mesa;
import org.uma.mbd.mdJarras.jarras.Jarra;

public class MainJarra {

    public static void main(String[] args) {
        Jarra jarra1 = new Jarra(5);
        Jarra jarra2 = new Jarra(7);

        Mesa mesa = new Mesa(5,7);

        jarrato1(jarra1, jarra2);
        mesato1(mesa);
    }

    public static void jarrato1(Jarra jarra1, Jarra jarra2) {
        jarra1.llena();
        jarra2.llenaDesde(jarra1);
        jarra1.llena();
        jarra2.llenaDesde(jarra1);
        jarra2.vacia();
        jarra2.llenaDesde(jarra1);
        jarra1.llena();
        jarra2.llenaDesde(jarra1);
        jarra2.vacia();
        System.out.println("j1 " + jarra1);
        System.out.println("j2 " + jarra2);
    }

    public static void mesato1(Mesa mesa) {
        mesa.llenaA();
        mesa.vuelcaASobreB();
        mesa.llenaA();
        mesa.vuelcaASobreB();
        mesa.vaciaB();
        mesa.vuelcaASobreB();
        mesa.llenaA();
        mesa.vuelcaASobreB();
        mesa.vaciaB();
        System.out.println(mesa);
    }
}