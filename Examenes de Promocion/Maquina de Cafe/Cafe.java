import java.util.List;
import java.util.Map;
import java.util.ArrayList;
/**
 * Producto generado por la maquina de cafe
 */
public class Cafe
{
    // instance variables - replace the example below with your own
    protected TipoProducto tipo;
    protected List <Extra> extras;

    /**
     * Constructor se inicializa a partir de un tipo de producto
     */
    public Cafe(TipoProducto tipo)
    {
        this.tipo = tipo;
        this.extras = new ArrayList<Extra>();
    }

    /**
     * Agrega extras a un cafe pedido
     * @param extra: El elemento que se desea agregar al cafe
     */
    public void agregarExtra(Extra extra) {
        extras.add(extra);
    }
    
    /**
     * Obtiene todos los extras contenido en el cafe
     * @return: lista de extras
     */
    public List<Extra> obtenerExtras(){
        return extras;
    }
    
    /**
     * Obtiene la lista de los ingredientes del producto a partir de las recetas disponibles 
     * @param recetas: Estructura que contiene las recetas para cada tipo de producto
     * @throws ProductoException si el tipo de producto no se encuentra en las recetas
     */
    public List<Ingrediente> obtenerIngredientes(Map<TipoProducto, Receta> recetas) throws ProductoException{
       Receta receta = recetas.get(tipo);
       if(receta == null){
            throw new ProductoException("");
        }
       return receta.getIngredientes();
    }
}


