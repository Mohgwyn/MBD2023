package org.uma.mbd.mdDegree.degree;

public record Fahrenheit(double degree) implements Degree{

    @Override
    public boolean isFrozen() {
        return degree < 32;
    }
    @Override
    public Degree toCelsius() {
        return new Celsius((degree-32)/1.8);
    }
}