
public class MisionDeCombate extends Mision {
    private EscenarioDeCombate escenario;

    /**
     * Crea una nueva mision de combate
     *
     * @param nombre El nombre de la mision
     * @param nivelRequerido El nivel requerido para participar de la mision
     * @param escenario El escenario de combate donde se realizara la mision
     * @throws java.lang.IllegalArgumentException cuando el escenario no es de
     * combate
     */
    public MisionDeCombate(String nombre, Integer nivelRequerido, Escenario escenario) {
        super(nombre, nivelRequerido);
        try {
            this.escenario = (EscenarioDeCombate) escenario;
        }
        catch (ClassCastException e) {
            throw new IllegalArgumentException("El escenario no es valido");
        }
    }

    /**
     * Valida si el personaje cumplio la mision o no
     *
     * @param p El personaje a validar
     * @return true si no quedan enemigos en el escenario false en caso contrario
     * @throws java.lang.IllegalArgumentException cuando el personaje no es un personaje jugador
     */
    public Boolean validarCumplimiento(Personaje p) {
        if (!(p instanceof PersonajeJugador) ) {
            throw new IllegalArgumentException();
        }
        return escenario.getEnemigos().isEmpty();
    }
}
