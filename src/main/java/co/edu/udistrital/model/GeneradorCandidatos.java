/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;




import java.util.Random;

/**
 * Clase utilitaria para generar candidatos de manera sintética.
 *
 * - Genera nombres aleatorios a partir de prefijos y sufijos.
 * - Asigna valores aleatorios a todas las características.
 */
public class GeneradorCandidatos {

    private static final String[] PREFIJOS = {
            "Juan", "Ana", "Luis", "María", "Pedro", "Laura", "Carlos", "Sofía", "Andrés", "Valeria"
    };

    private static final String[] SUFIJOS = {
            " Pérez", " Gómez", " Rodríguez", " López", " Hernández", " Martínez", " Ramírez", " Díaz"
    };

    /**
     * Genera un candidato con id, nombre y características aleatorias.
     *
     * @param id identificador único
     * @param maxValor rango máximo de valores para las características
     * @param rnd generador aleatorio
     * @return candidato generado
     */
    public static Candidato generarCandidato(int id, int maxValor, Random rnd) {
        // Crear nombre aleatorio combinando prefijo y sufijo
        String nombre = PREFIJOS[rnd.nextInt(PREFIJOS.length)] +
                        SUFIJOS[rnd.nextInt(SUFIJOS.length)];

        Candidato candidato = new Candidato(id, nombre);

        // Asignar valores aleatorios en [1, maxValor]
        for (int i = 0; i < Candidato.NOMBRES_CARACTERISTICAS.length; i++) {
            int valor = 1 + rnd.nextInt(maxValor);
            candidato.setCaracteristica(i, valor);
        }

        return candidato;
    }

    /**
     * Genera un arreglo de candidatos con datos sintéticos.
     *
     * @param n número de candidatos
     * @param maxValor rango máximo de valores por característica
     * @param rnd generador aleatorio
     * @return arreglo de candidatos
     */
    public static Candidato[] generarPoblacion(int n, int maxValor, Random rnd) {
        Candidato[] poblacion = new Candidato[n];
        for (int i = 0; i < n; i++) {
            poblacion[i] = generarCandidato(i + 1, maxValor, rnd);
        }
        return poblacion;
    }
}
