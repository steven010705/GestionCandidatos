/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

/*
 * Clase abstracta que define la estructura de los algoritmos de ordenamiento.
 * Cada característica del candidato será ordenada con un tipo específico
 * de algoritmo.
 */

public abstract class Ordenamiento {

    /*
     * Método abstracto para ordenar en orden invertido.
     *
     * @param datos Arreglo de enteros a ordenar
     * @return Arreglo ordenado
     */
    public abstract int[] invertido(int[] datos);

    /*
     * Método abstracto para ordenar en forma levemente ordenada.
     *
     * @param datos Arreglo de enteros a ordenar
     * @return Arreglo ordenado
     */
    public abstract int[] levementeOrdenado(int[] datos);

    /*
     * Método abstracto para ordenar de manera aleatoria.
     *
     * @param datos Arreglo de enteros a ordenar
     * @return Arreglo ordenado
     */
    public abstract int[] aleatorio(int[] datos);

    /*
     * Método estático que selecciona el tipo de ordenamiento según la
     * característica del candidato.
     *
     * @param tipoCaracteristica Nombre de la característica (ejemplo:
     * "HorasPerdidas")
     * @return Instancia de la subclase de Ordenamiento correspondiente
     */
    public static Ordenamiento getOrdenamientoPorCaracteristica(String tipoCaracteristica) {
        switch (tipoCaracteristica) {
            case "HorasPerdidas" -> {
                return new Burbuja();
            }
            case "DistanciaRecorrida" -> {
                return new Insercion();
            }
            case "SobornosRecibidos" -> {
                return new Seleccion();
            }
            case "PrebendasSindicales" -> {
                return new Merge();
            }
            case "TotalCorrupcion" -> {
                return new Quick();
            }
            default -> throw new IllegalArgumentException("Característica no reconocida: " + tipoCaracteristica);
        }
    }
}
