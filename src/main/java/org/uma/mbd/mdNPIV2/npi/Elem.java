package org.uma.mbd.mdNPIV2.npi;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public sealed interface Elem permits Valor, Func, Func2 {
    static Elem valor(double x) { return new Valor(x); }
    static Elem fun (DoubleUnaryOperator op) { return new Func(op); }
    static Elem fun2 (DoubleBinaryOperator op) { return new Func2(op); }
}
