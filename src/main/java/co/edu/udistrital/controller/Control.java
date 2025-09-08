/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.controller;


import co.edu.udistrital.model.Burbuja;
import co.edu.udistrital.model.Candidato;
import co.edu.udistrital.model.Insercion;
import co.edu.udistrital.model.Merge;
import co.edu.udistrital.model.Ordenamiento;
import co.edu.udistrital.model.Quick;
import co.edu.udistrital.model.Seleccion;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Clase Control (Controller en el patrón MVC).
 *
 * Su responsabilidad principal es coordinar el flujo del programa:
 * - Generar la población sintética de candidatos.
 * - Ejecutar los algoritmos de ordenamiento sobre distintas distribuciones
 *   (aleatoria, invertida, levemente ordenada).
 * - Repetir cada experimento k veces para obtener estadísticas robustas.
 * - Registrar métricas (comparaciones, intercambios y tiempo de ejecución).
 * - Exportar resultados a CSV para posterior análisis.
 *
 * Esta clase NO implementa lógica de ordenamiento (eso está en el modelo),
 * ni maneja la interfaz de usuario (eso se hace en la Vista).
 */
public class Control {

    private final int n;          // Número de candidatos
    private final int m;          // Rango máximo de valores de características
    private final int repeticiones; // Número de repeticiones por experimento
    private final long semilla;   // Semilla fija para reproducibilidad

    private final Random rnd;

    /**
     * Constructor del controlador.
     * @param n número de candidatos
     * @param m máximo de valor de característica
     * @param repeticiones número de repeticiones por combinación
     * @param semilla semilla fija de aleatoriedad (para reproducibilidad)
     */
    public Control(int n, int m, int repeticiones, long semilla) {
        this.n = n;
        this.m = m;
        this.repeticiones = repeticiones;
        this.semilla = semilla;
        this.rnd = new Random(semilla);
    }

    /**
     * Genera un arreglo de candidatos con valores aleatorios.
     * Cada candidato obtiene valores en [1, m] para las 5 características.
     * @return arreglo de N candidatos
     */
    private Candidato[] generarCandidatos() {
        Candidato[] arr = new Candidato[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Candidato(i + 1);
            arr[i].generarValores(m, rnd);
        }
        return arr;
    }

    /**
     * Ejecuta un conjunto de algoritmos sobre todas las distribuciones,
     * repitiendo cada experimento "repeticiones" veces.
     * Exporta los resultados a un archivo CSV.
     * @param rutaSalida ruta del archivo CSV de salida
     */
    public void ejecutarExperimentos(String rutaSalida) {
        // Lista de algoritmos a evaluar (cada uno fijo a un atributo)
        List<Ordenamiento> algoritmos = Arrays.asList(
                new Burbuja(),
                new Insercion(),
                new Merge(),
                new Seleccion(),
                new Quick()
        );

        // Distribuciones a probar (nombre, lambda de ejecución)
        String[] distribuciones = {"Aleatorio", "Invertido", "LevementeOrdenado"};

        try (FileWriter writer = new FileWriter(rutaSalida)) {
            // Cabecera CSV
            writer.write("Algoritmo,Distribucion,Repeticion,Comparaciones,Intercambios,TiempoNano\n");

            for (Ordenamiento algoritmo : algoritmos) {
                for (String dist : distribuciones) {
                    for (int rep = 1; rep <= repeticiones; rep++) {
                        // Generar población nueva para cada repetición
                        Candidato[] base = generarCandidatos();
                        Candidato[] copia = Arrays.copyOf(base, base.length);

                        // Medir tiempo antes y después
                        long inicio = System.nanoTime();

                        // Ejecutar según distribución
                        if (dist.equals("Aleatorio")) {
                            algoritmo.aleatorio(copia, new Random(semilla + rep));
                        } else if (dist.equals("Invertido")) {
                            algoritmo.invertido(copia, new Random(semilla + rep));
                        } else {
                            algoritmo.levementeOrdenado(copia, new Random(semilla + rep));
                        }

                        long fin = System.nanoTime();

                        // Guardar resultados
                        writer.write(String.format("%s,%s,%d,%d,%d,%d\n",
                                algoritmo.getNombre(),
                                dist,
                                rep,
                                algoritmo.getComparaciones(),
                                algoritmo.getIntercambios(),
                                (fin - inicio)
                        ));
                    }
                }
            }

            System.out.println("✅ Resultados exportados a: " + rutaSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
