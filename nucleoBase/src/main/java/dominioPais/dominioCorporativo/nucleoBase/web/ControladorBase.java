package dominioPais.dominioCorporativo.nucleoBase.web;

import java.awt.event.ActionEvent;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

public class ControladorBase {

	public static final String ATTR_FORCED_BEAN_NAME = "FORCED_BEAN_NAME";

	public static final String EVENT_FLOW_ADD = "FLOW_ADD";
	public static final String EVENT_FLOW_DISSOCIATE = "FLOW_DISSOCIATE";
	public static final String EVENT_FLOW_ENDED = "FLOW_ENDED";
	public static final String EVENT_FLOW_CANCELED = "FLOW_CANCEL";
	public static final String EVENT_FLOW_FINALIZED = "FLOW_FINALIZE";

	private static final String PREVIOUS_REGISTERED_BEAN_INSTANCE_ATTRIBUTE = "PREVIOUS_REGISTERED_BEAN_INSTANCE";

	protected static final String ERROR = "Ha ocurrido un error.";
	protected static final String HAY_COINCIDENCIAS = "Se han encontrado coincidencias. Usted puede seleccionar un elemento del listado o incluir uno nuevo.";
	protected static final String HAY_COINCIDENCIA = "Se ha encontrado una coincidencia. Usted puede seleccionar el elemento o incluir uno nuevo.";
	protected static final String COINCIDENCIAS = "Se han encontrado coincidencias.";
	public static final String NO_COINCIDENCIAS = "No se encontraron coincidencias.";
	protected static final String ACCION_CANCELADA = "La acci\u00F3n ha sido cancelada.";
	protected static final String ERROR_CARGANDO_RECURSOS = "Ha ocurrido un error obteniendo el recurso.";
	protected static final String FUNCIONALIDAD_NO_SOPORTADA = "La funcionalidad {0} no est\u00E1 soportada en esta versi\u00F3n del sistema.";
	protected static final String HISTORICO_SIN_MODIFICACIONES = "No se han hecho modificaciones en el atributo ''{0}''.";
	protected static final String ENCABEZADO_CONSULTAR = "Criterios de B\u00FAsqueda";
	protected static final String ENCABEZADO_COINCIDENCIAS = "Listado de Resultados";
	protected static final String DATOS_OBLIGATORIOS_BUSQUEDA = "Debe especificar al menos un criterio de b\u00FAsqueda.";
	protected static final String ELEMENTO_CREADO = "Se ha creado un Elemento.";
	protected static final String ELEMENTO_ACTUALIZADO = "Se ha actualizado el Elemento.";
	protected static final String ELEMENTO_ELIMINADO = "El elemento seleccionado ha sido eliminado.";
	protected static final String NOVEDAD_CREADA = "Se ha creado una Novedad en el Despacho.";
	protected static final String ELEMENTO_YA_INCLUIDO = "El elemento que intenta incluir ya se encuentra en el sistema.";
	protected static final String ELEMENTO_GUARDADO = "Se han guardado los datos del elemento. Para acceder a ellos, consulte la bandeja de Borradores de su Agenda de Trabajo.";
	public static final String ERROR_GENERANDO_REPORTE = "Ha ocurrido un error generando el reporte.";
	public static final String ELEMENTO_EXISTENTE_LISTA = "No se puede adicionar. {0} ya existe en la lista.";
	public static final String DATOS_OBLIGATORIOS = "Existen campos vac\u00EDos que son obligatorios, por favor, complete estos datos.";
	public static final String DATOS_INCORRECTOS = "Existen campos escritos incorrectamente, por favor, rectifique estos datos.";

	protected EscritorioTrabajo escritorio;

	private Map<String, Object> attributes;

	private String urlAnterior;

	@Resource(name = "escritorioManejado")
	protected void setEscritorio(EscritorioTrabajo escritorio) {
		this.escritorio = escritorio;
	}

