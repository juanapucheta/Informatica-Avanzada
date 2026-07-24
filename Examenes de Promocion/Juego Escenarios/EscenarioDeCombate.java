import java.util.ArrayList;
import java.util.Iterator;

public class EscenarioDeCombate extends Escenario {
    private ArrayList<PersonajeNoJugadorGuerrero> enemigos;

    public EscenarioDeCombate(String nombre, Integer capacidad) {
        super(nombre, capacidad);
        enemigos = new ArrayList<>();
    }

    /**
     * Actualiza la posicion actual del personaje y agrega el personaje
     * a la lista de visitantes del escenario.
     * Si hay enemigos y el personaje tiene un arma como elemento actual
     * simula ademas una batalla (metodo interno)
     * Si hay enemigos y el personaje no tiene como elemento actual un arma 
     * lanza IllegalStateException y no actualiza la lista de visitantes ni la
     * posicion del personaje.
     * @param p El pesonaje jugador que visita el escenario
     * @throws IllegalStateException cuando hay enemigos y el personaje
     * no tiene seleccionada un arma
     */
    @Override
    public void visitar(PersonajeJugador p) {
        if(this.getEnemigos().size() > 0){
            if(p.getElementoActual() instanceof Arma){
                this.simularBatalla(p);
            }
            else{
                throw new IllegalStateException();
            }
        }
        p.setEscenarioActual(this);
        super.getVisitantes().add(p);
    }

    /**
     * Agrega un personaje a la lista de personajes enemigos del escenario.
     * Debe validar el nombre para evitar duplicados. En caso de que ya
     * exista un personaje con el mismo nombre arroja InvalidArgumentException
     * @param p el personaje no jugador guerrero a agregar
     * @throws IllegalArgumentException si hay un personaje con el mismo
     * nombre en la lista
     */
    public void addPersonaje (PersonajeNoJugadorGuerrero p) {
        for(PersonajeNoJugadorGuerrero pers : this.getEnemigos()){
            if(pers.getNombre().equals(p.getNombre())){
                throw new IllegalArgumentException();
            }
        }
        this.getEnemigos().add(p);
    }

    /**
     * Remueve un personaje de nombre "name" de la lista de
     * personajes enemigos del mapa. Si el pesonaje no esta en la lista
     * arroja IllegalArgumentException.
     * @param name El nombre del personaje a remover
     * @return El personaje removido de la lista
     * @throws IllegalArgumentException si el personaje no esta en la lista
     */
    public PersonajeNoJugadorGuerrero removePersonaje (String name) {
        Iterator<PersonajeNoJugadorGuerrero> it = this.getEnemigos().iterator();
        
        while(it.hasNext()){
             PersonajeNoJugadorGuerrero persNJ = it.next();
             
             if(persNJ.getNombre().equals(name)){
                it.remove();
                return persNJ;
                }
        }
        
        throw new IllegalStateException();
    }

    /**
     * Simula una batalla en el escenario.
     * Se simularan tantos pasos de batalla como sea necesario
     * hasta que el personaje jugador muera (vida =< 0) o
     * mueran todos sus enemigos.
     * En cada paso de batalla deberan ejecutarse las siguientes
     * acciones:
     * - Verificar si todavia hay enemigos y si el jugador tiene
     * vida > 0
     * - Recorrer la lista de enemigos
     *      - Efectuar un ataque del enemigo
     *      - Efectuar un ataque del personaje
     * - Verificar si algun enemigo tiene vida <= 0 y removerlo
     * de la lista
     * Al finalizar la batalla debe reasignarse la vida inicial
     * del personaje solo si no fue derrotado.
     * @param p el personaje jugador
     */
    public void simularBatalla (PersonajeJugador p) {
        Integer vidaInicial = p.getVida();
        while (!enemigos.isEmpty() && p.getVida() > 0) {
            for (PersonajeNoJugadorGuerrero g : enemigos) {
                try {
                    if (g.getVida() > 0) {
                        g.atacar(p);
                    }
                } catch (ArmaDescargadaException ignore) {

                }
                try {
                    if (p.getVida() > 0) {
                        p.atacar(g);
                    }
                } catch (ArmaDescargadaException ignore) {

                }
            }
            enemigos.removeIf(g -> g.getVida() <= 0);
        }
        if (p.getVida() > 0) {
            p.setVida(vidaInicial);
        }
    }

    /**
     * Retorna la lista de enemigos actualmente en la batalla.
     *
     * @return la lista de enemigos
     */
    public ArrayList<PersonajeNoJugadorGuerrero> getEnemigos() {
        return this.enemigos;
    }
}
