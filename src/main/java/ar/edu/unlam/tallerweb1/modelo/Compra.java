package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	private List<Streaming> streamings;
	
	@ManyToMany
	private List<Cancion> canciones;
	
	@ManyToMany
	private List<Album> albunes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Streaming> getStreamings() {
		return streamings;
	}

	public void setStreamings(List<Streaming> streamings) {
		this.streamings = streamings;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public List<Album> getAlbunes() {
		return albunes;
	}

	public void setAlbunes(List<Album> albunes) {
		this.albunes = albunes;
	}
	
	
}
