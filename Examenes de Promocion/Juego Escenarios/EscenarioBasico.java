import java.util.ArrayList;

public class EscenarioBasico extends Escenario
{
    private ArrayList<PersonajeNoJugador> personajes;

    /**
     * Crea un escenario basico con nombre y capacidad de alojar
     * personajes no jugadores.
     *
     * @param nombre El nombre del escenario
     * @param capacidad La cantidad de Personajes no jugadores que pueden
     *                  agregarse
     */
    public EscenarioBasico(String nombre, Integer capacidad)
    {
        super(nombre, capacidad);
        this.personajes = new ArrayList<>();
    }

    /**
     * Visita el escenario actualizando el escenarioActual del personaje
     * y agregandolo a la lista de visitantes.
     *
     * @param p el personaje jugador que visita el escenario
     * @throws IllegalStateException si el personaje jugador tiene un arma como elemento actual
     */
    @Override
    public void visitar(PersonajeJugador p) {
        if(p.getElementoActual() instanceof Arma){
            throw new IllegalStateException();
        }

        p.setEscenarioActual(this);
        super.getVisitantes().add(p);
    }

    /**
     * Agrega un personaje no jugador al escenario.
     *
     * @param p el personaje no jugador a agregar
     * @throws IllegalStateException si el escenario esta lleno y no puede agregar mas personajes
     */
    public void addPersonaje(PersonajeNoJugador p)
    {
        if(super.getCapacidad() > super.getVisitantes().size()){
            this.getVisitantes().add(p);
        }
        else{
            throw new IllegalStateException();
        }
    }

    /**
     * Devuelve una lista de PersonajeNoJugador que representa los personajes
     * no jugadores actualmente en el escenario.
     *
     * @return la lista de personajes no jugadores en el escenario
     */
    public ArrayList<PersonajeNoJugador> getPersonajes()
    {
        return this.personajes;
    }
}