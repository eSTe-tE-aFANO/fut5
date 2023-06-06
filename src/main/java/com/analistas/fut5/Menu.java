/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.fut5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    crearEquipo(scanner);
                    break;
                case 2:
                    buscarJugadorPorNombre(scanner);
                    break;
                case 3:
                    buscarEquipoPorNombre(scanner);
                    break;
                case 4:
                    mostrarEquipoConJugadores(scanner);
                    break;
                case 5:
                    eliminarEquipo(scanner);
                    break;
                case 6:
                    importarJugadores(scanner);
                    break;
                case 7:
                    exportarJugadores(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");

                    System.out.println();
            }
            while (opcion != 8);
        }

    } 
    
        private static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Crear un equipo, sus jugadores y entrenador");
        System.out.println("2. Buscar un jugador por su nombre");
        System.out.println("3. Buscar un equipo por su nombre");
        System.out.println("4. Mostrar un equipo con sus jugadores");
        System.out.println("5. Eliminar un equipo");
        System.out.println("6. Importar jugadores desde un archivo");
        System.out.println("7. Exportar jugadores a un archivo");
        System.out.println("8. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void crearEquipo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.print("Ingrese la fecha de creación del equipo: ");
        String fechaCreacion = scanner.nextLine();

        // Código para crear el equipo, sus jugadores y entrenador
        // ...
        // Agregar el equipo a la lista de equipos
        Equipo equipo = new Equipo(nombreEquipo, fechaCreacion);
        equipos.add(equipo);

        System.out.println("Equipo creado exitosamente.");
        System.out.println();
    }

    private static void buscarJugadorPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a buscar: ");
        String nombreJugador = scanner.nextLine();

        Jugador jugadorEncontrado = null;

        // Recorrer todos los equipos y jugadores para encontrar el jugador por su nombre
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getNombreCompleto().equalsIgnoreCase(nombreJugador)) {
                    jugadorEncontrado = jugador;
                    break;
                }
            }
            if (jugadorEncontrado != null) {
                break;
            }
        }

        if (jugadorEncontrado != null) {
            System.out.println("Jugador encontrado:");
            System.out.println("Nombre: " + jugadorEncontrado.getNombreCompleto());
            System.out.println("Apellido: " + jugadorEncontrado.getApellido());
            System.out.println("Posición: " + jugadorEncontrado.getPosicion());
            System.out.println("Capitán: " + (jugadorEncontrado.esCapitan() ? "Sí" : "No"));
            System.out.println("Equipo: " + jugadorEncontrado.getEquipo().getNombreCompleto());
        } else {
            System.out.println("No se encontró ningún jugador con ese nombre.");
        }
        System.out.println();
    }

    private static void buscarEquipoPorNombre(Scanner scanner) {
    System.out.print("Ingrese el nombre del equipo a buscar: ");
    String nombreEquipo = scanner.nextLine();

    Equipo equipoEncontrado = null;

    // Recorrer todos los equipos para encontrar el equipo por su nombre
    for (Equipo equipo : equipos) {
        if (equipo.getNombreCompleto().equalsIgnoreCase(nombreEquipo)) {
            equipoEncontrado = equipo;
            break;
        }
    }

    if (equipoEncontrado != null) {
        System.out.println("Equipo encontrado:");
        System.out.println("Nombre: " + equipoEncontrado.getNombreCompleto());
        System.out.println("Entrenador: " + equipoEncontrado.getEntrenador().getNombreCompleto());
        System.out.println("Capitán: " + equipoEncontrado.getCapitan().getNombreCompleto());
    } else {
        System.out.println("No se encontró ningún equipo con ese nombre.");
    }
    System.out.println();
}

    private static void mostrarEquipoConJugadores(Scanner scanner) {
    System.out.print("Ingrese el nombre del equipo a mostrar: ");
    String nombreEquipo = scanner.nextLine();

    Equipo equipoEncontrado = null;

    // Recorrer todos los equipos para encontrar el equipo por su nombre
    for (Equipo equipo : equipos) {
        if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
            equipoEncontrado = equipo;
            break;
        }
    }

    if (equipoEncontrado != null) {
        System.out.println("Equipo: " + equipoEncontrado.getNombre());
        System.out.println("Entrenador: " + equipoEncontrado.getEntrenador().getNombre());
        System.out.println("Jugadores:");

        for (Jugador jugador : equipoEncontrado.getJugadores()) {
            System.out.println("- Nombre: " + jugador.getNombre());
            System.out.println("  Posición: " + jugador.getPosicion());
            System.out.println("  Capitán: " + (jugador.esCapitan() ? "Sí" : "No"));
        }
    } else {
        System.out.println("No se encontró ningún equipo con ese nombre.");
    }
    System.out.println();
}


    private static void eliminarEquipo(Scanner scanner) {
    System.out.print("Ingrese el nombre del equipo a eliminar: ");
    String nombreEquipo = scanner.nextLine();

    boolean equipoEncontrado = false;

    // Recorrer todos los equipos para encontrar el equipo por su nombre
    for (Equipo equipo : equipos) {
        if (equipo.getNombreCompleto().equalsIgnoreCase(nombreEquipo)) {
            equipos.remove(equipo);
            equipoEncontrado = true;
            break;
        }
    }

    if (equipoEncontrado) {
        System.out.println("El equipo ha sido eliminado correctamente.");
    } else {
        System.out.println("No se encontró ningún equipo con ese nombre.");
    }
    System.out.println();
}

    private static void importarJugadores(Scanner scanner) {
    System.out.print("Ingrese la ruta del archivo a importar (csv o txt): ");
    String rutaArchivo = scanner.nextLine();

    // Aquí implementa el código para leer el archivo y procesar la información de los jugadores
    // Puedes usar clases como BufferedReader o Scanner para leer el archivo

    // Luego de procesar la información, crea los objetos Jugador y Equipo según corresponda y añádelos a la lista de equipos y jugadores

    System.out.println("Los jugadores han sido importados correctamente.");
    System.out.println();
}

    private static void exportarJugadores(Scanner scanner) {
    System.out.print("Ingrese la ruta del archivo de destino (csv o txt): ");
    String rutaArchivo = scanner.nextLine();

    // Aquí implementa el código para escribir la información de los jugadores en el archivo
    // Puedes usar clases como FileWriter o PrintWriter para escribir en el archivo

    System.out.println("Los jugadores han sido exportados correctamente.");
    System.out.println();
}

    System.out.println("Saliendo del programa...");
    System.exit(0);

}

