package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;

public class ServicioAlbumTest {

	private ServicioAlbum servicioAlbum; 
	private RepositorioAlbum repositorioAlbum;
	
	@Before
	public void setUp() throws Exception {
		repositorioAlbum = mock(RepositorioAlbum.class);
		servicioAlbum = new ServicioAlbumImpl(repositorioAlbum);
	}

	@Test
	public void testQueVerificaMetodoGuardarAlbum() {
		Album album = crearAlbum(null, null, null);
		servicioAlbum.guardarAlbum(album);
		verify(repositorioAlbum,times(1)).guardarAlbum(album);
	}

	@Test
	public void testQueVerificaMetodoGetAllAlbunes() {
		List<Album> albunes = servicioAlbum.getAllAlbunes();
		verify(repositorioAlbum,times(1)).getAllAlbunes();
		when(repositorioAlbum.getAllAlbunes()).thenReturn(albunes);
	}
	
	@Test
	public void testQueVerificaMetodoGetAlbunesByUsuario() {
		List<Album> albunesByUsuario = servicioAlbum.getAlbunesByUsuarioId(Long.valueOf(1));
		when(repositorioAlbum.getAlbunesByUsuarioId(anyLong())).thenReturn(albunesByUsuario);
		verify(repositorioAlbum,times(1)).getAlbunesByUsuarioId(Long.valueOf(1));
	}
	
	@Test
	public void testQueVerificaMetodoGetAlbumById() {
		Album album = servicioAlbum.getAlbumById(Long.valueOf(1));
		verify(repositorioAlbum,times(1)).getAlbumById(anyLong());
		when(repositorioAlbum.getAlbumById(anyLong())).thenReturn(new Album());
	}
	
	private Album crearAlbum(String nombre,Usuario usuario, List<Cancion> canciones) {
		Album album = new Album();
		album.setNombre(nombre);
		album.setUsuario(usuario);
		return album;
	}
	
}
