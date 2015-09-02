package dominioPais.dominioCorporativo.nucleoBase.datos;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.BaseException;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;


public interface DaoGenerico {

	public void activarObjeto(dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase entidad);

	public void desactivarObjeto(EntidadPersistenteBase entidad);

	/**
	 * Utilizando las options, crea un criteria y le aplica una proyeccion rowCount() para devolver
	 * la cantidad de resultados de la consulta especificada
	 * 
	 * @param claseEntidad
	 * @param parametros
	 * @return
	 */
	public <T> int contarElementos(Class<T> claseEntidad, Criteria criteria);

	/**
	 * Utilizando las options, crea un criteria y le aplica una proyeccion rowCount() para devolver
	 * la cantidad de resultados de la consulta especificada
	 * 
	 * @param claseEntidad
	 * @param filtros
	 * @param parametros
	 * @return
	 */
	public <T> int contarElementos(Class<T> claseEntidad, Integer filtros, Criteria criteria);

	/**
	 * Salva una instancia de <code>EntidadPersistenteBase</code>. En caso de tener que incluir
	 * alguna l&oacute;gica espec&iacute;fica en el momento de realizar esta acci&oacute;n, se debe
	 * sobreescribir este metodo en la fachada correspondiente. <br/>
	 * El par&aacute;metro no puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea salvar.
	 * @throws DataBaseException
	 *             Si el par&aacute;metro pasado es <code>null</code>.
	 */
	public void salvar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Actualiza una instancia de <code>EntidadPersistenteBase</code>. En caso de tener que incluir
	 * alguna l&oacute;gica espec&iacute;fica en el momento de realizar esta acci&oacute;n, se debe
	 * sobreescribir este metodo en la fachada correspondiente.<br/>
	 * El par&aacute;metro no puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea actualizar.
	 * @throws DataBaseException
	 *             Si el par&aacute;metro pasado es <code>null</code>.
	 */
	public void actualizar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Elimina una instancia de <code>EntidadPersistenteBase</code>. En caso de tener que adicionar
	 * alguna l&oacute;gica espec&iacute;fica en el momento de realizar esta acci&oacute;n, se debe
	 * sobreescribir este metodo en la fachada correspondiente.<br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea eliminar.
	 * @param motivo
	 *            Indica el motivo por el que se realiza la eliminaci&oacute;n.
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public void eliminar(EntidadPersistenteBase entidad, String motivo) throws DataBaseException;

	/**
	 * Elimina una colecci&oacute;n de objetos de tipo <code>EntidadPersistenteBase</code>. En caso
	 * de tener que adicionar alguna l&oacute;gica espec&iacute;fica en el momento de realizar esta
	 * acci&oacute;n, se debe sobreescribir este metodo en la fachada correspondiente.<br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            entidad
	 * @param motivo
	 *            Indica el motivo por el que se realiza la eliminaci&oacute;n.
	 */
	public void ocultar(EntidadPersistenteBase entidad, String motivo);

	/**
	 * Eliminar.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param coleccion
	 *            coleccion
	 * @param motivo
	 *            motivo
	 * @throws DataBaseException
	 *             ABCD data base exception
	 */
	public <T extends EntidadPersistenteBase> void eliminar(Collection<T> coleccion, String motivo) throws DataBaseException;

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
	public <T> T obtenerUnico(Class<T> claseEntidad, Criteria criteria);

	/**
	 * Obtener unico.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            clase entidad
	 * @param filtros
	 *            filtros
	 * @param parametros
	 *            parametros
	 * @return t
	 */
	public <T> T obtenerUnico(Class<T> claseEntidad, Integer filtros, Criteria criteria);

	/**
	 * Devuelve el primer elemento de los resultados. Siempre que se desee hacer esto, usar este
	 * metodo, ya que no carga TODOS los objetos, sino solo el primero.
	 * 
	 * @param claseEntidad
	 *            clase de la entidad que se desea obtener
	 * @param parametros
	 *            Parametros para restringir la consulta.
	 * @return El primer elemento de la consulta resultante.
	 */
	public <T> T obtenerPrimero(Class<T> claseEntidad, Criteria criteria);

	/**
	 * Devuelve el primer elemento de los resultados. Siempre que se desee hacer esto, usar este
	 * metodo, ya que no carga TODOS los objetos, sino solo el primero.
	 * 
	 * @param claseEntidad
	 *            clase de la entidad que se desea obtener
	 * @param filtros
	 *            Filtros que se desea activar al realizar la consulta
	 * @param parametros
	 *            Parametros para restringir la consulta.
	 * @return El primer elemento de la consulta resultante.
	 */
	public <T> T obtenerPrimero(Class<T> claseEntidad, Integer filtros, Criteria criteriavvvvv);

