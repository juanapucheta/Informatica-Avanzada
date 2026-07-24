
import java.util.ArrayList;
import java.util.TreeMap;

public class Mapa {
    private TreeMap<String, ArrayList<Escenario>> conexiones;
    private Escenario escenarioInicial;

    public Mapa() {
        this.conexiones = new TreeMap<>();
    }

    /**
     * Agrega un escenario y su lista de conexiones.
     *
     * @param escenario El escenario a agregar al mapa
     * @param conexiones La lista de conexiones
     */
    public void addConexiones (Escenario escenario, ArrayList<Escenario> conexiones) {
        this.conexiones.put(escenario.getNombre(), conexiones);
    }

    /**
     * Obtiene el escenario inicial.
     *
     * @return El escenario inicial
     */
    public Escenario getEscenarioInicial() {
        return escenarioInicial;
    }

    /**
     * Establece el escenario inicial.
     *
     * @param escenarioInicial el escenario inicial que se va a establecer
     */
    public void setEscenarioInicial(Escenario escenarioInicial) {
        this.escenarioInicial = escenarioInicial;
    }

    /**
     * Obtiene los escenarios contiguos al escenario actual.
     *
     * @param escenarioActual el escenario actual del cual se desean obtener los escenarios contiguos
     * @return una lista de los escenarios contiguos al escenario actual
     */
    public ArrayList<Escenario> getEscenariosContiguos (Escenario escenarioActual) {
        return conexiones.get(escenarioActual.getNombre());
    }
}
