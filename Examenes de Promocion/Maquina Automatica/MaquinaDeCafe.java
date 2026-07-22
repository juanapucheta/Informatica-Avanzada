import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// Resolucion de Juana Pucheta. Puntaje 32 / 37

public class MaquinaDeCafe implements MaquinaDeEstados {
    protected Producto seleccion;
    protected Estado estado = Estado.APAGADO;
    protected List <Recipiente> recipientes;
    protected int totalProductosServidos;
    protected Caja caja;
    protected List <Producto> productosDisponibles;
    
    /**
     * Constructor sin parametros.
     */
    public MaquinaDeCafe(){
        recipientes = new ArrayList<Recipiente>();
        productosDisponibles = new ArrayList<Producto>();
        totalProductosServidos = 0;
        caja = new Caja();
    }
    
    /**
     * Retorna la cantidad total de productos servidos por esta
     * maquina.
     * 
     * @return cantidad total de productos servidos
     */
    public int getTotalProductosServidos() {
        return totalProductosServidos;
    }
    
    /**
     * Retorna el total de dinero recaudado por esta maquina
     * 
     * @return total de dinero recaudado
     */
    public int getTotalRecaudacion(){
        return caja.getTotalRecaudado();
    }
    
    /**
     * Retorna el producto seleccionado
     *
     * @return el producto seleccionada en la maquina
     */
    public Producto getSeleccion() {
        return seleccion;
    }

