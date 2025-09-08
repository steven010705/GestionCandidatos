/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Insercion (Insertion Sort) instrumentado.
 *
 * Detalles:
 * - Atributo asociado: índice 1 (DistanciaRecorrida).
 * - Algoritmo: toma el elemento key y lo inserta en la sublista ordenada.
 * - Métricas:
 *    - comparaciones: cada vez que se compara un elemento de la sublista con key.
 *    - intercambios: aquí se cuentan las asignaciones de desplazamiento (arr[j+1]=arr[j])
 *      y la asignación final de key (arr[j+1]=key) como movimientos/intercambios.
 *
 * Complejidad:
 * - Tiempo: O(n^2) peor caso (invertido), O(n) mejor caso (casi ordenado).
 * - Espacio: O(1) auxiliar.
 *
 * Notas:
 * - Debido a que Insertion hace desplazamientos en vez de swaps, se contabilizan
 *   como "intercambios" cada asignación que mueve un elemento.
 */
public class Insercion extends Ordenamiento {

    public Insercion() {
        super(1, "Insercion (DistanciaRecorrida)");
    }

    @Override
    protected void ordenar(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Candidato key = arr[i];
            int j = i - 1;
            // mientras arr[j] > key (aumenta comparaciones)
            while (j >= 0 && comparar(arr[j], key) > 0) {
                // desplazar arr[j] a la derecha; cuenta como "intercambio" (movimiento)
                arr[j + 1] = arr[j];
                intercambios++;
                j--;
            }
            // colocar key en su posición (contamos la asignación final)
            arr[j + 1] = key;
            intercambios++;
        }
    }
}