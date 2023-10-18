package org.uma.mbd.mdDegree.degree;

public record Fahrenheit(double fahrenheit) implements Degree{

    @Override
    public double celsius() {
        Degree c = toCelsius(fahrenheit);
        return c.celsius();
    }

}
