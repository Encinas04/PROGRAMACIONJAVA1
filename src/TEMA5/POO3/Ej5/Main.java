package TEMA5.POO3.Ej5;

public class Main {
    public static void main(String[] args) {
        PublicarTexto texto = new PublicarTexto("calcetines");
        texto.publicar();
        texto.compartir();
        texto.comentar("Me encanta");

        PublicacionFoto foto = new PublicacionFoto("foto.jpg");
        foto.publicar();
        foto.compartir();
        foto.comentar("Foton");
        foto.abrir();

        PublicacionVideo video = new PublicacionVideo("video.mp4");
        video.publicar();
        video.compartir();
        video.comentar("Gran video");
        video.abrir();
    }
}
