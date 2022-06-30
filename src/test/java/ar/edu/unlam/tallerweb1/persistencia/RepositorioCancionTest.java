package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.Cancion.RepositorioCancion;

public class RepositorioCancionTest extends SpringTest{

	@Autowired
	RepositorioCancion repositorioCancion;
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueSeBusqueCancionesPorArtista() {
		Usuario u1 = crearUsuario(null, null, null);
		Usuario u2 = crearUsuario(null, null, null);
		
		Cancion cancion1 = crearCancion("cancion1", u2);
		Cancion cancion2 = crearCancion("cancion2", u1);
		Cancion cancion3 = crearCancion("cancion3", u2);
		session().save(u1);
		session().save(u2);
		session().save(cancion1);
		session().save(cancion2);
		session().save(cancion3);
		
		List<Cancion> cancionesPorArtista = repositorioCancion.getCancionesByArtista(2l);
		
		assertThat(cancionesPorArtista).hasSize(2);
		//assertEquals(2, cancionesPorArtista.size());
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueBusqueCancionesPorAlbum() {
		Album album1 = crearAlbum(null, null);
		Album album2 = crearAlbum(null, null);
		session().save(album1);
		session().save(album2);
		Cancion cancion1 = crearCancion(null, null);
		cancion1.setAlbum(album2);
		Cancion cancion2 = crearCancion(null, null);
		cancion2.setAlbum(album1);
		Cancion cancion3 = crearCancion(null, null);
		cancion1.setAlbum(album2);
		session().save(cancion3);
		session().save(cancion2);
		session().save(cancion1);
		List<Cancion> canciones = repositorioCancion.getCancionesByAlbumId(Long.valueOf(1));
		assertThat(canciones).hasSize(1);
	}
	
	private Cancion crearCancion(String nombre, Usuario artista) {
		Cancion cancion = new Cancion();
		cancion.setPathArchivo("archivo");
		cancion.setArtista(artista);
		cancion.setNombre(nombre);
		return cancion;
	}
	
	private Usuario crearUsuario(String email, String password, String nombre) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		return usuario;
	}
	
	private Album crearAlbum(String nombre,Usuario usuario) {
		Album album = new Album();
		album.setNombre(nombre);
		album.setUsuario(usuario);
		return album;
	}

}
