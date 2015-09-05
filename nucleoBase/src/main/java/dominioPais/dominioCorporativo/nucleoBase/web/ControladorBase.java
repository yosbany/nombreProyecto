package dominioPais.dominioCorporativo.nucleoBase.web;

import java.util.Map;

public class ControladorBase {

	private EscritorioTrabajo escritorio;

	private Map<String, Object> attributes;

	public EscritorioTrabajo getEscritorio() {
		return escritorio;
	}

	public void setEscritorio(EscritorioTrabajo escritorio) {
		this.escritorio = escritorio;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
