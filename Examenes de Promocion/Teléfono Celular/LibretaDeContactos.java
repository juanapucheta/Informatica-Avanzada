import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 *  Representa una libreta de Contatos
 *  Contactos con el mismo numero telefonico son reemplazados.* 
 *
 */
public class LibretaDeContactos {
	
	private Map<String,Contacto> contactos;
	
	/**
	 * Cosnstructor de una libreta de contactos vac
	 */
	public LibretaDeContactos(){
		contactos = new HashMap<String, Contacto> ();
	} 
	
	/**
	 * Agrega un contacto a la libreta
	 * @param contacto
	 */
	public void agregarContacto (Contacto contacto){
		contactos.put (contacto.getNumerotelefonico(), contacto);
	}
	
	/**
	 * Devuelve el contacto cuyo numero es pasado como argumento
	 * @param numero
	 * @return
	 */
	public Contacto getContactoPorNumero (String numero){
		return contactos.get(numero);		
	}

	/**
	 * Remueve el contacto de la libreta de contactos
	 * @param contacto
	 */
	public void borrarContacto (Contacto contacto){
		contactos.remove(contacto.getNumerotelefonico());
	}
	
	/**
	 * Devuelve una lista con todos los contactos de la libreta
	 * @return
	 */
	
	public List<Contacto> getContactos(){
		return new ArrayList<Contacto> (contactos.values());
	}
}
