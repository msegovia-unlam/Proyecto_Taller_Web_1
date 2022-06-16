package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);
	void guardarusuario(Usuario usuario);
	Usuario buscarPorId(Long id);
	List<Usuario> getAllUsers();
}
