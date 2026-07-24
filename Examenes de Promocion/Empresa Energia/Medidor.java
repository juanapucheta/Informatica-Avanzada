public abstract class Medidor implements Reseteable {
    protected CoordenadaGPS coordenadas;
    protected int serialNumber;
    protected int consumoAcumulado;
    static int contador = 0;
    
    /**
     * Constructor
     *
     * @param coordenadas La ubicacion fisica del medidor
     */
    public Medidor (CoordenadaGPS coordenadas){
        this.coordenadas = coordenadas;    
        consumoAcumulado=0;
        serialNumber = contador;
        contador++;
    }

    /**
     * 
     * @return Las coordenadasGPS con la ubicacion del medidor
     */
    public CoordenadaGPS getCoordenadas() {
        return coordenadas;
    }

    /**
     * 
     * @return El serialNumber del medidor
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * 
     * @return El consumo acumulado del medidor
     */
    public int getConsumoAcumulado() {
        return consumoAcumulado;
    }    
    
    /**
     * Incrementa el consumo acumulado en el valor especificado
     *
     * @param consumo El valor de consumo a incrementar
     */
    public void incrementarConsumo(int consumo){
        consumoAcumulado+=consumo;
    }
    
    /**
     * 
     * @return El Tipo de Medidor
     */
    public abstract TipoMedidor getTipoMedidor();
    
    /**
     * @return La DESCRIPCION del Medidor
     */
    public String toString(){
        return "SN_"+ serialNumber;
    }
    
}
