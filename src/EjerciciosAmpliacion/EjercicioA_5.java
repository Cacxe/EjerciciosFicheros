package EjerciciosAmpliacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioA_5 {
    public static void main(String[] args) {

        final String RUTA_FICHERO = "src/EjerciciosAmpliacion/";
        final String NOMBRE_FICHERO = "salida.txt";
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre de un fichero (ruta): ");
        String nombre = sc.nextLine();

        File fichero = new File(nombre);

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            ArrayList<String> lineasAux = new ArrayList<>();
            String linea;

            while((linea = br.readLine()) != null) {

                lineasAux.add(linea);

            }

            String [] lineas = lineasAux.toArray(new String[0]);
            String [] reverseLineas = new String [lineas.length];
            for(int i = reverseLineas.length - 1; i >= 0; i--) {

                reverseLineas[i] = lineas[lineas.length - 1 - i];
            }

            File salida = new File(RUTA_FICHERO + NOMBRE_FICHERO);

            try {
                if(!salida.exists()) {

                    System.out.println("Creando el fichero \"salida.txt\"...");

                    salida.createNewFile();
                } else {

                    System.out.println("El fichero ya existe.");
                }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

                for(String line : reverseLineas) {

                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

            System.out.println("Archivo escrito con éxito");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
