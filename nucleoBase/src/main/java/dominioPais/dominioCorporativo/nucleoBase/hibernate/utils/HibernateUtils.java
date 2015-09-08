package dominioPais.dominioCorporativo.nucleoBase.hibernate.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.Subcriteria;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;

public class HibernateUtils {

	/**
	 * Utilizado para inicializar un proxy de HIbernate, e inmediatamente
	 * despues castearlo a la clase pasada por parametros. Notese que el objeto
	 * inicializado esta disponible con su clase original por referencia en el
	 * primer parametro, pero con la clase casteada en el tipo de dato de
	 * retorno. Si el objeto no es un proxy simplemente se castea.
	 * 
	 * @param <T>
	 *            la clase a la que se desea castear el proxy
	 * @param objeto
	 *            proxy de hibernate a inicializar
	 * @param clase
	 *            la clase a la que se debe castear el proxy inicializado
	 * @return proxy inicializado y casteado
	 */
	public static <T extends EntidadPersistenteBase> T initializeAndCast(Object objeto, Class<T> clase) {
		if (objeto instanceof HibernateProxy)
			objeto = ((HibernateProxy) objeto).getHibernateLazyInitializer().getImplementation();
		return clase.cast(objeto);
	}

	/**
	 * Inicializa un proxy de Hibernate. Util cuando se encuentra un proxy en
	 * una jerarquia de herencia y se desea acceder a parametros de clase hija,
	 * pero el proxy esta hecho sobre la clase padre y por tanto no reconoce los
	 * elementos de la hija. Notese que el meotod inicializa el parametro pasado
	 * por referencia, ademas de devolverlo como tipo de retorno
	 * 
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param objeto
	 *            proxy a inicializar.
	 * @return proxy inicializado
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EntidadPersistenteBase> T initialize(T objeto) {
		if (objeto instanceof HibernateProxy)
			return (T) ((HibernateProxy) objeto).getHibernateLazyInitializer().getImplementation();
		else
			return objeto;
	}

	/**
	 * Inicializa los proxy de Hibernate de los elementos de la coleccion. Util
	 * cuando se encuentra un proxy en una jerarquia de herencia y se desea
	 * acceder a parametros de clase hija, pero el proxy esta hecho sobre la
	 * clase padre y por tanto no reconoce los elementos de la hija. Notese que
	 * el meotod inicializa el parametro pasado por referencia, ademas de
	 * devolverlo como tipo de retorno.
	 * <p>
	 * <em><strong>NOTA:</strong> Modifica los elementos de la coleccion <code>collection</code>
	 * .</em>
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param collection
	 *            Coleccion a inicializar
	 * @return La coleccion <code>collection</code> con sus elementos
	 *         inicializados
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EntidadPersistenteBase> List<T> initialize(List<T> collection) {
		T elm;
		for (int i = 0; i < collection.size(); i++) {
			elm = collection.get(i);
			if (elm instanceof HibernateProxy)
				collection.set(i, (T) ((HibernateProxy) elm).getHibernateLazyInitializer().getImplementation());
		}
		return collection;
	}

	/**
	 * Inicializa los proxy de Hibernate de los elementos de la coleccion. Util
	 * cuando se encuentra un proxy en una jerarquia de herencia y se desea
	 * acceder a parametros de clase hija, pero el proxy esta hecho sobre la
	 * clase padre y por tanto no reconoce los elementos de la hija. Notese que
	 * el meotod inicializa el parametro pasado por referencia, ademas de
	 * devolverlo como tipo de retorno.
	 * <p>
	 * <em><strong>NOTA:</strong> Modifica los elementos de la coleccion <code>collection</code>
	 * .</em>
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param collection
	 *            Coleccion a inicializar
	 * @return La coleccion <code>collection</code> con sus elementos
	 *         inicializados
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EntidadPersistenteBase> Set<T> initialize(Set<T> collection) {
		if (collection != null) {
			final Set<T> r = new HashSet<T>(collection.size());
			for (T elm : collection) {
				if (elm instanceof HibernateProxy)
					r.add((T) ((HibernateProxy) elm).getHibernateLazyInitializer().getImplementation());
				else
					r.add(elm);
			}
			collection.clear();
			collection.addAll(r);
		}
		return collection;
	}

	/**
	 * Para realizar comparaciones de proxies de Hibernate utilizando
	 * instanceof. Actualmente los instanceof directos con proxies de Hibernate
	 * no funcionan, dado que una clase con proxy no es instanceof de su clase
	 * target, especialmente si pertenece a una jerarquia de herencia. Con este
	 * metodo el instanceof funciona tal cual para objetos que no son
	 * HibernateProxy, y para los proxies primero los inicializa y luego aplica
	 * el instanceof. La inicializacion es inevitable dado que un objeto de una
	 * clase hija en una jerarquia de herencia no puede compararse con el proxy
	 * de una clase padre
	 * 
	 * @param objeto
	 *            objeto a comparar, que puede o no ser un proxy de hibernate.
	 * @param clase
	 *            la clase con la cual se va a comparar el objeto
	 * @param flag
	 *            si se desea que la inicializacion del proxy se conserve en el
	 *            parametro objeto por referencia, o solo que se inicialice para
	 *            la comparacion y el proxy continue.
	 * @return true si el objeto o proxy inicializado es de la clase
	 *         especificada, falso en otro caso
	 */
	public static boolean proxiedInstanceof(EntidadPersistenteBase objeto, Class<? extends EntidadPersistenteBase> clase, boolean flag) {
		// TODO Yamek: Revisar este metodo contra la documentacion
		Object temp = objeto;
		if (flag)
			objeto = initialize(objeto);
		if (objeto instanceof HibernateProxy)
			temp = ((HibernateProxy) objeto).getHibernateLazyInitializer().getImplementation();
		return clase.isInstance(temp);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Object> Class<T> getClass(T objeto) {
		if (objeto instanceof HibernateProxy)
			return (Class<T>) ((HibernateProxy) objeto).getHibernateLazyInitializer().getImplementation().getClass();
		return (Class<T>) objeto.getClass();
	}

	public static boolean proxiedInstanceof(EntidadPersistenteBase objeto, Class<? extends EntidadPersistenteBase> clase) {
		return proxiedInstanceof(objeto, clase, false);
	}

	private static Criterion createAttrib(Opcion opt) {
		switch (opt.op) {
		case Opcion.IN:
			return Restrictions.in(opt.nombreAtt, (Object[]) opt.valorAtt);
		case Opcion.BETWEEN:
			return Restrictions.between(opt.nombreAtt, ((Object[]) opt.valorAtt)[0], ((Object[]) opt.valorAtt)[1]);
		case Opcion.ISNULL:
			return Restrictions.isNull(opt.nombreAtt);
		case Opcion.NNULL:
			return Restrictions.isNotNull(opt.nombreAtt);
		case Opcion.IEQ:
			return Restrictions.eqProperty(opt.nombreAtt, (String) opt.valorAtt);
		case Opcion.EQ:
			return Restrictions.eq(opt.nombreAtt, opt.valorAtt);
		case Opcion.LIKE:
			// el MatchMode por defecto es ANYWHERE
			if (opt.valorAtt instanceof String)
				return Restrictions.like(opt.nombreAtt, opt.valorAtt.toString(), MatchMode.ANYWHERE);
			else
				return Restrictions.like(opt.nombreAtt, ((Object[]) opt.valorAtt)[0].toString(), (MatchMode) ((Object[]) opt.valorAtt)[1]);
		case Opcion.ILIKE:
			// el MatchMode por defecto es ANYWHERE
			if (opt.valorAtt instanceof String)
				return Restrictions.ilike(opt.nombreAtt, opt.valorAtt.toString(), MatchMode.ANYWHERE);
			else
				return Restrictions.ilike(opt.nombreAtt, ((Object[]) opt.valorAtt)[0].toString(), (MatchMode) ((Object[]) opt.valorAtt)[1]);
		case Opcion.NE:
			return Restrictions.ne(opt.nombreAtt, opt.valorAtt);
		case Opcion.GT:
			return Restrictions.gt(opt.nombreAtt, opt.valorAtt);
		case Opcion.GE:
			return Restrictions.ge(opt.nombreAtt, opt.valorAtt);
		case Opcion.LT:
			return Restrictions.lt(opt.nombreAtt, opt.valorAtt);
		case Opcion.LE:
			return Restrictions.le(opt.nombreAtt, opt.valorAtt);
		case Opcion.NOOP:
			return null;
		default:
			throw new DataBaseException("Error en la construccion de las opciones de consulta: el atributo att debe especificar una operacion");
		}
	}

	private static void createAttrib(List<Criterion> criterios, Opcion opt) {
		if (opt.valorAtt == null && (opt.op != Opcion.NNULL && opt.op != Opcion.ISNULL))
			return;

		final Criterion criterio = createAttrib(opt);
		if (criterio != null)
			criterios.add(criterio);

	}

	private static Junction createJunction(Opcion opt) {
		final Junction oper = opt.valor == Opcion.AND ? Restrictions.conjunction() : (opt.valor == Opcion.OR) ? Restrictions.disjunction() : null;
		if (oper == null)
			throw new RuntimeException("Un valor de Options no puede usarse en este contexto (Se esperaba OR o AND): " + opt.valor);
		for (Opcion ot : (Opcion[]) opt.valorAtt) {
			if (ot.valor != Opcion.NOOP) {
				if (ot.valor == Opcion.ATT)
					oper.add(createAttrib(ot));
				else
					oper.add(createJunction(ot));
			}
		}
		return oper;
	}

	public static Opcion populateCriteria(Criteria crit, Opcion[] parametros) {
		boolean opProjFlag = false;
		final ProjectionList pl = Projections.projectionList();
		Opcion res = null;
		ResultTransformer transformer = null;
		if (crit.getClass().equals(CriteriaImpl.class))
			transformer = ((CriteriaImpl) crit).getResultTransformer();
		final List<Object[]> orders = new ArrayList<Object[]>();
		final List<Criterion> atts = new ArrayList<Criterion>();

		for (Opcion opt : parametros) {
			if (opt.valor == Opcion.NOOP) {
				continue;
			} else if (opt.valor == Opcion.ATT) {
				createAttrib(atts, opt);
			} else if (opt.valor == Opcion.CRITERIA) {
				String[] elementos = opt.nombreAtt.split(",");
				Criteria subCrit = null;
				// para poder especificar el alias en el subcriteria, se ponen
				// los dos valores
				// separados por coma. esto es necesario debido a la limitacion
				// de 4 parametros del
				// objeto Options
				if (elementos.length > 1)
					// para permitir especificar el JoinType en las consultas de
					// criteria. De no
					// especificarse, se asume el JoinType por defecto
					// (INNER_JOIN)
					if (opt.op == null)
						subCrit = crit.createCriteria(elementos[0], elementos[1]);
					else
						subCrit = crit.createCriteria(elementos[0], elementos[1], JoinType.parse(opt.op));
				else {
					// para permitir especificar el JoinType en las consultas de
					// criteria. De no
					// especificarse, se asume el JoinType por defecto
					// (INNER_JOIN)
					if (opt.op == null)
						subCrit = crit.createCriteria(opt.nombreAtt);
					else
						subCrit = crit.createCriteria(opt.nombreAtt, JoinType.parse(opt.op));
				}
				// con falso, para no especificar resultTransformer en la
				// subcriteria. Subcriteria
				// no puede ser casteado a CriteriaImpl, que es lo necesario
				// para obtener el
				// ResultTransformer.
				populateCriteria(subCrit, (Opcion[]) opt.valorAtt);
			} else if (opt.valor == Opcion.ALIAS) {
				// la diferencia entre createAlias y createCriteria es que
				// createAlias devuelve la
				// misma criteria que lo crea, mientras que createCriteria
				// define una subCriteria y
				// la devuelve. En cuanto a rendimiento es lo mismo, ambos crean
				// una instancia de
				// subCriteria, pero createAlias trabaja sobre la criteria
				// padre, y createCriteria
				// expone la subcriteria creada para que se le puedan definir
				// mas criterions
				// directamente. CreateCriteria tiene mas opciones para
				// controlar el JoinType,
				// ademas.
				crit.createAlias(opt.nombreAtt, opt.valorAtt.toString());
			} else if (opt.valor == Opcion.AND) {
				crit.add(createJunction(opt));
			} else if (opt.valor == Opcion.OR) {
				crit.add(createJunction(opt));
			} else if (opt.valor == Opcion.NOT) {
				crit.add(Restrictions.not(createAttrib((Opcion) opt.valorAtt)));
			} else if (opt.valor == Opcion.FETCH) {
				crit.setFetchMode(opt.nombreAtt, (FetchMode) opt.valorAtt);
			} else if ((opt.valor == Opcion.ORDER_ASC) || (opt.valor == Opcion.ORDER_DESC)) {
				if (opt.nombreAtt.indexOf('.') > -1) {
					final Criteria subcriteria = createSubCriteria(crit, opt.nombreAtt.substring(0, opt.nombreAtt.lastIndexOf('.')), JoinType.LEFT_OUTER_JOIN);
					orders.add(new Object[] { null, (opt.valor == Opcion.ORDER_ASC) ? Order.asc(opt.nombreAtt.substring(opt.nombreAtt.lastIndexOf('.') + 1))
							: Order.desc(opt.nombreAtt.substring(opt.nombreAtt.lastIndexOf('.') + 1)), subcriteria });
				} else
					orders.add(new Object[] { null, (opt.valor == Opcion.ORDER_ASC) ? Order.asc(opt.nombreAtt) : Order.desc(opt.nombreAtt) });
			} else if (opt.valor == Opcion.PROJECTION) {
				pl.add(Projections.property(opt.nombreAtt));
				opProjFlag = true;
			} else if (opt.valor == Opcion.GROUP_PROJ) {
				pl.add(Projections.groupProperty(opt.nombreAtt), opt.valorAtt.toString());
				opProjFlag = true;
			} else if (opt.valor == Opcion.PAGINATED) {
				res = opt;
			} else if (opt.valor == Opcion.TRANSFORMER) {
				transformer = ResultTransformer.class.cast(opt.valorAtt);
			} else if (opt.valor == Opcion.GROUP_HINT) {
				pl.add(Projections.sqlProjection("/*+" + opt.nombreAtt.toString() + "*/ 1 AS HINT", new String[] {}, new Type[] {}));
				opProjFlag = true;
			} else if (opt.valor == Opcion.MAX_RESULTS) {
				crit.setMaxResults((Integer) opt.valorAtt);
			} else
				throw new DataBaseException("Una opcion especificada para la construccion de criteria no es correcta.");
		}

		if (!atts.isEmpty())
			for (Criterion att : atts)
				crit.add(att);
		// si es necesario proyectar, se adiciona la lista de proyecciones
		// ademas se proyecta antes del resulTransformer porque la proyeccion
		// especifica un nuevo
		// resulTransformer
		if (opProjFlag)
			crit.setProjection(pl);

		// el result transformer por defecto en el criteria es el ROOT_ENTITY,
		// pero para las
		// consultas estas es DISTINCT_ROOT_ENTITY.
		if (transformer != null)
			crit.setResultTransformer(transformer);
		else
			/*
			 * INFORMACION: Como averigue recientemente (27-09-2010) (aunque era
			 * bastante obvio) el ResultTransformer DISTINCT_ROOT_ENTITY opera
			 * sobre el resultado, en vez de interferir en la produccion del
			 * SQL. Esto significa que para consultas con muchos resultados no
			 * es eficiente, dado que se obtienen todos los resultados primero y
			 * luego se filtran en el codigo de la aplicacion para eliminar
			 * duplicados. Para consultas pequennas la perdida de eficiencia es
			 * negligible y comparable a la perdida del codigo siquiente. El
			 * codigo que sigue es el equivalente de especificar el
			 * resultTransformer mencionado, pero lo que hace es generar la
			 * sentencia select distinct en el SQL, haciendo que la operacion
			 * sea mas rapida. Lo dejo aqui por si es necesario cambiarlo en
			 * algun momento.
			 * 
			 * String[] properties =
			 * getCurrentSession().getSessionFactory().getClassMetadata(
			 * claseEntidad ).getPropertyNames(); ProjectionList list =
			 * Projections.projectionList(); for (int i = 0; i <
			 * properties.length; ++i)
			 * list.add(Projections.property(properties[i]), properties[i]);
			 * criteria.setProjection(Projections.distinct(list));*
			 */
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		// el paginatedListOptions tiene su propia manera de ordenar los
		// criterios. Si en alguna
		// consulta se pasan Options.pag() y Options.asc()/desc(), los segundos
		// se ignoran en favor
		// del ordenamiento en la paginacion. En caso que no se pase paginacion,
		// entonces se ordena
		// por los criterios especificados en el orden en que se ponen en la
		// llamada
		// si res no es null, entonces es paginado
		if (res == null)
			for (Object[] ord : orders) {
				if ((null == ord[0])) {
					if (ord.length < 3)
						crit.addOrder((Order) ord[1]);
					else
						((Criteria) ord[2]).addOrder((Order) ord[1]);
				}
			}
		return res;
	}

	protected static final Criteria createSubCriteria(Criteria parent, String associationPath, JoinType joinType) throws HibernateException {
		while (parent instanceof Subcriteria)
			parent = ((Subcriteria) parent).getParent();
		final Iterator<Subcriteria> iterator = ((CriteriaImpl) parent).iterateSubcriteria();
		Subcriteria subcriteria;
		while (iterator.hasNext()) {
			subcriteria = iterator.next();
			if (associationPath.equals(subcriteria.getPath()))
				return subcriteria;
		}
		return parent.createCriteria(associationPath, joinType);
	}

}
