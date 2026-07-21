import java.util.ArrayList;
import java.util.List;

/**
 * Clase resuelta por Juana Pucheta. Puntaje: 20 / 20
 * Modelo simplificado de una calle de 2 vias
 */
public class Calle {

    private String nombre;
    private Integer longitud; // Longitud [mts]
    private List<InterseccionInterface> intersecciones;

    /**
     * Inicializacion
     * @param nombre nombre de la calle
     * @param longitud longitud máxima disponible
     */
    public Calle(String nombre, Integer longitud){
        this.nombre = nombre; 
        this.longitud = longitud;
        this.intersecciones = new ArrayList<>();
    }


    /**
     * Agrega una nueva interseccion a esta calle
     * no puede contener intersecciones repetidas
     * @param inte Interseccion a ser agregada 
     */
    public void agregar_interseccion(InterseccionInterface inte){
        if(!(this.intersecciones.contains(inte))){
            this.intersecciones.add(inte);
        }
    }

    /**
     *
     * @return longitud de la calle
     */
    public Integer get_longitud(){
        return longitud;
    }

    /**
     *
     * @return lista con todas las intersecciones por las que es afectada esta calle
     */
    public List<InterseccionInterface> get_intersecciones(){
        return this.intersecciones;
    }

    /**
     * @return devuelve el nombre de la calle
     */
    @Override
    public String toString() {
        return nombre;
    }
}
