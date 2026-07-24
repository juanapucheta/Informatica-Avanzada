
public class MisionDeExploracion extends Mision {
    private EscenarioBasico escenarioAExplorar;

    /**
     * Crea una nueva mision de exploracion
     *
     * @param nombre El nombre de la mision.
     * @param nivelRequerido El nivel requerido para realizar la mision.
     * @param escenarioAExplorar El escenario basico a explorar.
     * @throws java.lang.IllegalArgumentException cuando el escenario no es
     * un escenario basico
     */
    public MisionDeExploracion(String nombre, Integer nivelRequerido, Escenario escenarioAExplorar) {
        super(nombre, nivelRequerido);
        try {
            this.escenarioAExplorar = (EscenarioBasico) escenarioAExplorar;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("El escenario no es valido");
        }
    }

    /**
     * Valida el cumplimiento de la misión por parte de un personaje jugador.
     *
     * @param p El personaje jugador para validar el cumplimiento de la misión.
     * @return true si el personaje jugador ya visito el escenario false de lo contrario.
     */
    public Boolean validarCumplimiento (Personaje p) {
        if (!(p instanceof PersonajeJugador)){
            throw new IllegalArgumentException("El personaje no es un personaje Jugador");
        }
        return escenarioAExplorar.getVisitantes().contains(p);
    }
}

