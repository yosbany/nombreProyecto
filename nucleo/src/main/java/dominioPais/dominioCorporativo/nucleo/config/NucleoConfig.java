package dominioPais.dominioCorporativo.nucleo.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@ComponentScan(basePackages = { "dominioPais.dominioCorporativo.nucleoBase" })
@Configuration
public class NucleoConfig {

	// private Logger log = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		// log.info("Iniciado correctamente");
	}

}
