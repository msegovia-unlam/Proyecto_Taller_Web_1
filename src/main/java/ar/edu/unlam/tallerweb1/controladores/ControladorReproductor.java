package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;

@Controller
public class ControladorReproductor {
    private ServicioCancion servicioCancion;

    public ControladorReproductor(ServicioCancion servicioCancion){
        this.servicioCancion = servicioCancion;

    }
    @RequestMapping(path = "reproductor", method = RequestMethod.POST)
    //llega el id de la cancion por post
    public ModelAndView  reproducirCancion( @RequestParam("id") Long id){
        Cancion cancion = servicioCancion.getCancionbyID(id);
        ModelMap model = new ModelMap();
        model.put("Cancion", cancion);
        ModelAndView mav = new ModelAndView("Reproductor",model);
        return mav;
    }
}
