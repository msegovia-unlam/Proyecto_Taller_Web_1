package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.servicios.ServicioStreaming;

public class ControladorStreamingTest {
	
	private ControladorStreaming controladorStreaming;
	private ServicioStreaming servicioStreaming;
	private int cantidad = 4;
	private int vacio = 0;
	List<Streaming> streamingsComprados = new LinkedList<>();
	
	@Before
	public void init() {
				
		servicioStreaming = mock(ServicioStreaming.class);	
		controladorStreaming = new ControladorStreaming(servicioStreaming);
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void queDevuelveLaListaCompletaDeStreaming() {
		
		streamingsDisponibles(9);
		ModelAndView mav = obtenerStreamingsDisponibles();
		
		List<Streaming> listaDisponibles = (List<Streaming>) mav.getModel().get("streamings");
		
		assertThat(listaDisponibles).isNotEmpty();
	}
	
	@Test
	public void queDevuelvaUnMensajeSiNoHayStreamingDisponibles() {
				
		streamingsDisponibles(vacio);
		ModelAndView mav = obtenerStreamingsDisponibles();
		String error = (String) mav.getModel().get("error");
		assertEquals("No hay streamings disponibles", error);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void queDevuelveLaListaCompletaDeStreamingComprados() {		
		
		streamingsDisponibles(9);
		ModelAndView mav = obtenerStreamingsDisponibles();
		List<Streaming> listaDisponibles = (List<Streaming>) mav.getModel().get("streamings");
		
		comprarStreaming(listaDisponibles.get(1));
		ModelAndView mav2 = obtenerStreamingsComprados();
		List<Streaming> streamingsComprados = (List<Streaming>) mav2.getModel().get("streamings");
		
		assertThat(streamingsComprados).isNotEmpty();
	}

	
	private void streamingsDisponibles(int cant) {
		List<Streaming> lista = new LinkedList<>();
		
		for(int i = 0; i< cant; i++) {
			Streaming st = new Streaming();
			st.setArtista(UUID.randomUUID().toString());
			st.setUrl(UUID.randomUUID().toString());
			st.setId(i);
			lista.add(st);
		}
		
        when(servicioStreaming.obtenerStreamings()).thenReturn(lista);
    }
	
	
	
	private void comprarStreaming(Streaming streaming) {
		streamingsComprados.add(streaming);
    }
	
	private ModelAndView obtenerStreamingsDisponibles() {
        return controladorStreaming.listarStreamings();
    }
	
	private ModelAndView obtenerStreamingsDisponibles(int id) {
        return controladorStreaming.compraStreaming(id);
    }
	
	private ModelAndView obtenerStreamingsComprados() {
		
		when(servicioStreaming.obtenerStreamingsComprados()).thenReturn(streamingsComprados);
		
        return controladorStreaming.listarStreamingsComprados();
    }
	
}
