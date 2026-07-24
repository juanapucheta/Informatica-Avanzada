
public class Fecha implements Comparable<Fecha> {

	private int diaDelAnio;
	private int anio;
	
	/**
	 * Constructor 
	 *
	 * @param diaDelAnio El dia del anio, entre 1 y 365
	 * @param anio El anio, entre 2000 y 2100
	 */
	public Fecha (int diaDelAnio, int anio){
		if (diaDelAnio < 1 || diaDelAnio > 365 || anio < 2000 || anio > 2100)
			throw new  IllegalArgumentException ();
		this.diaDelAnio = diaDelAnio;
		this.anio = anio;
	}

	/**
	 * 
	 * @return El dia del anio, entre 1 y 365
	 */
	public int getDiaDelAnio() {
		return diaDelAnio;
	}

	/**
	 * 
	 * @return El anio de la fecha
	 * 
	 */
	public int getAnio() {
		return anio;
	}

	@Override
	public int compareTo(Fecha otra) {
		// Retorna un valor negativo, cero, o positivo si esta
		// (this) Fecha es menor, igual o mayor que la "otra"
		// fecha especificada
		return anio*365 + diaDelAnio 
				- (otra.getAnio()*365 + otra.getDiaDelAnio());
	}
	
	@Override
	public boolean equals (Object otra){
		if (otra == null || !(otra instanceof Fecha))
			return false;
		if (this.anio == ((Fecha)otra).getAnio() 
				&& this.diaDelAnio == ((Fecha)otra).getDiaDelAnio())  
			return true;
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(anio);
		sb.append("-");
		sb.append(diaDelAnio);
		return sb.toString();
	}
	
}
