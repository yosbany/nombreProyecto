package dominioPais.dominioCorporativo.nucleo.hibernate.filtros.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.Session;

import dominioPais.dominioCorporativo.nucleo.hibernate.DaoGenerico;
import dominioPais.dominioCorporativo.nucleo.hibernate.filtros.annotation.DisableFilter;
/**
 * 
 * @author Yosbany Tejas
 *
 */
public class FilterAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation mi) throws Throwable {
		final DisableFilter filtered = mi.getMethod().getAnnotation(DisableFilter.class);

		if (filtered != null) {
			final Session session = ((DaoGenerico) mi.getThis()).getCurrentSession();

			for (String value : filtered.value())
				session.disableFilter(value);
		}

		final Object res = mi.proceed();

		if (filtered != null) {
			final Session session = ((DaoGenerico) mi.getThis()).getCurrentSession();

			for (String value : filtered.value())
				session.enableFilter(value);
		}
		
		return res;
	}

}
