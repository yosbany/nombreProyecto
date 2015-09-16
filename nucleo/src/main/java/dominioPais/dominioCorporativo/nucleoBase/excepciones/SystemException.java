package dominioPais.dominioCorporativo.nucleoBase.excepciones;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public class SystemException extends BaseException {
	private static final long serialVersionUID = -6184375899704418079L;

	protected String subSistema;

	protected String clase;

	protected String metodo;

	public SystemException() {
		super();
	}

	public SystemException(Exception causa, String mensaje) {
		super(causa, mensaje);
	}

	public SystemException(String mensaje) {
		super(mensaje);
	}

	public String getSubSistema() {
		return subSistema;
	}

	public void setSubSistema(String subSistema) {
		this.subSistema = subSistema;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
