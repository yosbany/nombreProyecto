package dominioPais.dominioCorporativo.nucleo.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import dominioPais.dominioCorporativo.nucleo.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleo.excepciones.DataBaseException;
import dominioPais.dominioCorporativo.nucleo.hibernate.utils.Opcion;

/**
 * 
 * @author Yosbany Tejas
 *
 */
public interface IDaoGenerico {

	public void habilitarObjeto(EntidadPersistenteBase entidad);

	public void desabilitarObjeto(EntidadPersistenteBase entidad);

	/**
	 * Utilizando las options, crea un criteria y le aplica una proyeccion
	 * rowCount() para devolver la cantidad de resultados de la consulta
	 * especificada
	 * 
	 * @param claseEntidad
	 * @param parametros
	 * @return
	 */
	public <T> int contarElementos(Class<T> claseEntidad, Opcion... parametros);

	/**
	 * Salva una instancia de <code>EntidadPersistenteBase</code>. En caso de
	 * tener que incluir alguna l&oacute;gica espec&iacute;fica en el momento de
	 * realizar esta acci&oacute;n, se debe sobreescribir este metodo en la
	 * fachada correspondiente. <br/>
	 * El par&aacute;metro no puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea salvar.
	 * @throws DataBaseException
	 *             Si el par&aacute;metro pasado es <code>null</code>.
	 */
	public void salvar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Actualiza una instancia de <code>EntidadPersistenteBase</code>. En caso
	 * de tener que incluir alguna l&oacute;gica espec&iacute;fica en el momento
	 * de realizar esta acci&oacute;n, se debe sobreescribir este metodo en la
	 * fachada correspondiente.<br/>
	 * El par&aacute;metro no puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea actualizar.
	 * @throws DataBaseException
	 *             Si el par&aacute;metro pasado es <code>null</code>.
	 */
	public void actualizar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Elimina una instancia de <code>EntidadPersistenteBase</code>. En caso de
	 * tener que adicionar alguna l&oacute;gica espec&iacute;fica en el momento
	 * de realizar esta acci&oacute;n, se debe sobreescribir este metodo en la
	 * fachada correspondiente.<br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea eliminar.
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public void eliminar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Eliminar.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param coleccion
	 *            coleccion
	 * @throws DataBaseException
	 *             data base exception
	 */
	public <T extends EntidadPersistenteBase> void eliminar(Collection<T> coleccion) throws DataBaseException;

	/**
	 * Obtener unico.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            clase entidad
	 * @param parametros
	 *            parametros
	 * @return t
	 */
	public <T> T obtenerUnico(Class<T> claseEntidad, Opcion... parametros);

	/**
	 * Devuelve el primer elemento de los resultados. Siempre que se desee hacer
	 * esto, usar este metodo, ya que no carga TODOS los objetos, sino solo el
	 * primero.
	 * 
	 * @param claseEntidad
	 *            clase de la entidad que se desea obtener
	 * @param parametros
	 *            Parametros para restringir la consulta.
	 * @return El primer elemento de la consulta resultante.
	 */
	public <T> T obtenerPrimero(Class<T> claseEntidad, Opcion... parametros);

	public <T> List<T> obtener(Class<T> claseEntidad, Opcion... parametros);

	/**
	 * Obtener por id.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            clase entidad
	 * @param valor
	 *            valor
	 * @return t
	 * @throws DataBaseException
	 *             data base exception
	 */
	public <T> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException;

	/**
	 * Este metodo se encarga de refrescar el objeto pasado por parametro con la
	 * base de datos manteniendo el mismo identificador de java. Se utiliza
	 * cuando es necesario que el objeto se mantenga asociado a la sesion sin
	 * persistir los cambios realizados sobre el en la BD.
	 * 
	 * @param object
	 *            objeto que desea refrescar
	 */
	public void descartarCambios(Object object);

	/**
	 * Para uso de la maquina de estados y el generador de numeros.
	 * 
	 * @return session
	 */
	public Session openSession();

	public Session getCurrentSession();
}
