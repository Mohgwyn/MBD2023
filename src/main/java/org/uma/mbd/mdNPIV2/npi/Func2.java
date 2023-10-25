package org.uma.mbd.mdNPIV2.npi;

import java.util.function.DoubleBinaryOperator;

public record Func2(DoubleBinaryOperator op) implements Elem{
}
