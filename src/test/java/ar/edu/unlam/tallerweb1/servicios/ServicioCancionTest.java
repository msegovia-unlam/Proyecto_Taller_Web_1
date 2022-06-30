package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.Cancion.RepositorioCancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancionImpl;

public class ServicioCancionTest {
	
	private ServicioCancion servicioCancion;
	private RepositorioCancion repositorioCancion;
	
	@Before
	public void init() {
		repositorioCancion = mock(RepositorioCancion.class);
		servicioCancion = new ServicioCancionImpl(repositorioCancion);
	}
	
	@Test 
	public void testQueVerifiqueQueSeGuardeUnaCancion() {
		Usuario usuario = crearUsuario();
		Cancion cancion = crearCancion(usuario);
		servicioCancion.guardarCancion(cancion);
		verify(repositorioCancion,times(1)).guardarCancion(cancion);
	}
	
	@Test
	public void testQueVerifiqueMetodoBuscarPorArtistaId(){
		List<Cancion> canciones = servicioCancion.getCancionesByArtista(2);
		verify(repositorioCancion,times(1)).getCancionesByArtista(2);
	}
	
	@Test
	public void testQueVerificaMetodoGetCancionByAlbumId() {
		List<Cancion> canciones = repositorioCancion.getCancionesByAlbumId(Long.valueOf(1));
		verify(repositorioCancion,times(1)).getCancionesByAlbumId(anyLong());
		when(repositorioCancion.getCancionesByAlbumId(anyLong())).thenReturn(new ArrayList<Cancion>());
	}
	
	public Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Federico");
		usuario.setEmail("fede_andrijasevich@hotmail.com");
		usuario.setPassword("password");
		return usuario;
	}
	
	public Cancion crearCancion(Usuario usuario) {
		Cancion cancion  = new Cancion();
		cancion.setPathArchivo("archivo");
		cancion.setArtista(usuario);
		cancion.setNombre("Cancion 1");
		return cancion;
	}

}
