package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.servicios.ServicioStreaming;

@Controller
public class ControladorStreaming1 {

	private ServicioStreaming servicioStreaming;

	@Autowired
	public ControladorStreaming1(ServicioStreaming servicioStreaming){
		this.servicioStreaming = servicioStreaming;
	}
	
	@RequestMapping("/streamings")
	public ModelAndView listarStreamings() {

		ModelMap modelo = new ModelMap();
		List<Streaming> streamings = servicioStreaming.obtenerStreamings();
		
		if(streamings.isEmpty()) {
			String mensaje = "No hay streaming disponible";
			modelo.put("Error", mensaje);
		}else {
			modelo.put("streamings", streamings);			
		}
		
		return new ModelAndView("streaming", modelo);
	}
	
	@RequestMapping(path="/ver-streaming/{url}", method=RequestMethod.GET)
	public ModelAndView verStreaming(@PathVariable("url") String url) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("url", url);
		return new ModelAndView("ver-streaming", modelo);		
		
	}

	
}
