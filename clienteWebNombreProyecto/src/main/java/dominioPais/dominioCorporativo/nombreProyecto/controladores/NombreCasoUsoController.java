package dominioPais.dominioCorporativo.nombreProyecto.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.dominio.ObjetoEntidad;
import dominioPais.dominioCorporativo.nombreProyecto.controladores.modelos.NombreFormularioForm;
import dominioPais.dominioCorporativo.nombreProyecto.validadores.NombreFormularioValidator;
import dominioPais.dominioCorporativo.nucleoBase.web.ControladorBase;

@Controller
@Scope("session")
@Lazy
@RequestMapping(value = "/nombreCasoUso/*")
public class NombreCasoUsoController extends ControladorBase {

	// Inyectamos del contecto tantos facade como se necesite
	// @Autowired
	// private IFacade facade;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new NombreFormularioValidator());
	}

	@RequestMapping(method = RequestMethod.POST, value = "nombreOperacionInsertAndEdit.do")
	public ModelAndView nombreOperacionInsertAndEdit(@Validated NombreFormularioForm nombreFormularioForm,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("ff");
		}
		ObjetoEntidad objetoEntidad = new ObjetoEntidad();
		objetoEntidad.setCampo1(nombreFormularioForm.getCampo1());
		return new ModelAndView("sdd");
	}

	@RequestMapping(method = RequestMethod.GET, value = "nombreOperacionList.do")
	protected ModelAndView nombreOperacionList() throws ServletException {
		ModelAndView modelo = new ModelAndView("nombreCasoUso/nombreOperacionList");
		List<String> list = new ArrayList<String>();
		list.add("Objeto 1");
		list.add("Objeto 2");
		modelo.addObject("lista", list);
		return modelo;
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "nombreOperacionDetails.do")
	protected NombreFormularioForm nombreOperacionDetails() throws ServletException {
		return new NombreFormularioForm();
		
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView Exception(Exception e, HttpServletRequest request) {
		return new ModelAndView("comun/error");
	}
}
