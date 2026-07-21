import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
/**
 * Write a description of class RegistroDeLlamadas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegistroDeLlamadas extends Registro
{
    
     
    public RegistroDeLlamadas()
    {
        super();
        
    }

 /**
     * Devuelve una lista con las llamadas cuya duraci�n est� comprendida entre
     *  
     *  [minInicial:segInicial] y [minFinal:segFinal] 
     *
     * Ej. minInicial = 1, segInicial=30, minFinal=3, segFinal=45, la lista contendr� solo llamdas cuya duraci�n est� comprendida entre
     * un minuto treinga segundos y tres minutos cuarenta y cinco segundos.
     *
     * Una argumento invalido es cuando par�metro valor es negativo, o cuando seg > 59 o cuando el tiempo incial es mayor que el final 
     * 
     *  valido contiene 10 digitos (luego de remover espacios previos o posteriores si los hubiera).
     * 
     * 
     * @param numero
     * @return Lista de llamadas 
     * @throws ParametrosInconsistentesException cuando el numero es null o con un formato invalido.
     */
    public List<Llamada> getLlamadasPorDuracion (int minInicial, int segInicial, int minFinal, int segFinal) throws ParametrosInconsistentesException
    {
        List<Llamada> llamadas= new ArrayList <Llamada>();
        
       
        if( minInicial<0 && segInicial<0 && minFinal<0 && segFinal<0)
        {
            throw new ParametrosInconsistentesException();}
        else if(segInicial>59 && segFinal>59)
        {
             throw new ParametrosInconsistentesException();
        }
        else if(minInicial > minFinal && segInicial > segFinal)
        {
             throw new ParametrosInconsistentesException();
        }
        else{
        Iterator<Llamada> it= getRegistroCompleto ().iterator();
        while(it.hasNext())
        {
            Llamada llamdas= it.next();
            llamadas.add(llamdas);
        }
    }
     return llamadas;   
    }
                
            
        
    
    /**
     * Devuelve una lista con las llamadas salientes o entrantes
     * @param tipo tipo de Llamada ENTRANTE/SALIENTE
     * @return Lista de llamadas
     */
    public List<Llamada> getLlamadasPorTipo (TipoDeLlamada tipo){
    
    List<Llamada> totalLlamadas= new ArrayList<Llamada>();
    Iterator<Llamada> it= getRegistroCompleto ().iterator();
    while (it.hasNext())
        {   Llamada llama = it.next();
            if(llama.getTipoDeLlamada()== tipo)
                totalLlamadas.add (llama);
            }
    return totalLlamadas;
    }
    
    /**
     * Devulelve un entero con la duracion total de las llamadas saliente y entrantes, en segundos
     * @return duracion total de llmadas
     */
    public int getDuracionTotalLlamadasDelRegistro (){
     
     int duracionTotal=0;
    Iterator<Llamada> it= getRegistroCompleto ().iterator();
    while (it.hasNext())
        {   Llamada tiempo = it.next();
            
                duracionTotal+=tiempo.getDuracionEnSegundos();
            }
    return duracionTotal;
    }   
    
    
    /**
     * Devuelve un mapa <String, EstadisticasNumero> 
     * con las estadisticas de cada numero del registro de llamadas.
     * 
     * Ej.: Si en el registro de llamadas contiene 10 llamadas, 5 al numero A,
     * 3 del numero B, y 2 del numero C, el mapa deber� contener 3 entradas,
     * con las estad�sticas de cada numero (A, B y C)
     *
     * @return mapa de estadisticas
     */
    public Map<String, EstadisticasNumero> getMapaDeEstadisticasDelRegistroCompleto (){
        
        Map<String, EstadisticasNumero> mapaTotal= new HashMap<String, EstadisticasNumero>();
        Iterator<Llamada> it= getRegistroCompleto ().iterator();
        while(it.hasNext())
        {
            Llamada total= it.next();
            {
                String clave= total.getNumero();
                if ( !mapaTotal.containsKey(clave))
                  { EstadisticasNumero caracteristicas = new EstadisticasNumero();                                    
                    mapaTotal.put(clave,caracteristicas);
                   
        
        
    }
}
}
return mapaTotal;
}
    /**
     * Devuelve las estad�sticas de la lista de llamados para un numero en particular 
     * 
     * @param llamadas
     * @return
     */
    public EstadisticasNumero getEstadisticasPorNumero (List<Llamada> llamadas, String numero) throws ParametrosInconsistentesException{
         
         Iterator<Llamada> it= llamadas.iterator();
         EstadisticasNumero numn= new EstadisticasNumero();
         
         while(it.hasNext())
         {
             Llamada num= it.next();
             if(num.getNumero()==numero)
             {
                 if(num.getTipoDeLlamada()==TipoDeLlamada.SALIENTE)
                     { numn.incrementarSalientes();
                       numn.incremetarDuracionSalientes(num.getDuracionEnSegundos()) ;
                    }
                 else
                     {numn.incrementarEntrantes();
                      numn.incrementarDuracionEntrantes(num.getDuracionEnSegundos());
                    }
        
                }}
            return numn;
        }
        
         
         
        
}
