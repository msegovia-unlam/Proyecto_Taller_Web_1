package ar.edu.unlam.tallerweb1.tdd;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

//TDD by Example.... author: Ken Beck
//1 no escribir codigo productivo sin que haya un test que falle antes
//2 escribir el menor codigo productivo posible que haga que el test pase
//3 mejorar el codigo hecho
// BABY STEPS

public class CajaFuerteTest {

	Integer clave = 4657;
	CajaFuerte cajaFuerte = new CajaFuerte();
	private Integer claveErronea = 888;

	@Test
	public void AlAbrirConClaveCorrectaDeberiaAbrirse() {
		// preparacion

		cajaFuerte.cerrar(clave);

		// ejecucion
		cajaFuerte.abrir(clave);

		// validacion
		entoncesEstaAbierta(cajaFuerte);
	}

	@Test
	public void AlAbrirConClaveIncorrectaNoDeberiaAbrirse() {
		// preparacion

		cajaFuerte.cerrar(clave);

		// ejecucion
		cajaFuerte.abrir(claveErronea);

		// validacion
		entoncesEstaCerrada(cajaFuerte);

	}

	@Test
	public void alCrearUnaCajaFuerteDeberiaEstarAbierta() {
		// preparacion

		// validacion
		entoncesEstaAbierta(cajaFuerte);
	}

	@Test
	public void alCerrarUnaCajaFuerteDeberiaQuedarCerrada() {
		// preparacion

		cajaFuerte.cerrar(clave);

		// validacion
		entoncesEstaCerrada(cajaFuerte);
	}

	@Test
	public void alCambiarDeClaveDeberiaAbrirseConLaClaveNueva() {

		cajaFuerte.cerrar(clave);
		cajaFuerte.abrir(clave);
		Integer claveNueva = 9875;
		cajaFuerte.cerrar(claveNueva);
		cajaFuerte.abrir(claveNueva);

		entoncesEstaAbierta(cajaFuerte);
	}

	@Test
	public void seBloqueaDespuesDe3IntentosFallidos() {
		// preparacion
		cajaFuerte.cerrar(clave);
		cajaFuerte.abrir(claveErronea);
		cajaFuerte.abrir(claveErronea);

		// ejecucion
		cajaFuerte.abrir(claveErronea);

		// validacion
		entoncesEstaBloqueada(cajaFuerte);

	}

	@Test
	public void luegoDeAperturaExitosaSeReseteanLosIntentosFallidos() {
		// preparacion
		cajaFuerte.cerrar(clave);
		cajaFuerte.abrir(claveErronea);
		cajaFuerte.abrir(claveErronea);
		cajaFuerte.abrir(clave);
		
		// ejecucion
		cajaFuerte.cerrar(clave);
		cajaFuerte.abrir(claveErronea);

		// validacion		
		entoncesNoEstaBloqueada(cajaFuerte);
	}

	private void entoncesNoEstaBloqueada(CajaFuerte cajaFuerte2) {
				
		assertThat(cajaFuerte.estaBloqueada()).isFalse();
		
	}

	private void entoncesEstaBloqueada(CajaFuerte cajaFuerte2) {

		assertThat(cajaFuerte.estaAbierta()).isFalse();
		assertThat(cajaFuerte.estaBloqueada()).isTrue();

	}

	private void entoncesEstaCerrada(CajaFuerte cajaFuerte) {

		assertThat(cajaFuerte.estaAbierta()).isFalse();

	}

	private void entoncesEstaAbierta(CajaFuerte cajaFuerte) {

		assertThat(cajaFuerte.estaAbierta()).isTrue();

	}
}
