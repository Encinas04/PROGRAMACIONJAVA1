package TEMA5.POO3.Figuras;

public class PruebaFiguras {
    public static void main(String[] args) {
        Figura2D cuadrado = new Cuadrado(5);
        Figura2D rectangulo = new Rectangulo(4, 6);
        Figura2D triangulo = new Triangulo(5, 4, 5, 5, 5);
        Figura2D circulo = new Circulo(3);

        System.out.println(cuadrado);
        System.out.println(rectangulo);
        System.out.println(triangulo);
        System.out.println(circulo);
    }
}