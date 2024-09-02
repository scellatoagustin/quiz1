package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

            int respuestaUsuario = -1;
            boolean entradaValida = false;

            while (!entradaValida) {
                System.out.print("Elige una opción (número): ");
                if (scanner.hasNextInt()) {
                    respuestaUsuario = scanner.nextInt() - 1;
                    if (respuestaUsuario >= 0 && respuestaUsuario < p.getOpciones().size()) {
                        entradaValida = true;
                    } else {
                        System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingresa un número.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
            }

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

    // Método para guardar el cuestionario en un archivo
    public void guardarCuestionario(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (Pregunta pregunta : preguntas) {
                writer.write(pregunta.getTextoPregunta() + "\n");
                for (String opcion : pregunta.getOpciones()) {
                    writer.write(opcion + "\n");
                }
                writer.write(pregunta.getIndiceRespuestaCorrecta() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar el cuestionario desde un archivo
    public void cargarCuestionario(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String textoPregunta;
            while ((textoPregunta = reader.readLine()) != null) {
                List<String> opciones = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    opciones.add(reader.readLine());
                }
                int indiceRespuestaCorrecta = Integer.parseInt(reader.readLine());
                agregarPregunta(new Pregunta(textoPregunta, opciones, indiceRespuestaCorrecta));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
