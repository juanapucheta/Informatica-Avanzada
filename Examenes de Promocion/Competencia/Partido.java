import java.util.ArrayList;
import java.util.List;

public class Partido 
{
    Equipo e1; // este sera el local
    Equipo e2; // este sera el viistante
    Resultado r; 
    /**
     * Constructor con parametros. Representa un partido. Al iniciarse,
     * el partido está pendiente
     * @param local equipo local
     * @param visita equipo visitante
     * @throws IllegalArgumentException cuando algun equipo es null o cuando
     * ambos equipos son el mismo equipo
     */
    public Partido (Equipo local, Equipo visita)
    {
        if(local == null || visita == null || local == visita)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            e1 = local;
            e2 = visita;
            r  = Resultado.PENDIENTE;
        }
    }
    
       

    /**
     * Getter del Equipo local
     * @return el equipo local
     */
    public Equipo getEquipoLocal() 
    {
        return e1;    
    }

    /**
     * Getter del Equipo visitante
     * @return el equipo visotante
     */
    public Equipo getEquipoVisitante() 
    {
        return e2;    
    }

    
    /**
     * Determina si el partido fue disputado. Un partido fue disputado
     * cuando su resultado no está pendiente.
     * @return si el partido fue disputado
     */
    public boolean disputado() 
    {
        if( r != Resultado.PENDIENTE )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /**
     * Devuelve el resultado de este partido
     * @return el resultado de este partido
     */
    public Resultado getResultado() 
    {
       return r;    
    }
    
    
    /**
     * Setea un resultado para este partido. 
     * @param resultado El resultado de este partido
     * @throws IllegalArgumentException si el resultado es inválido (null)
     */
    public void setResultado(Resultado resultado)
    {
        if(resultado.equals(null))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            r = resultado;
        }
    }
    
    
    /**
     * Retorna una representación como String del partido con el siguiente 
     * formato:
     * "Partido: <equipo_local> vs. <equipo_visitante> [<resultado>]"
     * 
     * 
     * Ej.
     * "Partido: boca vs. river [EMPATE]"
     * 
     */
    public String toString()
    {
        String mensaje = "Partido: ";
        
        mensaje += e1 + " vs. " + e2 + " [" + r + "]"; 
        
        return mensaje;                    
    }
}
