/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import java.util.Random;

/**
 * Candidato
 *
 * Representa un candidato del universo sintético.
 *
 * Atributos:
 * - id (entero único)
 * - caracteristica : objeto Caracteristica que contiene los 5 valores
 *
 * NOTAS:
 * - La generación de valores se delega a la clase Caracteristica.
 * - No duplicamos los atributos numéricos como campos sueltos por requerimiento.
 */
public class Candidato {
    private final int id;
    private final Caracteristica caracteristica;

    /**
     * Crea un candidato con id. Los valores deben generarse con generarValores.
     * @param id identificador único (se recomienda 1..N)
     */
    public Candidato(int id) {
        this.id = id;
        this.caracteristica = new Caracteristica();
    }

    public int getId() {
        return id;
    }

    public Caracteristica getCaracteristicaObj() {
        return caracteristica;
    }

    /**
     * Genera aleatoriamente las 5 características dentro de [1, m].
     * @param m máximo inclusive (m>=1)
     * @param rnd Random con semilla para reproducibilidad
     */
    public void generarValores(int m, Random rnd) {
        caracteristica.generarValores(m, rnd);
    }

    /**
     * Acceso rápido a la característica por índice (0..4).
     * @param index índice
     * @return valor de la característica
     */
    public int getValorCaracteristica(int index) {
        return caracteristica.getValor(index);
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", caracteristica=" + caracteristica +
                '}';
    }
}



