package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;

@Service
public class ServicioAlbumImpl implements ServicioAlbum {

	private RepositorioAlbum repositorioAlbum;
	
	@Autowired
	public ServicioAlbumImpl(RepositorioAlbum repositorioAlbum) {
		this.repositorioAlbum = repositorioAlbum;
	}

	@Override
	public void guardarAlbum(Album album) {
		repositorioAlbum.guardarAlbum(album);
	}

	@Override
	public List<Album> getAllAlbunes() {
		return repositorioAlbum.getAllAlbunes();
	}

	@Override
	public List<Album> getAlbunesByUsuarioId(Long usuarioId) {
		return repositorioAlbum.getAlbunesByUsuarioId(usuarioId);
	}

	@Override
	public Album getAlbumById(Long id) {
		return repositorioAlbum.getAlbumById(id);
	}

	@Override
	public void updateAlbum(Album album) {
		repositorioAlbum.updateAlbum(album);
	}

}
