import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
	protected String nombre;
	protected Medidor medidor;
	protected List<Lectura>lecturas;
	
	/**
	 * Constructor. Inicializa el nombre, inicializa la lista de lecturas
	 * @param nombre Nombre del cliente. El nombre debe persistirse en
	 * min�sculas y sin espacios al principio o fin de la cadena.
	 */
	public Cliente (String nombre){
		this.nombre= nombre.trim().toLowerCase();
		lecturas= new ArrayList<Lectura>();
	}
	
	/**
	 * Retorna el nombre del cliente
	 * @return
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * 
	 * @return el Medidor asociado al cliente (Null si no tiene)
	 */
	public Medidor getMedidorAsociado(){
		return medidor;
	}
	
	/**
	 * 
	 * @return la lista de Lecturas realizadas sobre el medidor del cliente
	 */
	public List<Lectura> getLecturas(){
		return lecturas;
	}
	

	
	/**
	 * Este m�todo:
	 * 1. Crea una nueva lectura con la fecha indicada y el consumo del medidor asociado.
	 * 2. Si la nueva lectura es v�lida, la agrega a la lista de lecturas del cliente. 
	 * (Puede utilizar los metodos de la clase Utils para validar la lectura)
	 * 
	 * @param f fecha de la lectura a agregar
	 * @throws IllegalStateException cuando el cliente no tiene medidor asociado.
	 * @throws LecturaInconsistenteException cuando la lectura es anterior a la �ltima lectura de la lista
	 * o cuando el valor le�do es inferior al valor de la �ltima lectura
	 * 
	 */
	public void registrarNuevaLectura (Fecha f) throws LecturaInconsistenteException{
	    Lectura lecturaNueva= new Lectura(medidor.getConsumoAcumulado(), f);
	    
	    if(lecturas.size()!=0)
	    {
		Lectura ultimaLectura= lecturas.get(lecturas.size()-1);
		Fecha ultimaFecha= ultimaLectura.getFechaDeLectura();
		if(ultimaFecha.compareTo(f)>0   || lecturaNueva.getValorDeLectura() < ultimaLectura.getValorDeLectura() )
		{
		    throw new LecturaInconsistenteException("datos inconsistentes");
		
	}
	  else {
	      lecturas.add(lecturaNueva);
	   }
	}
	}
	
	   
	
	   
	
	/**
	 * Asocia un medidor a este cliente, si es que no tiene ning�n medidor asociado. 
	 * Si el cliente ya tiene un medidor asociado, ignora esta nueva asociaci�n.
	 * @param m el Medidor a asociar
	 * @return true si se pudo asociar el medidor, false si el cliente ya tiene un medidor asociado.
	 */
	public boolean asociarMedidor(Medidor m){
	    boolean exito;
		if(medidor==null)
		{
		    medidor= m;
		    exito= true;
		  }
		  else {
		      exito =  false;
		  }
		return exito;
	}
	
	/**
	 * 	Remueve el medidor asociado a este cliente,
	 *  y limpia la lista de lecturas asociadas
	 */
	public void removerMedidor(){
		medidor= null;
		getLecturas().clear();
	}
	
	
	/**
	 * Obtiene el consumo para un per�odo determinado. Si hay varias lecturas dentro del periodo
	 * indicado, retorna el consumo total entre el la primera y la �ltima lectura dentro del
	 * per�odo.
	 * (Puede utilizar los m�todos de la clase Utils para obtener la lista con las lecturas comprendidas
	 * en el per�odo especificado, y en base a ellas calcular el consumo)
	 * 
	 * Ej: Si las lecturas del cliente son
	 * Fecha (dia-anio) | Consumo
	 * 20-2015			| 200
	 * 50-2015			| 350
	 * 85-2015			| 470
	 * 120-2015			| 610
	 * 150-2015			| 770
	 * 
	 * Si se solicita el consumo del per�odo 30-2015 al 130-2015, las lecturas del per�odo seran
	 * Fecha (dia-anio) | Consumo
	 * 50-2015			| 350
	 * 85-2015			| 470
	 * 120-2015			| 610
	 * 
	 * y el consumo del per�odo ser� 260
	 * 
	 * Si se solicita el consumo del per�odo 30-2015 al 40-2015 lanza IllegalStateException
	 * Si se solicita el consumo del per�odo 50-2015 al 40-2015 lanza IllegalArgumentException
	 *  
	 * @param desde fecha inicial
	 * @param hasta fecha final
	 * @return el consumo 
	 * @throws IllegalArgumentException si la fecha desde es posterior a la fecha hasta
	 * @throws IllegalStateException si no hay lecturas en el per�odo 
	 */
	public int consumoPeriodo (Fecha desde, Fecha hasta){
		int consumo=0;
		List<Lectura> lecturasPeriodo= new ArrayList<Lectura>();
		Iterator<Lectura> it= lecturas.iterator();
		if(lecturas.size() != 0)
		{
		   if(desde.compareTo(hasta)>0)
		    {
		    throw new IllegalArgumentException("la fecha desde es posterior a la fecha hasta");
		    }
		
		   while(it.hasNext())
		   { 
		    Lectura lec= it.next();
		  
		    
		    if(lec.getFechaDeLectura().compareTo(hasta)<0)
		    {
		        if(lec.getFechaDeLectura().compareTo(desde)>0)
		        {
		            lecturasPeriodo.add(lec);
		            consumo += lec.getValorDeLectura(); 
		          }    	    	  	   		    		    		    		    
		   		  		  		  
		     }
		
	      }
	if(lecturasPeriodo.size() == 0)
	{
	    throw new IllegalStateException("no hay lecturas en el periodo");
	   }		
	}
	
	return consumo;
	}
	/**
	 * Retorna un string con el siguiente formato:
	 * "Cliente: <nombre_del_cliente> - Medidor: SN_<Medidor_SerialNumber>" cuando tiene un medidor asociado
	 * "Cliente: <nombre_del_cliente> - Medidor: N/A" cuando no tienen un medidor asociado
	 * 
	 * ej. "Cliente: juan perez - Medidor: N/A" o
	 * "Cliente: juan perez - Medidor: SN_12"
	 *
	 */
	public String toString() {
		String caract= ("");
		if(medidor==null)
		{
		    caract= caract.concat( "Cliente : <" + getNombre() + "- Medidor: N/A" );
		    
		  }
		else{
		    caract= caract.concat( "Cliente : <" + getNombre() + "- Medidor: SN_<" + medidor.getSerialNumber());
		  }
		  return caract;
		   
		
	}
}