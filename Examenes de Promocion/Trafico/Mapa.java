import java.util.ArrayList;
import java.util.List;

/**
 * Clase resuelta por Juana Pucheta. Puntaje: 40 / 40
 * Logica que centraliza la informacion de los movimientos de los autos
 * Evita que los autos choquen entre sí o que intenten cruzar un semáforo en rojo
 */
public class Mapa {
    private List<Auto> autos;

    public Mapa(){
        this.autos = new ArrayList<>();
    }

    /**
     * Agrego un nuevo auto para ser controlado
     * @param auto
     */
    public void agregar_auto(Auto auto){
        this.autos.add(auto);
    }

    /**
     * Devuelve la lista de autos en mapa
     */
    public List<Auto> get_autos() {
        return this.autos;
    }

    /**
     * Elimina la lista de autos registrados en el mapa
     */
    public void borrar_autos() {
        this.autos.clear();
    }

    /**
     * Se fija en la lista de autos disponible si hay alguno que cumpla las siguientes condiciones
     *      1. Va en la misma direccion que el auto consultado
     *      2. Esta en la misma calle
     *      3. Esta en alguna posicion por lo cual el auto pasaria en su proximo movimiento
     *      Recomendacion: utilizar metodos de la clase Auto
     * @param auto
     * @return verdadero si algun auto cumple la condicion, falso si no la cumple
     */
    private boolean auto_en_el_camino(Auto auto){
        for(Auto a : autos){
            if((a.get_direccion() == auto.get_direccion()) && (a.get_calle() == auto.get_calle()) && (auto.auto_pasa_por(a.get_posicion()))){
                return true;
            }
        }
        return false;
    }

    /**
     * Se fija si dentro de las intersecciones que hay en la calle actual del auto:
     *     si hay alguna interseccion en la trayectoria del auto:
     *          verifica que el semaforo este en verde para la calle en la cual 
     *          transita el auto (true si esta en verde, falso si no)
     *     de lo contrario:
     *          devuelve verdadero
    
     * @param auto
     * @return verdadero si no hay ninguna interseccion con semaforo en rojo en el camino,
     * de lo contrario devuelve falso
     */
    private boolean interseccion_disponible(Auto auto) {
        //Recorro todas las intersecciones que afectan a la calle por la que transita el auto.
        for(InterseccionInterface interseccion : auto.get_calle().get_intersecciones()){
            try{
                //para cada una me fijo si el auto la "pisa" en su próximo movimiento.
                Integer altura = interseccion.get_altura_calle(auto.get_calle());
                
                //reviso si el auto va a pasar por la interseccion
                // y ademas el semáforo está en rojo
                if(auto.auto_pasa_por(altura) && interseccion.get_paso(auto.get_calle())){
                    return false;
                }
            }
            catch(CalleIncorrectaException e){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Logica de comprobacion de movimientos de los autos
     * Evalua:
     *     1. Que no haya ningun auto en el camino
     *     2. Que no tenga semaforo en rojo en ninguna intereseccion
     * Recomendacion: Utilizar métodos privados de la misma clase
     * @param auto
     * @return verdadero si el movimiento a realizar está permitido, falso si no lo está
     */
    public boolean comprobar_movimiento(Auto auto) {
        return ((!this.auto_en_el_camino(auto)) && (this.interseccion_disponible(auto)));
    }
}
