package org.uma.mbd.mdNPIV2.npi;

import java.util.function.DoubleUnaryOperator;

public record Func(DoubleUnaryOperator op) implements Elem{
}
