package dominioPais.dominioCorporativo.nucleoBase.datos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.stereotype.Repository;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.BaseException;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;

@Repository("daoGenerico")
public class DaoGenericoImpl implements DaoGenerico {

	@Resource
	private SessionFactory sessionFactory;

	public void salvar(EntidadPersistenteBase entidad) {
		if (entidad == null)
			throw new DataBaseException("La entidad a salvar no puede ser nula.");
		getCurrentSession().save(entidad);
	}

	public void actualizar(EntidadPersistenteBase entidad) {
		if (entidad == null)
			throw new DataBaseException("La entidad a actualizar no puede ser nula.");
		getCurrentSession().update(entidad);
	}

	public void ocultar(EntidadPersistenteBase entidad, String motivo) {
		if (motivo == null)
			throw new DataBaseException("El motivo para ocultar no puede ser nulo.");
		desactivarObjeto(entidad);
	}

	public void activarObjeto(EntidadPersistenteBase entidad) {
		actualizar(entidad);
	}

	public void desactivarObjeto(EntidadPersistenteBase entidad) {
		actualizar(entidad);
	}

	public void eliminar(EntidadPersistenteBase entidad, String motivo) {
		if (entidad == null)
			throw new DataBaseException("La entidad a eliminar no puede ser nula.");
		if (motivo == null)
			throw new DataBaseException("El motivo para eliminar no puede ser nulo.");
		getCurrentSession().delete(entidad);
	}

	public <T extends EntidadPersistenteBase> void eliminar(Collection<T> coleccion, String motivo) {
		if (coleccion == null)
			throw new DataBaseException("La coleccion a eliminar no puede ser nula.");

		for (EntidadPersistenteBase name : coleccion)
			eliminar(name, motivo);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> obtener(Class<T> claseEntidad, Integer filtros, Criteria criteria) {
		if (claseEntidad == null)
			throw new DataBaseException("La clase entidad que se desea cargar no puede ser nula.");

		disableFilters(getCurrentSession(), filtros);

		List<T> res = criteria.list();

		enableFilters(getCurrentSession(), filtros);

		return (res == null) ? Collections.EMPTY_LIST : res;
	}

	public <T> T obtenerUnico(Class<T> claseEntidad, Criteria criteria) {
		return null;
	}

	public <T> T obtenerUnico(Class<T> claseEntidad, Integer filtros, Criteria criteria) {
		return null;
	}

	@Override
	public <T> T obtenerPrimero(Class<T> claseEntidad, Criteria criteria) {
		return null;
	}

	@Override
	public <T> T obtenerPrimero(Class<T> claseEntidad, Integer filtros, Criteria criteria) {
		return null;
	}

	public <T> int contarElementos(Class<T> claseEntidad, Criteria criteria) {
		return 0;
	}

	public <T> int contarElementos(Class<T> claseEntidad, Integer filtros, Criteria criteria) {
		return filtros;
	}

	public void enableFilters(Session session) {
		session.enableFilter("FiltroCarga");
		session.enableFilter("FiltroColeccion");
	}

	public void enableFilters(Session session, Integer filtros) {

	}

	public void disableFilters(Session session) {
		session.disableFilter("FiltroColeccion");
		session.disableFilter("FiltroCarga");
	}

	public void disableFilters(Session session, Integer filtros) {

	}

	public <T> List<T> obtener(Class<T> claseEntidad, Criteria criteria) {
		return null;

	}

	public <T> T obtenerPorId(Class<T> claseEntidad, Integer valor) {
		return null;
	}

	public void detachObject(Object object) {
		if (object != null) {
			getCurrentSession().evict(object);
		}
	}

	public void discardChanges(Object object) {
		if (object != null) {
			getCurrentSession().refresh(object);
		}
	}

	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public Session openSession() {

		Session session = getSessionFactory().openSession();

		session.setFlushMode(FlushMode.MANUAL);
		enableFilters(session);
		return session;
	}

	protected Session openSession(FlushMode flushMode) {
		Session session = getSessionFactory().openSession();
		session.setFlushMode(flushMode);
		enableFilters(session);
		return session;
	}

	protected Criteria createCriteria(Class<? extends Object> clase, String alias) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase, alias);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(Class<? extends Object> clase, ResultTransformer transformer) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase)
				.setResultTransformer(transformer);
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	protected Criteria createCriteria(Class<? extends Object> clase, String alias, ResultTransformer transformer) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(clase, alias)
				.setResultTransformer(transformer);
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Query createQuery(String query) {
		return getCurrentSession().createQuery(query).setFlushMode(FlushMode.MANUAL);
	}

	protected Criteria createCriteriaByExample(Object objeto) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(objeto.getClass());
		criteria.add(Example.create(objeto));
		criteria.setFlushMode(FlushMode.MANUAL);
		return criteria;
	}

	public SQLQuery crearSQLQuery(String sql, ResultTransformer transformer) {
		return crearSQLQuery(getCurrentSession(), sql, transformer);
	}

	public SQLQuery crearSQLQuery(Session sess, String sql, ResultTransformer transformer) {
		SQLQuery query = sess.createSQLQuery(sql);
		query.setFlushMode(FlushMode.MANUAL);
		if (transformer != null)
			query.setResultTransformer(transformer);
		else
			query.setResultTransformer(ToListResultTransformer.INSTANCE);
		return query;
	}

	public void ejecutarDML(String sql, boolean nuevaSession) {
		Session sess = nuevaSession ? openSession() : getCurrentSession();
		SQLQuery query = crearSQLQuery(sess, sql, null);
		query.executeUpdate();
		if (nuevaSession)
			sess.close();
	}

	public List<?> ejecutarSQLQuery(String sql, ResultTransformer transformer, boolean nuevaSession) {
		Session sess = nuevaSession ? openSession() : getCurrentSession();
		SQLQuery query = crearSQLQuery(sess, sql, transformer);

		if (!nuevaSession)
			query.setFlushMode(FlushMode.MANUAL);

		List<?> resultado = null;
		List<?> list = query.list();
		resultado = (list == null) ? Collections.EMPTY_LIST : list;

		if (nuevaSession)
			sess.close();

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> ejecutarCriteria(Criteria criteria) {
		if (criteria != null)
			return criteria.list();
		return new ArrayList<T>();
	}

	public <T> List<T> ejecutarCriteriaPaginada(Criteria criteria) {
		return null;
	}

	public <T extends Object> List<T> ejecutarProcedimientoPaginado(String genericProcedureId, Object... parametros) {
		return null;
	}

	public <T extends Object> List<T> ejecutarProcedimiento(String genericProcedureId, Object... parametros) {
		return null;
	}

	public Object ejecutarProcedimientoParamSalida(String genericProcedureId, String parametroSalida,
			Object... parametros) throws BaseException {
		return parametros;

	}

}