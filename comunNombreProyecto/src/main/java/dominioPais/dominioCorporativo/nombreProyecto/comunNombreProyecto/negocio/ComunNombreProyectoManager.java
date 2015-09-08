package dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.datos.dao.IComunNombreProyectoDao;
import dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.datos.das.IComunNombreProyectoDas;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Component
public class ComunNombreProyectoManager implements IComunNombreProyectoManager {
	
	@Autowired
	private IComunNombreProyectoDao dao;
	
	@Autowired
	private IComunNombreProyectoDas dat;

	public IComunNombreProyectoDao getDao() {
		return dao;
	}

	public void setDao(IComunNombreProyectoDao dao) {
		this.dao = dao;
	}

	public IComunNombreProyectoDas getDat() {
		return dat;
	}

	public void setDat(IComunNombreProyectoDas dat) {
		this.dat = dat;
	}
	
	
}