	/**
	 * Bandera para establecer el bean como activo en las llamadas al metodo
	 * navigate. Existe solo para aumentar la claridad de las llamadas (true y
	 * false no son descriptivos de la funcion realizada)
	 */
	public final static boolean ACTIVAR = true;
	/**
	 * Bandera para establecer el bean como activo en las llamadas al metodo
	 * navigate. Existe solo para aumentar la claridad de las llamadas (true y
	 * false no son descriptivos de la funcion realizada)
	 */
	public final static boolean NO_ACTIVAR = false;

	/**
	 * Este metodo permite condensar las llamadas a navigateTo y
	 * establecerComoActivo en una sola llamada, dado que la inmensa mayoria de
	 * la navegacion combina estos metodos.Es un metodo de conveniencia que
	 * relega el verdadero trabajo a las opciones anteriormente existentes de la
	 * clase. Esta sobrecarga no modifica la url anterior
	 * 
	 * @param activarBean
	 *            el bean sobre el cual se modifica la urlAnterior y se
	 *            establece como activo. algunos pocos casos de navegacion en el
	 *            sistema no presentan un bean que pueda ser utilizado de esta
	 *            manera, pero la inmensa mayoria de la navegacion primeramente
	 *            instancia un bean de algun tipo y lo configura para luego
	 *            dirigir la navegacion a la pagina que este bean
	 *            soporta.Funcionalmente, es como navegar hacia el bean, que es
	 *            lo que se quiere expresar con el metodo
	 * @param viewId
	 *            la url del jsp a navegar
	 * @return el bean sobre el que se realiza la llamada, para permitir
	 *         llamadas encadenadas
	 */
	public ControladorBase navigate(boolean activarBean, String viewId) {
		if (activarBean)
			this.establecerComoActivo();
		escritorio.navigateTo(viewId);
		return this;
	}

	/**
	 * Este metodo permite condensar las llamadas a navigateTo, setUrlAnterior y
	 * establecerComoActivo en una sola llamada, dado que la inmensa mayoria de
	 * la navegacion combina estos metodos.Es un metodo de conveniencia que
	 * relega el verdadero trabajo a las opciones anteriormente existentes de la
	 * clase. Esta sobrecarga modifica la url anterior
	 * 
	 * @param activarBean
	 *            el bean sobre el cual se modifica la urlAnterior y se
	 *            establece como activo. algunos pocos casos de navegacion en el
	 *            sistema no presentan un bean que pueda ser utilizado de esta
	 *            manera, pero la inmensa mayoria de la navegacion primeramente
	 *            instancia un bean de algun tipo y lo configura para luego
	 *            dirigir la navegacion a la pagina que este bean
	 *            soporta.Funcionalmente, es como navegar hacia el bean, que es
	 *            lo que se quiere expresar con el metodo
	 * @param viewId
	 *            la url del jsp a navegar
	 * @param urlAnterior
	 *            la url anterior para setear al bean
	 * @return el bean sobre el que se realiza la llamada, para permitir
	 *         llamadas encadenadas
	 */
	public ControladorBase navigate(boolean activarBean, String viewId, String urlAnterior) {
		if (activarBean)
			this.establecerComoActivo(urlAnterior);
		else
			this.setUrlAnterior(urlAnterior);
		escritorio.navigateTo(viewId);
		return this;
	}

	public String getUrlActual() {
		return escritorio.getCurrentViewId();
	}

	/**
	 * Método para mostrar un mensaje de Advertencia a partir del identificador
	 * del mensaje en el bundle asociado al bean manejado que lo invoca.
	 * 
	 * @param idMensaje
	 *            Llave del mensaje en el bundle asociado al bean
	 * @param parameters
	 *            parameters
	 */
	public ControladorBase adicionarMensajeAdvertencia(String idMensaje, Object... parameters) {

		return this;
	}

	/**
	 * Método para mostrar un mensaje de Error a partir del identificador del
	 * mensaje en el bundle asociado al bean manejado que lo invoca.
	 * 
	 * @param idMensaje
	 *            Llave del mensaje en el bundle asociado al bean
	 * @param parameters
	 *            parameters
	 */
	public ControladorBase adicionarMensajeError(String idMensaje, Object... parameters) {

		return this;
	}

	public ControladorBase adicionarMensajeExcepcion(Exception e) {

		return this;
	}

