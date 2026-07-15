import java.util.ArrayList;
import java.util.List;

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas; // Array List de flechas

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
        setNombre("Carcaj");
        setTipo(TipoElemento.RECIPIENTE);
        setPeso(PESO_PROPIO);
        
        this.capacidad = 5; 
        this.flechas = new ArrayList<>(); // incializo vacio
        
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
        setNombre(nombre); // nombre por parametro
        setTipo(TipoElemento.RECIPIENTE);
        setPeso(PESO_PROPIO);
        
        this.capacidad = capacidad; //capacidad por parametro
        this.flechas = new ArrayList<>(); // incializo vacio

        
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
         if(!(flecha instanceof Flecha)){
            System.out.println(flecha.getNombre() + ": No es una flecha");
        }
        
        else if(flechas.size() >= capacidad){
            System.out.println(getNombre() + ": Capacidad completa");
        }
        
        else{
            flechas.add((Flecha) flecha);
            addPeso(flecha.getPeso());
        }
    }

    /**
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha () {
        if(flechas.isEmpty()){
            System.out.println(getNombre() + ": No quedan flechas");
            return null;    
        }
        
        Flecha flecha = flechas.remove(0);
        addPeso(-flecha.getPeso());
        return flecha;
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        setPeso(getPeso() + peso);
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        return getNombre() + ": Flechas " + flechas.size() + "/" + capacidad;
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