    /**
     * Verifica si existe suficiente cantidad de un ingrediente
     *
     * @param ingrediente el ingrediente requerido
     * @param cantidadRequerida la cantidad requerida
     * @return true si existe suficiente ingrediente, false en
     * caso contrario
     */
    public boolean hayIngredienteDisponible (Ingrediente ingrediente, int cantidadRequerida){
        for (Recipiente r: recipientes){
            if (ingrediente == r.getTipoIngredienteAlmacenado()){
                if (r.getCantidadIngredienteDisponible()>=cantidadRequerida){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica si es posible despachar el producto especificado
     * 
     * @param p el producto a despachar
     * @throws ProductoException si el producto especificado es
     * null, o no esta configurado en esta maquina, o existen
     * ingredientes faltantes en la receta.
     */
    public boolean validarProducto(Producto p) {
        if (p==null || p.getReceta()==null )
            return false;    
        Receta r =  p.getReceta();
        for (Ingrediente ing: r.getIngredientes()){
            if (!hayIngredienteDisponible(ing, r.getCantidadDeIngredienteRequerida(ing)))
                return false;
        }
        return true;
    }
    
    @Override
    public Estado getEstado() {
        return estado;
    }
    
    @Override
    /*
     * Verifica si puede despachar el producto seleccionado.
     * Lanza IllegalStateException si la maquina no esta LISTA. 
     * Despacha el producto seleccionado. 
     * Cambia el Estado de la maquina a OPERANDO. 
     * Incrementa la cuenta de productos despachados
     */
    public void operar() {
        if(this.getEstado() != Estado.LISTO){
            throw new IllegalStateException();
        }
        else{
            // Cambia el Estado de la maquina a OPERANDO. 
            this.estado = Estado.OPERANDO;
            
            // Reviso si no se puede despachar el producto 
            if(!this.validarProducto(this.getSeleccion())){
                throw new IllegalStateException();
            }
            try{
                // Despacha el producto seleccionado. 
                this.prepararProducto(this.getSeleccion());     // Preparo el producto.
                this.caja.completarVenta();                     // Completo la venta.
                
                // Incrementa la cuenta de productos despachados
                this.totalProductosServidos++;                  // Actualizo el campo.
            }
            catch(ProductoException e){}
        }
    }

    @Override
    /*
     * Cambia el Estado de la maquina a LISTO
     * Establece la seleccion de producto en null  
     */
    public void restablecer() {
        this.estado = Estado.LISTO;
        this.seleccion = null; 
    }

    @Override
    /*
     * Lanza IllegalStateException si la maquina no esta APAGADA
     * Cambia el Estado de la maquina a LISTO
     * Establece la seleccion de producto en null
     */
    public void encender() {
        if(this.getEstado() != Estado.APAGADO){
            throw new IllegalStateException();
        }
        
        else{
            this.restablecer();
        }
    }

    @Override
    /*
     * Lanza IllegalStateException si la maquina esta OPERANDO
     * Cambia el Estado de la maquina a APAGADO.
     */
    public void apagar() {
        if(this.getEstado() == Estado.OPERANDO){
            throw new IllegalStateException();
        }
        else{
        this.estado = Estado.APAGADO;
        }
    }

    @Override
    /*
     * Lanza IllegalStateException si la maquina no esta LISTA
     * Cambia el Estado de la maquina a MANTENIMIENTO
     */
    public void mantener() {
        if(this.getEstado() != Estado.LISTO){
            throw new IllegalStateException();
        }
        
        this.estado = Estado.MANTENIMIENTO;
    }
    
    /**
     * Programa el precio a un producto. Solo es posible programar
     * el precio en modo MANTENIMIENTO
     *
     * @param producto el producto al cual definir el precio
     * @param precio el precio del producto
     * @throws IllegalStateException cuando no esta en modo
     * MANTENIMIENTO
     */
    public void programarPrecioDeProducto(Producto producto, int precio){
        if(this.getEstado() == Estado.MANTENIMIENTO){
            producto.setPrecio(precio);
        }
        else{
             throw new IllegalStateException();
        }
    }
    
    /**
     * Agrega una receta para un producto de la maquina de
     * cafe. Solo es valido en modo mantenimiento
     * 
     * @param p el Producto a configurar en la maquina
     * @param r la Receta correspondiente al producto a agregar
     * @throws IllegalStateException si la maquina no esta en modo
     * MANTENIMIENTO
     */
    public void programarRecetaDeProducto (Producto p, Receta r){
        if(this.getEstado() == Estado.MANTENIMIENTO){
            p.setReceta(r);
        }
        else{
             throw new IllegalStateException();
        }
    }
    
    /**
     * Retorna una lista de ingredientes faltantes para las
     * recetas cargadas en la maquina
     * 
     * @return Lista de ingredientes faltantes.
     */
    public List<Ingrediente> getFaltantes(){
        HashSet<Ingrediente> faltantes = new HashSet<>();
        
        for(Producto p : productosDisponibles){
            Receta r = p.getReceta();
            
            for(Ingrediente i : r.getIngredientes()){
                int cantRequerida = r.getCantidadDeIngredienteRequerida(i);
                
                if(!hayIngredienteDisponible(i,cantRequerida)){
                    faltantes.add(i);
                }
            }
        }
        
        return new ArrayList<Ingrediente>(faltantes);
    }
    
    /**
     * Ejecuta la receta para el producto especificado, extrayendo
     * de cada recipiente la cantidad necesaria de ingredientes
     * para preparar la receta.
     * 
     * @param seleccion el producto seleccionado 
     * @throws ProductoException si por algun motivo no se puede
     * extraer la cantidad requerida de cada ingrediente.
     */
    public void prepararProducto(Producto seleccion) throws ProductoException {
        Receta r = seleccion.getReceta();
        
        for(Ingrediente i : r.getIngredientes()){
            int cantidad = r.getCantidadDeIngredienteRequerida(i);
            Recipiente recipiente = this.getRecipiente(i);
            
            if(recipiente == null){
                throw new ProductoException(" ");
            }
            
            if(recipiente.getCantidadIngredienteDisponible() < cantidad){
                throw new ProductoException(" ");
            }
            
            try{
                recipiente.extraer(cantidad);
            }
            
            catch(CapacidadExcedidaException e){}
        }
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
            if(r.getTipoIngredienteAlmacenado().equals(ingrediente)){
                return r;
            }
        }
        return null;
    }
    
    /**
    * DEBI AGREGAR ESTE METODO PARA SUPERAR LAS PRUEBAS OCULTAS.
    * Agrega un recipiente a la maquina de cafe.
    *
    * @param recipiente el recipiente a agregar
    * @throws IllegalArgumentException si el recipiente es null
    */
    public void agregarRecipiente(Recipiente recipiente) {
    if (recipiente == null) {
        throw new IllegalArgumentException();
    }
    this.recipientes.add(recipiente);
    }
    
    /**
     * Selecciona un producto para despachar. Solo es posible si
     * la maquina esta lista para despachar producto.  Configura
     * el precio del producto como precio a cobrar en la Caja, o 0
     * si la seleccion es null
     *
     * @param seleccion el producto a despachar
     * @throws IllegalStateException si la maquina no esta lista
     */
    public void setSeleccion(Producto seleccion) {
        if(this.getEstado() != Estado.LISTO){
            throw new IllegalStateException();
        }
        
        if(this.getSeleccion() == null){
            this.caja.setPrecioACobrar(0);
        }
        
        else{
            this.caja.setPrecioACobrar(seleccion.getPrecio());
        }
    }
}
