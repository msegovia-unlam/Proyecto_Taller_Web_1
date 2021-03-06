package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioConcierto;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private ServicioCancion servicioCancion;
	private ServicioConcierto servicioConcierto;
	private ServicioAlbum servicioAlbum;
	
	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioCancion servicioCancion,
			ServicioConcierto servicioConcierto, ServicioAlbum servicioAlbum) {
		this.servicioLogin = servicioLogin;
		this.servicioCancion = servicioCancion;
		this.servicioConcierto = servicioConcierto;
		this.servicioAlbum = servicioAlbum;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea
		// asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando
		// el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con
	// metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el
	// form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL
		// /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a esta
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("NOMBRE", usuarioBuscado.getNombre());
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			return new ModelAndView("redirect:/home");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/registrarme")
	public ModelAndView registrarUsuario(@RequestParam("nombre") String nombre, @RequestParam("email") String email,
			@RequestParam("clave") String password) {
		ModelMap model = new ModelMap();
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setPassword(password);
		servicioLogin.guardarusuario(usuario);
		model.put("mensaje", "Se registro correctamente el usuario");
		return new ModelAndView("registro-usuario", model);
	}

	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.GET)
	public ModelAndView irARegistrarUsuario() {
		return new ModelAndView("registro-usuario");
	}

	@RequestMapping(path = "/cerrar-sesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/home");
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		List<Cancion> canciones = servicioCancion.getAllCanciones();
		List<Usuario> artistas = servicioLogin.getAllUsers();
		List<Concierto> proximosConciertos = servicioConcierto.getProximosConciertos();
		List<Concierto> conciertosDelDiaDeHoy = servicioConcierto.getConciertosdeHoy();
		List<Concierto> conciertos = servicioConcierto.getAllConciertos();
		List<Album> albumes = servicioAlbum.getAllAlbunes();
		ModelMap model = new ModelMap();

		try {
			String nombreUsuario = request.getSession().getAttribute("NOMBRE").toString();
			model.put("nombreUsuario", nombreUsuario);
		} catch (Exception e) {
			model.put("error", e);
		}

		if (artistas.isEmpty()) {
			model.put("mensajeArtistas", "No se encuentran Artistas");
		} else {
			model.put("artistas", artistas);
		}

		if (canciones.isEmpty()) {
			model.put("mensajeCanciones", "No se encuentran canciones");
		} else {
			model.put("canciones", canciones);
		}
		
		if (proximosConciertos.isEmpty()) {
			model.put("mensajeProximosConciertos", "No se encuentran proximos conciertos");
		} else {
			model.put("proximosConciertos", proximosConciertos);
		}

		if (conciertosDelDiaDeHoy.isEmpty()) {
			model.put("mensajeConciertosDiaHoy", "No se encuentran conciertos para el dia de hoy");
		} else {
			model.put("conciertosDiaHoy", conciertosDelDiaDeHoy);
		}
		
		if (conciertos.isEmpty()) {
			model.put("mensajeConciertos", "No se encuentran conciertos");
		} else {
			model.put("conciertos", conciertos);
		}
		
		if (albumes.isEmpty()) {
			model.put("mensajeAlbunes", "No se encuentran albunes");
		} else {
			model.put("albunes", albumes);
		}
		return new ModelAndView("home", model);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la
	// url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/artista")
	public ModelAndView irAPerfilArtista(@RequestParam("id") Long id) {
		ModelMap model = new ModelMap();
		Usuario usuario = servicioLogin.buscarPorId(id);
		if (usuario != null) {
			String nombre = usuario.getNombre();
			List<Cancion> canciones = servicioCancion.getCancionesByArtista(usuario.getId());
			List<Album> albunes = servicioAlbum.getAlbunesByUsuarioId(id);
			model.put("nombre", nombre);
			model.put("canciones", canciones);
			model.put("albunes", albunes);
		}
		return new ModelAndView("artista", model);
	}
}
