package dominioPais.dominioCorporativo.nucleoBase.hibernate.utils;

import java.util.Collection;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 
 * @author Yosbany Tejas
 *
 */
public final class Opcion {

	public final static Integer SIN_FILTRO = 1;
	public final static Integer FILTRO_CARGA = 2;
	public final static Integer FILTRO_COLECCION = 4;

	public final Object valorAtt;
	public final String nombreAtt;
	public final int valor;
	public final Integer op;

	public final static int ORDER_ASC = 2;
	public final static int ORDER_DESC = 3;

	public final static int ATT = 4;

	public final static int OR = 6;
	public final static int AND = 7;

	public final static int PROJECTION = 8;

	public final static int PAGINATED = 9;

	public final static int FETCH = 10;

	public final static int NOOP = 100;

	public final static int EQ = 101;
	public final static int NE = 102;

	public final static int GT = 103;
	public final static int GE = 104;

	public final static int LT = 105;
	public final static int LE = 106;

	public final static int IEQ = 107;

	public final static int NNULL = 108;
	public final static int ISNULL = 109;

	public final static int LIKE = 110;
	public final static int ILIKE = 111;

	public final static int IN = 112;
	public final static int BETWEEN = 113;

	public final static int CRITERIA = 114;

	public final static int NOT = 115;

	public final static int ALIAS = 116;

	public final static int GROUP_PROJ = 117;

	public final static int TRANSFORMER = 118;

	public final static int CEDULA = 119;
	public final static int DIRECCION = 120;
	public final static int NOMBRES = 121;

	public final static int GROUP_HINT = 122;

	public final static int MAX_RESULTS = 123;

	private static final Opcion NOOP_OPTION = new Opcion(NOOP, NOOP, null, null);

	private Opcion(Integer op, int valor, String nombreAtt, Object valorAtt) {
		this.nombreAtt = nombreAtt;
		this.valorAtt = valorAtt;
		this.valor = valor;
		
		if (valor == ATT && valorAtt == null && op != ISNULL && op != NNULL)
			this.op = NOOP;
		else
			this.op = op;
	}

	public static Opcion in(String nombreAtt, Object[] valorAtt) {
		if (nombreAtt != null && valorAtt != null) {
			if (valorAtt.length == 1)
				return Opcion.eq(nombreAtt, valorAtt[0]);
			else
				return new Opcion(IN, ATT, nombreAtt, valorAtt);
		} else
			return NOOP_OPTION;
	}

	public static Opcion in(String nombreAtt, Collection<?> valorAtt) {
		if (nombreAtt != null && !CollectionUtils.isEmpty(valorAtt)) {
			if (valorAtt.size() == 1)
				return Opcion.eq(nombreAtt, valorAtt.iterator().next());
			else
				return new Opcion(IN, ATT, nombreAtt, valorAtt.toArray());
		} else
			return NOOP_OPTION;
	}

	public static Opcion eq(String nombreAtt, Object valorAtt) {
		if (StringUtils.hasText(nombreAtt) && valorAtt != null)
			return new Opcion(EQ, ATT, nombreAtt, valorAtt);
		else
			return NOOP_OPTION;
	}

	public static Opcion eq(String nombreAtt, String valorAtt) {
		if (StringUtils.hasText(valorAtt))
			return eq(nombreAtt, (Object) valorAtt);
		else
			return NOOP_OPTION;
	}

	public static Opcion ieq(String nombreAtt, Object valorAtt) {
		if (StringUtils.hasText(nombreAtt) && valorAtt != null)
			return new Opcion(IEQ, ATT, nombreAtt, valorAtt);
		else
			return NOOP_OPTION;
	}

	public static Opcion ieq(String nombreAtt, String valorAtt) {
		if (StringUtils.hasText(valorAtt))
			return ieq(nombreAtt, (Object) valorAtt);
		else
			return NOOP_OPTION;
	}
	
	public static Opcion maxResults(Integer maxResults) {
		if (maxResults != null)
			return new Opcion(NOOP, MAX_RESULTS, null, maxResults);
		else
			return NOOP_OPTION;
	}
	
	public static Opcion[] mergeOptions(Opcion[] baseOptions, Opcion... optionsToMerge) {
		if (optionsToMerge.length > 0) {
			final Opcion[] r = new Opcion[baseOptions.length + optionsToMerge.length];
			System.arraycopy(baseOptions, 0, r, 0, baseOptions.length);
			System.arraycopy(optionsToMerge, 0, r, baseOptions.length, optionsToMerge.length);
			return r;
		} else
			return baseOptions;
	}

}
