package TEMA5.POO3.Ej5;

class PublicacionFoto implements PublicacionConReaccion, AbrirPublicacion {
    private String urlFoto;

    public PublicacionFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public void publicar() {
        System.out.println(" Publicando foto: " + urlFoto);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo foto: " + urlFoto);
    }

    @Override
    public void comentar(String comentario) {
        System.out.println("Comentario en foto: " + comentario);
    }

    @Override
    public void abrir() {
        System.out.println("Abriendo foto: " + urlFoto);
    }
}
