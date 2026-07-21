public abstract class Medidor implements Reseteable {
	protected CoordenadaGPS coordenadas;
	protected int serialNumber;
	protected int consumoAcumulado;
	static int contador = 0;
	
	/**
	 * Constructor
	 * @param coordenadas la ubicaci�n fisica del medidor
	 */
	public Medidor (CoordenadaGPS coordenadas){
		this.coordenadas = coordenadas;	
		consumoAcumulado=0;
		serialNumber = contador;
		contador++;
	}

	/**
	 * 
	 * @return Las coordenadasGPS con la ubicaci�n del medidor
	 */
	public CoordenadaGPS getCoordenadas() {
		return coordenadas;
	}

	/**
	 * 
	 * @return el serialNumber del medidor
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * 
	 * @return el consumo acumulado del medidor
	 */
	public int getConsumoAcumulado() {
		return consumoAcumulado;
	}	
	
	/**
	 * Incrementa el consumo acumulado en el valor especificado
	 * @param consumo el valor de consumo a incrementar
	 */
	public void incrementarConsumo(int consumo){
		consumoAcumulado+=consumo;
	}
	
	/**
	 * 
	 * @return el TipoMedido
	 */
	public abstract TipoMedidor getTipoMedidor();
	
	
	/**
	 * @return la DESCRIPCION del Medidor
	 */
	public String toString(){
		return "SN_"+ serialNumber;
	}
	/**
	 * Restablece los valores a cero
	 */
	public void reset(){
	    consumoAcumulado= 0;
	   
	   }
	
}
