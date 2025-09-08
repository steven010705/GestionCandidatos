/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/*
 * Ordenamiento (abstracto)
 *
 * Clase base para todos los algoritmos instrumentados. Provee:
 * - Contadores: comparaciones e intercambios (long).
 * - Atributo asociado (atributoIndex) que fija la característica por la que
 *   se comparará en todas las ejecuciones de esa instancia.
 * - Métodos para preparar distribuciones de entrada: aleatorio, invertido y levementeOrdenado.
 * - Métodos utilitarios protegidos para que las implementaciones los usen
 *   (comparar e intercambiar instrumentados).
 *
 * Contrato y convenciones:
 * - Los métodos preparar* NO incrementan los contadores (preparación excluida
 *   de métricas), porque representan estructura de entrada. Las métricas solo
 *   se acumulan en el método abstracto ordenar(Candidato[]) implementado
 *   por cada subclase.
 * - comparar(a,b) incrementa `comparaciones` y devuelve el resultado.
 * - intercambiar(arr,i,j) incrementa `intercambios` y efectúa el swap.
 * - validarOrden(...) verifica orden no decreciente por el atributo (sin
 *   afectar contadores).
 *
 * Uso típico:
 *   Ordenamiento ord = new Burbuja(); // constructor fija atributoIndex (en subclase)
 *   ord.aleatorio(arr, rnd); // prepara y ordena; luego getComparaciones()/getIntercambios()
 *
 * Observación de métricas:
 * - Qué es "comparación": cualquier evaluación entre dos valores de la característica.
 * - Qué es "intercambio":
 *     * Burbuja/Seleccion/Quick: cuenta swaps reales (swap de 2 posiciones).
 *     * Insercion: cuenta desplazamientos (asignaciones) y la colocación final.
 *     * Merge: contamos cada escritura en el arreglo original como movimiento.
 *
 * NOTA: No mide tiempo. El arnés (controller/main) debe medir tiempo con System.nanoTime().
 */
public abstract class Ordenamiento {
    protected long comparaciones;
    protected long intercambios;
    protected final int atributoIndex;
    protected final String nombre;

    /*
     * Constructor protegido: las subclases deben pasar el índice de atributo asociado.
     *
     * @param atributoIndex índice 0..4 que indica la característica utilizada
     * @param nombre nombre legible del algoritmo
     */
    protected Ordenamiento(int atributoIndex, String nombre) {
        if (atributoIndex < 0 || atributoIndex > 4)
            throw new IllegalArgumentException("atributoIndex debe estar en 0..4");
        this.atributoIndex = atributoIndex;
        this.nombre = nombre;
        reset();
    }

    /* Resetea contadores a cero (invocar antes de cada medición si se reutiliza la instancia). */
    public void reset() {
        comparaciones = 0;
        intercambios = 0;
    }

    public long getComparaciones() { return comparaciones; }
    public long getIntercambios() { return intercambios; }
    public int getAtributoIndex() { return atributoIndex; }
    public String getNombre() { return nombre; }

    /*
     * Implementación concreta del algoritmo instrumentado.
     * - Debe usar comparar(...) e intercambiar(...) para que las métricas se acumulen.
     * - Debe ordenar el arreglo IN-PLACE en orden no decreciente por la característica.
     *
     * @param arreglo arreglo de Candidato modificado in-place
     */
    protected abstract void ordenar(Candidato[] arreglo);

    // ------------------------
    // Métodos que preparan la entrada y llaman a ordenar(...) instrumentado
    // ------------------------

    /*
     * Prepara entrada aleatoria (barajar) y ejecuta el algoritmo instrumentado.
     * NOTA: la preparación (barajear) NO cuenta en las métricas.
     *
     * @param arreglo arreglo que se barajeará y ordenará (se modifica)
     * @param rnd Random para determinismo
     */
    public void aleatorio(Candidato[] arreglo, Random rnd) {
        reset();
        if (arreglo == null) return;
        prepararAleatorio(arreglo, rnd);
        ordenar(arreglo);
    }

