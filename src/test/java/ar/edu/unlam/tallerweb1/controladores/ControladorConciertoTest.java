package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioConcierto;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorConciertoTest {

	ControladorConcierto controlador;
	ServicioLogin servicioLogin;
	ServicioConcierto servicioConcierto;
	
	@Before
	public void init() {
		servicioConcierto = mock(ServicioConcierto.class);
		servicioLogin = mock(ServicioLogin.class);
		controlador = new ControladorConcierto(servicioConcierto,servicioLogin);
	}
	
	@Test
	public void testQueVerificaQueLleveAVistaDeAgregarConcierto() {
		ModelAndView mav = controlador.irACrearConcierto();
		assertThat(mav.getViewName()).isEqualTo("agregar-concierto");
	}
	
	@Test
	public void testQuellevaAListaDeConciertosConMensajeQueNoExistenProximosConciertos() {
		ModelAndView mav = controlador.listaConciertos();
		assertThat(mav.getViewName()).isEqualTo("lista-conciertos");
		assertThat(mav.getModel().get("mensajeProximosConciertos")).isEqualTo("No se encuentran proximos conciertos");
	}
	
	@Test
	public void testQuellevaAListaDeConciertosConMensajeQueNoExistenConciertosDelDiaDeHoy() {
		ModelAndView mav = controlador.listaConciertos();
		assertThat(mav.getViewName()).isEqualTo("lista-conciertos");
		assertThat(mav.getModel().get("mensajeConciertosDiaHoy")).isEqualTo("No se encuentran conciertos para el dia de hoy");
	}
	
	@Test
	public void testQuellevaAListaDeConciertosConMensajeQueNoExistenConciertos() {
		ModelAndView mav = controlador.listaConciertos();
		assertThat(mav.getViewName()).isEqualTo("lista-conciertos");
		assertThat(mav.getModel().get("mensajeConciertos")).isEqualTo("No se encuentran conciertos");
	}
}
