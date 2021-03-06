package dominioPais.dominioCorporativo.nucleo.excepciones;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public class RequiredOptionsException extends SystemException {
	private static final long serialVersionUID = -119888907918704857L;

	public RequiredOptionsException(String atributo, Integer valor) {
		super(String.format("Se ha pasado un valor null a un Options marcado como requerido (Atributo: %s, Operador: %d).", atributo, valor));
	}

}
