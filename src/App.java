import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Metodos ordenamientoOpcion = new Metodos();
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int[] arreglo = null;

        while (true) {
            System.out.println("Bienvenido al programa de metodos");
            System.out.println("Menu Principal");
            System.out.println("1. Ingrese un arreglo");
            System.out.println("2. Ordenar arreglo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!leer.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                leer.next(); // Descarta la entrada inválida
            }
            opcion = leer.nextInt();

            if (opcion < 0) {
                System.out.println("Por favor, ingrese un número no negativo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tamaño de su arreglo: ");
                    int tamanio;
                    while (true) {
                        if (leer.hasNextInt()) {
                            tamanio = leer.nextInt();
                            if (tamanio > 0) {
                                break;
                            } else {
                                System.out.println("Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Por favor, ingrese un número entero válido.");
                            leer.next(); // Descarta la entrada inválida
                        }
                    }
                    arreglo = new int[tamanio];
                    for (int i = 0; i < tamanio; i++) {
                        System.out.print("Ingrese el valor para el elemento " + (i + 1) + ": ");
                        while (!leer.hasNextInt()) {
                            System.out.println("Por favor, ingrese un número entero válido.");
                            leer.next(); // Descarta la entrada inválida
                        }
                        arreglo[i] = leer.nextInt();
                    }
                    System.out.println("Arreglo ingresado correctamente: " + Arrays.toString(arreglo));
                    break;
                case 2:
                    if (arreglo == null) {
                        System.out.println("Primero debe ingresar un arreglo.");
                        break;
                    }
                    System.out.println("Escoja un método de ordenamiento:");
                    System.out.println("1. Método Burbuja");
                    System.out.println("2. Método Selección");
                    System.out.println("3. Método Inserción");
                    System.out.println("4. Método Burbuja Mejorado");
                    System.out.print("Seleccione una opción: ");
                    int metodoOpcion;
                    while (!leer.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        leer.next(); // Descarta la entrada inválida
                    }
                    metodoOpcion = leer.nextInt();

                    System.out.println("Seleccione el orden:");
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    int ordenOpcion;
                    while (!leer.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        leer.next(); // Descarta la entrada inválida
                    }
                    ordenOpcion = leer.nextInt();
                    boolean ascendente = (ordenOpcion == 1);

                    System.out.println("¿Quiere ver los pasos intermedios?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    int verPasosOpcion;
                    while (!leer.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        leer.next(); // Descarta la entrada inválida
                    }
                    verPasosOpcion = leer.nextInt();
                    boolean mostrarPasos = (verPasosOpcion == 1);

                    // Llamar al método de ordenamiento correspondiente
                    switch (metodoOpcion) {
                        case 1: // Método Burbuja
                            arreglo = ordenamientoOpcion.sortByBubble(arreglo, mostrarPasos);
                            break;
                        case 2: // Método Selección
                            arreglo = ordenamientoOpcion.selectionSort(arreglo, ascendente, mostrarPasos);
                            break;
                        case 3: // Método Inserción
                            arreglo = ordenamientoOpcion.insertionSort(arreglo, mostrarPasos);
                            break;
                        case 4: // Método Burbuja Mejorado
                            arreglo = ordenamientoOpcion.sortByBubbleAjuste(arreglo, mostrarPasos);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }
                    System.out.println("Arreglo ordenado:");
                    ordenamientoOpcion.printArreglo(arreglo);
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                    leer.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}