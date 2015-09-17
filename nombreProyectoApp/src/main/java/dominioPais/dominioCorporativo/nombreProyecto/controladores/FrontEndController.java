package dominioPais.dominioCorporativo.nombreProyecto.controladores;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dominioPais.dominioCorporativo.nucleo.web.ControladorBase;

/**
 * 
 * @author Yosbany Tejas
 *
 */
@Controller
@Lazy
@RequestMapping(value = "/")
public class FrontEndController extends ControladorBase {

	private static final long serialVersionUID = 5092684265807826084L;

	@RequestMapping(method = RequestMethod.GET, value = "inicio.do")
	public ModelAndView inicio() {

		return new ModelAndView("comun/inicio", "modelo", "Inicio");

	}

}
