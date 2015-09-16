package dominioPais.dominioCorporativo.nucleoBase.excepciones;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;

import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.Opcion;

public class NoUniqueResultException extends DataBaseException {
	private static final long serialVersionUID = 6045718085750349129L;

	private final Class<?> claseEntidad;
	private final Criteria criteria;
	private final Opcion[] parametros;

	public NoUniqueResultException(NonUniqueResultException cause, Class<?> claseEntidad, Criteria criteria, Opcion[] parametros) {
		super(cause, cause.getMessage());
		this.claseEntidad = claseEntidad;
		this.criteria = criteria;
		this.parametros = parametros;
	}

	public Class<?> getClaseEntidad() {
		return claseEntidad;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public Opcion[] getParametros() {
		return parametros;
	}

}
