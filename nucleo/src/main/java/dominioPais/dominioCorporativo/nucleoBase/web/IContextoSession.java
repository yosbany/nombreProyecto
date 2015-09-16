package dominioPais.dominioCorporativo.nucleoBase.web;

/**
 * 
 * @author Yosbany Tejas
 *
 */
public interface IContextoSession {
	/**
	 * M�todo para redireccionar la navegaci�n program�ticamente.
	 * 
	 * @param viewId
	 *            ID de la vista a la que se va a navegar, tal y como se especifica en las reglas de
	 *            navegaci&oacute;n (ruta absoluta a partir del WebContent sin el .do). Ejemplo:
	 *            <code>&quot;/ruta/&quot;</code>
	 */
	public IContextoSession navigateTo(String viewId);

	/**
	 * M�todo para redireccionar la navegaci�n hacia la p�gina de bienvenida.
	 */
	public IContextoSession navigateToHomePage();

	public IContextoSession navigateToPreviousPage();

	public String getPreviousPage();

	public boolean isAtHomePage();

	public String getCurrentViewId();

	/**
	 * @param menuKey
	 *            Id asociado al elemento del men� que se desea obtener la vista asociada.
	 * @return la viewId de la vista asociada a la llave del men� <code>menuKey</code>.
	 */
	public String getViewIdByKey(String menuKey);

	public <F extends Object> F getLoggedUser();

}
