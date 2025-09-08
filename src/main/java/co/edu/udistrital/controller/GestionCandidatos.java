package co.edu.udistrital.controller;

/*
 
Punto de entrada de la aplicación.
Llama al controlador para generar candidatos, ejecutar los algoritmos
y exportar resultados a CSV.*/
public class GestionCandidatos {
    public static void main(String[] args) {
        int N = 500;           // número de candidatos
        int M = 1000000;       // rango máximo de valores
        int repeticiones = 3;  // número de repeticiones por combinación
        long semilla = 12345L; // semilla fija

        Control control = new Control(N, M, repeticiones, semilla);
        control.ejecutarExperimentos("resultados.csv");
    }
}
