package TEMA5.POO3.Ej5;

class PublicacionVideo implements PublicacionConReaccion, AbrirPublicacion {
    private String urlVideo;

    public PublicacionVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando video: " + urlVideo);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo video: " + urlVideo);
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentario en video: " + comentario);
    }

    @Override
    public void abrir() {
        System.out.println(" Reproduciendo video: " + urlVideo);
    }
}
