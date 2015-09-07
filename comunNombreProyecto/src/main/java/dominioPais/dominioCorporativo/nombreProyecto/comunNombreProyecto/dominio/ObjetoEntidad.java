package dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.dominio;

import dominioPais.dominioCorporativo.nucleoBase.dominio.EntidadPersistenteBase;
/**
 * Objeto de entidad que se mapea con l base de datos.
 * @author Yosbany Tejas
 *
 */
public class ObjetoEntidad extends EntidadPersistenteBase {

	private static final long serialVersionUID = -7774359070702327394L;
	
	private String campo1;

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	
	

}
