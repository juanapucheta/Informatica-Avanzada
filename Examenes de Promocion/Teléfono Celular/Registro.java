import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Registro {
	private List<Llamada> registro;
	
	public Registro(){
		registro = new ArrayList<Llamada> ();
	}
	
	public List<Llamada> getRegistroCompleto (){
		return registro;
	}
	
	public void agregarLlamada (Llamada llamada){
		registro.add(llamada);
	}
	
	public void limpiarRegistro (){
		registro.clear();
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
	abstract public List<Llamada> getLlamadasPorDuracion (int minInicial, int segInicial, int minFinal, int segFinal) throws ParametrosInconsistentesException;
	
	/**
	 * Devuelve una lista con las llamadas salientes o entrantes
	 * @param tipo tipo de Llamada ENTRANTE/SALIENTE
	 * @return Lista de llamadas
	 */
	abstract public List<Llamada> getLlamadasPorTipo (TipoDeLlamada tipo);
	
	/**
	 * Devulelve un entero con la duracion total de las llamadas saliente y entrantes, en segundos
	 * @return duracion total de llmadas
	 */
	abstract public int getDuracionTotalLlamadasDelRegistro ();
	
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
	abstract public Map<String, EstadisticasNumero> getMapaDeEstadisticasDelRegistroCompleto ();
		
	
	/**
	 * Devuelve las estad�sticas de la lista de llamados para un numero en particular 
	 * 
	 * @param llamadas
	 * @return
	 */
	abstract public EstadisticasNumero getEstadisticasPorNumero (List<Llamada> llamadas, String numero) throws ParametrosInconsistentesException;
	
}
