import java.util.ArrayList;
import java.util.List;

public class Metodos {
    public Metodos() {
    }

    private String arrayToString(int[] arregloSturctura) {
        StringBuilder structura = new StringBuilder();
        for (int i = 0; i < arregloSturctura.length; i++) {
            structura.append(arregloSturctura[i]);
            if (i < arregloSturctura.length - 1) structura.append(", ");
        }
        return String.format("%-30s", structura.toString());
    }

    // Método de ordenamiento Burbuja
    public int[] sortByBubble(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int tamanio = arreglo.length;
        List<String> pasos = new ArrayList<>();
        for (int i = 0; i < tamanio - 1; i++) {
            for (int j = 0; j < tamanio - 1 - i; j++) {
                String paso = String.format("%s valor a: %-2d valor b: %d",
                               arrayToString(arreglo), arreglo[j], arreglo[j + 1]);
                pasos.add(paso);
                if ((ascendente && arreglo[j] > arreglo[j + 1]) ||
                    (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
                }
            }
        }
        if (mostrarPasos) {
            System.out.println("Método Burbuja:");
            for (String paso : pasos) {
                System.out.println(paso);
            }
        }
        return arreglo;
    }

    // Método de ordenamiento Selección
    public int[] selectionSort(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int tamanio = arreglo.length;
        List<String> pasos = new ArrayList<>();
        for (int i = 0; i < tamanio - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < tamanio; j++) {
                String paso = String.format("%s pos menor=%d pos j=%d",
                               arrayToString(arreglo), indice, j);
                pasos.add(paso);
                if (ascendente ? arreglo[j] < arreglo[indice] : arreglo[j] > arreglo[indice]) {
                    indice = j;
                }
            }
            if (indice != i) {
                int aux = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = aux;
                pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
            }
        }
        if (mostrarPasos) {
            System.out.println("Método Selección:");
            for (String paso : pasos) {
                System.out.println(paso);
            }
        }
        return arreglo;
    }

    // Método de ordenamiento Inserción
    public int[] insertionSort(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int n = arreglo.length;
        List<String> pasos = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;
            pasos.add(String.format("%s valor actual: %d", arrayToString(arreglo), valorActual));
            while (j >= 0 && ((ascendente && arreglo[j] > valorActual) ||
                              (!ascendente && arreglo[j] < valorActual))) {
                pasos.add(String.format("%s comparando con: %d", arrayToString(arreglo), arreglo[j]));
                arreglo[j + 1] = arreglo[j];
                j--;
                pasos.add(String.format("%s (desplazamiento)", arrayToString(arreglo)));
            }
            arreglo[j + 1] = valorActual;
            pasos.add(String.format("%s (inserción)", arrayToString(arreglo)));
        }
        if (mostrarPasos) {
            System.out.println("Método Inserción:");
            for (String paso : pasos) {
                System.out.println(paso);
            }
        }
        return arreglo;
    }

    // Método Burbuja Con Ajuste
    public int[] sortByBubbleAjuste(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int tamanio = arreglo.length;
        boolean swapped;
        List<String> pasos = new ArrayList<>();
        for (int i = 0; i < tamanio - 1; i++) {
            swapped = false;
            for (int j = 0; j < tamanio - 1 - i; j++) {
                pasos.add(String.format("%s valor a: %-2d valor b: %d", arrayToString(arreglo), arreglo[j], arreglo[j + 1]));
                if ((ascendente && arreglo[j] > arreglo[j + 1]) ||
                    (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    swapped = true;
                    pasos.add(String.format("%s (intercambio)", arrayToString(arreglo)));
                }
            }
            if (!swapped) {
                pasos.add("Arreglo ordenado antes de tiempo");
                break;
            }
        }
        if (mostrarPasos) {
            System.out.println("Método Burbuja con Ajuste:");
            for (String paso : pasos) {
                System.out.println(paso);
            }
        }
        return arreglo;
    }

    public void printArreglo(int[] arreglo) {
        System.out.println(arrayToString(arreglo));
    }
}