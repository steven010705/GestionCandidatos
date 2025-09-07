/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import java.util.Random;

/**
 * Evento - clase base ligera que representa un valor entero cuantificable.
 *
 * Propósito:
 * - Centralizar la generación aleatoria de un entero en rango [1, m].
 * - Proveer acceso al valor a través de getCantidad().
 *
 * Contrato:
 * - random(m, rnd) asigna un entero entre 1 y m (inclusive).
 * - La generación usa el Random provisto para permitir reproducibilidad mediante
 *   una semilla externa.
 *
 * Notas de implementación:
 * - Esta clase NO maneja validación extensiva de m; se asume m >= 1.
 * - No es thread-safe; si se usará en multi-hilo, sincronizar externamente.
 */
public abstract class Evento {
    protected int cantidad;

    public Evento() {
        this.cantidad = 0;
    }

    /**
     * Devuelve el valor del evento.
     * @return valor entero actual (0 si no se ha generado)
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Genera y asigna un valor entero uniforme en [1, m].
     *
     * Precondición: m >= 1.
     *
     * @param m  tope superior inclusive para la generación
     * @param rnd generador Random para reproducibilidad
     */
    public void random(int m, Random rnd) {
        if (m < 1) throw new IllegalArgumentException("m debe ser >= 1");
        this.cantidad = 1 + rnd.nextInt(m); // 1..m inclusive
    }

    @Override
    public String toString() {
        return String.valueOf(cantidad);
    }
}

