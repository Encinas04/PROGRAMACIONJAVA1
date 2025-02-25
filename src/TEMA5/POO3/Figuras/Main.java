package TEMA5.POO3.Figuras;

public class Main {
    public static void main(String[] args) {
        Figura2D cuadrado = new Cuadrado(4);
        Figura2D rectangulo = new Rectangulo(4, 6);
        Figura2D triangulo = new Triangulo(3, 4, 3, 4, 5);
        Figura2D circulo = new Circulo(5);

        cuadrado.area();
        cuadrado.perimetro();

        rectangulo.area();
        rectangulo.perimetro();

        triangulo.area();
        triangulo.perimetro();

        circulo.area();
        circulo.perimetro();
    }
}
