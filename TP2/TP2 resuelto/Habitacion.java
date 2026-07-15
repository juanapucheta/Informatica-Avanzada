import java.util.TreeMap;

/**
 * Clase Habitacion - Una habitacion en un juego de aventuras
 *
 * Esta clase es parte de la apliciacion "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Un objeto "Habitacion" representa una ubicacion en el juego. Las
 * habitaciones tienen salidas que conducen a otras habitaciones, indicadas
 * como norte, sur, este y oeste. Para cada direccion, una habitacion 
 * mantiene una referencia a la habitacion vecina, o null si no existe una
 * en esa direccion.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Habitacion 
{
    // private String descripcion;
    // almacena las salidas de esta habitacion
    protected TreeMap<Salida, Habitacion> salidas;
    // almacena los elementos de la habitacion
    protected TreeMap<String, Elemento> elementos;
    
/* *** Modificacion para el TP **************************** */
/* Informatica Avanzada - 2021 */
    // Esta version utiliza la informacion del enumerado LugaresMapa
    protected LugaresMapa lugar;
    
    /**
     * Crea una habitacion descrita por "descripcion". 
     * Inicialmente, la habitacion no tiene salidas, "descripcion"
     * es algo asi como "una cocina" o "un patio".
     * 
     * Se incorpora el String nombre y el TreeMap de elementos para
     * adaptarlo al TP de Informatica Avanzada.
     * 
     * @param nombre El nombre de la habitacion
     * @param descripcion La descripcion de la habitacion.
     */
    public Habitacion (LugaresMapa lugar) {
        // guardo el lugar del mapa que representa esta habitacion 
        this.lugar = lugar; 
    
        //la habitacion no tiene salidas. creo el mapa vacio de salidas
        salidas = new TreeMap<>();
        
        // incorporo el mapa vacio de elementos
        elementos = new TreeMap<>();
        
    }

    /**
     * Devuelve el nombre de la habitacion.
     * 
     * @return El nombre de la habitacion.
     */
    public String getNombre () {
        return lugar.getNombre();   
    }

    /**
     * @return La descripcion corta de esta habitacion
     * (la que se definio en el constructor).
     */
    public String getDescripcionCorta()
    {
        return lugar.getDescripcion();
    }

    /**
     * Devuelve una descripcion de la habitacion en la forma:
     * 
     *     Usted esta en la cocina
     *     Salidas: norte oeste
     *     Elementos: Pan Pluma Flecha
     * 
     * MODIFICAR el metodo para que la descripcion incluya la
     * lista de elementos:
     * 
     * @return Una descripcion larga de esta habitacion
     */
    public String getDescripcionLarga()
    {
        return "Usted esta en  " + lugar.getNombre() + ".\n" + getStringDeSalidas() + ".\n" + getStringDeElementos();
    }

    /**
     * Agrega un elemento a la habitacion.
     * 
     * Si el elemento es de tipo liquido, no se agrega al mapa
     * y se debe imprimir:
     *     "<nombre>: se acaba de derramar en el piso"
     * donde <nombre> es el nombre del liquido derramado.
     * 
     * @param elemento El elemento a agregar.
     */
    public void addElemento (Elemento elemento) {
        if(elemento.getTipo() == TipoElemento.LIQUIDO){
            System.out.println(elemento.getNombre() + ": se acaba de derramar en el piso");
        }
        
        else{
            // agrego al TreeMap de elementos el elemento nuevo
            // put(clave,valor) indico donde guardar y que guardar
            elementos.put(elemento.getNombre(), elemento);
        }
    }

    /**
     * Quita el elemento de la habitacion.
     * 
     * Si el elemento es de tipo fijo (parte del escenario)
     * no debe quitarlo, devuelve null e imprime el mensaje:
     *     "<nombre>: No se puede tomar"
     * donde <nombre> es el elemento solicitado.
     * 
     * Si el elemento no existe, devuelve null e imprime el mensaje:
     *     "<nombre>: No existe"
     * donde <nombre> es el elemento solicitado.
     * 
     * @param nombre El nombre del elemento a tomar.
     * @return El elemento a tomar.
     */
    public Elemento getElemento (String nombre) {
        // Busco el elemento en el mapa por su nombre.
        Elemento elemento = elementos.get(nombre);
        
        // Si no lo encuentro imprimo que no existe.
        if(elemento == null){
            System.out.println(nombre + ": No existe");
            return null; 
        }
        
        // Analizo si el elemento es fijo
        if(elemento.getTipo() == TipoElemento.FIJO){
            System.out.println(nombre + ": No se puede tomar");
            return null;
        }
        
        // Si existe y no es fijo, lo quito del mapa
        else{
            // remove(clave) sabe por asociacion el valor.
            elementos.remove(nombre);
            return elemento; 
        }
        
    }

    /**
     * Devuelve una cadena describiendo las salidas de la habitacion,
     * por ejemplo:
     *    "Elementos: Pan Pluma Flecha".
     * En caso de no haber elementos, devuelve la cadena:
     *    "No hay elementos en este lugar"
     * 
     * @return Detalles de las salidas de la habitacion
     */
    protected String getStringDeElementos ()
    {
        if(elementos.isEmpty()){
            return "No hay elementos en este lugar"; 
        }
        
        else{
            String cadena = "Elementos:";
            
            // uso key.Set() dado que las claves SON los nombres de los elementos.
            for(String nombre : elementos.keySet()){
            cadena += " " + nombre;
            }
            return cadena;
        }
    }

    /**
     * Devuelve la habitacion a la que se llega si vamos desde esta habitacion
     * en la direccion indicada. Si no hay habitaciones en esa direccion,
     * se devuelve a si misma e imprime el mensaje:
     *  
     *    "No hay salida en direccion <direccion>"
     * donde <direccion> es la direccion indicada.
     * 
     * @param direccion La direccion de salida
     * @return La habitacion en la direccion indicada
     */
    public Habitacion getSalida (Salida direccion) 
    {
        Habitacion siguiente = salidas.get(direccion);
        if(siguiente == null){
            System.out.println("No hay salida en direccion " + direccion); 
            return this;
        }
        return siguiente; 
    }

    /**
     * Define las salidas de esta habitacion.
     * @param direccion La direccion de la salida
     * @param vecina  La habitacion a la cual esta salida conduce.
     */
    public void establecerSalida (Salida direccion, Habitacion vecina) 
    {
        salidas.put(direccion, vecina);
    }

    /**
     * Devuelve una cadena describiendo las salidas de la habitacion,
     * por ejemplo
     * 
     * "Salidas: norte oeste".
     * 
     * @return Detalles de las salidas de la habitacion
     */
    private String getStringDeSalidas ()
    {
        String cadena = "Salidas:";
        for(Salida salida : salidas.keySet()) {
            cadena += " " + salida;
        }
        return cadena;
    }

}

