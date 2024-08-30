package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Quiz
        Quiz quiz = new Quiz();

        // Crear una lista de opciones para la primera pregunta
        List<String> respuestas1 = new ArrayList<>();
        respuestas1.add("Negro");
        respuestas1.add("Verde");
        respuestas1.add("Azul");
        respuestas1.add("Blanco");

        // Crear una instancia de Pregunta
        Pregunta pregunta1 = new Pregunta("¿De qué color es el caballo blanco de San Martín?", respuestas1, 3);

        // Agregar la pregunta al cuestionario
        quiz.agregarPregunta(pregunta1);

        List<String> respuestas2 = new ArrayList<>();
        respuestas2.add("Rosario");
        respuestas2.add("Buenos Aires");
        respuestas2.add("Cordoba");
        respuestas2.add("Santa Fe");

        Pregunta pregunta2 = new Pregunta("¿Cual es la capital de Argentina?", respuestas2, 3);

        // Iniciar el cuestionario
        quiz.iniciar();
    }
}

