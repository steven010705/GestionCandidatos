/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Seleccion (Selection Sort) instrumentado.
 *
 * Detalles:
 * - Atributo asociado: índice 3 (PrebendasSindicales).
 * - Algoritmo: para cada posición i encuentra el mínimo en [i..n-1] y lo swap con i.
 * - Métricas:
 *    - comparaciones: cada evaluación arr[j] < arr[minIdx]
 *    - intercambios: cada swap realizado (una sola vez por iteración si minIdx != i)
 *
 * Complejidad:
 * - Tiempo: O(n^2) siempre.
 * - Espacio: O(1) auxiliar.
 */
public class Seleccion extends Ordenamiento {

    public Seleccion() {
        super(3, "Seleccion (PrebendasSindicales)");
    }

    @Override
    protected void ordenar(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparar(arr[j], arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                intercambiar(arr, i, minIdx);
            }
        }
    }
}

