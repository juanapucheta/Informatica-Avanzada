import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class MaquinaDeCafe implements MaquinaDeEstados {
    protected TipoProducto seleccion;
    protected Estado estado = Estado.APAGADO;
    protected List <Recipiente> recipientes;
    protected Map <TipoProducto, Receta> recetas;
    protected int totalProductosServidos;
    
    /**
     * Constructor sin parametros.
     */
    public MaquinaDeCafe(){
        recipientes = new ArrayList<Recipiente>();
        recetas = new HashMap<TipoProducto,Receta>();
        totalProductosServidos = 0;
    }

    /**
     * Retorna la cantidad total de productos servidos por esta maquina.
     *
     * @return cantidad total de productos servidos
     */
    public int getTotalProductosServidos() {
        return totalProductosServidos;
    }

    /**
     * Retorna los productos y recetas configurados en esta
     * maquina de cafe
     *
     * @return mapa con productos y recetas asociadas
     */
    public Map<TipoProducto, Receta> getRecetas() {
        return recetas;
    }

    /**
     * Retorna los recipientes configurados en esta maquina de cafe
     *
     * @return lista de los recipientes
     */
    public List<Recipiente> getRecipientes() {
        return recipientes;
    }

    /**
     * Retorna el producto (receta) seleccionado
     *
     * @return el producto seleccionada en la maquina
     */
    public TipoProducto getSeleccion() {
        return seleccion;
    }
    
    // A PARTIR DE AQUI SON METODOS A MODIFICAR EN EL EXAMEN (NO MODIFICAR LOS ANTERIORIES)

    /**
     * Ejecuta la receta para el producto especificado, extrayendo
     * de cada recipiente la cantidad necesaria de ingredientes
     * para preparar la receta
     *
     * @param el TipoProducto seleccionado
     * @throws ProductoException si por algun motivo no se puede
     * extraer la cantidad requerida de cada ingrediente
     * @return un nuevo cafe
     */    
    public Cafe prepararProducto(TipoProducto seleccion) throws ProductoException {
        Receta receta = recetas.get(seleccion);
        if (receta == null) {
            throw new ProductoException("");
        }
 
        List<Ingrediente> ingredientes = receta.getIngredientes();
        // Verifico que exista un recipiente para cada ingrediente.
        for (Ingrediente ingrediente : ingredientes) {
            Recipiente recipiente = getRecipiente(ingrediente);
            if (recipiente == null) {
                throw new ProductoException("");
            }
        }
 
        // Ahora extraigo. Si falla alguno (no hay stock suficiente) --> ProductoException.
        for (Ingrediente ingrediente : ingredientes) {
            Recipiente recipiente = getRecipiente(ingrediente);
            int cantidadRequerida = receta.getCantidadDeIngrediente(ingrediente);
            try {
                recipiente.extraer(cantidadRequerida);
            } catch (CapacidadExcedidaException e) {
                throw new ProductoException("");
            }
        }
 
        totalProductosServidos++;
 
        return new Cafe(seleccion);
    }

    /**
     * Retorna el recipiente para el producto especificado
     *
     * @param ingrediente el ingrediente requerido
     * @return el recipiente que contiene el ingrediente
     * requerido, o null si no existe un recipiente para ese
     * ingrediente.
     */
    public Recipiente getRecipiente (Ingrediente ingrediente){
        for(Recipiente r : recipientes){
            if(r.getTipoIngredienteAlmacenado() == ingrediente){
                return r;
            }
        }
        return null;
    }

    /**
     * Agrega una receta para un producto de la maquina de
     * cafe. Solo es valido en modo MANTENIMIENTO
     *
     * @param r la Receta correspondiente al producto a agregar.
     * @param p el Producto a agregar y configurar en la maquina.
     * @throws IllegalStateException si la maquina no esta en modo MANTENIMIENTO
     */
    public void agregarReceta (Receta r, TipoProducto p){
        if(estado != Estado.MANTENIMIENTO){
            throw new IllegalStateException();
        }
        recetas.put(p, r);
    }

    /**
     * Selecciona un producto para despachar. Solo es posible si
     * la maquina esta lista para despachar el producto
     *
     * @param seleccion el producto a despachar
     * @throws IllegalStateException si la maquina no esta lista
     */
    public void setSeleccion(TipoProducto seleccion) {
        if(estado != Estado.LISTO){
            throw new IllegalStateException();
        }
        this.seleccion = seleccion;
    }

    /* Metodos de la interface */

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    /** Cambia al estado a OPERANDO  
     * 
     * @throws IllegalStateException cuando se intenta operar desde un estado no valido
     */
    public void operar() {
        if(estado != Estado.LISTO){
            throw new IllegalStateException();
        }
        
        estado = Estado.OPERANDO;
    }

    @Override
    /**
     * Restablece la maquina desde cualquier estado 
     * Cambia al estado LISTO (si no encuentra fallas)
     * Cambia al estado FALLA (si existe alguna condicion de error)
     * 
     * @throws IllegalStateException cuando se intenta operar desde un estado no valido
     */
    public void restablecer() {
        if(estado != Estado.OPERANDO && estado != Estado.MANTENIMIENTO){
            throw new IllegalStateException();
        }
        
        // el enum no tiene el valor FALLA
        estado = Estado.LISTO;
    }

    @Override
    /**
     * Enciende la maquina (solo desde el estado APAGADO) 
     * Cambia al estado LISTO (si no encuentra fallas)
     * Cambia al estado FALLA (si existe alguna condicion de error)
     * 
     * @throws IllegalStateException cuando se intenta operar desde un estado no valido
     */
    public void encender() {
        if(estado != Estado.APAGADO){
            throw new IllegalStateException();
        }
        estado = Estado.LISTO;
    }

    @Override
    /**
     * Apaga la maquina.
     * Cambia al estado APAGADO (si no encuentra fallas)
     * No es posible apagar la maquina si esta OPERANDO
     * 
     * @throws IllegalStateException cuando se intenta operar desde un estado no valido
     */
    public void apagar() {
        if(estado != Estado.OPERANDO){
            throw new IllegalStateException();
        }
        estado = Estado.APAGADO;
    }

    @Override
    /** 
     * Lleva la maquina a estado de MANTENIMIENTO
     * Cambia al estado 
     * 
     */
    public void mantener() {
        if(estado != Estado.LISTO){
            throw new IllegalStateException();
        }
        estado = Estado.MANTENIMIENTO;
    }
}