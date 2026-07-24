
public class PersonajeNoJugador extends Personaje{
    private Mision mision;
    private Elemento recompensa;

    /**
     * Crea un nuevo personaje no jugador con nombre, vida
     * una mision y su recompensa por cumplirla.
     *
     * @param nombre El nombre del personaje
     * @param vida La cantidad de vida del personaje
     * @param mision La mision que asignara a un personaje jugador que la solicite
     * @param recompensa La recompensa por cumplir la mision
     */
    public PersonajeNoJugador(String nombre, Integer vida, Mision mision, Elemento recompensa) {
        super(nombre, vida);
        this.mision = mision;
        this.recompensa = recompensa;
    }

    /**
     * Asigna una mision a un personaje jugador.
     *
     * @param personajeJugador El personaje jugador al cual se le asignara la mision
     */
    public void asignarMision(PersonajeJugador personajeJugador) {
            personajeJugador.asignarMision(mision);
    }

    /**
     * Asigna la recompensa de una mision completada a un personaje jugador.
     * Debe agrega el item a la bolsa, limpiar la mision actual y subir de nivel
     * del personaje.
     *
     * @param personajeJugador El personaje jugador al cual se le asignara la recompensa
     * @throws IllegalStateException si la mision no ha sido finalizada, si la bolsa del personaje esta llena
     */
    public void asignarRecompensa (PersonajeJugador personajeJugador) {
        if (mision == personajeJugador.getMision() && personajeJugador.isMisionFinalizada()){
            throw new IllegalStateException("Mision no finalizada");
        }
        try {
            personajeJugador.getBolsa().addElemento(recompensa);
            personajeJugador.setMision(null);
            personajeJugador.subirNivel();
        } catch (BolsaLlenaException e) {
            throw new IllegalStateException("Bolsa llena");
        }
    }
}
