package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Streaming;

@Repository("repositorioStreaming")
public class RepositorioStreamingImpl implements RepositorioStreaming{
	
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioStreamingImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Streaming> obtenerStreamings() {
		final Session session = sessionFactory.getCurrentSession();
		return (List<Streaming>) session.createCriteria(Streaming.class)
				.list();
	}

}
