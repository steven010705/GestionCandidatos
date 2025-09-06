/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


/**
 * Implementación del algoritmo de Burbuja
 * Asignado a la característica: HorasPerdidas
 */
public class Burbuja extends Ordenamiento {

    @Override
    public int[] Invertido(int[] datos) {
        int[] copia = datos.clone();
        bubbleSort(copia);
        invertir(copia);
        return copia;
    }

    @Override
    public int[] LevementeOrdenado(int[] datos) {
        // Simulación: ordenar parcialmente (primeros 3 elementos)
        int[] copia = datos.clone();
        for (int i = 0; i < Math.min(3, copia.length); i++) {
            bubbleSortParcial(copia, i);
        }
        return copia;
    }

    @Override
    public int[] Aleatorio(int[] datos) {
        // Simplemente aplica bubble sort completo
        int[] copia = datos.clone();
        bubbleSort(copia);
        return copia;
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void bubbleSortParcial(int[] arr, int limite) {
        for (int j = 0; j < arr.length - limite - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    private void invertir(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}

