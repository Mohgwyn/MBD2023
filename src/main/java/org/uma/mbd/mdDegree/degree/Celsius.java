package org.uma.mbd.mdDegree.degree;

public record Celsius(double celsius) implements Degree{

    @Override
    public double fahrenheit() {
        Degree f = toFahrenheit(celsius);
        return f.fahrenheit();
    }

}
