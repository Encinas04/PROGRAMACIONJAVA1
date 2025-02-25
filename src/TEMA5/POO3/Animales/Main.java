package TEMA5.POO3.Animales;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de los animales
        Gato gato = new Gato(3, 4.5, "Persa", "Miau");
        Leon leon = new Leon(5, 190.0, "Simba");
        Pajaro pajaro = new Pajaro(1, 0.5, "Pájaro Loro");
        Perro perro = new Perro(2, 10.0, "Rex");
        Vaca vaca = new Vaca(4, 300.0, "Bovina");

        // Usar métodos de Gato
        System.out.println(gato.getNombre() + " (Edad: " + gato.getEdad() + ", Peso: " + gato.getPeso() + " kg, Raza: " + gato.getRaza() + ")");
        gato.comer();
        gato.dormir();
        gato.hacerRuid();
        gato.ronronear();

        // Usar métodos de León
        System.out.println(leon.getNombre() + " (Edad: " + leon.getEdad() + ", Peso: " + leon.getPeso() + " kg)");
        leon.comer();
        leon.dormir();
        leon.hacerRuid();
        leon.accionUnica();

        // Usar métodos de Pájaro
        System.out.println(pajaro.getNombre() + " (Edad: " + pajaro.getEdad() + ", Peso: " + pajaro.getPeso() + " kg)");
        pajaro.comer();
        pajaro.dormir();
        pajaro.hacerRuid();
        pajaro.volar();

        // Usar métodos de Perro
        System.out.println(perro.getNombre() + " (Edad: " + perro.getEdad() + ", Peso: " + perro.getPeso() + " kg)");
        perro.comer();
        perro.dormir();
        perro.hacerRuid();
        perro.moverCola();

        // Usar métodos de Vaca
        System.out.println(vaca.getNombre() + " (Edad: " + vaca.getEdad() + ", Peso: " + vaca.getPeso() + " kg)");
        vaca.comer();
        vaca.dormir();
        vaca.hacerRuid();
        vaca.accionUnica();
    }
}

