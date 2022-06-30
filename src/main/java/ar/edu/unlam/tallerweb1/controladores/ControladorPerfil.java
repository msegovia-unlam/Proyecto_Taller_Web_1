package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

@Controller
public class ControladorPerfil {

	private ServicioAlbum servicioAlbum;
	private ServicioCancion servicioCancion;
	
	@Autowired
	public ControladorPerfil(ServicioAlbum servicioAlbum, ServicioCancion servicioCancion) {
		this.servicioAlbum = servicioAlbum;
		this.servicioCancion = servicioCancion;
	}

	@RequestMapping(path="/perfil", method = RequestMethod.GET)
	public ModelAndView irAVistaPerfil(HttpServletRequest request) {
		
		ModelMap model = new ModelMap();
		try {
			Long idUsuario = (Long) request.getSession().getAttribute("ID");
			List<Album> albunesByUser = servicioAlbum.getAlbunesByUsuarioId(idUsuario);
			List<Cancion> cancionesByUser = servicioCancion.getCancionesByArtista(idUsuario);
			if(!albunesByUser.isEmpty()) {
				model.put("albunes", albunesByUser);
			}else {
				model.put("mensajeAlbunes", "Este usuario no tiene albunes");
			}
			
			if(!albunesByUser.isEmpty()) {
				model.put("canciones", cancionesByUser);
			}else {
				model.put("mensajeCanciones", "Este usuario no tiene canciones");
			}

		}catch (Exception e) {
		
		}
		return new ModelAndView("perfil", model);
	}
	
	
	
}
