package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class ControladorReproductor {
    public ModelAndView  reproducirCancion(Cancion cancion){

        ModelMap model = new ModelMap();
        model.put("Cancion", cancion);
        ModelAndView mav = new ModelAndView("Reproductor",model);
        return mav;
    }
}
