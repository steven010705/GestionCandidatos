/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;




/**
 * Representa a un candidato en el proceso electoral.
 *
 * Cada candidato tiene:
 * - un id único,
 * - un nombre,
 * - un conjunto de características numéricas (almacenadas en un arreglo paralelo a los nombres).
 */
public class Candidato {

    private final int id;              // Identificador único
    private final String nombre;       // Nombre del candidato
    private final int[] caracteristicas; // Arreglo de valores enteros de características

    // Lista fija de nombres de características (mismo orden en todo el sistema)
    public static final String[] NOMBRES_CARACTERISTICAS = {
            "DistanciaRecorrida",
            "HorasPerdidas",
            "PrebendasSindicales",
            "SobornosRecibidos",
            "TotalCorrupcion"
    };

    /**
     * Constructor de Candidato.
     *
     * @param id identificador único
     * @param nombre nombre del candidato
     */
    public Candidato(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = new int[NOMBRES_CARACTERISTICAS.length];
    }

    /**
     * Asigna el valor a una característica específica según su índice.
     *
     * @param indice posición de la característica (0 a 4)
     * @param valor valor entero a asignar
     */
    public void setCaracteristica(int indice, int valor) {
        if (indice >= 0 && indice < caracteristicas.length) {
            caracteristicas[indice] = valor;
        }
    }

    /**
     * Obtiene el valor de una característica según su índice.
     *
     * @param indice posición de la característica
     * @return valor correspondiente
     */
    public int getCaracteristica(int indice) {
        if (indice >= 0 && indice < caracteristicas.length) {
            return caracteristicas[indice];
        }
        throw new IllegalArgumentException("Índice de característica inválido");
    }

    /**
     * @return identificador único
     */
    public int getId() {
        return id;
    }

    /**
     * @return nombre del candidato
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return arreglo completo de características
     */
    public int[] getCaracteristicas() {
        return caracteristicas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Candidato{id=" + id + ", nombre='" + nombre + "', ");
        for (int i = 0; i < caracteristicas.length; i++) {
            sb.append(NOMBRES_CARACTERISTICAS[i])
              .append("=")
              .append(caracteristicas[i]);
            if (i < caracteristicas.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}



