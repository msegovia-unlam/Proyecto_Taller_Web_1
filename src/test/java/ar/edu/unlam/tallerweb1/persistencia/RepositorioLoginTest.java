package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class RepositorioLoginTest extends SpringTest{

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueBusqueTodosLosArtistas() {
		Usuario u1 = crearUsuario(null, null, null);
		Usuario u2 = crearUsuario(null, null, null);
		Usuario u3 = crearUsuario(null, null, null);
		
		session().save(u3);
		session().save(u2);
		session().save(u1);
		
		List<Usuario> usuarios = repositorioUsuario.getAllUsers();
		
		assertThat(usuarios).hasSize(3);
	}
	
	private Usuario crearUsuario(String email, String password, String nombre) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		return usuario;
	}

}
