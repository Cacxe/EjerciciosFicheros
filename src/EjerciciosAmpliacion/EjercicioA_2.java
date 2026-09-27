package EjerciciosAmpliacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioA_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre de un fichero (ruta): ");
        String nombre = sc.nextLine();

        File fichero = new File(nombre);

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;
            int lineCount = 0;

            while((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineCount++;

                if(lineCount % 24 == 0) {
                    System.out.print("Pulsa intro para continuar...");
                    sc.nextLine();
                }
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
