package TEMA5.EXCEPCIONES;

import java.util.Random;

public class ej4 {
    public static void main(String[]args){
        Random rand=new Random();
        int[] array=new int[rand.nextInt(100)+1];
        for (int i=0;i<array.length;i++){
            int numRand= rand.nextInt(10)+1;
        }
        System.out.println("Di una posicion del vector ");
    }
}
