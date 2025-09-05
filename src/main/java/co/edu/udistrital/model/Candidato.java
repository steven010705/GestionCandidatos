/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

import java.util.Arrays;


public class Candidato {
    private int id;
    private Caracteristica caracteristicas;
    
    public Candidato(int id){
        this.id = id;
        this.caracteristicas = new int[numCaracteristicas];
    }

    public int getId() {
        return id;
    }

    public void setCaracteristica(int index, int valor) {
        this.caracteristicas[index] = valor;
    }

    public int getCaracteristica(int index) {
        return this.caracteristicas[index];
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", caracteristicas=" + Arrays.toString(caracteristicas) +
                '}';
    }
}

