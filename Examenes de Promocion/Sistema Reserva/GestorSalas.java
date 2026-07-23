import java.util.*;

public class GestorSalas {
    private List<Sala> salas = new ArrayList<>();

    /**
     * Agrega una Sala a la lista de salas del gestor
     */
    public void agregarSala(Sala sala) {
        if(sala != null){
            salas.add(sala);
        }
    }

    /**
     * Elimina de la lista la Sala cuyo nombre coincide
     * con el nombre pasado como argumento.
     */
    public void eliminarSala(String nombre) {
        Iterator<Sala> it = salas.iterator();
        
        while(it.hasNext()){
            Sala s = it.next();
            
            if(s.getNombre().equals(nombre)){
                it.remove();
                return;
            }
        }
    }

    /**
     * Actualiza la capacidad y ubicación de la Sala cuyo
     * nombre coincide con el nombre pasado como argumento.
     */
    public void modificarSala(String nombre, int nuevaCapacidad, Ubicacion nuevaUbicacion){
        for(Sala s : salas){
            if(s.getNombre().equals(nombre)){
                s.setCapacidad(nuevaCapacidad);
                s.setUbicacion(nuevaUbicacion);
            }
        }
    }

    /**
     * Devuelve la Sala cuyo nombre coincide con el nombre
     * pasado como argumento
     */
    public Sala buscarSala(String nombre) {
        for(Sala s : salas){
            if(s.getNombre().equals(nombre)){
                return s;
            }
        }
        return null;
    }

    /**
     * Devuelve una lista con todas las Salas del
     * gestor de Salas
     */
    public List<Sala> getTodas() {
        return this.salas; 
    }
}