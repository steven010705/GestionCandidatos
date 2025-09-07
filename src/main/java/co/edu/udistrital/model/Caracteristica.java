/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

import java.util.Random;

/**
 * Caracteristica
 *
 * Contenedor de las cinco subcaracterísticas requeridas por candidato.
 *
 * Indices:
 *  0 - HorasPerdidas
 *  1 - DistanciaRecorrida
 *  2 - SobornosRecibidos
 *  3 - PrebendasSindicales
 *  4 - TotalCorrupcion
 *
 * Responsabilidades:
 * - Generar valores para todas las subcaracterísticas con generarValores(m, rnd).
 * - Proveer acceso por índice mediante getValor(int).
 *
 * Diseño:
 * - No se crea una "clase atributo" adicional (como pediste).
 * - Lógica compacta: la representación interna usa clases específicas por claridad.
 */
public class Caracteristica {
    private final HorasPerdidas horasPerdidas;
    private final DistanciaRecorrida distanciaRecorrida;
    private final SobornosRecibidos sobornosRecibidos;
    private final PrebendasSindicales prebendasSindicales;
    private final TotalCorrupcion totalCorrupcion;

    public Caracteristica() {
        this.horasPerdidas = new HorasPerdidas();
        this.distanciaRecorrida = new DistanciaRecorrida();
        this.sobornosRecibidos = new SobornosRecibidos();
        this.prebendasSindicales = new PrebendasSindicales();
        this.totalCorrupcion = new TotalCorrupcion();
    }

    /**
     * Genera los 5 valores en el rango [1, m] usando el Random provisto.
     *
     * @param m tope máximo (>=1)
     * @param rnd Random con semilla para reproducibilidad
     */
    public void generarValores(int m, Random rnd) {
        horasPerdidas.random(m, rnd);
        distanciaRecorrida.random(m, rnd);
        sobornosRecibidos.random(m, rnd);
        prebendasSindicales.random(m, rnd);
        totalCorrupcion.random(m, rnd);
    }

    /**
     * Devuelve el valor de la característica indicada por índice.
     *
     * @param index índice 0..4
     * @return valor entero
     * @throws IndexOutOfBoundsException si index no está en 0..4
     */
    public int getValor(int index) {
        switch (index) {
            case 0: return horasPerdidas.getCantidad();
            case 1: return distanciaRecorrida.getCantidad();
            case 2: return sobornosRecibidos.getCantidad();
            case 3: return prebendasSindicales.getCantidad();
            case 4: return totalCorrupcion.getCantidad();
            default:
                throw new IndexOutOfBoundsException("Índice de característica inválido: " + index);
        }
    }

    /**
     * Devuelve los 5 valores en un arreglo (orden fijo).
     * @return int[5]
     */
    public int[] getValores() {
        return new int[] {
            horasPerdidas.getCantidad(),
            distanciaRecorrida.getCantidad(),
            sobornosRecibidos.getCantidad(),
            prebendasSindicales.getCantidad(),
            totalCorrupcion.getCantidad()
        };
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "horasPerdidas=" + horasPerdidas +
                ", distanciaRecorrida=" + distanciaRecorrida +
                ", sobornosRecibidos=" + sobornosRecibidos +
                ", prebendasSindicales=" + prebendasSindicales +
                ", totalCorrupcion=" + totalCorrupcion +
                '}';
    }
}
