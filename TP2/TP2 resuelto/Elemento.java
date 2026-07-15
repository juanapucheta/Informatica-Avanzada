/**
 * Modela elementos que representan objetos a utilizar.
 */

public class Elemento {
    private TipoElemento tipo;
    private Integer peso;
    private String nombre;

    /**
     * Constructor sin parámetros.
     */
    public Elemento () {}

    /**
     * Construye un objeto de tipo elemento con un nombre a eleccion,
     * el peso correspondiente y el tipo de elemento.
     * 
     * @param nombre El nombre del elemento.
     * @param peso El peso del elemento.
     * @param tipo El tipo de elemento.
     */
    public Elemento (String nombre, Integer peso, TipoElemento tipo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.peso = peso;
    }

    public TipoElemento getTipo() {
        return tipo;
    }

    public void setTipo(TipoElemento tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el peso del elemento.
     * 
     * @return El peso del elemento.
     */
    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    /**
     * Devuelve el nombre del elemento.
     * 
     * @return El nombre del elemento.
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el elemento como texto.
     * 
     * @return El texto que representa al elemento.
     */
    public String toString() {
        return getNombre() + " (" + tipo.getDescripcion() + ")";
    }

}