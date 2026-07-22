/*
 * Modela un silo, un tipo de recipiente que almacena un único
 * tipo de ingrediente.
 * Clase resuelta por Juana Pucheta con apoyo en Claude. Puntaje 16 / 16
 */
public class Silo extends Recipiente {
    
    private Ingrediente ingredienteAlmacenado;
    
    /**
     * Constructor con ingrediente y capacidad máxima.
     *
     * @param ingredienteAlmacenado el ingrediente que almacena el silo
     * @param capacidadMaxima la capacidad máxima de este silo
     * @throws IllegalArgumentException si el ingrediente es null,
     * o si la capacidad máxima es negativa o excede la capacidad
     * máxima por defecto
     */
    public Silo(Ingrediente ingredienteAlmacenado, int capacidadMaxima) {
        super(capacidadMaxima);
        if (ingredienteAlmacenado == null) {
            throw new IllegalArgumentException("Ingrediente no valido");
        }
        this.ingredienteAlmacenado = ingredienteAlmacenado;
    }
    
    /**
     * Constructor con ingrediente. Setea la capacidad máxima al
     * valor por defecto.
     *
     * @param ingredienteAlmacenado el ingrediente que almacena el silo
     * @throws IllegalArgumentException si el ingrediente es null
     */
    public Silo(Ingrediente ingredienteAlmacenado) {
        super();
        if (ingredienteAlmacenado == null) {
            throw new IllegalArgumentException("Ingrediente no valido");
        }
        this.ingredienteAlmacenado = ingredienteAlmacenado;
    }
    
    /**
     * Devuelve el tipo de ingrediente que almacena el silo
     *
     * @return el ingrediente almacenado
     */
    public Ingrediente getTipoIngredienteAlmacenado() {
        return this.ingredienteAlmacenado;
    }
    
    /**
     * Agrega contenido al silo
     *
     * @param cantidadAgregada la cantidad de contenido a agregar
     * @throws CapacidadExcedidaException cuando intenta agregarse
     * mas contenido del que el silo puede alojar
     * @throws IllegalArgumentException cuando la cantidad a
     * agregar es un valor negativo
     */
    public void agregar(int cantidadAgregada) throws CapacidadExcedidaException {
        if (cantidadAgregada < 0) {
            throw new IllegalArgumentException("Cantidad no valida");
        }
        if (this.cantidadDisponible + cantidadAgregada > this.capacidadMaxima) {
            throw new CapacidadExcedidaException();
        }
        this.cantidadDisponible += cantidadAgregada;
    }
    
    /**
     * Extrae contenido del silo
     *
     * @param cantidadAExtraer la cantidad a extraer
     * @throws CapacidadExcedidaException cuando intenta extraerse
     * una cantidad mayor a la disponible en el silo
     * @throws IllegalArgumentException cuando la cantidad a
     * extraer es un valor negativo
     */
    public void extraer(int cantidadAExtraer) throws CapacidadExcedidaException {
        if (cantidadAExtraer < 0) {
            throw new IllegalArgumentException("Cantidad no valida");
        }
        if (cantidadAExtraer > this.cantidadDisponible) {
            throw new CapacidadExcedidaException();
        }
        this.cantidadDisponible -= cantidadAExtraer;
    }
}