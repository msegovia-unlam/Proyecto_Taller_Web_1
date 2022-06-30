package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Album;

public interface RepositorioAlbum {

	void guardarAlbum(Album album);

	List<Album> getAllAlbunes();

	List<Album> getAlbunesByUsuarioId(Long idUsuario);

	Album getAlbumById(Long valueOf);
	
	void updateAlbum(Album album);
}
