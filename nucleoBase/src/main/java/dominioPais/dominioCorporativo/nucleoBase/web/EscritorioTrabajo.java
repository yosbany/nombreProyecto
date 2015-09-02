package dominioPais.dominioCorporativo.nucleoBase.web;


public interface EscritorioTrabajo /* extends EventDispatcher */ {
	public static final String BEAN_ID = "escritorioManejado";

	public static final String VIEW_ID_CHANGED = "VIEW_ID_CHANGED";

	public static final String WORKSPACE_PAGE_VIEW_ID = "/comun/escritorioDeTrabajo.jsf";
	public static final String HOME_PAGE_VIEW_ID = "/comun/bienvenidaABCD.jsp";
	public static final String BLANK_PAGE_VIEW_ID = "/comun/blankPage.jsp";
	public static final String LOGIN_PAGE_VIEW_ID = "/comun/login.jsf";

	/**
	 * M�todo para redireccionar la navegaci�n program�ticamente.
	 * 
	 * @param viewId
	 *            ID de la vista a la que se va a navegar, tal y como se
	 *            especifica en las reglas de navegaci&oacute;n (ruta absoluta a
	 *            partir del WebContent, comenzando en y terminada en .jsp, no
	 *            .jsf). Ejemplo:
	 *            <code>&quot;/investigacioncriminalistica/consultarRegistroVehiculo.jsp&quot;</code>
	 */
	public EscritorioTrabajo navigateTo(String viewId);

	/**
	 * M�todo para redireccionar la navegaci�n hacia la p�gina de bienvenida.
	 */
	public EscritorioTrabajo navigateToHomePage();

	public void navigateToHomePage(Object e);

	public EscritorioTrabajo navigateToPreviousPage();

	public String getPreviousPage();

	public boolean isAtHomePage();

	public String getCurrentViewId();

	/**
	 * @param menuKey
	 *            Id asociado al elemento del men� que se desea obtener la vista
	 *            asociada.
	 * @return la viewId de la vista asociada a la llave del men�
	 *         <code>menuKey</code>.
	 */
	public String getViewIdByKey(String menuKey);

	public <F extends Object> F getLoggedUser();

}
