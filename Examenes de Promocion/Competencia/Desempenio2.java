
/**
 * Write a description of class Desempenio2 here.
 *Implementa una clase concreta de Desempenio para asi poder usar sus metodos y campos en las otras clases
 */
public class Desempenio2 implements Desempenio
{
    Integer triunfo;
    Integer derrota;
    Integer empate;

    /**
     * Constructor for objects of class Desempenio2
     */
    public Desempenio2()
    {
        triunfo = 0;
        derrota = 0;
        empate  = 0;
    }

     /**
     *  Agrega un triunfo al historial  
     */
    public void sumarTriunfo()
    {
        triunfo++;
    }
    
    /**
     *  Agrega una derrota al historial
     */
    public void sumarDerrota()
    {
        derrota++;
    }
    
    /**
     *  Agrega un empate al historial
     */
    public void sumarEmpate()
    {
        empate++;
    }
    
    /**
     *  Retorna la cantidad de puntos obtenidos 
     *  Los puntos por victoria, derrota o empate dependen
     *  de la implementación. Por ej, victoria suma 2, empate
     *  1 y derrota 0 puntos.
     *  
     *  @return el total de puntos acumulados
     */
    public int getPuntos()
    {
        Integer puntos = 0;
        
       puntos = (2*getGanados()) + getEmpates() ;
        
        return puntos;
    }
    
    /**
     * Retorna el total de partidos jugados
     * @return los partidos jugados
     */
    public int getJugados()
    {
        Integer partidosJugados = 0;
        partidosJugados += getGanados()+getPerdidos()+getEmpates();
        return partidosJugados;
    }
    
    /**
     * Retorna el total de partidos ganados
     * @return los partidos perdidos
     */
    public int getGanados()
    {
        return triunfo;
    }
    
    /**
     * Retorna el total de partidos perdidos
     * @return los partidos ganados
     */
    public int getPerdidos()
    {
        return derrota;
    }
    
    /**
     * Retorna el total de partidos empatados
     * @return los partidos empatados
     */
    public int getEmpates()
    {
        return empate;
    }
    
}
