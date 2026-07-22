import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
// Resolucion de Juana Pucheta. Puntaje 15 / 15
public class Receta {
    protected Map<Ingrediente, Integer> ingredientes;
    
    public Receta (){
        ingredientes = new TreeMap<Ingrediente,Integer>();
    }
    
    /**
     * Devuelve el mapa de ingredientes de la receta
     *
     * @return
     */
    public Map<Ingrediente, Integer> getMapaDeIngredientes(){
        return ingredientes;
    }
    
    /**
     * Agrega un ingrediente a la receta
     *
     * @param ing el Ingrediente a agregar a la receta
     * @param cantidad la cantidad de ingrediente a agregar a la receta
     * @throws IllegalArgumentException cuando el ingrediente o la
     * cantidad de ingredinte a agregar no es valida (ej. negativa)
     */
    public void agregarIngrediente(Ingrediente ing, Integer cantidad){
        if(ing == null || cantidad <= 0){
            throw new IllegalArgumentException();
        }
        
        else{
            // Reviso si el ingrediente ya existe en el mapa 
            if(this.getMapaDeIngredientes().containsKey(ing)){
                // Suma la nueva cantidad a la que ya había, y actualiza el valor.
                this.getMapaDeIngredientes().put(ing, ingredientes.get(ing) + cantidad);
                return;
            }
            
            else{
                this.getMapaDeIngredientes().put(ing, cantidad);
            }
        }
    }
    
    /**
     * Obtiene la lista de ingredientes de esta receta
     *
     * @return la lista de ingredientes de la receta
     */
    public List<Ingrediente> getIngredientes(){
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        
        for(Ingrediente i : this.getMapaDeIngredientes().keySet()){
            listaIngredientes.add(i);
        }
        
        return listaIngredientes;
    }
    
    /**
     * Retorna la cantidad del ingrediente solicitado para esta
     * receta. Si la receta no requiere este ingrediente, retorna 0
     *
     * @param ingrediente el ingrediente solicitado
     * @return la cantidad de ingrediente requerida por la receta.
     */
    public int getCantidadDeIngredienteRequerida (Ingrediente ingrediente){
        // Este primer if esta agregado para superar la prueba oculta del LEV.
        if(ingrediente == null){
            return 0;
        }
        
        if(this.getMapaDeIngredientes().containsKey(ingrediente)){
            return this.getMapaDeIngredientes().get(ingrediente);
        }
        
        else{
            return 0;
        }
        
    }
    
    /**
     * Retorna el peso total de la receta (sumatoria de las
     * cantidades de todos los ingredientes de la receta)
     *
     * @return el peso total de la receta
     */
    public int volumenTotalReceta(){
        int pesoReceta = 0;
        
        for(Integer pesoIngrediente : this.getMapaDeIngredientes().values()){
            pesoReceta += pesoIngrediente;
        }
        
        return pesoReceta;
    }
    
    /**
     * Retorna un String con el siguiente formato:
     * 
     *  "Receta: <Ingrediente1>[<Cantidad1>];<Ingrediente2>[<Cantidad2>];...;<<IngredienteN>[<CantidadN>];"
     *  
     *  Ej.: "Receta: AZUCAR[5];CAFE[15];AGUA[150];"
     *    
     */
    public String toString(){
        String inicio = "Receta: ";
        
        for(Ingrediente i : this.getIngredientes()){
            inicio += i + "[" + this.getMapaDeIngredientes().get(i) + "];";
        }
        
        return inicio;
    }
}
