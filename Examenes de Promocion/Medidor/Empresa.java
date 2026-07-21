import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class Empresa {
	protected List<Cliente> clientes;
	protected List<Medidor> medidores;
	protected Map<String, String> mapaClientes;
	
	/**
	 * Constructor. Inicializa la lista de clientes y medidores administrados por la Empresa
	 * Inicializa el mapa de medidores asociados a clientes
	 */
	public Empresa(){
		clientes = new ArrayList<Cliente>();
		medidores = new ArrayList<Medidor>();
		mapaClientes = new HashMap<String,String>();
	}
		
	/**
	 * 
	 * @return la lista de Clientes de la empresa
	 */
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	/**
	 * 
	 * @return la lista de medidores administrados por la empresa
	 */
	public List<Medidor> getMedidoresAdministrados(){
		return medidores;
	}
	
	/**
	 * Obtiene el mapa da asociaciones cliente - medidor
	 * 
	 * @return el mapa de asociacioens de cliente-medidor
	 */
	public Map<String,String> getMapaAsociaciones(){
		return mapaClientes;
	}
	
	/**
	 * Devuelve el cliente de la empresa con el nombre especificado. 
	 * No se distingue may�sculas o min�sculas, es indistinto especificar "JUAN PEREZ"
	 * o "juan Perez" como argumento. Adem�s, deben eliminarse los espacios prefijos o sufijos. 
	 * @param nombre el nombre del cliente a buscar
	 * @return el cliente encontrado, o null en caso de no existir el cliente entre los clientes de la empresa
	 * 
	 */
	public Cliente getCliente(String nombre) {
	    Cliente clienteBuscado= null;
		Iterator<Cliente> it= clientes.iterator();
		if(clientes.size() != 0)
		{
		    while(it.hasNext())
		    {
		      Cliente cli= it.next();
		      if(cli.getNombre().equals(nombre.trim().toLowerCase()))
		      {
		          clienteBuscado= cli;
		      }
		      }
		  }
		return clienteBuscado;
	}
	
	
	/**
	 * Crea un nuevo medidor del tipo y con la ubicaci�n especificada, y lo agrega
	 * a la lista de medidores administrados por la Empresa
	 * 
	 * @param tipo el TipoMedidor (DOMICILIARIO/COMERCIAL)
	 * @param pos las coordenadas donde se ubicar� el nuevo medidor
	 * @return el medidor creado
	 */
	public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos){
		Medidor nuevoMedidor ;
		nuevoMedidor = null;
		if(tipo== TipoMedidor.INDUSTRIAL)
		{
		    nuevoMedidor= new MedidorIndustrial(pos);
		    }
		else if( tipo== TipoMedidor.COMERCIAL)
		{
		    nuevoMedidor= new MedidorComercial(pos);
		    
		  }
		  medidores.add(nuevoMedidor);
		  return nuevoMedidor;
		
	}
	
	/**
	 * Crea un nuevo cliente con el nombre especificado  y lo agrega a la lista de clientes de la empresa
	 * Si en la lista de clientes de la empresa existe un cliente con ese nombre, lanza una exception.
	 * @param nombre el nombre del nuevo cliente a crear
	 * @return el Cliente creado
	 * @throws IllegalStateException si ya existe un cliente con ese nombre en la empresa
	 */
	public Cliente nuevoCliente (String nombre){
		Cliente nuevoCliente= new Cliente(nombre.trim().toLowerCase());
		Iterator<Cliente> it= clientes.iterator();
		if(clientes.size() != 0)
		{
		    while(it.hasNext())
		    {
		      Cliente cli= it.next();
		      if(cli.getNombre().equals(nuevoCliente.getNombre()))
		      {
		          throw new IllegalStateException ("ya existe un cliente con ese nombre");
	          }
	         
	}
	}
	 clientes.add(nuevoCliente);
	 return nuevoCliente;
	}

	/**
	 * Asocia el medidor al cliente.
	 * Registra en el mapa de clientes la relaci�n (<nombre_del_cliente>,<descripcion_medidor>)
	 * (cliente.getNombre(), medidor.toString())
	 * 
	 * ej. ("juan perez", "SN_123")
	 * 
	 * Si el cliente ya tiene un medidor asociado, lanza una exception
	 * 	 * 	
	 * @param c el cliente al cual asociar el medidor
	 * @param m el medidor 
	 * @throws IllegalStateException si el medidor no puede asociarse al cliente (por ejemplo, si ya tiene un medidor asociado)
	 */
	public void asociarMedidorACliente(Cliente c, Medidor m){
	    if(c.getMedidorAsociado() != null)
	    {
	        throw new IllegalStateException("el cliente ya tiene un medidor asociado");
	        }
	    else{
	        
	        c.asociarMedidor(m);
	        mapaClientes.put(c.getNombre(), m.toString());
	       }
	    
	}
	
	/**
	 * Remueve el medidor del cliente,
	 * Elimina del mapa de clientes la relaci�n (<nombre_del_cliente>,<descripcion_medidor>)
	 * 
	 * @param c el cliente sobre el que desasociar
	 */
	public void disociarMedidorDeCliente (Cliente c){
		c.removerMedidor();
		mapaClientes.remove(c.getNombre());
	}
	
	/**
	  * Remueve de la lista de medidores administrados al medidor
	 * cuyo serial number es el que se especifica como parametro.
	 * 
	 * Retorna true si lo pudo eliminar, false si no existe ning�n 
	 * medidor administrado con ese serial number
	 * 
	 * @param serialNumber
	 * @return true si se pudo dar la baja, false si no existia medidor con el serial number especificado
	 */
	public boolean bajaMedidor(int serialNumber){
	    boolean exito= false ;
		Iterator<Medidor> it=medidores.iterator();
		if(medidores.size() != 0)
		{
		  while(it.hasNext())
		  {
		  Medidor med= it.next();
		  if(med.getSerialNumber() == serialNumber)
		  {
		   medidores.remove(med);
		   exito= true;
		   break;
		  }
		  
		  
		  }	  
		  
		 }
		return exito;
	}
	
	/**
	 * Remueve de la lista de clientes administrados al cliente
	 * cuyo nombre es el que se especifica como parametro.
	 * 
	 * Retorna true si lo pudo eliminar, false si no existe ning�n 
	 * cliente administrado con ese nombre
	 * 
	 * @param nombreCliente
	 * @return true si se pudo dar la baja, false si no existia cliente con el nombre especificado
	 */
	public boolean bajaCliente(String nombreCliente){
		boolean exito= false;
		
		if(clientes.size()!=0)
		{
		    Iterator<Cliente> it= clientes.iterator();
		  while(it.hasNext())
		  {
		  Cliente cli= it.next();
		  if(cli.getNombre().equals(nombreCliente.trim().toLowerCase()))
		  {
		      clientes.remove(cli);
		      exito=true;
		      break;
		  }
		  
		  }
		  
		  }
		
		return exito;
	}
	
	
	
}
