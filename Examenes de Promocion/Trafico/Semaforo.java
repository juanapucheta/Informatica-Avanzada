
/**
 * Logica de un semaforo de 2 estados: ROJO y VERDE
 */
public class Semaforo {

    private ESTADOS estado;

    /**
     * Inicializa el semaforo al estado inicial
     * @param estado_inicial: rojo o verde
     */
    public Semaforo(ESTADOS estado_inicial){
        this.estado = estado_inicial;
    }

    /**
     * Consulta el estado del semaforo
     * @return rojo o verde
     */
    public ESTADOS get_estado(){
        return estado;
    }

    /**
     * Cambia el estado del semaforo
     * @param nuevo_estado rojo o verde
     */
    public void set_estado(ESTADOS nuevo_estado){
        this.estado = nuevo_estado;
    }


    /**
     * @return verdadero si el semáforo está en verede, falso si no lo está
     */
    public boolean esta_disponible(){
        return estado.equals(ESTADOS.VERDE);
    }
}
