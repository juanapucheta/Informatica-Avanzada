
public class PersonajeNoJugadorGuerrero extends Personaje implements Guerrero {
    private Arma arma;

    /**
     * Crea una nueva instancia de un personaje no jugador guerrero
     *
     * @param nombre El nombre del personaje
     * @param vida La vida del personaje
     * @param arma El arma que utilizara el personaje
     */
    public PersonajeNoJugadorGuerrero(String nombre, Integer vida, Arma arma) {
        super(nombre, vida);
        this.arma = arma;
    }

    /**
     * Ataca a un personaje especifico utilizando el arma del personaje no jugador guerrero.
     *
     * @param p El personaje al que se va a atacar
     * @throws ArmaDescargadaException Si el arma del personaje no jugador guerrero esta descargada
     */
    @Override
    public void atacar(Personaje p) throws ArmaDescargadaException {
        p.recibirDanio(arma.disparar());
    }
}
