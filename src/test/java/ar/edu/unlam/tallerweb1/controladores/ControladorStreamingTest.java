package ar.edu.unlam.tallerweb1.controladores;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.servicios.ServicioStreaming;
import ar.edu.unlam.tallerweb1.servicios.ServicioStreamingImpl;

public class ControladorStreamingTest {
	
	private ControladorStreaming1 controladorStreaming;
	private ServicioStreaming servicioStreaming;
	private int cantidad = 4;
	private int vacio = 0;
	
	@Before
	public void init() {
		
		servicioStreaming = mock(ServicioStreamingImpl.class);
		//when(servicioStreaming.obtenerStreamings()).thenReturn(null);		
		controladorStreaming = new ControladorStreaming1(servicioStreaming);
		
	}
	
	
	@Test
	public void queDevuelveLaListaCompletaDeStreaming() {
		
		List<Streaming> lista = new LinkedList<>();
		for(int i = 0; i< cantidad; i++) {
			lista.add(new Streaming());
		}
		
		when(servicioStreaming.obtenerStreamings()).thenReturn(lista);	
		
	}
	
	@Test
	public void queDevuelvaUnMensajeSiNoHayStreamingDisponibles() {
				
		when(servicioStreaming.obtenerStreamings()).thenReturn(new LinkedList<>());
		
	}
}
