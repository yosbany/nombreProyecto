package dominioPais.dominioCorporativo.nombreProyecto.nombreModulo1.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dominioPais.dominioCorporativo.nombreProyecto.nombreModulo1.datos.dao.INombreModulo1Dao;
import dominioPais.dominioCorporativo.nombreProyecto.nombreModulo1.datos.das.INombreModulo1Das;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Component
public class NombreModulo1Manager implements INombreModulo1Manager {
	
	@Autowired
	private INombreModulo1Dao dao;
	
	@Autowired
	private INombreModulo1Das das;

	public INombreModulo1Dao getDao() {
		return dao;
	}

	public void setDao(INombreModulo1Dao dao) {
		this.dao = dao;
	}

	public INombreModulo1Das getDas() {
		return das;
	}

	public void setDas(INombreModulo1Das das) {
		this.das = das;
	}
	
	
}
