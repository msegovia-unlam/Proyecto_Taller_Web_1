package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioConcierto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class RepositorioConciertoTest extends SpringTest{
	
	@Autowired
	RepositorioConcierto repositorioConcierto;
	
	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueSeGuardeUnConcierto() {
		Usuario u1 = crearUsuario();
		Usuario u2 = crearUsuario();
		
		session().save(u2);
		session().save(u1);
		List<Usuario> usuarios = repositorioUsuario.getAllUsers();
		Concierto concierto = crearConcierto(null, null, null, usuarios);
		repositorioConcierto.guardarConcierto(concierto);
		List<Concierto> conciertos = repositorioConcierto.getAllConciertos();
		assertThat(concierto).isNotNull();
		assertThat(conciertos).hasSize(1);
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaQueBusqueTodosLosConciertos() {
		Usuario u1 = crearUsuario();
		Usuario u2 = crearUsuario();
		
		session().save(u2);
		session().save(u1);
		List<Usuario> usuarios = repositorioUsuario.getAllUsers();
		Concierto concierto1 = crearConcierto(null, null, "Casa", usuarios);
		Concierto concierto2 = crearConcierto(null, null, "Casa", usuarios);
		session().save(concierto1);
		session().save(concierto2);
		List<Concierto> conciertos = repositorioConcierto.getAllConciertos();
		assertThat(conciertos).hasSize(2);
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaBusquedaDeProximosConciertos() {
		Usuario u1 = crearUsuario();
		Usuario u2 = crearUsuario();
		
		session().save(u2);
		session().save(u1);
		List<Usuario> usuarios = repositorioUsuario.getAllUsers();
		Concierto concierto1 = crearConcierto(new Date(2022,6,17), null, "Casa", usuarios);
		Concierto concierto2 = crearConcierto(new Date(2022,6,17), null, "Casa", usuarios);
		Concierto concierto3 = crearConcierto(new Date(2022,8,16), null, "Casa", usuarios);
		Concierto concierto4 = crearConcierto(new Date(2022,7,16), null, "Casa", usuarios);
		session().save(concierto1);
		session().save(concierto2);
		session().save(concierto4);
		session().save(concierto3);
		
		List<Concierto> proximosConciertos = repositorioConcierto.getProximosConciertos();
		
		assertThat(proximosConciertos).hasSize(2);
	}
	
	@Test @Transactional @Rollback
	public void testQueVerificaBusquedaDelDiaDeHoy() {
		Usuario u1 = crearUsuario();
		Usuario u2 = crearUsuario();
		
		session().save(u2);
		session().save(u1);
		List<Usuario> usuarios = repositorioUsuario.getAllUsers();
<<<<<<< HEAD
		Concierto concierto1 = crearConcierto(new Date(2022,6,18), null, "Casa", usuarios);
		Concierto concierto2 = crearConcierto(new Date(2022,6,18), null, "Casa", usuarios);
=======
		Concierto concierto1 = crearConcierto(new Date(2022,6,17), null, "Casa", usuarios);
		Concierto concierto2 = crearConcierto(new Date(2022,6,17), null, "Casa", usuarios);
>>>>>>> fede
		Concierto concierto3 = crearConcierto(new Date(2022,8,16), null, "Casa", usuarios);

		session().save(concierto1);
		session().save(concierto2);
		session().save(concierto3);
		
		List<Concierto> proximosConciertos = repositorioConcierto.getConciertosdeHoy();
		
		assertThat(proximosConciertos).hasSize(2);
	}
	
	/*
	@Test @Transactional @Rollback
	public void testQueBusqueConciertosPorArtista() {
		Usuario u1 = crearUsuario();
		Usuario u2 = crearUsuario();
		Usuario u3 = crearUsuario();
		session().save(u2);
		session().save(u1);
		session().save(u3);
		
		Usuario usuario = repositorioUsuario.buscarPorId(1l);
		Usuario usuario2 = repositorioUsuario.buscarPorId(2l);
		Usuario usuario3 = repositorioUsuario.buscarPorId(3l);
		
		
		List<Usuario> usuariosConcierto1 = new ArrayList<Usuario>();
		usuariosConcierto1.add(usuario);
		usuariosConcierto1.add(usuario2);
		
		List<Usuario> usuariosConcierto2 = new ArrayList<Usuario>();
		usuariosConcierto2.add(usuario);
		usuariosConcierto2.add(usuario3);
		
		List<Usuario> usuariosConcierto3 = new ArrayList<Usuario>();
		usuariosConcierto1.add(usuario2);
		usuariosConcierto1.add(usuario3);


		Concierto concierto1 = crearConcierto(null, null, "Casa", usuariosConcierto1);
		Concierto concierto2 = crearConcierto(null, null, "Casa", usuariosConcierto2);
		Concierto concierto3 = crearConcierto(null, null, "Casa", usuariosConcierto3);
		
		session().save(concierto1);
		session().save(concierto3);
		session().save(concierto2);
		
		List<Concierto> conciertosPorUsuario = repositorioConcierto.getConciertosByUserId(1l);
		
		assertThat(conciertosPorUsuario).hasSize(2);
	}
	*/
	
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
