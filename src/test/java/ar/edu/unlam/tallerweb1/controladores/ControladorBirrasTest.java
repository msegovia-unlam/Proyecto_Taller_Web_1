package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ControladorBirrasTest {

	private ControladorBirras controladorBirras;

	@Test
	public void alPedirTodasLasBirrasDevuelveLaListaCompleta() {

		// preparacion
		dadoQueExistenCervezas(10, "IPA");

		// ejecucion
		ModelAndView mav = controladorBirras.Listar("IPA");

		entoncesEcuentro((List<Cerveza>) mav.getModel().get("cervezas"), 10);
		entoncesMeLlevaALaVista("listado-cervezas", mav.getViewName());

	}

	@Test
	public void alPedirUnCasoInvalidoLlevaAPantallaDeError() {
		dadoQueExistenCervezas(10, "IPA");
		
		ModelAndView mav = controladorBirras.Listar("FRUTA");
		
		entoncesMeLlevaALaVista("listado-cervezas", mav.getViewName());
		entoncesSeRecibeMensaje("tipo inexistente", mav.getModel());
		
	}

	private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
		assertThat(model.get("msg-error")).isEqualTo(mensaje);
		
	}

	private void entoncesMeLlevaALaVista(String vistaEsperada, String vistaRecibida) {
		assertThat(vistaRecibida).isEqualTo(vistaEsperada);
	}

	private void entoncesEcuentro(List<Cerveza> lista, int cantidadEsperada) {
		assertThat(lista).hasSize(cantidadEsperada);
	}

	private void dadoQueExistenCervezas(int cantidadExistente, String tipo) {
		controladorBirras = new ControladorBirras(cantidadExistente, tipo);
	}

}
