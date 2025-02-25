package TEMA5.POO3.Figuras;

public class Rectangulo extends Figura2D {
    private double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void area() {
        System.out.println("Área: " + (base * altura));
    }

    @Override
    public void perimetro() {
        System.out.println("Perímetro: " + (2 * (base + altura)));
    }
}
