package TEMA5.POO3.Ej5;

public class Main {
    public static void main(String[] args) {
        PublicarTexto texto = new PublicarTexto("¡Hola, mundo!");
        texto.publicar();
        texto.compartir();
        texto.comentar("¡Me encanta!");

        PublicacionFoto foto = new PublicacionFoto("foto.jpg");
        foto.publicar();
        foto.compartir();
        foto.comentar("¡Qué hermosa foto!");
        foto.abrir();

        PublicacionVideo video = new PublicacionVideo("video.mp4");
        video.publicar();
        video.compartir();
        video.comentar("¡Gran video!");
        video.abrir();
    }
}
