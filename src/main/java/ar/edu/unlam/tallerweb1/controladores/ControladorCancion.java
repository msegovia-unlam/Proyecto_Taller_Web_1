package ar.edu.unlam.tallerweb1.controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import ar.edu.unlam.tallerweb1.utils.ArchivosUtils;

@Controller
public class ControladorCancion {
	private ServicioCancion servicioCancion;
	private ServicioLogin servicioLogin;
	private String pathArchivoCancion;

	@Autowired
	public ControladorCancion(ServicioCancion servicioCancion, ServicioLogin servicioLogin) {
		this.servicioCancion = servicioCancion;
		this.servicioLogin = servicioLogin;
		pathArchivoCancion = "C:\\var\\proyectoTallerWeb\\adjuntosCanciones\\idArtista\\";
	}

	@RequestMapping(path = "/agregar-cancion", method = RequestMethod.GET)
	public ModelAndView agregarCancion(HttpServletRequest request) {
		String nombreArtista = request.getSession().getAttribute("NOMBRE").toString();
		ModelMap model = new ModelMap();
		model.put("nombreArtista", nombreArtista);
		return new ModelAndView("agregar-cancion", model);
	}

	@RequestMapping(path = "/saveCancion", method = RequestMethod.POST)
	public ModelAndView saveCancion(HttpServletRequest request, RedirectAttributes attributes,
			@RequestParam("archivo") MultipartFile archivo, @RequestParam("nombre") String nombre,
			@RequestParam("album") String album) throws IOException {
		ModelMap model = new ModelMap();
		String pathArchivo = pathArchivoCancion.replace("idArtista",
			request.getSession().getAttribute("ID").toString());
		String pathArchivoGuardado = ArchivosUtils.subirArchivo(archivo, pathArchivo);
		Usuario artistaGuardado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("ID"));
		Cancion cancionAGuardar = new Cancion();
		cancionAGuardar.setNombre(nombre);
		cancionAGuardar.setArtista(artistaGuardado);
		cancionAGuardar.setArchivo(pathArchivoGuardado);
		servicioCancion.guardarCancion(cancionAGuardar);
		attributes.addFlashAttribute("mensaje", "Se guardo correctamente la cancion");
		return new ModelAndView("redirect:/agregar-cancion");
	}

	@RequestMapping(path = "/lista-canciones", method = RequestMethod.GET)
	public ModelAndView listaCanciones(HttpServletRequest request,
			@RequestParam(value = "busqueda", required = false) String busqueda) {
		ModelMap model = new ModelMap();
		try {
			String nombreUsuario = request.getSession().getAttribute("NOMBRE").toString();
			model.put("nombreUsuario", nombreUsuario);
		} catch (Exception e) {
			model.put("error", e);
		}
		List<Cancion> canciones;
		if (busqueda == null || busqueda == "") {
			canciones = servicioCancion.getAllCanciones();
		} else {
			canciones = servicioCancion.buscarCancionPorNombre(busqueda);
		}
		if (canciones.isEmpty()) {
			String mensaje = "No existen canciones creadas";
			model.put("mensaje", mensaje);
		}
		model.put("canciones", canciones);
		return new ModelAndView("lista-canciones", model);
	}

}
