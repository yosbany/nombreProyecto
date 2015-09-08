package dominioPais.dominioCorporativo.nucleoBase.web;

import java.io.Serializable;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Lazy
public class ContextoSession implements IContextoSession, Serializable {

	private static final long serialVersionUID = 1334287978743760751L;

}