package co.edu.udistrital.controller;

/*
 
Punto de entrada de la aplicación.
Llama al controlador para generar candidatos, ejecutar los algoritmos
y exportar resultados a CSV.*/
public class GestionCandidatos {
    public static void main(String[] args) {
        // Parámetros de ejecución
        int n = 10;             // número de candidatos (puedes probar con valores grandes)
        int m = 100;            // valor máximo por característica
        long semilla = 1234L;   // semilla para reproducibilidad

        // Crear controlador y ejecutar pruebas
        Control control = new Control(n, m, semilla);
        control.ejecutar();
    }
}