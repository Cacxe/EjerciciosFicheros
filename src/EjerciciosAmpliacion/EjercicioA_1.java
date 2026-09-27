package EjerciciosAmpliacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioA_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce frases, separadas por \"*\": ");
        String input = sc.nextLine();

        final String RUTA_ARCHIVO = "src/EjerciciosAmpliacion/";
        final String NOMBRE_ARCHIVO = "fichero.txt";

        File fichero = new File(RUTA_ARCHIVO + NOMBRE_ARCHIVO);

        String [] frases = input.split("[*]");

        try {
            if(!fichero.exists()) {

                System.out.println("Creando el fichero \"fichero.txt\"...");
                fichero.createNewFile();
            } else {

                System.out.println("El fichero ya existe...");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String aux = "";

        for(String frase : frases) {

            aux += frase;
            aux += "\n";
        }

        try(BufferedWriter wr = new BufferedWriter(new FileWriter(fichero))) {

            wr.write(aux);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
