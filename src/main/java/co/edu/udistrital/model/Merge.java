/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import co.edu.udistrital.model.Candidato;

/**
 * Merge Sort instrumentado (divide y vencerás).
 *
 * Detalles:
 * - Atributo asociado: índice 2 (SobornosRecibidos).
 * - Métricas:
 *    - comparaciones: cada vez que se compara una pareja L[i] vs R[j].
 *    - intercambios: contamos cada escritura que se hace en el arreglo de salida
 *      (es decir, cada asignación arr[k] = ... es considerada un movimiento).
 *
 * Complejidad:
 * - Tiempo: O(n log n) en todos los casos.
 * - Espacio: O(n) auxiliar por los arreglos temporales.
 *
 * Notas:
 * - La definición de "intercambio" para merge difiere de swap: aquí representa
 *   la copia/escritura en el arreglo original.
 */
public class Merge extends Ordenamiento {

    public Merge() {
        super(2, "Merge (SobornosRecibidos)");
    }

    @Override
    protected void ordenar(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        ordenarRec(arr, 0, arr.length - 1);
    }

    private void ordenarRec(Candidato[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ordenarRec(arr, left, mid);
            ordenarRec(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(Candidato[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Candidato[] L = new Candidato[n1];
        Candidato[] R = new Candidato[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // comparar incrementa comparaciones
            if (comparar(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
                intercambios++; // contar la escritura
            } else {
                arr[k++] = R[j++];
                intercambios++; // contar la escritura
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
            intercambios++;
        }
        while (j < n2) {
            arr[k++] = R[j++];
            intercambios++;
        }
    }
}


