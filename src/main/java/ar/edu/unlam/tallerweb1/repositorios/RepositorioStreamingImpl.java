package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.StramingComprados;
import ar.edu.unlam.tallerweb1.modelo.Streaming;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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


	@Override
	public void comprarStreaming(int id) {
		
		StramingComprados compra = new StramingComprados();
		
		compra.setStreamingId(id);
		
		sessionFactory.getCurrentSession().save(compra);     
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Streaming> obtenerStreamingsComprados() {
		List<Streaming> streamingsComprados = new ArrayList<Streaming>();
		final Session session = sessionFactory.getCurrentSession();
		List<StramingComprados> ids = (List<StramingComprados>) session.createCriteria(StramingComprados.class)
				.list();
		
		for(StramingComprados sc : ids) {
			Streaming st = (Streaming) session.createCriteria(Streaming.class)
			.add(Restrictions.eq("id", sc.getStreamingId()))
			.uniqueResult();
			streamingsComprados.add(st);
		}
		
		return streamingsComprados;
	}

}
