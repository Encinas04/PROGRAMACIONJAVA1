package TEMA7.Ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ej5 {
    public static void main(String[]args) {
        List<String> nombres=new ArrayList<>();
        String rutaArchivo="Documentos/diccionario.txt";
        File dir = new File("Documentos/Diccionario");
       if (dir.mkdir()){
           System.out.println("Carpeta creada con exito ");
       }else {
           System.out.println("No se ha podido crear el archvo");
       }
       try {
           String linea="";
           BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
           while((linea=br.readLine())!=null){
               nombres.add(linea);
           }
           Map<Character, FileWriter> escritorMap =new HashMap<>();

           for (char letra='a';letra<='z';letra++){
               String ruta="Documentos/Diccionario/"+letra+".txt";
               FileWriter writer= new FileWriter(ruta);
               escritorMap.put(letra, writer);
           }
           for (String palabra:nombres){
               if (!palabra.isEmpty()){
                   char inicial=palabra.charAt(0);
                   if (escritorMap.containsKey(inicial)){
                       escritorMap.get(inicial).write(palabra+"\n");
                   }
               }
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }


    }
}
