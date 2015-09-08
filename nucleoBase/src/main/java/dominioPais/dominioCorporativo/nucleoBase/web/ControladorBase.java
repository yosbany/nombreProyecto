package dominioPais.dominioCorporativo.nucleoBase.web;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ControladorBase implements Serializable {

	private static final long serialVersionUID = 2524446270951076886L;

	@Autowired
	private IContextoSession session;

	private Map<String, Object> attributes;	

	public IContextoSession getSession() {
		return session;
	}

	public void setSession(IContextoSession session) {
		this.session = session;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
