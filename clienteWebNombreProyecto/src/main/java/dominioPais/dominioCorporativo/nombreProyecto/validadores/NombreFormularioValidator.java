package dominioPais.dominioCorporativo.nombreProyecto.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NombreFormularioValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		/** Retornar segun corresponda NombreFormularioForm.class.equals(clazz); */
		return false;
	}

	public void validate(Object arg0, Errors arg1) {

		/** Ejemplo de Validaci�n sobre un campo del NombreFormularioForm */
		// ValidationUtils.rejectIfEmptyOrWhitespace(e, "campo", "error.campo.necesario");
		// NombreFormularioForm nombreFormularioForm = (NombreFormularioForm) obj;

		/**
		 * Para no sacar 2 errores a la vez del mismo campo se hace esta condicional
		 */
		// if (!e.hasFieldErrors("campo")) {
			// if ( expresion de validaci�n) {
				/** Ejemplo de Validaci�n sobre un campo del NombreFormularioForm */
				//e.rejectValue("campo", "error.campo.longitud.incorrecta");
			// }
		// }

	}

}
