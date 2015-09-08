package dominioPais.dominioCorporativo.nucleoBase.fachada;

import java.util.List;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
import dominioPais.dominioCorporativo.nucleoBase.excepciones.DataBaseException;

/**
 * 
 * @author Yosbany Tejas
 *
 */
public interface IFacadaGenerica {

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
	 * Actualiza o salva una instancia de <code>EntidadPersistenteBase</code>
	 * teniendo en cuenta si este ya esta persistido o no. En caso de tener que
	 * incluir alguna l&oacute;gica espec&iacute;fica en el momento de realizar
	 * esta acci&oacute;n, se debe sobreescribir este metodo en la fachada
	 * correspondiente.<br/>
	 * El par&aacute;metro no puede ser <code>null</code>.
	 * 
	 * @param entidad
	 *            La entidad que se desea actualizar.
	 * @throws DataBaseException
	 *             Si el par&aacute;metro pasado es <code>null</code>.
	 */
	public void salvarActualizar(EntidadPersistenteBase entidad) throws DataBaseException;

	/**
	 * Obtiene una lista con los elementos coincidentes. <br/>
	 * ej.: <code>obtener(Persona.class, "usuario.idSesion", "admin");</code>
	 * <br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            Clase del elemento que se desea obtener.
	 * @param atributo
	 *            Atributo de la clase con el que se buscarán coincidencias.
	 * @param valor
	 *            Valor que debe tener el atributo especificado.
	 * @return Lista con los elementos coincidentes.
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends EntidadPersistenteBase> List<T> obtener(Class<T> claseEntidad, String atributo, Object valor) throws DataBaseException;

	/**
	 * Obtener unico.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            clase entidad
	 * @param atributo
	 *            atributo
	 * @param valor
	 *            valor
	 * @return t
	 * @throws DataBaseException data base exception
	 */
	public <T extends EntidadPersistenteBase> T obtenerUnico(Class<T> claseEntidad, String atributo, Object valor) throws DataBaseException;

	/**
	 * Obtener unico.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            clase entidad
	 * @param atributo
	 *            atributo
	 * @param valor
	 *            valor
	 * @param ignoreCase
	 *            ignore case
	 * @return t
	 * @throws DataBaseException data base exception
	 */
	public <T extends EntidadPersistenteBase> T obtenerUnico(Class<T> claseEntidad, String atributo, Object valor, boolean ignoreCase) throws DataBaseException;

	/**
	 * @param claseEntidad
	 * @param atributo
	 * @param valor
	 * @return
	 */
	public <T extends EntidadPersistenteBase> int contarElementos(Class<T> claseEntidad, String atributo, Object valor);

	/**
	 * 
	 * @param claseEntidad
	 * @param atributo
	 * @param valor
	 * @param ignoreCase
	 * @return
	 */
	public <T extends EntidadPersistenteBase> int contarElementos(Class<T> claseEntidad, String atributo, Object valor, boolean ignoreCase);

	/**
	 * Obtiene una instancia de <code>EntidadPersistenteBase</code> por el
	 * atributo <code>id</code>. <br/>
	 * ej.: <code>obtenerPorId(Persona.class, 125);</code><br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            Clase del elemento que se desea obtener.
	 * @param valor
	 *            Valor que debe tener el atributo especificado.
	 * @return EntidadPersistenteBase
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends EntidadPersistenteBase> T obtenerPorId(Class<T> claseEntidad, Integer valor) throws DataBaseException;

	/**
	 * Obtiene una instancia de <code>EntidadPersistenteBase</code> por el
	 * atributo <code>id</code>. <br/>
	 * ej.: <code>obtenerPorId(Persona.class, 125);</code><br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            Clase del elemento que se desea obtener.
	 * @param valor
	 *            Valor que debe tener el atributo especificado.
	 * @param proxy
	 *            proxy
	 * @return EntidadPersistenteBase
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends EntidadPersistenteBase> T obtenerPorId(Class<T> claseEntidad, Integer valor, boolean proxy) throws DataBaseException;

	/**
	 * Obtiene una lista con todas las instancias de una clase. <br/>
	 * ej.: <code>obtener(Persona.class);</code><br/>
	 * Ning&uacute;n par&aacute;metro puede ser <code>null</code>.
	 * 
	 * @param <T>
	 *            tipo genérico
	 * @param claseEntidad
	 *            Clase de los elementos que se desean obtener.
	 * @return Lista con todos los elementos de la clase.
	 * @throws DataBaseException
	 *             Si alg&uacute;n par&aacute;metro pasado es <code>null</code>.
	 */
	public <T extends EntidadPersistenteBase> List<T> obtener(Class<T> claseEntidad) throws DataBaseException;

	/**
	 * Eliminar.
	 * 
	 * @param entidad
	 *            entidad
	 * @param motivo
	 *            motivo
	 */
	public void eliminar(EntidadPersistenteBase entidad, String motivo);

}
