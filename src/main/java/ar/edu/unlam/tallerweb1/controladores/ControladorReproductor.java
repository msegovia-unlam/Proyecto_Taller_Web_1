package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorReproductor {
    private ServicioCancion servicioCancion;
    
@Autowired
    public ControladorReproductor(ServicioCancion servicioCancion){
        this.servicioCancion = servicioCancion;
    }
	
	//llega el id de la cancion por get desde lista-canciones
    @RequestMapping(path = "/reproductor", method = RequestMethod.GET)
        public ModelAndView reproducirCancion( @RequestParam("id") Long id){
        Cancion cancion = servicioCancion.getCancionbyID(id);
        ModelMap model = new ModelMap();
        model.put("cancion", cancion);
        return new ModelAndView("reproductor",model);
    }
}
