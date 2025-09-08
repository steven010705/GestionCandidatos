/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import co.edu.udistrital.model.Candidato;

/**
 * Burbuja (Bubble Sort) instrumentado.
 *
 * Detalles:
 * - Atributo asociado: índice 0 (HorasPerdidas).
 * - Algoritmo: doble bucle for; compara adyacentes y hace swap si necesario.
 * - Métricas:
 *    - comparaciones: cada vez que se compara arr[j] con arr[j+1]
 *    - intercambios: cada vez que se ejecuta un swap entre posiciones
 *
 * Complejidad:
 * - Tiempo: O(n^2) en promedio y peor caso.
 * - Espacio: O(1) auxiliar.
 *
 * Optimización incluida:
 * - Si en una pasada no se realiza ningún swap, el algoritmo termina temprano.
 */
public class Burbuja extends Ordenamiento {

    public Burbuja() {
        super(0, "Burbuja (HorasPerdidas)");
    }

    @Override
    protected void ordenar(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean huboSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                // comparar incrementará comparaciones
                if (comparar(arr[j], arr[j + 1]) > 0) {
                    // realiza swap y cuenta como intercambio
                    intercambiar(arr, j, j + 1);
                    huboSwap = true;
                }
            }
            if (!huboSwap) break; // ya está ordenado
        }
    }
}


