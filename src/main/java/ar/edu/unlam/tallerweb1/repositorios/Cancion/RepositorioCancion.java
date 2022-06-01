package ar.edu.unlam.tallerweb1.repositorios.Cancion;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioCancion {
	public void guardarCancion(Cancion cancion);
	public List<Cancion> buscarCancionPorNombre(String nombre);
	public List<Cancion> getAllCanciones();
}
