package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioConcierto;

public class ServicioConciertoTest {

	private ServicioConcierto servicioConcierto;
	private RepositorioConcierto repositorioConcierto;
	
	@Before
	public void init() {
		repositorioConcierto = mock(RepositorioConcierto.class);
		servicioConcierto = new ServicioConciertoImpl(repositorioConcierto);
	}
	
	@Test
	public void testQueVerificaMetodoGuardarConcierto() {
		Concierto concierto = crearConcierto(null, null, null, null);
		servicioConcierto.guardarConcierto(concierto);
		verify(repositorioConcierto,times(1)).guardarConcierto(any(Concierto.class));
	}
	
	@Test
	public void testQueVerificaMetodoGetAllConciertos() {
		Concierto concierto1 = crearConcierto(null, null, null, null);
		Concierto concierto2 = crearConcierto(null, null, null, null);
		List<Concierto> conciertos = servicioConcierto.getAllConciertos();
		verify(repositorioConcierto,times(1)).getAllConciertos();
		
	}
	
	@Test
	public void testQueVerificaMetodoGetProximosConciertos() {
		List<Concierto> conciertos = servicioConcierto.getProximosConciertos();
		verify(repositorioConcierto,times(1)).getProximosConciertos();
		
	}
	
	@Test
	public void testQueVerificaMetodoGetConciertosDelDiaDeHoy() {
		List<Concierto> conciertos = servicioConcierto.getConciertosdeHoy();
		verify(repositorioConcierto,times(1)).getConciertosdeHoy();
		
	}
	
	public Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Federico");
		usuario.setEmail("fede_andrijasevich@hotmail.com");
		usuario.setPassword("password");
		return usuario;
	}
	
	private Concierto crearConcierto(Date fecha, String hora, String lugar, List<Usuario> usuarios) {
		Concierto concierto = new Concierto();
		concierto.setFecha(fecha);
		concierto.setHora(hora);
		concierto.setLugar(lugar);
		concierto.setUsuarios(usuarios);
		return concierto;
	}

}
