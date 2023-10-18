package org.uma.mbd.mdDegree;

import org.uma.mbd.mdDegree.degree.Degree;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Degree> ld = List.of(
                Degree.fahrenheit(37),
                Degree.celsius(-7),
                Degree.fahrenheit(29),
                Degree.celsius(31)
        );
        ld.forEach(d -> System.out.println(d.toCelsius()));
        ld.forEach(d -> System.out.println(d.isFrozen()));
    }
}