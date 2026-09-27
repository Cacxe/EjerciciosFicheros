package Ejercicios3_5;

import java.io.File;
import java.io.IOException;

public class Ejercicios3_5 {
    public static void main(String[] args) {

        //Ejercicio 1

        System.out.println("\n\t\t\tEjercicio 1\n");

        final String RUTA_DIRECTORIO = "src/Ejercicios3_5/";
        final String NOMBRE_DIRECTORIO = "copias";

        File copias = new File(RUTA_DIRECTORIO + NOMBRE_DIRECTORIO);

        if (!copias.exists()) {
            System.out.println("Creando el directorio...");

            copias.mkdir();
        } else {
            System.out.println("El directorio ya existe...");
        }

        // Ejercicio 2

        System.out.println("\n\t\t\tEjercicio 2\n");

        final String RUTA_FICHERO = "src/Ejercicios3_5/copias/";
        final String NOMBRE_FICHERO = "config.txt";

        File config = new File(RUTA_FICHERO + NOMBRE_FICHERO);

        try {
            if (!config.exists()) {
                System.out.println("Creando el fichero...");

                config.createNewFile();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        // Ejercicio 3

        System.out.println("\n\t\t\tEjercicio 3\n");

        File[] contenidoDirectorio = copias.listFiles();

        if (contenidoDirectorio != null) {
            for (File archivo : contenidoDirectorio) {
                System.out.print(archivo);

                if (archivo.isFile()) {
                    System.out.print(" - Fichero");
                }
                if (archivo.isDirectory()) {
                    System.out.print(" - Directorio");
                }

                System.out.println();
            }
        }

        // Ejercicio 4

        System.out.println("\n\t\t\tEjercicio 4\n");

        if (config.exists()) {
            System.out.println("Eliminando fichero config.txt...");

            config.delete();
        } else {
            System.out.println("El fichero no existe.");
        }

        if (copias.exists()) {
            System.out.println("Eliminando el directorio copias...");

            copias.delete();
        }
    }
}
