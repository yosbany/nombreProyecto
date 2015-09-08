package dominioPais.dominioCorporativo.nucleoBase.excepciones;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public class DataBaseException extends SystemException {
	private static final long serialVersionUID = -3422507018963727537L;

	public DataBaseException() {
		super();
	}

	public DataBaseException(String mensaje) {
		super(mensaje);
	}

	public DataBaseException(Exception causa, String mensaje) {
		super(causa, mensaje);
	}
}
