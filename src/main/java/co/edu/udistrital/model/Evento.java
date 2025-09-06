/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import java.util.Random;

/**
 * Clase base para representar un evento cuantificable (ej: horas perdidas, sobornos).
 * 
 * Cada evento tiene un valor entero (cantidad), que puede ser generado aleatoriamente.
 */
public abstract class Evento {
    protected int cantidad;

    public Evento() {
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Genera un valor aleatorio en el rango [1, m].
     * 
     * @param m valor máximo permitido
     * @param random generador de números aleatorios (para reproducibilidad)
     */
    public void random(int m, Random random) {
        this.cantidad = 1 + random.nextInt(m);
    }

    @Override
    public String toString() {
        return String.valueOf(cantidad);
    }
}

