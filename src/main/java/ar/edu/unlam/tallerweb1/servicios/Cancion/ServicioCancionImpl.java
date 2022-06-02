package ar.edu.unlam.tallerweb1.servicios.Cancion;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.repositorios.Cancion.RepositorioCancion;

@Service
public class ServicioCancionImpl implements ServicioCancion{

	RepositorioCancion repositorioCancion;

	@Autowired
	public ServicioCancionImpl(RepositorioCancion repositorioCancion) {
		this.repositorioCancion = repositorioCancion;
	}


	@Override
	public void guardarCancion(Cancion cancion) {
		repositorioCancion.guardarCancion(cancion);
	}


	@Override
	public List<Cancion> buscarCancionPorNombre(String nombre) {
		return repositorioCancion.buscarCancionPorNombre(nombre);
	}


	@Override
	public List<Cancion> getAllCanciones() {
		return repositorioCancion.getAllCanciones();
	}

	@Override
	public Cancion getCancionbyID(Long id){
		return repositorioCancion.getCancionbyID(id);
	}


}
