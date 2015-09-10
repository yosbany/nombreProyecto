package dominioPais.dominioCorporativo.nucleoBase.manager;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.IDaoGenerico;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.HibernateUtils;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.Opcion;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Service
public class ManagerGenerico implements IManagerGenerico {

	@Autowired
	private IDaoGenerico daoGenerico;
	
	/**
	 * Getter and Setter
	 */
	public IDaoGenerico getDaoGeneric() {
		return daoGenerico;
	}

	public void setDaoGeneric(IDaoGenerico daoGenerico) {
		this.daoGenerico = daoGenerico;
	}

	@Override
	public void salvar(EntidadPersistenteBase entidad) throws DataBaseException {
		this.daoGenerico.salvar(entidad);
	}

	@Override
	public void actualizar(EntidadPersistenteBase entidad) throws DataBaseException {
		this.daoGenerico.actualizar(entidad);

	}

	@Override
	public void salvarActualizar(EntidadPersistenteBase entidad) throws DataBaseException {
		if (entidad.getId() != null)
			daoGenerico.actualizar(entidad);
		else
			daoGenerico.salvar(entidad);
	}
	
	@Override
	public <T extends EntidadPersistenteBase> List<T> obtener(Class<T> claseEntidad) throws DataBaseException {
		return daoGenerico.obtener(claseEntidad);
	}

	@Override
	public <T extends EntidadPersistenteBase> List<T> obtener(Class<T> claseEntidad, String atributo, Object valor) throws DataBaseException {
		if (valor instanceof Collection)
			return daoGenerico.obtener(claseEntidad, Opcion.in(atributo, (Collection<?>) valor));
		else
			return daoGenerico.obtener(claseEntidad, Opcion.eq(atributo, valor));
	}

	@Override
	public <T extends EntidadPersistenteBase> T obtenerUnico(Class<T> claseEntidad, String atributo, Object valor) throws DataBaseException {
		return daoGenerico.obtenerUnico(claseEntidad, Opcion.eq(atributo, valor));
	}

	@Override
	public <T extends EntidadPersistenteBase> T obtenerUnico(Class<T> claseEntidad, String atributo, Object valor, boolean ignoreCase) throws DataBaseException {
		if (ignoreCase)
			return daoGenerico.obtenerUnico(claseEntidad, Opcion.ieq(atributo, valor));
		return daoGenerico.obtenerUnico(claseEntidad, Opcion.eq(atributo, valor));
	}

	@Override
	public <T extends EntidadPersistenteBase> int contarElementos(Class<T> claseEntidad, String atributo, Object valor) {
		return daoGenerico.contarElementos(claseEntidad, Opcion.eq(atributo, valor));
	}

	@Override
	public <T extends EntidadPersistenteBase> int contarElementos(Class<T> claseEntidad, String atributo, Object valor, boolean ignoreCase) {
		if (ignoreCase)
			return daoGenerico.contarElementos(claseEntidad, Opcion.ieq(atributo, valor));
		else
			return daoGenerico.contarElementos(claseEntidad, Opcion.eq(atributo, valor));
	}

	@Override
	public <T extends EntidadPersistenteBase> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException {
		return daoGenerico.obtenerPorId(claseEntidad, valor);
	}

	@Override
	public <T extends EntidadPersistenteBase> T obtenerPorId(Class<T> claseEntidad, Integer valor, boolean proxy) throws DataBaseException {
		if (!proxy) {
			T element = daoGenerico.obtenerPorId(claseEntidad, valor);
			return HibernateUtils.initialize(element);
		}
		return obtenerPorId(claseEntidad, valor);
	}

	

	@Override
	public void eliminar(EntidadPersistenteBase entidad) {
		daoGenerico.eliminar(entidad);
	}

}