	/**
	 * Metodo de conveniencia que delega en la sobrecarga con varargs
	 * 
	 * @param claseEntidad
	 * @param parametros
	 * @return
	 */
	public <T> List<T> obtener(Class<T> claseEntidad, Criteria criteria);

	
	public <T> List<T> obtener(Class<T> claseEntidad, Integer filtros, Criteria criteria);

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
	 *             ABCD data base exception
	 */
	public <T> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException;

	/**
	 * Ejecutar criteria paginada.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param criteria
	 *            criteria
	 * @param options
	 *            options
	 * @return list
	 */
	public <T> List<T> ejecutarCriteriaPaginada(Criteria criteria);

	/**
	 * Ejecuta un procedimiento almacenado conociendo su identificador en el contexto de Spring. Su
	 * principal ventaja es no tener que realizar la inyecci&oacute;n del bean del procedimiento
	 * almacenado en los DAOs. Notese que se regresa el resultado de la ejecucion segun el nombre
	 * del cursor. Si el procedimiento no regresa nada por cursor, se regresa nulo. Si se desea el
	 * regreso por un parametro de salida, este metodo no es adecuado.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param genericProcedureId
	 *            generic procedure id
	 * @param parametros
	 *            Lista de tamanno variable que contiene todos los parametros de entrada del metodo
	 *            o ningun valor. Si el primer valor de la lista es un Map, los demas que pudiere
	 *            haber se ignoran y se toma el mapa como los parametros de entrada del
	 *            procedimiento.
	 * @return resultado de la invocaci&oacute;n del procedimiento almacenado, segun el nombre del
	 *         cursor. En dependencia de si el metodo regresa por cursor y si existe un mapeador, el
	 *         regreso puede ser una lista de entidades, un ResultSet, o un valor nulo.
	 * @throws BaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends Object> List<T> ejecutarProcedimiento(String genericProcedureId, Object... parametros) throws BaseException;

	/**
	 * Ejecuta un procedimiento almacenado conociendo su identificador en el contexto de Spring. Su
	 * principal ventaja es no tener que realizar la inyecci&oacute;n del bean del procedimiento
	 * almacenado en los DAOs. Notese que se regresa el resultado de la ejecucion segun el nombre
	 * del cursor. Si el procedimiento no regresa nada por cursor, se regresa nulo.
	 * 
	 * Este metodo activa la aplicacion del paginado a traves de la clase.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param genericProcedureId
	 *            generic procedure id
	 * @param options
	 *            objeto que contiene las opciones de paginado para la llamada actual
	 * @param parametros
	 *            Lista de tamanno variable que contiene todos los parametros de entrada del metodo
	 *            o ningun valor. Si el primer valor de la lista es un Map, los demas que pudiere
	 *            haber se ignoran y se toma el mapa como los parametros de entrada del
	 *            procedimiento.
	 * @return resultado de la invocaci&oacute;n del procedimiento almacenado, segun el nombre del
	 *         cursor. En dependencia de si el metodo regresa por cursor y si existe un mapeador, el
	 *         regreso puede ser una lista de entidades, un ResultSet, o un valor nulo.
	 * @throws BaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends Object> List<T> ejecutarProcedimientoPaginado(String genericProcedureId, Object... parametros) throws BaseException;

	/**
	 * Para ejecutar procedimientos almacenados con la finalidad de obtener valores puntuales de los
	 * parametros de salida, y no el resultset a traves del cursor normal.
	 * 
	 * @param genericProcedureId
	 *            nombre del procedimiento almacenado
	 * @param parametroSalida
	 *            nombre del parametro de salida del que se quiere obtener el valor. Si
	 *            parametroSalida es nulo, representa que se quieren obtener mas de un parametro de
	 *            salida del result set, asi que en vez de regresar un valor particular, se regresa
	 *            mapa de resultados completo.
	 * @param parametros
	 *            los parametros de ejecucion del procedimiento almacenado
	 * @return valor del parametro que se busca, o el mapa completo de resultados si se desean
	 *         varios parametros
	 * @throws BaseException
	 *             ABCD base exception
	 */
	public Object ejecutarProcedimientoParamSalida(String genericProcedureId, String parametroSalida, Object... parametros) throws BaseException;

	/**
	 * Este metodo se encarga de refrescar el objeto pasado por parametro con la base de datos
	 * manteniendo el mismo identificador de java. Se utiliza cuando es necesario que el objeto se
	 * mantenga asociado a la sesion sin persistir los cambios realizados sobre el en la BD.
	 * 
	 * @param object
	 *            objeto que desea refrescar
	 */
	public void discardChanges(Object object);

	/**
	 * Este metodo se encarga de desconectar un objeto determinado con la sesion de hibernate. Una
	 * vez el objeto se encuentre en estado detached, no se actualizara en la BD.
	 * 
	 * @param object
	 *            Entidad que desea refrescar
	 */
	public void detachObject(Object object);

	/**
	 * Para uso de la maquina de estados y el generador de numeros.
	 * 
	 * @return session
	 */
	public Session openSession();

	public Session getCurrentSession();

}
