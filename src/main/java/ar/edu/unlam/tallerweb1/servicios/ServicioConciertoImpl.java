package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Concierto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioConcierto;

@Service
public class ServicioConciertoImpl implements ServicioConcierto {
	
	private RepositorioConcierto repositorioConcierto;
	
	@Autowired
	public ServicioConciertoImpl(RepositorioConcierto repositorioConcierto) {
		this.repositorioConcierto = repositorioConcierto;
	}

	@Override
	public void guardarConcierto(Concierto concierto) {
		repositorioConcierto.guardarConcierto(concierto);
	}

	@Override
	public List<Concierto> getAllConciertos() {
		return repositorioConcierto.getAllConciertos();
	}

	@Override
	public List<Concierto> getProximosConciertos() {
		return repositorioConcierto.getProximosConciertos();
	}

	@Override
	public List<Concierto> getConciertosdeHoy() {
		return repositorioConcierto.getConciertosdeHoy();
	}
	
	
}
