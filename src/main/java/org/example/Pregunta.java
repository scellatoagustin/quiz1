package org.example;

import java.util.List;

public class Pregunta {
    private String textoPregunta;
    private List<String> opciones;
    private int indiceRespuestaCorrecta;

    public Pregunta(String textoPregunta, List<String> opciones, int indiceRespuestaCorrecta) {
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getIndiceRespuestaCorrecta() {
        return indiceRespuestaCorrecta;
    }

    public boolean esRespuestaCorrecta(int indiceOpcion) {
        return indiceOpcion == indiceRespuestaCorrecta;
    }

    public void mostrarPregunta() {
        System.out.println(textoPregunta);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ": " + opciones.get(i));
        }
    }
}
