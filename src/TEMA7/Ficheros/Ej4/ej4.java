package TEMA7.Ficheros.Ej4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ej4 {
    public static void main(String[]args){
        Random rand=new Random();
        Scanner scan=new Scanner(System.in);
        List<String> nombres=new ArrayList<>();
        List<String> apellidos=new ArrayList<>();
        List <String> nombreCompletos=new ArrayList<>();

        String rutaArchivo="Documentos/usa_nombres.txt";
        String rutaArchivo2="Documentos/usa_apellidos.txt";
        try{
            BufferedReader br=new BufferedReader(new FileReader(rutaArchivo));
            BufferedReader brapellido=new BufferedReader(new FileReader(rutaArchivo2));
            String linea="";
            while((linea=br.readLine())!=null){
                nombres.add(linea);
            }
            linea="";
            while((linea=brapellido.readLine())!=null){
                apellidos.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Cuantos nombres de personas desea crear? ");
        int personas= scan.nextInt();
        for (int i=0;i<personas;i++){
            String nombre=nombres.get(rand.nextInt(nombres.size()));
            String apellido=apellidos.get(rand.nextInt(apellidos.size()));
            nombreCompletos.add(nombre+" "+apellido);
        }
        System.out.println("Ponle nombre al archivo que se ha ordenado alfabeticamente: ");
        String archivoCreado= scan.next();

        try{
            FileWriter writer= new FileWriter("Documentos/"+archivoCreado+".txt");
            for(String texto: nombreCompletos){
                writer.write(texto+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Carpeta creada con exito.");




    }
}
