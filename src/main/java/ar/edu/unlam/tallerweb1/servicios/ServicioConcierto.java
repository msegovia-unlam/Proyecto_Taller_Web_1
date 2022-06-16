package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Concierto;

public interface ServicioConcierto {

	void guardarConcierto(Concierto concierto);

	List<Concierto> getAllConciertos();

	List<Concierto> getProximosConciertos();

	List<Concierto> getConciertosdeHoy();

}
