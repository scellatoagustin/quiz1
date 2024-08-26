package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        List<String> respuestas1 = new ArrayList<>();
        respuestas1.add("Negro");
        respuestas1.add("Verde");
        respuestas1.add("Azul");
        respuestas1.add("Blanco");
        Pregunta pregunta1 =
                new Pregunta (pregunta "De que color es el caballo blanco de San Martin?", respuestas1, respuestaCorrecta,4);
        quiz.agregarPregunta(pregunta1);

        pregunta1.mostrarPregunta();
    }
}