	public boolean adicionarMensajeErrorSiNulo(Object arg, String idMensaje) {
		if (arg == null) {
			adicionarMensajeError(idMensaje);
			return false;
		}
		return true;
	}

	/**
	 * Si la condicion es verdadera, imprime el mensaje de error especificado y
	 * regresa false. Diseñada para usarse en casos como
	 * if(adicionarMensajeErrorSi(condicion,mensaje))
	 * 
	 * @param condition
	 * @param idMensaje
	 * @return false si se incluye un mensaje, true si no se hace.
	 */
	public boolean adicionarMensajeErrorSi(boolean condition, String idMensaje) {
		if (condition) {
			adicionarMensajeError(idMensaje);
			return false;
		} else
			return true;
	}

	/**
	 * Método para mostrar un mensaje de Información a partir del identificador
	 * del mensaje en el bundle asociado al bean manejado que lo invoca.
	 * 
	 * @param idMensaje
	 *            Llave del mensaje en el bundle asociado al bean
	 * @param parameters
	 *            parameters
	 */
	public ControladorBase adicionarMensajeInformacion(String idMensaje, Object... parameters) {

		return this;
	}

	/**
	 * Realiza las verificaciones comunes para una lista de elementos obtenida
	 * por una consulta. Por el momento solo se verifica si arroj&oacute;
	 * resultados, mostrando el mensaje correspondiente en caso contrario.
	 * 
	 * @param resultados
	 *            Lista a verificar
	 * @return true en caso de no estar vacia, false en caso contrario
	 */
	public boolean verificarListadoCoincidencias(Collection<?> resultados) {
		try {
			if (!resultados.isEmpty())
				return true;
		} catch (NullPointerException e) {
			// Nada que hacer, se continua tomando como vacia
		}
		adicionarMensajeInformacion(NO_COINCIDENCIAS);
		return false;
	}

	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}

	/**
	 * M&eacute;todo que retorna la URL a la que debe retornar la vista una vez
	 * haya concluido sus operaciones. Dicho valor debe establecerse usando
	 * <code>setUrlAnterior</code>
	 * 
	 * @return Valor actual de la URL anterior.
	 */
	public String getUrlAnterior() {
		return urlAnterior;
	}

	/**
	 * M&eacute;todo que establece la URL a la que debe retornar la vista una
	 * vez haya concluido sus operaciones.
	 * 
	 * @param urlAnterior
	 *            URL a la que se debe retornar.
	 * 
	 */
	public void setUrlAnterior(String urlAnterior) {
		this.urlAnterior = urlAnterior;
	}

	public void setUrlAnterior(String urlAnterior, boolean overrideWithPreviousBean) {
		final ControladorBase previousBean = getPreviousBeanInstance();
		if (null != previousBean)
			this.urlAnterior = previousBean.getUrlAnterior();
		else
			this.urlAnterior = urlAnterior;
	}

	/**
	 * M&eacute;todo que se utiliza para retornar a la URL anterior, en los
	 * casos que la especificaci&oacute;n del CU dice &quot;Retorna a la vista
	 * anterior&quot;.
	 * 
	 */
	public ControladorBase retornarUrlAnterior() {
		escritorio.navigateTo(
				((null != urlAnterior && !urlAnterior.isEmpty()) ? urlAnterior : EscritorioTrabajo.HOME_PAGE_VIEW_ID));
		return this;
	}

	public void retornarUrlAnterior(ActionEvent event) {
		retornarUrlAnterior();
	}

	public ControladorBase cancelarOperacion() {
		retornarUrlAnterior();
		return this;
	}

	/**
	 * Esta funcionalidad es para mostrar los detalles de una funcionaliad no
	 * implementada en esta version del sistema, recibe como parámetros el
	 * titulo de la funcionalidad no implementada o disponible, los detalles que
	 * explican la causa, y la url para donde debe redireccionar una vez
	 * clickeado el botón aceptar.
	 * 
	 * @param titulo
	 *            titulo
	 * @param detalles
	 *            detalles
	 */
	public ControladorBase funcionalidadNoSoportada(String titulo, String detalles) {
		adicionarMensajeInformacion(FUNCIONALIDAD_NO_SOPORTADA, titulo, detalles);
		return this;
	}

	/**
	 * @return nombre que DEBE tener para JSF el bean manejado en dependencia de
	 *         su clase.<br>
	 *         <b>Ejemplo:</b><br>
	 *         Una instancia del bean manejado
	 *         <code>GestionarPersonaManejado</code>, devuelve
	 *         <code>gestionarPersonaManejado</code>
	 */
	public String getBeanName() {
		if (null != getAttributeValue(ATTR_FORCED_BEAN_NAME))
			return getAttributeValue(ATTR_FORCED_BEAN_NAME);
		else {
			final String className = this.getClass().getSimpleName();
			return className.substring(0, 1).toLowerCase().concat(className.substring(1));
		}
	}

	public ControladorBase activarDependencias() {
		return this;
	}

	/**
	 * Asigna la instancia del bean al <code>ValueBinding</code> correspondiente
	 * (Usando el m&eacute;todo <code>getBeanName</code>).
	 * 
	 * @param urlAnterior
	 *            la urlAnterior a setear para el bean
	 * @return el bean que se establece como activo
	 */
	public <T extends ControladorBase> T establecerComoActivo(String urlAnterior) {
		setUrlAnterior(urlAnterior);
		return establecerComoActivo();
	}

	/**
	 * Asigna la instancia del bean al <code>ValueBinding</code> correspondiente
	 * (Usando el m&eacute;todo <code>getBeanName</code>).
	 * 
	 * @return base bean
	 */
	@SuppressWarnings("unchecked")
	public <T extends ControladorBase> T establecerComoActivo() {

		return (T) this;
	}

	public ControladorBase setPreviousBeanInstance(ControladorBase bean) {
		this.setAttributeValue(PREVIOUS_REGISTERED_BEAN_INSTANCE_ATTRIBUTE, bean);
		return this;
	}

	public ControladorBase removePreviousBeanInstance() {
		this.setAttributeValue(PREVIOUS_REGISTERED_BEAN_INSTANCE_ATTRIBUTE, null);
		return this;
	}

	public <T extends ControladorBase> T getPreviousBeanInstance() {
		return this.getAttributeValue(PREVIOUS_REGISTERED_BEAN_INSTANCE_ATTRIBUTE);
	}

	public ControladorBase restorePreviousBeanInstance() {
		final ControladorBase bean = (ControladorBase) this
				.getAttributeValue(PREVIOUS_REGISTERED_BEAN_INSTANCE_ATTRIBUTE);
		this.eliminarBean();

		return bean;
	}

	public String getELForMethod(String methodName) {
		return String.format("#" + "{%" + "s.%s}", this.getBeanName(), methodName);
	}

	/**
	 * Elimina de sesi&oacute;n la instancia del bean correspondiente (Usando el
	 * m&eacute;todo <code>getBeanName</code>).
	 */
	public void eliminarBean() {

	}

	public void eliminarBean(String nombreBean) {

	}

	void eliminarBeanPorEvento() {

	}

	public ControladorBase removeBeanOnEvent(String eventId) {

		return this;
	}

	public String obtenerFechaFormato(Date fecha) {
		return null;
	}

	public String getMessage(String key, Object... parameters) {
		String value = key;
		if (null != key && (parameters != null) && (parameters.length > 0)) {
			MessageFormat mf = new MessageFormat(key);
			value = mf.format(parameters, new StringBuffer(), null).toString();
		}
		return value;
	}

	// Métodos para el manejo de los atributos

	public Map<String, Object> getAttributes() {
		if (null == attributes)
			attributes = new HashMap<String, Object>();
		return attributes;
	}

	public boolean containsAttribute(String name) {
		if (null == attributes)
			return false;
		else
			return attributes.containsKey(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttributeValue(String name) {
		if (null != attributes)
			return (T) attributes.get(name);
		else
			return null;
	}

	public <T> T setAttributeValue(String name, T value) {
		if (null != value)
			getAttributes().put(name, value);
		else
			getAttributes().remove(name);
		return value;
	}

	public ControladorBase clearAttributes() {
		attributes = null;
		return this;
	}
}
