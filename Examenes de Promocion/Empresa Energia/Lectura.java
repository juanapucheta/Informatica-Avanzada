
public class Lectura {

	private Fecha fechaDeLectura;
	private int valorDeLectura;
	
	public Lectura (int consumoLeido, Fecha f){
		this.fechaDeLectura = f;
		this.valorDeLectura = consumoLeido;
	}
	
	public Fecha getFechaDeLectura() {
		return fechaDeLectura;
	}
	
	public int getValorDeLectura() {
		return valorDeLectura;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(fechaDeLectura);
		sb.append(":");
		sb.append(valorDeLectura);
		return sb.toString();
	}
	
}
