import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Torneo 
{
    String nombre;
    List<Equipo> equipos; 
    List<Partido> partidos;
    
    /**
     * Constructor con parametros.
     * @param nombre El nombre del torneo
     */
    public Torneo (String nombre)
    {
        this.nombre = nombre;
        equipos  = new ArrayList<Equipo>();
        partidos = new ArrayList<Partido>();
    }
    
    /**
     * Retorna la cantidad máxima de equipos que podrían disputar
     * el torneo
     * @return int con el numero maximo de equipos permitidos
     */
    abstract public int getNumeroMaximoDeEquipos();
    
    /**
     * 
     * @return el nombre del torneo
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Inicializa el torneo. Remueve todos los equipos y partidos del torneo 
     */
    public void iniciarTorneo()
    {
        equipos.clear();
        partidos.clear();
    }
    
    /**
     * Agrega un equipo al torneo solo si no se supera el numero maximo de equipos permitido 
     * @param e el equipo a agregar
     * @return true si se pudo agregar el equipo, false en caso contrario
     */
    public boolean addEquipo(Equipo e)
    {
       if(equipos.size() < getNumeroMaximoDeEquipos() )
       {
           equipos.add(e);
           return true;
       }
       else
       {
           return false;
       }
    }
    
    /**
     * Agrega un partido al torneo. Solo se pueden agregar partidos de equipos que pertenezcan al torneo
     * @param p el partido a agregar
     * @throws IllegalArgumentException si alguno de los equipos del partido no pertenece al torneo.
     */
    public void addPartido (Partido p)
    {   
       
      if(equipos.contains(p.e1) && equipos.contains(p.e2))
      {
          partidos.add(p);
      }
      else
      {
         throw new IllegalArgumentException(); 
      }
    }
    
    /**
     * Retorna la cantidad de partidos DISPUTADOS
     * @return la cantidad de partidos disputados del torneo.
     */
    public int partidosDisputados()
    {
        int disputados = 0;
        for(Partido p : partidos )
        {
            if(p.getResultado()!= Resultado.PENDIENTE)
            {
                disputados++;
            }
        }
        return disputados;
    }
    
    /**
     * Retorna la cantidad de equipos en el torneo
     * @return la cantidad de equipos
     */
    public int cantidadDeEquipos()
    {
        return equipos.size();
    }
    

    /**
     * Retorna la cantidad de partidos TOTALES en el torneo
     * @return la cantidad de partidos
     */
    public int cantidadDePartidos()
    {
        return partidos.size();
    }
    
    /**
     * Retorna el torneo como String con el siguiente formato
     * "Torneo: <Nombre_del_troneo> (<cantidad_de_equipos> equipos) - [<equipo1>][<equipo2>][<equipo3>]"
     * Ej. 
     * "Torneo: Amistad (4 equipos) - [BOCA][RIVER][TALLERES][BELGRANO]"
     * 
     * @return el String con los equipos
     */
    public String toString()
    {
        
        String mensaje = "Torneo: ";
        mensaje+= getNombre() + " ("+ cantidadDeEquipos() + ") - ";
        
        for( Equipo e : equipos)
        {
            String nombreEquipo = "[" + e.getNombre() + "]" ; 
            mensaje+= nombreEquipo;
        }
        return mensaje;
    }
    
    
    
    /**
     * Retorna un mapa de <Equipos, Desempenio> representando el desempeño
     * de cada equipo en este torneo.
     * 
     * Utilice una implementación de Desempenio que otorgue 
     * 2 puntos por victoria, 1 por empate y 0 por derrota
     *
     * Ej.
     * Para un torneo con equipos e1,e2,e3,e4 y 
     * partidos 
     *  p1 = e1 vs. e2  [LOCAL]
     *  p2 = e3 vs. e4  [EMPATE]
     *  p3 = e2 vs. e3  [VISITANTE]
     *  p4 = e4 vs. e1  [PENDIENTE]
     *  
     *  las posiciones deberían ser
     *  e1 -> 2 puntos, 1 partido  jugado , 1 victoria
     *  e2 -> 0 puntos, 2 partidos jugados, 2 derrotas
     *  e3 -> 3 puntos, 2 partidos jugados, 1 victoria, 1 empate 
     *  e4 -> 1 punto , 1 partido  jugado , 1 empate 
     *  
     * @return el mapa
     */
    public Map<Equipo,Desempenio> getPosiciones()
    {
        HashMap<Equipo,Desempenio> mapa = new HashMap<Equipo,Desempenio>();
        
        for( Equipo e : equipos )
        {
            Desempenio d = new Desempenio2();
            //creo una variable de tipo Desempenio y la inicializo con el 
            //nombre Desempenio2 que es implementacion de la interface Desempenio
            mapa.put(e,d);
        }
        
        for( Partido p : partidos)
        {
            if(p.getResultado()==Resultado.LOCAL)
            {
                mapa.get(p.e1).sumarTriunfo();
                mapa.get(p.e2).sumarDerrota();
            }
            if(p.getResultado()==Resultado.VISITANTE)
            {
                mapa.get(p.e2).sumarTriunfo();
                mapa.get(p.e1).sumarDerrota();
            }
            if(p.getResultado()==Resultado.EMPATE)
            {
                mapa.get(p.e1).sumarEmpate();
                mapa.get(p.e2).sumarEmpate();
            }
        }
                
        return mapa;
    }
    
            
}    


