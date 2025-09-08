/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * QuickSort instrumentado (partición de Lomuto).
 *
 * Detalles:
 * - Atributo asociado: índice 4 (TotalCorrupcion).
 * - Métricas:
 *    - comparaciones: cada comparación arr[j] <= pivot (comparar arr[j] con pivot).
 *    - intercambios: cada swap realizado.
 *
 * Complejidad:
 * - Tiempo: O(n^2) peor caso (ej. arreglo ya ordenado con pivot malo), O(n log n) promedio.
 * - Espacio: O(log n) pila recursiva promedio.
 *
 * Notas:
 * - Para mayor robustez en producción se suele aleatorizar el pivot; aquí usamos
 *   pivot = arr[high] (Lomuto) por simplicidad. Si quieres aleatorizar, lo puedo adaptar.
 */
public class Quick extends Ordenamiento {

    public Quick() {
        super(4, "Quick (TotalCorrupcion)");
    }

    @Override
    protected void ordenar(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        ordenarRec(arr, 0, arr.length - 1);
    }

    private void ordenarRec(Candidato[] arr, int low, int high) {
        if (low < high) {
            int p = particion(arr, low, high);
            ordenarRec(arr, low, p - 1);
            ordenarRec(arr, p + 1, high);
        }
    }

    private int particion(Candidato[] arr, int low, int high) {
        Candidato pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // comparar inc. comparaciones
            if (comparar(arr[j], pivot) <= 0) {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, high);
        return i + 1;
    }
}