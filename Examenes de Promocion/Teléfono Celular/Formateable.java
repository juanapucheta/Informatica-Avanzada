import java.util.ArrayList;
import java.util.HashMap;


public interface Formateable {
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
	public String convertirListaComoString(ArrayList<Llamada> llamadas);

	
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
	public String convertirListaComoStringAmigable(ArrayList<Llamada> llamadas, LibretaDeContactos cont);
	
	
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
	public String convertirMapaEstadisticaComoString(HashMap<String, EstadisticasNumero> m);
}
