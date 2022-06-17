package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="streaming")
public class Streaming {

	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "artista")	
	private String artista;
	
	@Column(name = "enlace")
	private String url;
	
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		artista = artista;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
