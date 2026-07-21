
public class Fecha {
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	
	/**
	 * Lanza una IllegalArgumentException cuando la fecha es invalida
	 * Anio debe ser mayor a 2012.
	 * Hora en formato 24hs
	 * Validar mes y dia (no considera a�os bisiestos. Ej, 29 FEB es invalido)
	 * 
	 * Ej. fechas invalidas: 1999,12,12,12,12 ; 2010,2,29,21,6; 2012,1,31,24,01
	 * 
	 * @param anio 
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 */
	public Fecha (int anio, int mes, int dia, int hora, int minuto){
	this.anio= anio;
	this.mes= mes;
	this.dia=dia;
	this.hora=hora;
	this.minuto= minuto;
	}

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(anio);
		sb.append("/");
		if (mes<10)
			sb.append("0");
		sb.append(mes);
		sb.append("/");
		if (dia<10)
			sb.append("0");
		sb.append(dia);
		sb.append(" ");
		if (hora<10)
			sb.append("0");
		sb.append(hora);
		sb.append(":");
		if (minuto<10)
			sb.append("0");
		sb.append(minuto);
		return sb.toString();
	}
}
