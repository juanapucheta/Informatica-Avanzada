public class PersonajeJugador extends Personaje implements Guerrero {
    private Elemento elementoActual;
    private Integer nivel;
    private Mision mision;
    private Escenario escenarioActual;
    private EstadoMision estado;
    /**
     * Crea un nuevo Personaje Jugador con su nombre y cantidad de vida
     *
     * @param nombre El nombre del personaje
     * @param vida La vida del personaje
     */
    public PersonajeJugador(String nombre, Integer vida) {
        super(nombre, vida);
        this.nivel = 1;
        this.estado = new MisionNoAsignada();
    }

    /**
     * Retorna el elemento actual del personaje jugador.
     *
     * @return el elemento actual del personaje jugador
     */
    public Elemento getElementoActual() {
        return elementoActual;
    }

    /**
     * Establece el elemento actual del personaje jugador.
     *
     * @param elementoActual el nuevo elemento actual del personaje jugador
     */
    public void setElementoActual(Elemento elementoActual) {
        this.elementoActual = elementoActual;
    }

    /**
     * Realiza un ataque al enemigo.
     *
     * @param enemigo el personaje enemigo al que se va a atacar
     * @throws ArmaDescargadaException si el arma está descargada y no se puede disparar
     */
    @Override
    public void atacar(Personaje enemigo) throws ArmaDescargadaException {
        enemigo.recibirDanio(((Arma) elementoActual).disparar());
    }

    /**
     * Guarda el elemento actual en la bolsa.
     *
     * @throws BolsaLlenaException si la bolsa está llena y no se puede guardar el elemento
     */
    public void guardarElemento() throws BolsaLlenaException {
        getBolsa().addElemento(this.elementoActual);
        this.elementoActual = null;
    }

    public void subirNivel() {
        this.nivel += 1;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Mision getMision() {
        return mision;
    }

    public EstadoMision getEstadoMision() {
        return estado;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public void setEstadoMision(EstadoMision estado) {
        this.estado = estado;
    }

    public Escenario getEscenarioActual() {
        return escenarioActual;
    }

    public void setEscenarioActual(Escenario escenarioActual) {
        this.escenarioActual = escenarioActual;
    }

    public void asignarMision(Mision m) {
        setMision(m);
        estado.asignarMision(this);
    }

    public void aceptarMision() {
        estado.aceptarMision(this);
    }

    public void cumplirMision() {
        estado.cumplirMision(this);
    }

    public Boolean isMisionFinalizada () {
        return estado instanceof MisionFinalizada;
    }

    /**
     * Define un patron State para la mision
     * - Estado MisionNoAsignada : Solo puede asignarse la mision a un personaje.
     * Cualquier otra accion debe lanzar IllegalStateException.
     * - Estado MisionAsignada : Solo puede aceptarse la mision. Cualquier otra
     * accion debe lanzar IllegalStateException.
     * - Estado MisionAceptada : Solo puede cumplirse la mision. Cualquier otra
     * accion debe lanzar IllegalStateException.
     * - Estado MisionFinalizada : No puede realizarse ninguna accion. Cualquier
     * llamada a metodos en este estado debe lanzar IllegalStateException.
     */
    public abstract class EstadoMision {

        public abstract void asignarMision(PersonajeJugador p);

        public abstract void aceptarMision(PersonajeJugador p);

        public abstract void cumplirMision(PersonajeJugador p);

        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    class MisionNoAsignada extends EstadoMision {
        /**
         * Asigna la mision al personaje y cambia el estado de la mision.
         * @param p el personaje al cual asignarle la mision.
         */
        @Override
        public void asignarMision(PersonajeJugador p) {
            p.setMision(p.getMision());
            p.setEstadoMision(new MisionAsignada());
        }

        @Override
        public void aceptarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

        @Override
        public void cumplirMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

    }

    class MisionAsignada extends EstadoMision {
        // Solo puede aceptarse la mision.
        @Override
        public void asignarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

        /**
         * Valida que el personaje tenga asignada la mision y el nivel requerido
         * realizarla. Si puede aceptarla cambia su estado a Aceptada.
         * Si el personaje no tiene nivel suficiente para aceptar la mision
         * lanza IllegalStateException.
         * @param p el personaje que quiere aceptar la mision.
         */
        @Override
        public void aceptarMision(PersonajeJugador p) {
            if((p.getMision() != null) || (p.getNivel() >= p.getMision().getNivelRequerido())) {
                    p.setEstadoMision(new MisionAceptada());
            }
            else{
                throw new IllegalStateException();
            }
        }

        @Override
        public void cumplirMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }
    }

    class MisionAceptada extends EstadoMision {
        //- Estado MisionAceptada : Solo puede cumplirse la mision.     
        @Override
        public void asignarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

        @Override
        public void aceptarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

        /**
         * Valida que el personaje tenga asignada la mision y
         * el cumplimiento de la misma. Si se cumplen ambas condiciones
         * cambia su estado a Finalizada.
         * Si la mision no esta completa arroja IllegalArgumentException.
         * @param p el personaje que quiere cumplir la mision.
         */
        @Override
        public void cumplirMision(PersonajeJugador p) {
            if((p.getMision() != null) && (p.getMision().validarCumplimiento(p))){
                    p.setEstadoMision(new MisionFinalizada());
            }
            else{
                throw new IllegalStateException();
            }
        }
    }

    class MisionFinalizada extends EstadoMision {
        // Estado MisionFinalizada : No puede realizarse ninguna accion. 
        @Override
        public void asignarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }

        @Override
        public void aceptarMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }
        @Override
        public void cumplirMision(PersonajeJugador p) {
            throw new IllegalStateException();
        }
    }
}
