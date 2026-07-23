import java.util.*;
import java.time.LocalDateTime;

public class GestorReservas {
    private GestorSalas gestorSalas;
    protected Map<Sala, List<Reserva>> reservas;

    public GestorReservas(GestorSalas gestorSalas) {
        this.gestorSalas = gestorSalas;
        reservas = new HashMap<>();
    }
    
    public List<Reserva> getReservasPorSala (String nombreSala){
        Sala sala = gestorSalas.buscarSala(nombreSala);
        List<Reserva> listaReservas;
        if (sala !=null && reservas.containsKey(sala)) {
           listaReservas = reservas.get(sala);
        }
        return new ArrayList<>();
    }

    /**
     * Reserva una sala para un usuario, a la hora y con la duración indicada
     *  
     * Si la sala no existe en el gestor de Salas -> Lanza Exception ().
     * 
     * Revisa todas las reservas asociadas a la sala, y si existe alguna
     * que se superpone -> Lanza Exception ().
     * 
     * Si la sala existe, y no tienen ninguna reserva superpuesta
     * se genera una nueva Reserva y se agrega al mapa de reservas
     * y retorna true.
     * 
     * @throw Exception si la sala no existe, o si tiene una reserva en el 
     * horario requerido
     * @return true si se pudo generar la reserva.
     * 
     */
    public boolean reservar(String nombreSala, Usuario usuario, LocalDateTime inicio, int duracion) throws Exception {
        Sala salaReservar = this.gestorSalas.buscarSala(nombreSala);
        
        if(salaReservar == null){
            throw new Exception("La sala no existe."); 
        }
        
        // Revisa todas las reservas asociadas a la sala.
        // Creo la lista de reservas de esa sala. 
        List<Reserva> lista = reservas.get(salaReservar);
        if(lista == null){ // La sala no tiene ningun reserva hecha.
            lista = new ArrayList<>();
            reservas.put(salaReservar, lista);
        }
        
        // Reviso si hay superposición con las reservas existentes
        for(Reserva r : lista){
            if(r.seSuperpone(inicio, duracion)){
            throw new Exception("La sala ya tiene una reserva en ese horario."); 
            }            
        }
        
        // Si no hay superposicion, agrego la reserva a la sala. 
        Reserva nuevaReserva = new Reserva(salaReservar, usuario, inicio, duracion);
        lista.add(nuevaReserva);
        return true;
    }

    /**
     * Libera la sala de la reserva agendada a la hora epecificada.
     * 
     * Obitene la Sala por su nombre del gestor de Salas, si no existe o no tiene
     * reservas asociadas, no hace nada.
     * 
     * Recorre la lista de reservas de la sala, busca si hay alguna que inicie
     * a la hora especificada y la remueve.
     * 
     */
    public void liberar(String nombreSala, LocalDateTime inicio) {
        Sala salaLiberar = this.gestorSalas.buscarSala(nombreSala);
        
        if(salaLiberar == null){return; }
        
        List<Reserva> lista = reservas.get(salaLiberar);
        if(lista != null){
            Iterator<Reserva> it = lista.iterator();
            while(it.hasNext()){
                Reserva r = it.next();
                
                if(r.getInicio().equals(inicio)){
                    it.remove();
                }
            }
        }
    }

    /**
     * Devuevle una lista de todas las salas DISPONIBLES con una capacidad
     * mínima y en una ubicación.
     * 
     * Recorre todas las salas existentes, y de cada sala recorre la lista de 
     * reservas y determina si están o no disponibles a la hora indicada 
     * por el tiempo indicado. Si está disponible, agrega la Sala a la lista.
     * 
     * @return la lista con todas las salas disponbiles.
     */
    public List<Sala> disponibles(LocalDateTime inicio, int duracion) {
        List<Sala> disponibles = new ArrayList<Sala>();
        List<Sala> todas = gestorSalas.getTodas();
        
        for(Sala s : todas){
            List<Reserva> lista = reservas.get(s);
            boolean libre = true; 
            
            if(lista != null){
                for(Reserva r : lista){
                    if(r.seSuperpone(inicio, duracion)){
                        libre = false; 
                        break;
                    }
                }
            }
            
            if(libre){
                disponibles.add(s);
            }
        }   
        return disponibles;
    }
}