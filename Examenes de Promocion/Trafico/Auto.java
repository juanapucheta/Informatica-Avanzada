 /**
 * Clase resuelta por Juana Pucheta. Puntaje: 40 / 40
 * Implementacion de un Auto que transita por una determinada calle.
 * El modelo tiene en cuenta las siguientes simplificaciones:
 *      1. El auto siempre transita por la misma calle (no puede doblar)
 *      2. La direcciones posibles son adelante y atras. El auto no cambia de dirección en ningún momento
 */
public class Auto {
    // Estaticos
    private static final Integer velocidad = 1; // cantidad de lugares que se mueve el auto.
    private static final String nombre = "Auto";
    private static Integer numero_auto = 0;

    public enum DIRECCION {
        ADELANTE,
        ATRAS
    }

    private Calle calle_actual;
    private Integer posicion; // altura ubicada en la calle actual
    private DIRECCION direccion;
    private Integer id;

    /**
     * Inicializacion del auto
     * @param calle_inicial: calle por la cual el auto va a transitar
     * @param direccion: direccion en la cual puede transitar @see DIRECCION
     * @param lugar_inicial: lugar inicial dentro de la calle en la cual inicia su recorrido
     */
    public Auto(Calle calle_inicial, DIRECCION direccion, Integer lugar_inicial){
           this.calle_actual = calle_inicial;
           this.direccion = direccion;
           this.posicion = lugar_inicial;

           id = numero_auto;
           numero_auto += 1;
    }

    /**
     * @return direccion del auto
     */
    public DIRECCION get_direccion(){
        return direccion;
    }

    /**
     * @return calle actual
     */
    public Calle get_calle(){
        return calle_actual;
    }

    /**
     * @return posicion actual del auto
     */
    public Integer get_posicion(){
        return posicion;
    }


    /**
     * Devuelve la nueva posicion que tendria el auto
     * La nueva posicion depende de la DIRECCION que tiene el auto y su velocidad, 
     * que en este caso es la misma para todos los autos
     * Si la direccion es hacia ADELANTE la posicion del auto aumenta
     * Si la direccion es hacia ATRAS la posicion del auto decrese
     * @return la nueva posicion que va a ocupar el auto
     */
    public Integer get_siguiente_posicion() {
        if(this.get_direccion() == DIRECCION.ADELANTE){
           return (this.get_posicion() + velocidad);
        }
        else{
            return (this.get_posicion() - velocidad);
        }
    }

    /**
     * Se fija si la posicion a validar está entre la posición actual del auto y
     * su siguiente posición ( get_siguiente_posicion() )
     * @param posicion_a_validar: posicion por la cual queremos saber si estará en la posición 
     * a validar en su próximo moviemiento
     * @return verdadero si pasa por la posicion, falso si no pasa
     */
    public boolean auto_pasa_por(Integer posicion_a_validar){
        
        Integer actual = this.get_posicion();
        Integer siguiente = this.get_siguiente_posicion();
        
        if(this.get_direccion() == DIRECCION.ADELANTE){
            return ((posicion_a_validar >= actual) && (posicion_a_validar <= siguiente));
        }
        
        else{
            return ((posicion_a_validar <= actual) && (posicion_a_validar >= siguiente));
        }
    }

    /**
     * Logica de movimiento del auto:
     * Si el proximo movimiento del auto esta dentro de los limites de la calles entonces:
     *  Si el auto puede avanzar, es decir, no choca con otro auto ni se encuentra un semaforo en rojo 
     *  (Ayuda: ver clase Mapa) avanza.
     *  Si no puede avanzar lanza excepcion
     * Si el auto esta por salirse de los limites no avanza pero tampoco tira excepcion.
     */
    public void mover_auto_una_posicion(Mapa mapa) throws IllegalStateException {
        Integer siguiente = this.get_siguiente_posicion();
        
        if((siguiente < 0) || (siguiente > this.get_calle().get_longitud())){
            return;
        }
        
        //reviso que no choca con otro auto ni se encuentra un semaforo en rojo
        if(mapa.comprobar_movimiento(this)){
            posicion = this.get_siguiente_posicion();
        }
        
        //Si no puede avanzar lanza excepcion
        else{
            throw new IllegalStateException();
        }
        
    }

    public String toString() {
        return String.format("%s %d", nombre, id);
    }
}
