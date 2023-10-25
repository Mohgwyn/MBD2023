package org.uma.mbd.mdNPIV2.npi;

import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class NPI {

    private double x,y,z,t;
    public static DoubleBinaryOperator resta = (x,y) -> x-y;
    public static DoubleBinaryOperator suma = (x,y) -> x+y;
    public static DoubleBinaryOperator division = (x,y) -> x/y;
    public static DoubleBinaryOperator producto = (x,y) -> x*y;
    public static DoubleUnaryOperator raiz = (x) -> Math.sqrt(x);

    public double evalua(List<Elem> lista) {
        for (var c: lista) {
            switch (c) {
                case Valor(var x) -> entra(x);
                case Func(var op) -> opera1(op);
                case Func2(var op) -> opera2(op);
            }
        }
        return x;
    }

    private void entra(double value) {
        t = z;
        z = y;
        y = x;
        x = value;
    }
    private void opera1(DoubleUnaryOperator opera) {
        x = opera.applyAsDouble(x);
    }
    private void opera2(DoubleBinaryOperator opera) {
        double res = opera.applyAsDouble(x,y);
        x = res;
        y = z;
        z = t;
    }
}