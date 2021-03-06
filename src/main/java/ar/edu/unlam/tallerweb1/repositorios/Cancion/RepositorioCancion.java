package ar.edu.unlam.tallerweb1.repositorios.Cancion;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;

public interface RepositorioCancion {
	public void guardarCancion(Cancion cancion);
	public List<Cancion> buscarCancionPorNombre(String nombre);
	public List<Cancion> getAllCanciones();
	public Cancion getCancionbyID(Long id);
	public List<Cancion> getCancionesByArtista(long id);
    public List<Cancion> top(Integer top);
	public List<Cancion> getCancionesByAlbumId(Long id);
	public void updateCancion(Cancion cancion);

}
