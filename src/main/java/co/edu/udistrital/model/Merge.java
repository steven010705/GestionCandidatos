/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Implementación del algoritmo MergeSort Asignado a la característica:
 * PrebendasSindicales
 */

public class Merge extends Ordenamiento {

    @Override
    public int[] Invertido(int[] datos) {
        int[] copia = datos.clone();
        mergeSort(copia, 0, copia.length - 1);
        invertir(copia);
        return copia;
    }

    @Override
    public int[] LevementeOrdenado(int[] datos) {
        int[] copia = datos.clone();
        // Ordenar solo la primera mitad
        mergeSort(copia, 0, copia.length / 2);
        return copia;
    }

    @Override
    public int[] Aleatorio(int[] datos) {
        int[] copia = datos.clone();
        mergeSort(copia, 0, copia.length - 1);
        return copia;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
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
