import java.util.*;
// Codigo armado por Juana Pucheta. Puntaje 37 / 40

public class Mapa{
    private List<Personaje> personajes;
    private final int tamano;
    private final static int DISTANCIA_VISUALIZACION = 5; 
    private static final int TAMANO_DEFAULT = 100;

    /**
    * Inicializacion de mapa. Guarda el tamanio
    * e inicializa la lista de personajes
    *
    * @param tamano Se asume un tablero cuadrado del valor recibido
    */
    public Mapa(int tamano){
        if (tamano < 1)
            this.tamano= TAMANO_DEFAULT;
        else 
            this.tamano = tamano;
        personajes = new ArrayList<Personaje>();
    }

     /**
    * Agrega un personaje a la lista en caso de que no se encuentre en ella.
    * Si el nombre del personaje ya se encuentra en la lista
    * arroja una excepcion
    *
    * @param p Personaje a ser agregado
    */
    public boolean agregarPersonaje(Personaje p) throws NombreDuplicadoException{
        for(Personaje pers : personajes){
            
            if(pers.getNombre().equals(p.getNombre())){
                throw new NombreDuplicadoException("");
            }
        }
        personajes.add(p);
        return true;
    }

    /**
    * Elimina el personaje de la lista en caso de que exista
    * si el personaje no existe en la lista devuelve False, 
    * de lo contrario retorna True
    *
    * @param p Personaje a ser eliminado
    *
    */
    public boolean eliminarPersonaje(Personaje p){
        if(this.personajes.contains(p)){
            personajes.remove(p);
            return true;
        }
        else{
        return false;
        }
    }

    /**
    * Elimina el personaje de la lista en base a su nombre
    * si el personaje no existe en la lista devuelve False, 
    * de lo contrario retorna True
    * 
    * @param nombre Nombre del personaje a ser eliminado 
    *
    */ 
    public boolean eliminarPersonaje(String nombre){
        // Un Iterator es un objeto especial en Java que sirve para recorrer una colección elemento por elemento,
        // de forma segura, incluso si hayq ue eliminar elementos mientras se la recorre.
        Iterator<Personaje> it = personajes.iterator();
        
        // Devuelve true si todavía queda al menos un elemento por recorrer, false si ya llego al final de la lista.
        while(it.hasNext()){
            Personaje p = it.next();
            if(p.getNombre().equals(nombre)){
                it.remove();
                return true;
            }
        }
        
        return false;
        // En este metodo no podria haber implementado un for normal pues Java no deja borrar elementos de una lista mientras esta 
        // lista es recorrida por un for ("de forma directa"). Si o si debo implementar un Iterator. 
    }

    /**
     * @return Devuelve la lista de personajes
     */
    List<Personaje> getPersonajes(){
        return personajes;
    }

     /**
     * Mueve el personaje especificado en la direccion indicada. 
     * Si es posible, setea una nueva posicion al personaje
     * Debe cumplirse que:
     * 1. La nueva posicion este dentro de los limites del tablero
     * 2. La nueva posicion este disponible (-> no este ocupada por otro personaje)
     * 
     * 
     * Ayuda: Utilizar metodos privados de esta misma clase (posicionDisponible, nuevaPosicion -> clase Posicion)
     * 
     * @param p el Personaje
     * @param d la Direccion
     * @return true si se pudo efectuar el movimiento, false si no se pudo.
     */
    public boolean moverPersonajeEnDireccion(Personaje p, Direccion d){
        Posicion actual = p.getPosicion();
        Posicion nueva = actual.nuevaPosicion(d); // se captura el objeto nuevo devuelto
    
        // Reviso que la nueva posicion este dentro de los limites del tablero.
        if((nueva.getX() < 0 || nueva.getX() >= tamano)||(nueva.getY() < 0 || nueva.getY() >= tamano)){
            return false;
        }
    
        // Reviso si esta ocupada para devolver false.
        if(!this.posicionDisponible(nueva)){
            return false;
        }
    
        return p.setPosicion(nueva);
    }

    /**
     * @param nuevapos posicion tentativa del personaje. No debe haber ningun personaje en esa posicion
     * @return true si la posicion esta disponible, false si no lo esta
     */
    public boolean posicionDisponible(Posicion nuevapos){
        
        for(Personaje p : personajes){
            if(p.getPosicion().equals(nuevapos)){
                return false;
            }
        }
        
        return true;
    }

    /**
     * Retorna una lista con los personajes que se encuentran cercanos a un personaje
     * El personaje se considera cercano si la distancia entre los dos personajes
     * tanto en x como en y es menor a la distancia de visualizacion
     * 
     * AYUDA: Ningun personaje puede estar cerca de si mismo (la lista no debe incluir una referencia a si mismo)
     *  
     * @param p el Personaje
     * @return una List<Personaje> con los personajes cercanos
     */
    List<Personaje> obtenerPersonajesCercanos(Personaje p){
        List<Personaje> personajesCercanos = new ArrayList<>();
        
        for(Personaje per : personajes) {
            if(per.equals(p))  // Ningún personaje puede estar cerca de sí mismo
            {
                continue;
            }
        
            int dx = Math.abs(p.getPosicion().getX() - per.getPosicion().getX());
            int dy = Math.abs(p.getPosicion().getY() - per.getPosicion().getY());
            
            if((dx < DISTANCIA_VISUALIZACION) && (dy < DISTANCIA_VISUALIZACION))
            {
                personajesCercanos.add(per);
            }
        }
        return personajesCercanos;
    }

     /**
     * Retorna la cantidad de Heroes de una faccion determinada
     * @param f la faccion 
     * @return el numero de heroes de esa faccion
     */
    int obtenerNroHeroesDeFaccion (Faccion f) {
        int hereoesFaccion = 0;
        
        for(Personaje p : personajes){
            Heroe h = (Heroe) p; 
            if(h.getFaccion().equals(f)){
                hereoesFaccion++;
            }
        }
        return hereoesFaccion;
    }
}
