package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioConcierto;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

public class ControladorLoginTest {

	private ControladorLogin controladorLogin;
	private ServicioLogin servicioLogin;
	private ServicioCancion servicioCancion;
	private HttpServletRequest servletRequest;
	private ServicioConcierto servicioConcierto;
	private ServicioAlbum servicioAlbum;
	
	@Before
	public void init() {
		servletRequest = mock(HttpServletRequest.class);
		servicioLogin = mock(ServicioLogin.class);
		servicioCancion = mock(ServicioCancion.class);
		servicioConcierto = mock(ServicioConcierto.class);
		servicioAlbum = mock(ServicioAlbum.class);
		controladorLogin = new ControladorLogin(servicioLogin, servicioCancion,servicioConcierto,servicioAlbum);
	}
	
	@Test
	public void testQueVerificaQueLleveAlPerfilDelArtista() {
		ModelAndView mav = controladorLogin.irAPerfilArtista(anyLong());
		when(servicioLogin.buscarPorId(Long.valueOf(1))).thenReturn(new Usuario());
		when(servicioCancion.getCancionesByArtista(anyLong())).thenReturn(new ArrayList<Cancion>());
		assertThat(mav.getViewName()).isEqualTo("artista");
	}

	@Test
	public void testQueRegreseAHomeConMensajeQueNoExistenArtistas() {
		ModelAndView mav = controladorLogin.irAHome(servletRequest);
		List<Usuario> usuarios = servicioLogin.getAllUsers();
		when(servicioLogin.getAllUsers()).thenReturn(new ArrayList<Usuario>());
		assertThat(usuarios).hasSize(0);
		assertThat(mav.getViewName()).isEqualTo("home");
		assertThat(mav.getModel().get("mensajeArtistas")).isEqualTo("No se encuentran Artistas");
	}
	
	@Test
	public void testQueRegreseAHomeConMensajeQueNoExistenCanciones() {
		ModelAndView mav = controladorLogin.irAHome(servletRequest);
		List<Cancion> canciones = servicioCancion.getAllCanciones();
		when(servicioCancion.getAllCanciones()).thenReturn(new ArrayList<Cancion>());
		assertThat(canciones).hasSize(0);
		assertThat(mav.getViewName()).isEqualTo("home");
		assertThat(mav.getModel().get("mensajeCanciones")).isEqualTo("No se encuentran canciones");
	}
	
	@Test
	public void testQueRegreseAHomeConMensajeQueNoExistenProximosConciertos() {
		ModelAndView mav = controladorLogin.irAHome(servletRequest);
		List<Concierto> conciertos = servicioConcierto.getProximosConciertos();
		when(servicioConcierto.getProximosConciertos()).thenReturn(new ArrayList<Concierto>());
		assertThat(conciertos).hasSize(0);
		assertThat(mav.getViewName()).isEqualTo("home");
		assertThat(mav.getModel().get("mensajeProximosConciertos")).isEqualTo("No se encuentran proximos conciertos");
	}
	
	@Test
	public void testQueRegreseAHomeConMensajeQueNoExistenConciertosDelDiaDeHoy() {
		ModelAndView mav = controladorLogin.irAHome(servletRequest);
		List<Concierto> conciertos = servicioConcierto.getConciertosdeHoy();
		when(servicioConcierto.getConciertosdeHoy()).thenReturn(new ArrayList<Concierto>());
		assertThat(conciertos).hasSize(0);
		assertThat(mav.getViewName()).isEqualTo("home");
		assertThat(mav.getModel().get("mensajeConciertosDiaHoy")).isEqualTo("No se encuentran conciertos para el dia de hoy");
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
