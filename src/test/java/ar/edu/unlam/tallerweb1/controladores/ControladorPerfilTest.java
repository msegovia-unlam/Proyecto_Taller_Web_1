package ar.edu.unlam.tallerweb1.controladores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ControladorPerfilTest {

	ControladorPerfil controladorPerfil;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueVerificaQueSeDirijaALaVistaDePerfil() {
		ModelAndView mav = controladorPerfil.irAVistaPerfil();
	}

}
