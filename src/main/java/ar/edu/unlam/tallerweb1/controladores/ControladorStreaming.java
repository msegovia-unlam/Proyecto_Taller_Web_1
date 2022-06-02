package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.servicios.ServicioStreaming;

@Controller
public class ControladorStreaming {

	private ServicioStreaming servicioStreaming;

	@Autowired
	public ControladorStreaming(ServicioStreaming servicioStreaming){
		this.servicioStreaming = servicioStreaming;
	}
	
	@RequestMapping("/streamings")
	public ModelAndView listarStreamings() {

		ModelMap modelo = new ModelMap();
		List<Streaming> streamings = servicioStreaming.obtenerStreamings();
		modelo.put("streamings", streamings);
		return new ModelAndView("pagina", modelo);
	}

	
}
