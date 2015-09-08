package dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.fachada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ComunNombreProyectoFacadeImpl implements IComunNombreProyectoFacade {

	@Override
	public List<String> listar() {
		List<String> list = new ArrayList<String>();
		list.add("Yosbany");
		return list;
	}

}
