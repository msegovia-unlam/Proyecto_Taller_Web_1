package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Streaming;

public interface ServicioStreaming {
	
	List<Streaming> obtenerStreamings();
	
	void comprarStreaming(int id);
	
	List<Streaming> obtenerStreamingsComprados();
}
