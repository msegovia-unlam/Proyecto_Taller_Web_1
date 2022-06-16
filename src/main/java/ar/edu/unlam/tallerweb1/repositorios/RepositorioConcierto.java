package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Concierto;

public interface RepositorioConcierto {
	void guardarConcierto(Concierto concierto);

	List<Concierto> getAllConciertos();

	List<Concierto> getConciertosByUserId(Long idUsusario);

	List<Concierto> getProximosConciertos();

	List<Concierto> getConciertosdeHoy();
}
