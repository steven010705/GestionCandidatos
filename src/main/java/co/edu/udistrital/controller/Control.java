/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.controller;

// ======================
// Clase Control
// ======================
import co.edu.udistrital.model.Candidato;
import co.edu.udistrital.view.Vista;

public class Control {

    // Atributos
    private Vista vista;
    private Candidato candidato;

    // Constructor
    public Control() {
        this.vista = new Vista();
        this.candidato = new Candidato();
    }

    // Método run
    public void run() {
        // Aquí iría la lógica principal del controlador
        vista.GUI();
        vista.mostrarMensaje("Control en ejecución...");

        // Ejemplo: mostrar el id de un candidato
        candidato.setId(1);
        vista.mostrarMensaje("Candidato con id: " + candidato.getId(1));
    }
}
