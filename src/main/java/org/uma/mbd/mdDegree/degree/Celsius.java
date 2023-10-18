package org.uma.mbd.mdDegree.degree;

public record Celsius(double degree) implements Degree{

    @Override
    public boolean isFrozen() {
        return degree < 0;
    }
    @Override
    public Degree toFahrenheit() {
        return new Fahrenheit(degree*1.8+32);
    }
}