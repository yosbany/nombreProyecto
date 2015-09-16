package dominioPais.dominioCorporativo.nombreProyecto.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import dominioPais.dominioCorporativo.nombreProyecto.utils.Kte;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@Configuration
@ComponentScan(basePackages = { "dominioPais.dominioCorporativo" })
public class NombreProyectoDispatcherServlet extends WebMvcConfigurationSupport {

	// private Logger log = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		// log.info("Iniciado correctamente");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/" + Kte.URL_INICIO);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp(Kte.DIRECTORIO_VISTAS, ".jsp");
	}

}
