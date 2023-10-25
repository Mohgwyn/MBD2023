package org.uma.mbd.mdTest.test;

import java.util.*;

public class TestAsignatura {

    private String nombreAsignatura;
    private List<Test> examenes;
    private double valorAciertos;
    private double valorErrores;
    public static final int APROBADO = 5;

    public TestAsignatura(String nombre, double valAc, double valErr, List<String> estudiantes) {
        if(valAc <= 0 || valErr >= 0) throw new IllegalArgumentException();
        nombreAsignatura = nombre;
        valorAciertos = valAc;
        valorErrores = valErr;
        examenes = new ArrayList<>();
        buildExamen(estudiantes);
    }
    public TestAsignatura(String asignatura, List<String> estudiantes) {
        this(asignatura, 1, 0, estudiantes);
    }

    private void buildExamen(List<String> estudiantes) {
        for (String estudiante : estudiantes) {
            try (Scanner sc = new Scanner(estudiante)) {
                sc.useDelimiter("[:+]");
                String n = sc.next();
                int aciertos = sc.nextInt();
                int errores = sc.nextInt();
                examenes.add(new Test(n,aciertos,errores));
            } catch (InputMismatchException e) {
                System.err.println("Número erróneo en " + estudiante);
            } catch (NoSuchElementException e) {
                System.err.println("Faltan datos en " + estudiante);
            }
        }
    }

    public double notaMedia() {
        return examenes.stream()
                .mapToDouble(e -> e.calificacion(valorAciertos, valorErrores))
                .average()
                .getAsDouble();
    }
    public int aprobados() {
        return (int)examenes.stream()
                .filter(e -> e.calificacion(valorAciertos, valorErrores)>APROBADO)
                .count();
    }

    public String getNombreAsignatura() { return nombreAsignatura; }
}
