package dominioPais.dominioCorporativo.nombreProyecto.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import dominioPais.dominioCorporativo.nucleo.config.NucleoConfig;

/**
 * 
 * @author Yosbany Tejas
 *
 */
public class NombreProyectoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { NucleoConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { NombreProyectoDispatcherServlet.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
