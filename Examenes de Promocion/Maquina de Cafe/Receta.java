import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receta {
    protected Map<Ingrediente, Integer> ingredientes;
    
    public Receta (){
        ingredientes = new HashMap<Ingrediente,Integer>();
    }
    
    /**
     * Agrega un ingrediente a la receta
     * @param ing el Ingredienta a agregar a la receta
     * @param cantidad la cantidad de ingrediente a agregar a la receta
     * 
     * @throws IllegalArgumentException cuando el ingrediente o la cantidad de ingredinte a agregar es invalida (ej. negativa)
     * 
     */
    public void agregarIngrediente(Ingrediente ing, Integer cantidad){
        if(ing == null || cantidad < 0){
            throw new IllegalArgumentException();
        }
        
        else{
            // El ingrediente a agregar ya existe, solo agrego cantidad. 
            if(this.getMapaDeIngredientes().containsKey(ing)){
                this.getMapaDeIngredientes().put(ing, ingredientes.get(ing) + cantidad);
            }
            
            // Agrego un ingrediente nuevo.
            else{
                this.getMapaDeIngredientes().put(ing, cantidad); 
            }
        }
    }
    
    /**
     * Retorna el peso total de la receta (sumatoria de todos los ingredientes de la receta)
     * @return el peso total de la receta
     */
    public int volumenTotalReceta(){
        int pesoReceta = 0; 
        
        for(Integer peso : this.getMapaDeIngredientes().values()){
            pesoReceta += peso;
        }
        return pesoReceta;
    }
    
    /**
     * Getter
     * @return
     */
    public Map<Ingrediente, Integer> getMapaDeIngredientes(){
        return ingredientes;
    }
    
    /**
     * Obtiene la lista de ingredientes de esta receta
     * @return la lista de ingredientes de la receta
     */
    public List<Ingrediente> getIngredientes(){
        return new ArrayList<Ingrediente>(ingredientes.keySet());
    }
    
    /**
     * Retorna la cantidad del ingrediente solicitado para esta receta. Si la receta
     * no requiere este ingrediente, retorna 0
     * @param ingrediente el ingrediente solicitado
     * @return la cantidad de ingrediente requerida por la receta.
     */
    public int getCantidadDeIngrediente (Ingrediente ingrediente){
        if (ingredientes.containsKey(ingrediente))
            return ingredientes.get(ingrediente);
        else 
            return 0;
    }
}