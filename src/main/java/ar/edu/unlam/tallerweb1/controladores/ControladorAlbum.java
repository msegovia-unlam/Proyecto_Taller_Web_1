package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

@Controller
public class ControladorAlbum {

	private ServicioAlbum servicioAlbum;
	private ServicioLogin servicioLogin;
	private ServicioCancion servicioCancion;
	
	@Autowired
	public ControladorAlbum(ServicioAlbum servicioAlbum, ServicioLogin servicioLogin, ServicioCancion servicioCancion) {
		this.servicioAlbum = servicioAlbum;
		this.servicioLogin = servicioLogin;
		this.servicioCancion = servicioCancion;
	}


	@RequestMapping(path = "/lista-albunes", method = RequestMethod.GET)
	public ModelAndView irAListaDeAlbunes(HttpServletRequest request){
		ModelMap model = new ModelMap();
		try {
			String nombreUsuario = request.getSession().getAttribute("NOMBRE").toString();
			model.put("nombreUsuario", nombreUsuario);
		} catch (Exception e) {
			model.put("error", e);
		}
		
		List<Album> albunes = servicioAlbum.getAllAlbunes();
		if(!albunes.isEmpty()) {
			model.put("albunes", albunes);
		}else {
			model.put("mensajeAlbunes", "No existen albunes");
		}
		return new ModelAndView("lista-albunes",model);
	}


	@RequestMapping(path = "/crear-album",method = RequestMethod.GET)
	public ModelAndView irACrearAlbun(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try {
			String nombreUsuario = request.getSession().getAttribute("NOMBRE").toString();
			model.put("nombreUsuario", nombreUsuario);
		} catch (Exception e) {
			model.put("error", e);
		}
		return new ModelAndView("crear-album",model);
	}


	@RequestMapping(path="/save-album")
	public ModelAndView saveAlbum(@RequestParam("nombre") String nombre, HttpServletRequest request, RedirectAttributes attributes) {
		ModelMap model = new ModelMap();
		try {
			Usuario usuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("ID"));
			Album album = new Album();
			album.setNombre(nombre);
			album.setUsuario(usuario);
			servicioAlbum.guardarAlbum(album);
			attributes.addFlashAttribute("mensaje", "Se guardo correctamente el album");
		}catch (Exception e) {
			attributes.addFlashAttribute("error", "Error al guardar el album");
		}
			
		return new ModelAndView("redirect:/crear-album");
	}
	
	@RequestMapping(path = "/album")
	public ModelAndView irAAlbum(@RequestParam("id") Long id) {
		ModelMap model = new ModelMap();
		Album album = servicioAlbum.getAlbumById(id);
		List<Cancion> canciones = servicioCancion.getCancionByAlbumId(id);
		model.put("album", album);
		model.put("canciones", canciones);
		return new ModelAndView("album",model);
	}
	
	@RequestMapping("/agregar-canciones-album")
	public ModelAndView agregarCanciones(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try {
			List<Cancion> canciones = servicioCancion.getCancionesByArtista((long) request.getSession().getAttribute("ID"));
			Album album = servicioAlbum.getAlbumById(id);
			model.put("canciones", canciones);
			model.put("album", album);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("agregar-canciones-album",model);
	}
	
	@RequestMapping(path = "/add-canciones", method = RequestMethod.POST)
	public ModelAndView addCanciones(@RequestParam("canciones") String[] canciones,
			@RequestParam("id") Long id
			) {
		Album album = servicioAlbum.getAlbumById(Long.valueOf(id).longValue());
		List<Cancion> cancionesEnAlbum = new ArrayList<Cancion>();
		for(String cancion: canciones) {
			cancionesEnAlbum.add(servicioCancion.getCancionbyID(Long.valueOf(cancion).longValue()));
		}
		for(Cancion cancion:cancionesEnAlbum) {
			cancion.setAlbum(album);
			servicioCancion.updateCancion(cancion);
		}
		
		return new ModelAndView("redirect:/lista-albunes");
	}
	
}
