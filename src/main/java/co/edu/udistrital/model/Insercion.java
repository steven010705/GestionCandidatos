/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Implementación del algoritmo de Inserción Asignado a la característica:
 * DistanciaRecorrida
 */

public class Insercion extends Ordenamiento {

    @Override
    public int[] Invertido(int[] datos) {
        int[] copia = datos.clone();
        insertionSort(copia);
        invertir(copia);
        return copia;
    }

    @Override
    public int[] LevementeOrdenado(int[] datos) {
        int[] copia = datos.clone();
        // Ordenar parcialmente los primeros 5 elementos
        for (int i = 1; i < Math.min(5, copia.length); i++) {
            int key = copia[i];
            int j = i - 1;
            while (j >= 0 && copia[j] > key) {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = key;
        }
        return copia;
    }

    @Override
    public int[] Aleatorio(int[] datos) {
        int[] copia = datos.clone();
        insertionSort(copia);
        return copia;
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
