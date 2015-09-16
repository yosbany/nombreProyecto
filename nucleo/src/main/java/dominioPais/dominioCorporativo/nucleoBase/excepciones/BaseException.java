package dominioPais.dominioCorporativo.nucleoBase.excepciones;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 7162337011328146895L;

	public BaseException() {
		super("EXCEPCION_DESCONOCIDA", null);
	}

	public BaseException(Throwable causa, String mensaje) {
		super(mensaje, causa);
	}

	public BaseException(String mensaje) {
		super(mensaje, null);
	}
}
