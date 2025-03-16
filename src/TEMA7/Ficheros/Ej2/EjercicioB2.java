package TEMA7.Ficheros.Ej2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjercicioB2 {
    public static void main(String[]args) {
        String rutaArchivo="Documentos/alumnos_notas.txt";
        List<Persona> alumnos=new ArrayList<>();
        try{
            BufferedReader br=new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            double notas=0;
            double sumanotas=0;
            double medianota=0;
            double resultado=0;

            while((linea= br.readLine())!=null){
                String[] partes=linea.split(" ");
                String nombre=partes[0]+" "+partes[1];
                for (int i=2; i< partes.length;i++){
                    notas=Double.parseDouble(partes[i]);
                   sumanotas=notas+sumanotas;
                   medianota++;
                  resultado=sumanotas/medianota;
                }
                //alumnos.add(new Persona(nombre,resultado));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        alumnos.sort((a1, a2) -> Double.compare(a2.getNotaMedia(), a1.getNotaMedia()));
        for (Persona alumno:alumnos){
            System.out.println(alumno);
        }
    }
}
