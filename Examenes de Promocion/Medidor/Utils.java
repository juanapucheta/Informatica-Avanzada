import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Utils {

	/**
	 * Valida una lectura en una lista de lecturas
	 * La lectura es valida si la fecha es posterior a la fecha de la �ltima lectura de la lista,
	 * y si el consumo de la lectura es mayor al consumo de la �ltima lectura de la lista.
	 * 
	 * @param lectura
	 * @param lista
	 * @return true si la lectura es valida, false en caso contrario
	 * 
	 */
	public static boolean validarLectura(Lectura lectura, List<Lectura> lista) {
	    boolean exito= false;
	    if(lista.size() != 0)
	    {
		Lectura ultimaLectura= lista.get(lista.size()-1);
		Fecha ultimaFecha= ultimaLectura.getFechaDeLectura();
		if(ultimaFecha.compareTo( lectura.getFechaDeLectura())< 0 &&  lectura.getValorDeLectura() > ultimaLectura.getValorDeLectura())
		{
		  exito= true;
		  }
		
		}
		return exito;
	}
	
	
	/**
	 * Devuelve una lista con las lecturas comprendidas entre las fechas "desde" - "hasta" de la lista
	 * de lecturas pasadas como argunmento.
	 * Si la fecha "desde" es null, considera todas las lecturas hasta la fecha "hasta"
	 * Si la fecha "hasta" es null, considera todas las lecturas desde la fecha "desde"
	 * Si ambas fechas son null, todas las fechas se consideran dentro del per�odo 
	 * 
	 * @param lecturas la lista de lecturas original
	 * @param desde la fecha desde la cual se considera el periodo
	 * @param hasta la fecha hasta que se considera el per�odo
	 * @return la lista de fechas inclu�das en el per�odo.
	 */
	public static List<Lectura> filtrarLecturasPorFecha (List<Lectura> lecturas, Fecha desde, Fecha hasta){
		List<Lectura> lecturass= new ArrayList<Lectura>();
		if(lecturas.size() != 0)
		{
		Iterator<Lectura> it= lecturas.iterator();
		while(it.hasNext())
		{
		  Lectura lec= it.next();
		  if(desde== null)
		  {
		    if(lec.getFechaDeLectura().compareTo(hasta)<0)
		    {
		        lecturass.add(lec);
		        }
		  }
		  if(hasta==null)
		  {
		        if(lec.getFechaDeLectura().compareTo(desde)>0)
		        {
		            lecturass.add(lec);
		          }    
		    
		  	   		    		    		    		    
		   
		  		  		  
		  }
		  if(desde == null && hasta == null)
		  {
		  lecturass.add(lec);
		  
		  }		      
		
	     }
	    }
	    return lecturass;
	}
	
	
}
