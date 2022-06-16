package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioConcierto;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorConcierto {

	ServicioLogin servicioLogin;
	ServicioConcierto servicioConcierto;
	
	@Autowired
	public ControladorConcierto(ServicioConcierto servicioConcierto,ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
		this.servicioConcierto = servicioConcierto;
	}

	
	@RequestMapping(path = "/crear-concierto",method = RequestMethod.GET)
	public ModelAndView irACrearConcierto() {
		ModelMap model = new ModelMap();
		List<Usuario> artistas = servicioLogin.getAllUsers();
		model.put("artistas", artistas);
		return new ModelAndView("agregar-concierto",model);
	}
	
	@RequestMapping(path="/saveConcierto",method = RequestMethod.POST)
	public ModelAndView saveConcierto(@RequestParam("fecha") Date fecha, 
										@RequestParam("hora") String hora, 
										@RequestParam("artistas") String[] artistas, 
										@RequestParam("lugar") String lugar,
										RedirectAttributes attributes) {
		ModelMap model = new ModelMap();
		Concierto concierto = new Concierto();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(int i=0;i<artistas.length;i++) {
			usuarios.add(servicioLogin.buscarPorId(Long.valueOf(artistas[i]).longValue()));
		}
		concierto.setFecha(fecha);
		concierto.setHora(hora);
		concierto.setLugar(lugar);
		concierto.setUsuarios(usuarios);
		servicioConcierto.guardarConcierto(concierto);
		attributes.addFlashAttribute("mensaje", "Se guardo correctamente el concierto");
		return new ModelAndView("redirect:/crear-concierto");
	}
	
	@RequestMapping(path = "/lista-conciertos",method = RequestMethod.GET)
	public ModelAndView listaConciertos() {
		ModelMap model = new ModelMap();
		List<Concierto> proximosConciertos = servicioConcierto.getProximosConciertos();
		List<Concierto> conciertosDelDiaDeHoy = servicioConcierto.getConciertosdeHoy();
		List<Concierto> conciertos = servicioConcierto.getAllConciertos();
		
		if (proximosConciertos.isEmpty()) {
			model.put("mensajeProximosConciertos", "No se encuentran proximos conciertos");
		} else {
			model.put("proximosConciertos", proximosConciertos);
		}

		if (conciertosDelDiaDeHoy.isEmpty()) {
			model.put("mensajeConciertosDiaHoy", "No se encuentran conciertos para el dia de hoy");
		} else {
			model.put("conciertosDiaHoy", conciertosDelDiaDeHoy);
		}
		
		if (conciertos.isEmpty()) {
			model.put("mensajeConciertos", "No se encuentran conciertos");
		} else {
			model.put("conciertos", conciertos);
		}
		
		return new ModelAndView("lista-conciertos",model);
		
	}
}
