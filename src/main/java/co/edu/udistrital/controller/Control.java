/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.controller;


import co.edu.udistrital.model.Burbuja;
import co.edu.udistrital.model.Candidato;
import co.edu.udistrital.model.GeneradorCandidatos;
import co.edu.udistrital.model.Insercion;
import co.edu.udistrital.model.Merge;
import co.edu.udistrital.model.Ordenamiento;
import co.edu.udistrital.model.Quick;
import co.edu.udistrital.model.Seleccion;
import java.util.Arrays;
import java.util.Random;



/**
 * Control (corregido): utiliza la API pública de Ordenamiento (aleatorio/invertido/levementeOrdenado).
 */
public class Control {

    private final int n;       // número de candidatos
    private final int m;       // rango máximo de valores de características
    private final long semilla; // semilla para reproducibilidad

    public Control(int n, int m, long semilla) {
        this.n = n;
        this.m = m;
        this.semilla = semilla;
    }

    /**
     * Ejecuta experimento simple: genera N candidatos y prueba cada algoritmo
     * en las 3 distribuciones. Imprime métricas y valida orden.
     */
    public void ejecutar() {
        Random rndGeneracion = new Random(semilla);
        // Generar población base (la misma para todos los algoritmos)
        Candidato[] base = GeneradorCandidatos.generarPoblacion(n, m, rndGeneracion);

        // Instancias de algoritmos (cada una ya fija su atributo internamente)
        Ordenamiento[] algoritmos = new Ordenamiento[] {
                new Burbuja(),    // asociada al atributo interno que definiste
                new Insercion(),
                new Merge(),
                new Seleccion(),
                new Quick()
        };

        String[] distribuciones = {"Aleatorio", "Invertido", "LevementeOrdenado"};

        for (Ordenamiento alg : algoritmos) {
            System.out.println("\n--- Algoritmo: " + alg.getNombre() + " (atributoIndex=" + alg.getAtributoIndex() + ") ---");
            for (String dist : distribuciones) {
                // Copia superficial del arreglo de referencias (está bien: no clonamos objetos)
                Candidato[] datos = Arrays.copyOf(base, base.length);

                // Usar una semilla derivada para cada ejecución (reproducible)
                Random rndExec = new Random(semilla ^ (alg.getAtributoIndex() + dist.hashCode()));

                long t0 = System.nanoTime();

                // Llamar al método público correcto según la distribución
                switch (dist) {
                    case "Aleatorio":
                        alg.aleatorio(datos, rndExec);
                        break;
                    case "Invertido":
                        alg.invertido(datos, rndExec);
                        break;
                    case "LevementeOrdenado":
                        alg.levementeOrdenado(datos, rndExec);
                        break;
                    default:
                        throw new IllegalStateException("Distribución desconocida: " + dist);
                }

                long t1 = System.nanoTime();

                boolean ordenValido = alg.validarOrdenNoDecreciente(datos);

                System.out.printf("%-18s | %-18s | cmp=%10d | mov=%10d | tiempo=%8d ms | OK=%s%n",
                        alg.getNombre(),
                        dist,
                        alg.getComparaciones(),
                        alg.getIntercambios(),
                        (t1 - t0) / 1_000_000,
                        ordenValido ? "SI" : "NO");
            }
        }
    }
}
