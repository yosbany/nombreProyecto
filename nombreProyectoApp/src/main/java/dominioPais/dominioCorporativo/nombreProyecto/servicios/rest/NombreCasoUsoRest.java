package dominioPais.dominioCorporativo.nombreProyecto.servicios.rest;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dominioPais.dominioCorporativo.nucleo.web.ControladorBase;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@RestController
@Lazy
@RequestMapping(value = "/rest/nombreCasoUsoRest/")
public class NombreCasoUsoRest extends ControladorBase {

	private static final long serialVersionUID = -4661173135195526358L;

}
