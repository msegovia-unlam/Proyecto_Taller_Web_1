package ar.edu.unlam.tallerweb1.repositorios.Cancion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ar.edu.unlam.tallerweb1.modelo.Cancion;

@Repository
@EnableTransactionManagement
@Transactional
public class RepositorioCancionImpl implements RepositorioCancion{

	SessionFactory sessionFactory;
	
	
	@Autowired
	public RepositorioCancionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void guardarCancion(Cancion cancion) {
		sessionFactory.getCurrentSession().save(cancion);
	}



	@Override
	public List<Cancion> buscarCancionPorNombre(String nombre) {
		return sessionFactory.getCurrentSession().createCriteria(Cancion.class)
				.add(Restrictions.eq("nombre", nombre)).list();
	}



	@Override
	public List<Cancion> getAllCanciones() {
		return sessionFactory.getCurrentSession().createCriteria(Cancion.class)
				.list();
	}

	@Override
	public Cancion getCancionbyID(Long id) {
		return (Cancion) sessionFactory.getCurrentSession().createCriteria(Cancion.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

    @Override
    public List<Cancion> top(Integer top) {
		return sessionFactory.getCurrentSession().createCriteria(Cancion.class)
				.addOrder(Order.desc("reproducciones")).setMaxResults(top).list();

    }

}
