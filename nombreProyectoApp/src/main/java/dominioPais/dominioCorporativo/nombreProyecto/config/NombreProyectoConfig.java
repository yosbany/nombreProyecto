package dominioPais.dominioCorporativo.nombreProyecto.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@Configuration
public class NombreProyectoConfig {

	private Logger log = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		log.info("Iniciado correctamente");
	}

}
