package TEMA7.Serializacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ej2 {
    public static void main(String[]src){
        List<String> texto=new ArrayList<>();
        String rutaArchivo="usuario.txt";
        try{
            BufferedReader br=new BufferedReader(new FileReader(rutaArchivo));
            String linea="";
            while((linea=br.readLine())!=null){
                texto.add(linea);
            }

            for (String linea1: texto){
                System.out.println(linea1);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
