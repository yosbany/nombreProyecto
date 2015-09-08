package dominioPais.dominioCorporativo.nombreProyecto.nombreModulo2.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dominioPais.dominioCorporativo.nombreProyecto.nombreModulo2.datos.dao.INombreModulo2Dao;
import dominioPais.dominioCorporativo.nombreProyecto.nombreModulo2.datos.das.INombreModulo2Das;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Component
public class NombreModulo2Manager implements INombreModulo2Manager {
	
	@Autowired
	private INombreModulo2Dao dao;
	
	@Autowired
	private INombreModulo2Das das;

	public INombreModulo2Dao getDao() {
		return dao;
	}

	public void setDao(INombreModulo2Dao dao) {
		this.dao = dao;
	}

	public INombreModulo2Das getDas() {
		return das;
	}

	public void setDas(INombreModulo2Das das) {
		this.das = das;
	}
	
	
}
