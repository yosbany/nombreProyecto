package dominioPais.dominioCorporativo.nucleo.dominio;

import java.io.Serializable;

import dominioPais.dominioCorporativo.nucleo.excepciones.BaseException;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public abstract class EntidadPersistenteBase implements Serializable {

	private static final long serialVersionUID = 2789426236961245241L;

	protected Integer id = null;

	protected boolean persist = false;

	protected boolean habilitado = true;
	
	/**
	 * Para bloquear el objeto en transacciones concurrentes, en los objetos que aplique. Solo lectura
	 */
	private int version;

	public int getVersion() {
		return version;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassEntidad() {
		throw new BaseException("La Entidad no posee el metodo redefinido.");
	}

	public boolean getPersist() {
		return persist;
	}

	public void setPersist(boolean persist) {
		this.persist = persist;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}	

}
