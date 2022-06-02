package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControladorBirras {

	private List<Cerveza> lista = new LinkedList<>();
			
	// TODO solo para explicar controladores, hay que eliminarlo!!!!!
	public ControladorBirras(int cantidadExistente, String tipo) {
		for(int i = 0; i < cantidadExistente; i++)
			lista.add(new Cerveza(tipo));
	}
	// TODO solo para explicar controladores, hay que eliminarlo!!!!!
	
	
	
	// /listarCerveza GET
	public ModelAndView Listar(String tipo) {
		
		ModelMap model = new ModelMap();
		List<Cerveza> resultado = buscarCervezasDelTipo(tipo);
		
		if(resultado.isEmpty()) {
			model.put("msg-error", "tipo inexistente");
		}else {
			//En la key cervezas se le agrega la lista de cervezas
			model.put("cervezas", resultado);			
		}

		
		return new ModelAndView("listado-cervezas", model);
		
		
	}



	private List<Cerveza> buscarCervezasDelTipo(String tipo) {
		List<Cerveza> resultado = new ArrayList<>();
		for(Cerveza each: lista) {
			if(each.getTipo().equals(tipo))
				resultado.add(each);
		}
		
		return resultado;
	}

	//tipo de retorno de una accion: datos + vista (model + vista)
}
