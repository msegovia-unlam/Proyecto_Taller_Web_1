package ar.edu.unlam.tallerweb1.modelo;

public class Cancion {
    private String nombreCancion;
    private String url;

    public Cancion(String nombreCancion, String url) {

        this.setNombreCancion(nombreCancion);
        this.setUrl(url);

    }


    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
