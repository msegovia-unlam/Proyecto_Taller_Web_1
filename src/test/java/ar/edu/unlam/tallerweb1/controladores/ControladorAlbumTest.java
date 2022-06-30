package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorAlbumTest {

	private ControladorAlbum controladorAlbum;
	private ServicioAlbum servicioAlbum;
	private ServicioLogin servicioLogin;
	private HttpServletRequest request;
	private RedirectAttributes redirectAttributes;
	
	@Before
	public void setUp() throws Exception {
		redirectAttributes = mock(RedirectAttributes.class);
		request = mock(HttpServletRequest.class);
		request.setAttribute("ID", 1);
		servicioAlbum = mock(ServicioAlbum.class);
		servicioLogin = mock(ServicioLogin.class);
		controladorAlbum = new ControladorAlbum(servicioAlbum, servicioLogin);
	}

	@Test
	public void testQueVerificaListaDeAlbunes() {
		ModelAndView mav = controladorAlbum.irAListaDeAlbunes(request);
		assertThat(mav.getViewName()).isEqualTo("lista-albunes");
	}
	
	@Test
	public void testQueVerificaQueSeDirijaAVistaListaAlbunesConMensajeDeError() {
		ModelAndView mav = controladorAlbum.irAListaDeAlbunes(request);
		List<Album> albunes = servicioAlbum.getAllAlbunes();
		when(servicioAlbum.getAllAlbunes()).thenReturn(albunes);
		assertThat(albunes).hasSize(0);
		assertThat(mav.getViewName()).isEqualTo("lista-albunes");
		assertThat(mav.getModel().get("mensajeAlbunes")).isEqualTo("No existen albunes");
	}
	
	@Test
	public void testQueVerificaQueSeDirijaALaVistaDeCrearAlbun() {
		ModelAndView mav = controladorAlbum.irACrearAlbun(request);
		assertThat(mav.getViewName()).isEqualTo("crear-album");
	}
	
	@Test
	public void testQueVerificaQueSeDirijaAVistaDeGuardarAlbum() {
		
		ModelAndView mav = controladorAlbum.saveAlbum("nombre Album", request, redirectAttributes);
		when(servicioLogin.buscarPorId(anyLong())).thenReturn(new Usuario());
		assertThat(mav.getViewName()).isEqualTo("redirect:/crear-album");
	}
}
