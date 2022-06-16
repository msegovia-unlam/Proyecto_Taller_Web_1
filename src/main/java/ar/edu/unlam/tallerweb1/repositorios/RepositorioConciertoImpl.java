package ar.edu.unlam.tallerweb1.repositorios;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Concierto;

@Repository
@EnableTransactionManagement
@Transactional
public class RepositorioConciertoImpl implements RepositorioConcierto{

	SessionFactory sessionFactory;

	@Autowired
	public RepositorioConciertoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardarConcierto(Concierto concierto) {
		sessionFactory.getCurrentSession().save(concierto);
	}

	@Override
	public List<Concierto> getAllConciertos() {
		return sessionFactory.getCurrentSession().createCriteria(Concierto.class)
				.list();
	}

	@Override
	public List<Concierto> getConciertosByUserId(Long idUsusario) {
		return sessionFactory.getCurrentSession().createCriteria(Concierto.class)
				.createAlias("usuarios", "us")
				.add(Restrictions.eq("us.id", idUsusario))
				.list();
	}

	@Override
	public List<Concierto> getProximosConciertos() {
		Calendar calendar = Calendar.getInstance();
		Integer diaActual = calendar.get(Calendar.DATE);
		Integer mesActual = calendar.get(Calendar.MONTH)+1;
		Integer anioActual = calendar.get(Calendar.YEAR);
		
		return sessionFactory.getCurrentSession().createCriteria(Concierto.class)
				.add(Restrictions.gt("fecha", new Date(anioActual, mesActual, diaActual)))
				.list();
	}

	@Override
	public List<Concierto> getConciertosdeHoy() {
		Calendar calendar = Calendar.getInstance();
		Integer diaActual = calendar.get(Calendar.DATE);
		Integer mesActual = calendar.get(Calendar.MONTH)+1;
		Integer anioActual = calendar.get(Calendar.YEAR);
		Date fechaActual = new Date(anioActual, mesActual, diaActual);
		return sessionFactory.getCurrentSession().createCriteria(Concierto.class)
				.add(Restrictions.eq("fecha", fechaActual))
				.list();
	}
	
}
