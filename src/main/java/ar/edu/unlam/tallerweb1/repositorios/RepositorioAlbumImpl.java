package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ar.edu.unlam.tallerweb1.modelo.Album;

@Repository @EnableTransactionManagement
@Transactional
public class RepositorioAlbumImpl implements RepositorioAlbum {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioAlbumImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardarAlbum(Album album) {
		sessionFactory.getCurrentSession().save(album);
	}

	@Override
	public List<Album> getAllAlbunes() {
		return sessionFactory.getCurrentSession().createCriteria(Album.class)
				.list();
	}

	@Override
	public List<Album> getAlbunesByUsuarioId(Long idUsuario) {
		return sessionFactory.getCurrentSession().createCriteria(Album.class)
				.createAlias("usuario", "us")
				.add(Restrictions.eq("us.id", idUsuario)).list();
	}

	@Override
	public Album getAlbumById(Long id) {
		return (Album) sessionFactory.getCurrentSession().createCriteria(Album.class)
				.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public void updateAlbum(Album album) {
		sessionFactory.getCurrentSession().update(album);
	}

}
