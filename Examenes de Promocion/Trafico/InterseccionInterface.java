

/**
 * Esta clase provee una interfaz para definir intersecciones de distintos tipos
 * Su principal tarea es el de crear y coordinar semáforos para cada calle y de poder determinar
 * que calle tiene paso en un determinado momento
 */
public interface InterseccionInterface {

    /**
     * Regitrarse a las calles integrantes para que los autos puedan saber en donde estan ubicados
     * los semáforos
     */
    void registrar_interseccion();

    /**
     * Determina si la calle consultada tiene habilitado el cruce o no
     * @param calle: calle de la cuál se está consultando
     * @return: verdadero si tiene paso, falso si no
     * @throws CalleIncorrectaException: si se consulta por una calle que no forma parte de la Interseccion
     */
    boolean get_paso(Calle calle) throws CalleIncorrectaException;

    /**
     * Para un determinada calle retorna la altura en la cual se encuentra esta interseccion
     * @param calle
     * @return
     * @throws CalleIncorrectaException
     */
    Integer get_altura_calle(Calle calle) throws CalleIncorrectaException;

    /**
     * Setea los semaforos componentes en el siguiente estado.
     * Representa el cambio de un estado al siguiente en la maquina de estados de la interseccion
     * depende del tipo de interseccion
     */
    void next_estado_semaforo();
}
