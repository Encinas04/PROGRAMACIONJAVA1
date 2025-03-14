package TEMA7.Ficheros.Ej3;

import java.io.*;
import java.util.*;

public class ej3 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        List<String> textos=new ArrayList<>();
        System.out.println("Ingrese el archivo que desea ordenar");
        String archivo= scan.next();
        String rutaArchivo="Documentos/"+archivo+".txt";
         String linea="";
        try{
            BufferedReader br=new BufferedReader(new FileReader(rutaArchivo));
            while((linea= br.readLine())!=null){
                textos.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(textos);
        System.out.println("Ponle nombre al archivo que se ha ordenado alfaveticamente: ");
        String archivoCreado= scan.next();
        try{
            FileWriter writer= new FileWriter("Documentos/"+archivoCreado+".txt");
            for(String texto: textos){
                writer.write(texto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
