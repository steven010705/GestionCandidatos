/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


/*
 * Implementación del algoritmo QuickSort
 * Asignado a la característica: TotalCorrupcion
 */

public class Quick extends Ordenamiento {

    @Override
    public int[] Invertido(int[] datos) {
        int[] copia = datos.clone();
        quickSort(copia, 0, copia.length - 1);
        invertir(copia);
        return copia;
    }

    @Override
    public int[] LevementeOrdenado(int[] datos) {
        int[] copia = datos.clone();
        // Ordenar parcialmente (primeros 5 elementos)
        quickSort(copia, 0, Math.min(4, copia.length - 1));
        return copia;
    }

    @Override
    public int[] Aleatorio(int[] datos) {
        int[] copia = datos.clone();
        quickSort(copia, 0, copia.length - 1);
        return copia;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void invertir(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}

