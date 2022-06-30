package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPerfil {

	public ModelAndView irAVistaPerfil(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try {
			Long idUsuario = (Long) request.getSession().getAttribute("ID");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("perfil");
	}
	
	
	
}
