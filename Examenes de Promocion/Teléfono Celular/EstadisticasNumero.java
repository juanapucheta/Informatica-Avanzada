
public class EstadisticasNumero {
	private int salientes;
	private int entrantes;
	private int duracionSalientes;
	private int duracionEntrantes;
	
	public EstadisticasNumero(){
		salientes = 0;
		entrantes = 0;
		duracionSalientes = 0;
		duracionEntrantes = 0;
	}

	public int getSalientes() {
		return salientes;
	}

	public void incrementarSalientes() {
		salientes ++;
	}

	public int getEntrantes() {
		return entrantes;
	}

	public void incrementarEntrantes() {
		entrantes++;
	}

	public int getDuracionSalientes() {
		return duracionSalientes;
	}

	public void incremetarDuracionSalientes(int duracionSalientes) {
		this.duracionSalientes += duracionSalientes;
	}

	public int getDuracionEntrantes() {
		return duracionEntrantes;
	}

	public void incrementarDuracionEntrantes(int duracionEntrantes) {
		this.duracionEntrantes += duracionEntrantes;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Llamadas salientes: ");
		sb.append(salientes);
		sb.append("(");
		sb.append(duracionSalientes);
		sb.append(") - Llamadas entrantes: ");
		sb.append(entrantes);
		sb.append("(");
		sb.append(duracionEntrantes);
		sb.append(")");
		return sb.toString();	
	}
}
