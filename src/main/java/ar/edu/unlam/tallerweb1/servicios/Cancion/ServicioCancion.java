package ar.edu.unlam.tallerweb1.servicios.Cancion;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.modelo.Cancion;

public interface ServicioCancion {
	public void guardarCancion(Cancion cancion);
	public List<Cancion> buscarCancionPorNombre(String nombre);
	public List<Cancion> getAllCanciones();
	public Cancion getCancionbyID(Long id);
	public List<Cancion> getCancionesByArtista(long idArtista);
    public List<Cancion> top(Integer top);

}
