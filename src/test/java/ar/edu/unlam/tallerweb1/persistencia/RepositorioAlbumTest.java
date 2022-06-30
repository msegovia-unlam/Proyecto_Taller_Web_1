package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;

public class RepositorioAlbumTest extends SpringTest{
	
	@Autowired
	private RepositorioAlbum repositorioAlbum;
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueSeAgregueUnAlbum() {
		Album album1 = crearAlbum(null, null, null);
		repositorioAlbum.guardarAlbum(album1);
		List<Album> albunes= repositorioAlbum.getAllAlbunes();
		assertThat(albunes).hasSize(1);
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueSeEncuentrenTodosLosAlbunes() {
		Album album1 = crearAlbum(null, null, null);
		Album album2 = crearAlbum(null, null, null);
		session().save(album2);
		session().save(album1);
		List<Album> albunes= repositorioAlbum.getAllAlbunes();
		assertThat(albunes).hasSize(2);
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueBusqueAlbunsPorUsuario() {
		Usuario usuario1 = crearUsuario(null, null, null);
		Usuario usuario2 = crearUsuario(null, null, null);
		session().save(usuario1);
		session().save(usuario2);
		Album album1 = crearAlbum(null, usuario1, null);
		Album album2 = crearAlbum(null, usuario2, null);
		Album album3 = crearAlbum(null, usuario1, null);
		Album album4 = crearAlbum(null, usuario1, null);
		session().save(album2);
		session().save(album1);
		session().save(album3);
		session().save(album4);
		List<Album> albunesPorUsuario = repositorioAlbum.getAlbunesByUsuarioId(1l);
		assertThat(albunesPorUsuario).hasSize(3);
	}
	
	private Usuario crearUsuario(String email, String nombre, String password) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		return usuario;
	}
	
	private Cancion crearCancion(Usuario usuario, String nombre, String path) {
		Cancion cancion = new Cancion();
		cancion.setArtista(usuario);
		cancion.setNombre(nombre);
		cancion.setPathArchivo(path);
		return cancion;
	}
	
	private Album crearAlbum(String nombre,Usuario usuario, List<Cancion> canciones) {
		Album album = new Album();
		album.setNombre(nombre);
		album.setUsuario(usuario);
		album.setCanciones(canciones);
		return album;
	}

}
