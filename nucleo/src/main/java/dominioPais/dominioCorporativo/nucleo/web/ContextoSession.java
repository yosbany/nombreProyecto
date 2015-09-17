package dominioPais.dominioCorporativo.nucleo.web;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Yosbany Tejas
 *
 */
@Component
@Scope("session")
@Lazy
public class ContextoSession implements IContextoSession, Serializable {

	private static final long serialVersionUID = 1334287978743760751L;

	@Override
	public IContextoSession navigateTo(String viewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextoSession navigateToHomePage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextoSession navigateToPreviousPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPreviousPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAtHomePage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrentViewId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getViewIdByKey(String menuKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <F> F getLoggedUser() {
		// TODO Auto-generated method stub
		return null;
	}

}