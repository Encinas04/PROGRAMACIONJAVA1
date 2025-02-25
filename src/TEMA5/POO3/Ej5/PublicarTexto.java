package TEMA5.POO3.Ej5;

public class PublicarTexto implements PublicacionConReaccion {
    private String texto;

    public PublicarTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando texto: " + texto);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo texto: " + texto);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentario en texto: " + comentario);
    }
}
