
import java.util.TreeMap;

public class Bolsa {
    private TreeMap<String, Elemento> elementos ;
    private final Integer capacidad;

    /**
     * Constructor de Bolsa
     *
     * @param capacidad La capacidad de la bolsa
     */
    public Bolsa(Integer capacidad) {
        this.capacidad = capacidad;
        this.elementos = new TreeMap<>();
    }

    /**
     * Anade un elemento a la bolsa.
     *
     * @param e El elemento a anadir.
     * @throws BolsaLlenaException Si la bolsa esta llena y no se puede anadir el elemento.
     */
    public void addElemento (Elemento e) throws BolsaLlenaException {
        if (capacidad == elementos.size()) {
            throw new BolsaLlenaException("No hay espacio disponible en la bolsa");
        }
        elementos.put(e.getNombre(),e);
    }

    /**
     * Devuelve el elemento con el nombre suministrado.
     *
     * @param nombre El nombre del elemento a buscar.
     * @return El elemento con el nombre suministrado.
     * @throws IllegalArgumentException Si no existe elemento con el nombre suministrado.
     */
    public Elemento getElemento (String nombre) {
        Elemento e = elementos.get(nombre);
        if (e == null) {
            throw new IllegalArgumentException("No existe elemento con el nombre suministrado");
        }
        elementos.remove(nombre);
        return e;
    }
}
