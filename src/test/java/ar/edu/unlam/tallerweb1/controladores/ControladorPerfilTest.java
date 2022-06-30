package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

public class ControladorPerfilTest {

	private ControladorPerfil controladorPerfil;
	private ServicioAlbum servicioAlbum;
	private ServicioCancion servicioCancion;
	private HttpServletRequest request;
	
	@Before
	public void setUp() throws Exception {
		servicioAlbum = mock(ServicioAlbum.class);
		servicioCancion = mock(ServicioCancion.class);
		controladorPerfil = new ControladorPerfil(servicioAlbum, servicioCancion);
		request = mock(HttpServletRequest.class);
	}

	@Test
	public void testQueVerificaQueSeDirijaALaVistaDePerfil() {
		ModelAndView mav = controladorPerfil.irAVistaPerfil(request);
		when(servicioAlbum.getAlbunesByUsuarioId(anyLong())).thenReturn(anyListOf(Album.class));
		assertThat(mav.getViewName()).isEqualTo("perfil");
	}

}
