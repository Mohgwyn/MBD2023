package org.uma.mbd.mdDegree.degree;

public sealed interface Degree permits Celsius, Fahrenheit{
    boolean isFrozen();
    default Degree toCelsius() {
        return this;
    }
    default Degree toFahrenheit() {
        return this;
    }
    static Degree fahrenheit(double degree) {
        return new Fahrenheit(degree);
    }
    static Degree celsius(double degree) {
        return new Celsius(degree);
    }
}
