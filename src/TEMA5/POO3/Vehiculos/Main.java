package TEMA5.POO3.Vehiculos;

public class Main {
    public static void main(String[] args) {
        Turismos turismo = new Turismos(4, "Rojo", "Gasolina", 5, "ola");
        Camiones camion = new Camiones(2, "Azul", "Diesel", 12000, true);
        Ciclomotores ciclomotor = new Ciclomotores(0, "Negro", "Gasolina", 110);

        System.out.println("Turismo: " + turismo.getColor() + ", " + turismo.getCombustible() + ", Plazas: " + turismo.getNumeroPlazas() + ", Uso: " + turismo.getTipoUso());
        System.out.println("Camion: " + camion.getColor() + ", " + camion.getCombustible() + ", PMA: " + camion.getPesoMaximo() + ", Mercancía peligrosa: " + camion.isMercanciaPeligrosa());
        System.out.println("Ciclomotor: " + ciclomotor.getColor() + ", " + ciclomotor.getCombustible() + ", Cilindrada: " + ciclomotor.getCilindrada() + ", Necesita carnet: " + ciclomotor.necesitaCarnet());
    }
}
