package Ejercicios4_5;

import java.io.*;
import java.util.Scanner;

public class Ejercicios4_5 {
    public static void main(String[] args) {
        // Ejercicio 1

        final String RUTA_PRINCIPAL = "src/Ejercicios4_5/";
        final String NOMBRE_FICHERO = "datos.txt";
        File datos = new File(RUTA_PRINCIPAL + NOMBRE_FICHERO);

        try {

            if(!datos.exists()) {

                System.out.println("Creando fichero \"datos.txt\"...");
                datos.createNewFile();
            } else {

                System.out.println("El fichero \"datos.txt\" ya existe.");
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(datos))) {

            String linea;
            int lineCount = 0;
            while((linea = br.readLine()) != null) {
                System.out.println(linea);

                lineCount++;
            }

            System.out.println("Número total de líneas del fichero: "+lineCount);

        } catch (IOException e ) {

            System.out.println("El fichero datos.txt, no existe");

            e.getStackTrace();
        }

        // Ejercicio 2

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabraSolicitada = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(datos))) {

            String linea;

            int wordCount = 0;

            while ((linea = br.readLine()) != null) {

                String [] palabrasFichero = linea.split(" ");

                for(String palabra : palabrasFichero) {
                    palabra = palabra.toLowerCase();

                    if(palabraSolicitada.toLowerCase().equals(palabra)) {

                        wordCount++;

                    }

                }
            }

            System.out.println("Veces que aparece la palabra \""
                    +palabraSolicitada+"\": "
                    +wordCount
            );

        } catch (IOException e) {

            System.out.println("El fichero datos.txt, no existe");

            e.getStackTrace();
        }

        // Ejercicio 3

        final String NOMBRE_COPIA = "copia.txt";

        File copia = new File(RUTA_PRINCIPAL + NOMBRE_COPIA);

        try {

            if(!copia.exists()) {

                System.out.println("Creando fichero \"copia.txt\"...");

                copia.createNewFile();

            }
            else {

                System.out.println("Fichero \"copia.txt\" ya existe...");

            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(datos));
             BufferedWriter wr = new BufferedWriter(new FileWriter(copia))) {

            String linea;
            while((linea = br.readLine()) != null) {

                wr.write(linea);
                wr.newLine();
            }

            System.out.println("Fichero \"copia.txt\" escrito exitosamente!");

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

        // Ejercicio 4

        try (BufferedReader br = new BufferedReader(new FileReader(datos));
             BufferedWriter wr = new BufferedWriter(new FileWriter(copia))) {

            String linea;
            while((linea = br.readLine()) != null) {
                linea.replace(" ", "");

                if(!linea.equals("")) {
                    wr.write(linea);
                    wr.newLine();
                }
            }

            System.out.println("Fichero \"copia.txt\" escrito exitosamente!");

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}