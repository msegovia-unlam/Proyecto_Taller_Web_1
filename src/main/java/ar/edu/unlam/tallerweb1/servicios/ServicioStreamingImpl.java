package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioStreaming;

@Service("servicioStreaming")
@Transactional
public class ServicioStreamingImpl implements ServicioStreaming{
	
	private RepositorioStreaming servicioStreamingDao;

	@Autowired
	public ServicioStreamingImpl(RepositorioStreaming servicioStreamingDao){
		this.servicioStreamingDao = servicioStreamingDao;
	}

	@Override
	public List<Streaming> obtenerStreamings() {
		return servicioStreamingDao.obtenerStreamings();
	}

}
