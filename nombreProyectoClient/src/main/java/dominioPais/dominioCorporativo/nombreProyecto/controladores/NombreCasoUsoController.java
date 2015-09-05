package dominioPais.dominioCorporativo.nombreProyecto.controladores;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dominioPais.dominioCorporativo.nucleoBase.web.ControladorBase;

@Controller
@Scope("session")
@Lazy
@RequestMapping(value = "/NombreCasoUso/*")
public class NombreCasoUsoController extends ControladorBase {
	/*
	 * //Inyectamos del contecto tantos facade como se necesite
	 * 
	 * @Autowired private IFacade facade;
	 * 
	 * //Enlasamos el validador del formulario si el controlador lo requiere
	 * 
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.setValidator(new NombreFormularioValidator()); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST value =
	 * 'nombreOperacionInsertAndEdit.do') public ModelAndView
	 * nombreOperacionInsertAndEdit(@Validated NombreFormularioForm
	 * nombreFormularioForm, BindingResult result){ if(result.hasErrors()){
	 * return new ModelAndView('retorno la misma página del formulario'); }
	 * 
	 * ObjetoEntidad objetoEntidad = new ObjetoEntidad();
	 * objetoEntidad.setCampo(nombreFormularioForm.getCampo()); //Llamo a la
	 * fachada tantas veces se requiera; this.facade.metodo(objetoEntidad);
	 * 
	 * return new ModelAndView('voy a la siguiente página'); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET value =
	 * 'nombreOperacionList.do') protected AlumnoForm nombreOperacionList()
	 * throws ServletException { return new NombreFormularioForm();
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.GET value =
	 * 'nombreOperacionDetails.do') protected AlumnoForm
	 * nombreOperacionDetails() throws ServletException { return new
	 * NombreFormularioForm();
	 * 
	 * }
	 * 
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * Exception(Exception e , HttpServletRequest request){ //Redirecciona a la
	 * página de error return new ModelAndView("pagina de error"); }
	 */
}
