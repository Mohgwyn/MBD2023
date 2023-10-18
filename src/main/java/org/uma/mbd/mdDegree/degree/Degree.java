package org.uma.mbd.mdDegree.degree;

public sealed interface Degree permits Celsius, Fahrenheit{

    public double celsius();
    public double fahrenheit();
    default boolean isFrozen() {
        return (celsius() < 0);
    }
    default Degree toCelsius(double f) {
        return new Celsius((f-32)/1.8);
    }
    default Degree toFahrenheit(double c) {
        return new Fahrenheit(c*1.8+32);
    }

}
