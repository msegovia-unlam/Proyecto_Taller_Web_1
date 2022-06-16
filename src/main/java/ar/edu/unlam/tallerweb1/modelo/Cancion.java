package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToOne
	private Usuario artista;
	
	private String pathArchivo;
	
	private Long reproducciones;
	
	private String album;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario getArtista() {
		return artista;
	}
	
	public void setArtista(Usuario artista) {
		this.artista = artista;
	}
	
	
    public Long getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(Long reproducciones) {
		this.reproducciones = reproducciones;
	}

	
	
	public String getPathArchivo() {
		return pathArchivo;
	}

	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Cancion(){}
    
    public Cancion(String nombreCancion, String pathArchivo) {
        this.nombre = nombreCancion;
        this.pathArchivo = pathArchivo;
    }

}

