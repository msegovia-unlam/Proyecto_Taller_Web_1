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
		
		if(streamings.isEmpty()) {
			
			modelo.put("error", "No hay streamings disponibles");
		}else {
			
			modelo.put("streamings", streamings);
		}
				
		return new ModelAndView("streaming", modelo);
	}
	
	@RequestMapping(path="/compraStreaming/{idStreaming}", method = RequestMethod.GET)
	public ModelAndView compraStreaming(@PathVariable("idStreaming") Integer idStreaming) {

		ModelMap modelo = new ModelMap();
		servicioStreaming.comprarStreaming(idStreaming);
		modelo.put("streamings", null);
		return new ModelAndView("redirect:/streamingsComprados");
	}

	@RequestMapping("/streamingsComprados")
	public ModelAndView listarStreamingsComprados() {

		ModelMap modelo = new ModelMap();
		List<Streaming> streamings = servicioStreaming.obtenerStreamingsComprados();
		modelo.put("streamings", streamings);
		return new ModelAndView("streamings-comprados", modelo);
	}
	
}
