package TEMA7.Ficheros;

import java.io.*;

public class EjercicioB1 {
    public static void main(String[]args){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        String rutaArchivo="Documentos/numeros.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while((linea= br.readLine())!=null){
                try{
                    int numero=Integer.parseInt(linea.trim());

                    if (numero>max){
                        max=numero;
                    }if (numero<min){
                        min=numero;
                    }
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El numero minimo es: "+min);
        System.out.println("El numero maximo es: "+max);
    }
}
