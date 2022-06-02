package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class ControladorSimpleTest {
	
	private ControladorSimple controladorSimple = new ControladorSimple();

	@Test
	public void irAPagina() {
		
		cuandoInvocoAccion();		
		entoncesMeLlevaADeterminadaVista("pagina");
	}

	private void entoncesMeLlevaADeterminadaVista(String string) {
		
	}

	private void cuandoInvocoAccion() {
		controladorSimple.irAPagina().getViewName();
	}

}
