package org.uma.mbd.mdDegree.degree;

record Fahrenheit(double degree) implements Degree{}
record Celsius(double degree) implements Degree{}

public sealed interface Degree permits Celsius, Fahrenheit{
    default boolean isFrozen() {
        return switch(this) {
            case Celsius(var x) -> x < 0;
            case Fahrenheit(var x) -> x <32;
        };
    };
    default Degree toCelsius() {
        return switch(this) {
            case Celsius(var x) -> this;
            case Fahrenheit(var x) -> Degree.fahrenheit((x-32)/1.8);
        };

    }
    default Degree toFahrenheit() {
        return switch(this) {
            case Celsius(var x) -> Degree.celsius(x*1.8+32);
            case Fahrenheit(var x) -> this;
        };
    }


    // Métodos factoría
    static Degree fahrenheit(double degree) {
        return new Fahrenheit(degree);
    }
    static Degree celsius(double degree) {
        return new Celsius(degree);
    }
}