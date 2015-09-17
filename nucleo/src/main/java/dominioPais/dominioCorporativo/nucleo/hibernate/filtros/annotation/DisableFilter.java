package dominioPais.dominioCorporativo.nucleo.hibernate.filtros.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Esta anotacion activa o desactiva el filtro de elementos activos a nivel de Dao. Los metodos
 * anotados con Filtered pueden especificar un listado de nombre de filtros para ser activados en la
 * llamada del metodo. Esta anotacion funciona en conjuncion con el FilterAdvice.
 * 
 * @author Yosbany Tejas
 */
@Documented
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface DisableFilter {

	String[] value() default "";

}
