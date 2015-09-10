package dominioPais.dominioCorporativo.nucleoBase.hibernate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.NoUniqueResultException;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.filtros.Filtros;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.HibernateUtils;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.Opcion;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@Repository
public class DaoGenerico implements IDaoGenerico {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void habilitarObjeto(EntidadPersistenteBase entidad) {
		entidad.setHabilitado(true);
		actualizar(entidad);
	}

	@Override
	public void desabilitarObjeto(EntidadPersistenteBase entidad) {
		entidad.setHabilitado(false);
		actualizar(entidad);
	}

	@Override
	public <T> int contarElementos(Class<T> claseEntidad, Opcion... parametros) {
		final Criteria criteria = createCriteria(claseEntidad);
		criteria.setProjection(Projections.rowCount());
		if (parametros.length > 0)
			HibernateUtils.populateCriteria(criteria, parametros);

		return (((Long) criteria.uniqueResult())).intValue();
	}

	@Override
	public void salvar(EntidadPersistenteBase entidad) throws DataBaseException {
		if (entidad == null)
			throw new DataBaseException("La entidad a salvar no puede ser nula.");
		this.getCurrentSession().save(entidad);
	}

	@Override
	public void actualizar(EntidadPersistenteBase entidad) throws DataBaseException {
		if (entidad == null)
			throw new DataBaseException("La entidad a actualizar no puede ser nula.");
		this.getCurrentSession().update(entidad);
	}

	@Override
	public void eliminar(EntidadPersistenteBase entidad) throws DataBaseException {
		if (entidad == null)
			throw new DataBaseException("La entidad a eliminar no puede ser nula.");
		this.getCurrentSession().delete(entidad);

	}

	@Override
	public <T extends EntidadPersistenteBase> void eliminar(Collection<T> coleccion) throws DataBaseException {
		if (coleccion == null)
			throw new DataBaseException("La coleccion a eliminar no puede ser nula.");
		for (EntidadPersistenteBase name : coleccion) {
			this.eliminar(name);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override	
	public <T> T obtenerUnico(Class<T> claseEntidad, Opcion... parametros) {
		final Criteria criteria = createCriteria(claseEntidad);
		if (parametros.length > 0)
			HibernateUtils.populateCriteria(criteria, parametros);

		try {
			return (T) criteria.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new NoUniqueResultException(e, claseEntidad, criteria, parametros);
		}
	}

	@Override
	public <T> T obtenerPrimero(Class<T> claseEntidad, Opcion... parametros) {		
		return obtenerUnico(claseEntidad, Opcion.mergeOptions(parametros, Opcion.maxResults(1)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> obtener(Class<T> claseEntidad, Opcion... parametros) {
		if (claseEntidad == null)
			throw new DataBaseException("La clase entidad que se desea cargar no puede ser nula.");

		if (parametros.length == 0) {
			Criteria criteria = createCriteria(claseEntidad);
			return criteria.list();
		}
		Criteria crit = createCriteria(claseEntidad);

		HibernateUtils.populateCriteria(crit, parametros);
		
		List<T> res = crit.list();
		return (res == null) ? Collections.EMPTY_LIST : res;
	}

	@Override
	public <T> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException {
		if (claseEntidad == null)
			throw new DataBaseException("La clase entidad que se desea cargar no puede ser nula.");
		if (valor == null)
			throw new DataBaseException("La carga por el atributo id no admite un valor nulo.");

		return (T) getCurrentSession().get(claseEntidad, valor);
	}

	@Override
	public void descartarCambios(Object object) {
		if (object != null) {
			getCurrentSession().refresh(object);
		}
	}

	@Override
	public Session openSession() {
		Session session = getSessionFactory().openSession();
		session.setFlushMode(FlushMode.MANUAL);
		enableFilters(session);
		return session;
	}

	@Override
	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter and Setter
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Abrir session con un FlushMode pasado por parametro
	 * @param flushMode
	 * @return
	 */
	protected Session openSession(FlushMode flushMode) {
		Session session = getSessionFactory().openSession();
		session.setFlushMode(flushMode);
		enableFilters(session);
		return session;
	}

	/**
	 * Creando criteria
	 */

	protected Criteria createCriteria(Class<? extends Object> clase, String alias) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase, alias);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(Class<? extends Object> clase, ResultTransformer transformer) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase).setResultTransformer(transformer);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(Class<? extends Object> clase, String alias, ResultTransformer transformer) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase, alias).setResultTransformer(transformer);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(Class<? extends Object> clase) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(String path) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(path);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	/**
	 * Habilitar y desabilitar filtro para la session de hibernate
	 */

	public void enableFilters(Session session) {
		session.enableFilter(Filtros.FILTRO_CARGAR);
	}

	public void desabilidarFiltros(Session session) {
		session.disableFilter(Filtros.FILTRO_CARGAR);
	}
}