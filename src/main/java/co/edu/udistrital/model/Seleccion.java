/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Implementación del algoritmo de Selección Asignado a la característica:
 * SobornosRecibidos
 */

public class Seleccion extends Ordenamiento {

    @Override
    public int[] invertido(int[] datos) {
        int[] copia = datos.clone();
        selectionSort(copia);
        invertir(copia);
        return copia;
    }

    @Override
    public int[] levementeOrdenado(int[] datos) {
        int[] copia = datos.clone();
        // Ordenar parcialmente (solo mitad del arreglo)
        for (int i = 0; i < copia.length / 2; i++) {
            int minIdx = i;
            for (int j = i + 1; j < copia.length / 2; j++) {
                if (copia[j] < copia[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = copia[minIdx];
            copia[minIdx] = copia[i];
            copia[i] = temp;
        }
        return copia;
    }

    @Override
    public int[] aleatorio(int[] datos) {
        int[] copia = datos.clone();
        selectionSort(copia);
        return copia;
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
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