    /*
     * Prepara entrada invertida (orden descendente por atributo) y ejecuta el algoritmo.
     * NOTA: la preparación NO cuenta para métricas.
     *
     * @param arreglo arreglo a ordenar
     * @param rnd Random (se mantiene en API por consistencia)
     */
    public void invertido(Candidato[] arreglo, Random rnd) {
        reset();
        if (arreglo == null) return;
        prepararInvertido(arreglo);
        ordenar(arreglo);
    }

    /*
     * Prepara entrada levemente ordenada: ordena ascendentemente y realiza unos pocos swaps.
     * NOTA: la preparación NO cuenta para métricas.
     *
     * @param arreglo arreglo a preparar y ordenar
     * @param rnd Random para swaps
     */
    public void levementeOrdenado(Candidato[] arreglo, Random rnd) {
        reset();
        if (arreglo == null) return;
        prepararLevementeOrdenado(arreglo, rnd);
        ordenar(arreglo);
    }

    // ------------------------
    // Preparación (no instrumentada)
    // ------------------------

    /** Fisher–Yates shuffle para obtener permutación aleatoria. */
    protected void prepararAleatorio(Candidato[] arr, Random rnd) {
        if (arr == null || arr.length < 2) return;
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Candidato tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    /* Ordena descendentemente por atributoIndex (sin contar métricas). */
    protected void prepararInvertido(Candidato[] arr) {
        if (arr == null || arr.length < 2) return;
        Arrays.sort(arr, new Comparator<Candidato>() {
            @Override
            public int compare(Candidato a, Candidato b) {
                return Integer.compare(b.getCaracteristica(atributoIndex),
                                       a.getCaracteristica(atributoIndex));
            }
        });
    }

    /*
     * Ordena ascendentemente (sin contar métricas) y realiza ~5% swaps aleatorios.
     * Esto produce una entrada "levemente ordenada".
     */
    protected void prepararLevementeOrdenado(Candidato[] arr, Random rnd) {
        if (arr == null || arr.length < 2) return;
        Arrays.sort(arr, new Comparator<Candidato>() {
            @Override
            public int compare(Candidato a, Candidato b) {
                return Integer.compare(a.getCaracteristica(atributoIndex),
                                       b.getCaracteristica(atributoIndex));
            }
        });
        int n = arr.length;
        int swaps = Math.max(1, n / 20); // ~5%
        for (int s = 0; s < swaps; s++) {
            int i = rnd.nextInt(n);
            int j = rnd.nextInt(n);
            Candidato tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    // ------------------------
    // Operaciones instrumentadas que las subclases deben usar
    // ------------------------

    /*
     * Compara dos candidatos por el atributo asociado. Incrementa contador de comparaciones.
     *
     * @param a candidato A
     * @param b candidato B
     * @return negativo si a<b, 0 si iguales, positivo si a>b (por atributoIndex)
     */
    protected int comparar(Candidato a, Candidato b) {
        comparaciones++;
        return Integer.compare(a.getCaracteristica(atributoIndex),
                               b.getCaracteristica(atributoIndex));
    }

    /*
     * Intercambia dos posiciones e incrementa contador de intercambios.
     * Se considera un "intercambio" cada vez que se realiza un swap de posiciones.
     *
     * @param arr arreglo
     * @param i índice i
     * @param j índice j
     */
    protected void intercambiar(Candidato[] arr, int i, int j) {
        intercambios++;
        Candidato tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // ------------------------
    // Validación (no instrumentada)
    // ------------------------

    /*
     * Verifica que el arreglo esté en orden no decreciente por el atributo asociado.
     * No altera los contadores (usa acceso directo a getValorCaracteristica).
     *
     * @param arr arreglo a validar
     * @return true si está ordenado, false si no lo está
     */
    public boolean validarOrdenNoDecreciente(Candidato[] arr) {
        if (arr == null || arr.length < 2) return true;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i].getCaracteristica(atributoIndex);
            int b = arr[i+1].getCaracteristica(atributoIndex);
            if (a > b) return false;
        }
        return true;
    }
}


