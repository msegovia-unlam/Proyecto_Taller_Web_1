package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class ServicioLoginTest {

	private RepositorioUsuario repositorioUsuario;
	private ServicioLogin servicioLogin;
	
	@Before
	public void init() {
		repositorioUsuario = mock(RepositorioUsuario.class);
		servicioLogin = new ServicioLoginImpl(repositorioUsuario);
	}
	
	@Test
	public void testQueVerificaMetodoGetAllUsers() {
		List<Usuario> usuarios = servicioLogin.getAllUsers();
		verify(repositorioUsuario,times(1)).getAllUsers();
	}

}
