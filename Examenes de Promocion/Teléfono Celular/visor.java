import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.lang.String;
/**
 * Write a description of class visor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class visor implements Formateable
{
    

    /**
     * Constructor for objects of class visor
     */
    public visor()
    {
       
    }
public void capo()
{
    String s= new String("facundo \n es un capo");
    System.out.println(s);
}
/**
	 * Devuelve un String con el detalle de las llamadas, una llamada por linea
	 * Ej:
"2013/05/06 21:44, 3514801234, ENTRANTE, 05:12
2013/01/30 01:14, 1161293091, SALIENTE, 12:00
2013/01/30 01:28, 1161293091, SALIENTE, 02:10
2013/01/30 01:42, 1161293091, ENTRANTE, 12:00
"
	 *  
	 * @param llamadas
	 * @return
	 */
	public String convertirListaComoString(ArrayList<Llamada> llamadas){
	    String llam= (" ");
	    Iterator<Llamada> it= llamadas.iterator();
	    
	    while(it.hasNext())
	    {
	        Llamada llamd= it.next();
	        llam= llam.concat(llamd.toString());
	        
	        
	        
	       }
	       
	    return llam ;
	    
	   
}


	
	/**
	 * Devuelve un String con el detalle de las llamadas, si el numero corresponde
	 * a un contacto, reemplaza el numero por el nombre del contacto. si no est� en
	 * el la agenda de contactos, imprime el numero 
	 * 
	 * Una llamada por linea
	 * Ej:
	 * 
"2013/05/06 21:44, 3514801234, ENTRANTE, 05:12
2013/01/30 01:14, Juan Perez, SALIENTE, 12:00
2013/01/30 01:28, Julieta Alvarez, SALIENTE, 02:10
2013/01/30 01:42, 1161293091, ENTRANTE, 12:00
"
	 *  
	 * @param llamadas
	 * @return
	 */
	public String convertirListaComoStringAmigable(ArrayList<Llamada> llamadas, LibretaDeContactos cont){
	    String lista=("");
	    Iterator<Llamada> it= llamadas.iterator();
	    
	    while(it.hasNext())
	    {
	        Llamada llamd= it.next();
	        for(Contacto contt : cont.getContactos())
	        {
	        if(contt.getNumerotelefonico().equals(llamd.getNumero()))
	        {
	            lista= lista.concat( llamd.getFecha().toString() + "," + contt.getNombre() + "," + llamd.getTipoDeLlamada() + "," + llamd.getDuracion()); 
	            lista= lista.concat("");
	           }
	       }
	   }
	   return lista;
	   }

	
	
	/**
	 * Devuelve un String con las estadisticas de cada numero en el mapa
	 * Una numero por linea, con el formato:
	 * <numero>: Llamadas salientes: <cantidadLlamadasSalientes> (<duracionSalientesEnSegundos>) - Llamadas entrantes: <cantidadLlamadasEntrantes> (<duraciondeEntrantesEnSegundos>)
	 * 
	 * Ej:
	 * 
"3514801234: Llamadas salientes: 5(123) - Llamadas entrantes: 1(65)
3515597222: Llamadas salientes: 2(1315) - Llamadas entrantes: 4(165)
3516557177: Llamadas salientes: 16(2312) - Llamadas entrantes: 12(657)
"
	 *  
	 * @param llamadas
	 * @return
	 */
	public String convertirMapaEstadisticaComoString(HashMap<String, EstadisticasNumero> m){
	    String miedosa= ("");
	    Set<String> mala = m.keySet();
	    Iterator<String> it= mala.iterator();
	    while(it.hasNext())
	    {
	        String numero= it.next();
	        if(m.get(numero)!= null)
	        {
	        miedosa= miedosa.concat( m.get(numero).toString());
	       }
	    
	    
	   }
	   return miedosa;
}

}