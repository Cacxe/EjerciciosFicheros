package EjerciciosAmpliacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioA_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre de un fichero (ruta): ");
        String nombre = sc.nextLine();

        File fichero = new File(nombre);

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            ArrayList<String> lineasAux = new ArrayList<>();
            String linea;
            int lineCount = 0;

            while((linea = br.readLine()) != null) {

                lineCount++;
                lineasAux.add(linea);

            }

            String [] lineas = lineasAux.toArray(new String[0]);
            String [] reverseLineas = new String [lineas.length];
            for(int i = reverseLineas.length - 1; i >= 0; i--) {

                reverseLineas[i] = lineas[lineas.length - 1 - i];
            }

            for(String lines : reverseLineas) {

                System.out.println(lines);
            }

            System.out.println("Número de líneas: "+lineCount);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
