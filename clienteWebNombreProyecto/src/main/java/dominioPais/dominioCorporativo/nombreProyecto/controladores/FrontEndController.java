package dominioPais.dominioCorporativo.nombreProyecto.controladores;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
@Lazy
@RequestMapping(value="/")
public class FrontEndController {
	
	@RequestMapping(method = RequestMethod.GET, value="/inicio.do")
	public ModelAndView inicio(){
		return new ModelAndView("comun/inicio");
		
	}

}
