
public interface Desempenio 
{
    /**
     *  Agrega un triunfo al historial  
     */
    public void sumarTriunfo();
    
    /**
     *  Agrega una derrota al historial
     */
    public void sumarDerrota();
    
    /**
     *  Agrega un empate al historial
     */
    public void sumarEmpate();
    
    /**
     *  Retorna la cantidad de puntos obtenidos 
     *  Los puntos por victoria, derrota o empate dependen
     *  de la implementación. Por ej, victoria suma 2, empate
     *  1 y derrota 0 puntos.
     *  
     *  @return el total de puntos acumulados
     */
    public int getPuntos();
    
    /**
     * Retorna el total de partidos jugados
     * @return los partidos jugados
     */
    public int getJugados();
    /**
     * Retorna el total de partidos ganados
     * @return los partidos perdidos
     */
    public int getGanados();
    /**
     * Retorna el total de partidos perdidos
     * @return los partidos ganados
     */
    public int getPerdidos();
    /**
     * Retorna el total de partidos empatados
     * @return los partidos empatados
     */
    public int getEmpates();
}
