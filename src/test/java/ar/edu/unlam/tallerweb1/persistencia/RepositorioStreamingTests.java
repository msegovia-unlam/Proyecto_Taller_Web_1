package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioStreaming;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioStreamingTests extends SpringTest {
	
	@Autowired
	private RepositorioStreaming servicioStreamingDao;
	
	@Test @Transactional @Rollback
	public void obtenerStreamingsDisponibles() {
		
		Streaming st1 = new Streaming();
		st1.setArtista("Charly");
		st1.setUrl("http.charly.com");
		st1.setId(1);
		
		Streaming st2 = new Streaming();
		st2.setArtista("Fito");
		st2.setUrl("http.fito.com");
		st2.setId(2);
		
		Streaming st3 = new Streaming();
		st3.setArtista("Pepe");
		st3.setUrl("http.pepe.com");
		st3.setId(1);
		
		session().save(st1);
		session().save(st2);
		session().save(st3);
		
		List<Streaming> lista = servicioStreamingDao.obtenerStreamings();
		assertThat(lista).hasSize(3);
	}
	
	@Test @Transactional @Rollback
	public void obtenerStreamingsComprados() {
		
		Streaming st1 = new Streaming();
		st1.setArtista("Charly");
		st1.setUrl("http.charly.com");
		st1.setId(1);
		
		Streaming st2 = new Streaming();
		st2.setArtista("Fito");
		st2.setUrl("http.fito.com");
		st2.setId(2);
		
		Streaming st3 = new Streaming();
		st3.setArtista("Pepe");
		st3.setUrl("http.pepe.com");
		st3.setId(3);
		
		Streaming st4 = new Streaming();
		st3.setArtista("kiko");
		st3.setUrl("http.kiko.com");
		st3.setId(4);
		
		session().save(st1);
		session().save(st2);
		session().save(st3);
		session().save(st4);
		
		servicioStreamingDao.comprarStreaming(1);
		servicioStreamingDao.comprarStreaming(3);
				
		List<Streaming> listaComprados = servicioStreamingDao.obtenerStreamingsComprados();
		
		assertThat(listaComprados).hasSize(2);
	}

}
