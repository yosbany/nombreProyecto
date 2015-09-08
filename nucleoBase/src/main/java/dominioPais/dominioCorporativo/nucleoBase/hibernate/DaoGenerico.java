package dominioPais.dominioCorporativo.nucleoBase.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;
import dominioPais.dominioCorporativo.nucleoBase.hibernate.utils.Opcion;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Repository
public class DaoGenerico implements IDaoGenerico {

	@Override
	public void activarObjeto(EntidadPersistenteBase entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void desactivarObjeto(EntidadPersistenteBase entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> int contarElementos(Class<T> claseEntidad, Opcion... parametros) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> int contarElementos(Class<T> claseEntidad, Integer filtros, Opcion... parametros) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void salvar(EntidadPersistenteBase entidad) throws DataBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(EntidadPersistenteBase entidad) throws DataBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(EntidadPersistenteBase entidad, String motivo) throws DataBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ocultar(EntidadPersistenteBase entidad, String motivo) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends EntidadPersistenteBase> void eliminar(Collection<T> coleccion, String motivo) throws DataBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T obtenerUnico(Class<T> claseEntidad, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T obtenerUnico(Class<T> claseEntidad, Integer filtros, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T obtenerPrimero(Class<T> claseEntidad, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T obtenerPrimero(Class<T> claseEntidad, Integer filtros, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> obtener(Class<T> claseEntidad, List<Opcion> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> obtener(Class<T> claseEntidad, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> obtener(Class<T> claseEntidad, Integer filtros, Opcion... parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void discardChanges(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detachObject(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Session openSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

}