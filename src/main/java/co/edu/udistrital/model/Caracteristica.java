/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

import java.util.Random;

/**
 * Clase que representa el conjunto de características de un candidato.
 * Incluye:
 *  - Horas de clase perdidas
 *  - Distancia recorrida en marchas
 *  - Sobornos recibidos
 *  - Prebendas sindicales
 *  - Total de corrupción
 */
public class Caracteristica {
    private HorasPerdidas horasPerdidas;
    private DistanciaRecorrida distanciaRecorrida;
    private SobornosRecibidos sobornosRecibidos;
    private PrebendasSindicales prebendasSindicales;
    private TotalCorrupcion totalCorrupcion;

    public Caracteristica() {
        this.horasPerdidas = new HorasPerdidas();
        this.distanciaRecorrida = new DistanciaRecorrida();
        this.sobornosRecibidos = new SobornosRecibidos();
        this.prebendasSindicales = new PrebendasSindicales();
        this.totalCorrupcion = new TotalCorrupcion();
    }

    /**
     * Genera valores aleatorios para todas las características.
     * 
     * @param m valor máximo permitido
     * @param random generador de números aleatorios
     */
    public void generarValores(int m, Random random) {
        horasPerdidas.random(m, random);
        distanciaRecorrida.random(m, random);
        sobornosRecibidos.random(m, random);
        prebendasSindicales.random(m, random);
        totalCorrupcion.random(m, random);
    }

    public int[] getValores() {
        return new int[]{
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
