package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Album;

public interface ServicioAlbum {

	void guardarAlbum(Album album);

	List<Album> getAllAlbunes();

	List<Album> getAlbunesByUsuarioId(Long usuarioId);

	Album getAlbumById(Long id);
	void updateAlbum(Album album);

}
