package dominioPais.dominioCorporativo.nombreProyecto.controladores;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
import dominioPais.dominioCorporativo.nombreProyecto.comunNombreProyecto.fachada.IComunNombreProyectoFacade;
import dominioPais.dominioCorporativo.nombreProyecto.controladores.modelos.NombreFormularioForm;
import dominioPais.dominioCorporativo.nombreProyecto.validadores.NombreFormularioValidator;
import dominioPais.dominioCorporativo.nucleoBase.web.ControladorBase;

@Controller
@Lazy
@RequestMapping(value = "/nombreCasoUso/")
public class NombreCasoUsoController extends ControladorBase {

	private static final long serialVersionUID = 4941044112653244432L;

	@Autowired
	private IComunNombreProyectoFacade comunNombreProyectoFacade;

	public IComunNombreProyectoFacade getComunNombreProyectoFacade() {
		return comunNombreProyectoFacade;
	}

	public void setComunNombreProyectoFacade(IComunNombreProyectoFacade comunNombreProyectoFacade) {
		this.comunNombreProyectoFacade = comunNombreProyectoFacade;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new NombreFormularioValidator());
	}

	@RequestMapping(method = RequestMethod.POST, value = "nombreOperacionInsertAndEdit.do")
	public ModelAndView nombreOperacionInsertAndEdit(@Validated NombreFormularioForm nombreFormularioForm,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("comun/inicio");
		}

		ObjetoEntidad objetoEntidad = new ObjetoEntidad();
		objetoEntidad.setCampo1(nombreFormularioForm.getCampo1());

		return new ModelAndView("comun/inicio");
	}

	@RequestMapping(method = RequestMethod.GET, value = "nombreOperacionList.do")
	protected ModelAndView nombreOperacionList() throws ServletException {
		List<String> list = this.getComunNombreProyectoFacade().listar();

		return new ModelAndView("comun/inicio", "modelo", list);

	}

	@RequestMapping(method = RequestMethod.GET, value = "nombreOperacionDetails.do")
	protected ModelAndView nombreOperacionDetails() throws ServletException {
		return new ModelAndView("comun/inicio");

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView Exception(Exception e, HttpServletRequest request) {
		return new ModelAndView("comun/inicio");
	}

}
