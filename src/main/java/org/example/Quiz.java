package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Pregunta> preguntas;
    private int puntuacion;

    public Quiz() {
        this.preguntas = new ArrayList<>();
        this.puntuacion = 0;
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p = preguntas.get(i);
            p.mostrarPregunta();

            System.out.print("Elige una opción (número): ");
            int respuestaUsuario = scanner.nextInt() - 1;

            if (p.esRespuestaCorrecta(respuestaUsuario)) {
                System.out.println("¡Correcto!");
                puntuacion++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta era opción " + (p.getIndiceRespuestaCorrecta() + 1) + ".");
            }
            System.out.println();
        }

        System.out.println("Has terminado el cuestionario. Tu puntuación es: " + puntuacion + "/" + preguntas.size());
    }
}
