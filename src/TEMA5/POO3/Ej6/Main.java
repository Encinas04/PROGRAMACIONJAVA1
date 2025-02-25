package TEMA5.POO3.Ej6;

public class Main {
    public static void main(String[] args) {
        Ataque ataqueMagico = new AtaqueMagico(5.0, 20.0);
        ataqueMagico.lanzar();
        ataqueMagico.coste();
        ataqueMagico.danyoInflingido();

        Ataque ataqueFisico = new AtaqueFisico(3.0, 15.0);
        ataqueFisico.lanzar();
        ataqueFisico.coste();
        ataqueFisico.danyoInflingido();

        Ataque ataqueMagicoYFisico = new AtaqueMagicoFisico(4.0, 2.0, 10.0, 8.0);
        ataqueMagicoYFisico.lanzar();
        ataqueMagicoYFisico.coste();
        ataqueMagicoYFisico.danyoInflingido();

        AtaqueAvanzado ataqueBolaFuego = new AtaqueBolaFuego(10.0, 2.0, 25.0);
        ataqueBolaFuego.lanzar();
        System.out.println("Coste del ataque: " + ataqueBolaFuego.coste());
        double[] danyoBolaFuego = ataqueBolaFuego.danyoInfligido();
        System.out.println("Daño infligido (Mágico, Físico): " + danyoBolaFuego[0] + ", " + danyoBolaFuego[1]);

        AtaqueAvanzado ataqueEspadazo = new AtaqueEspadazo(5.0, 15.0);
        ataqueEspadazo.lanzar();
        System.out.println("Coste del ataque: " + ataqueEspadazo.coste());
        double[] danyoEspadazo = ataqueEspadazo.danyoInfligido();
        System.out.println("Daño infligido (Mágico, Físico): " + danyoEspadazo[0] + ", " + danyoEspadazo[1]);

        AtaqueAvanzado ataqueEspadazoEncantado = new AtaqueEspadazoEncantado(8.0, 3.0, 20.0, 12.0);
        ataqueEspadazoEncantado.lanzar();
        System.out.println("Coste del ataque: " + ataqueEspadazoEncantado.coste());
        double[] danyoEspadazoEncantado = ataqueEspadazoEncantado.danyoInfligido();
        System.out.println("Daño infligido (Mágico, Físico): " + danyoEspadazoEncantado[0] + ", " + danyoEspadazoEncantado[1]);
    }
}