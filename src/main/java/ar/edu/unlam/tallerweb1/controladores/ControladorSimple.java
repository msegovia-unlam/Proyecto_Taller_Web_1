package ar.edu.unlam.tallerweb1.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSimple {

	@RequestMapping(path="/ir-a-pagina", method = RequestMethod.GET)
	public ModelAndView irAPagina() {
		return new ModelAndView("pagina");
	}
	
	@RequestMapping(path="/ir-a-pagina/{nombre}/{apellido}", method = RequestMethod.GET)
	public ModelAndView irAPaginaConParametro(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido.toUpperCase());
		
		return new ModelAndView("pagina", modelo);
	}
	
}
