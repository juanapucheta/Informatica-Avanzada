public class Sala {
    private String nombre;
    private int capacidad;
    private Ubicacion ubicacion;

    public Sala(String nombre, int capacidad, Ubicacion ubicacion) {
        this.nombre = nombre; 
        this.capacidad = capacidad; 
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public int getCapacidad() { 
        return this.capacidad;
    }
    
    public Ubicacion getUbicacion() { 
        return this.ubicacion;
    }
    
    /**
     * Setea la capacidad de la sala
     * solo si la capacidad es mayor a 0
     */
     
    public void setCapacidad(int capacidad) { 
        if(capacidad > 0){
            this.capacidad = capacidad;
        }
    }
    
    public void setUbicacion(Ubicacion ubicacion) { 
        this.ubicacion = ubicacion; 
    }
    
    @Override
    /**
     * Retorna una representación de la Sala como String con el formato
     * 
     * "Sala <nombre> (capacidad: <capacidad>, ubicacion: <ubicacion>)"
     * 
     *  Ejemplo: 
     *      Sala Uritorco (capacidad: 6, ubicacion: Norte)
     */
    public String toString() { 
        String info = "Sala " + this.getNombre()
                    + " (capacidad: " + this.getCapacidad()
                    + ", ubicacion: " + this.getUbicacion() + ")" ;
        return info;
    }
}