/* Esta clase es abstracta para que no se pueda instanciar.
 * Las pruebas debe realizarlas mediante las subclases.
 */
abstract class Insumo implements Consumible 
{
    /* Maxima capacidad del insumo [W-h]*/
    private Integer MAXCAPACIDAD;
    /* Capacidad actual del insumo [W-h]*/
    private Integer capacidadActual;
    
    /**
     * Inicialización de la clase, configura la máxima capacidad e
     * inicializa la capacidadActual a 0
     * @param maxCapacidad Capacidad maxima que puede contener.
     */
    public Insumo(Integer maxCapacidad) 
    {
        MAXCAPACIDAD = maxCapacidad;
        capacidadActual = 0;
    }

    /**
     * Permite cambiar la configuracion de capacidad máxima.
     * Si la capacidad actual excede a la nueva capacidad máxima,
     * debe recortarse al nuevo valor máximo.
     * @param maxCapacidad Nuevo valor a configurar.
     */
    public void setMaxCapacidad(Integer maxCapacidad) 
    {
        if(MAXCAPACIDAD > maxCapacidad)
        {
            MAXCAPACIDAD = maxCapacidad;
        }
        
    }

    /**
     * Devuelve el nivel de energia del insumo,  de manera porcentual (0 a 100%)
     *  IMPORTANTE: si bien la capacidad actual y máxima son Integer, el
     *  cálculo debe hacerse en Double y convertirlo en entero nuevamente para
     *  retornar el nivel de energia.
     *  (De lo contrario se producirán errores en los cálculos)
     * @return Nivel de energía en porcentaje.
     */
    @Override
    public Integer getNivelDeEnergia() 
    {
        double nivel = 0;
                
        nivel = ((capacidadActual)/(MAXCAPACIDAD))*100 ;
        
        return (int) nivel;
    }

    /**
     * La energía se consume en Watts por hora, esto afectará
     * el nivel de energía del insumo dependiendo de la
     * capacidad de cada insumo. Si la cantidad que se pretende consumir
     * es mayor a la disponible se arroja un IllegalArgumentException 
     * @param wattsHora Cantidad de energia a consumir.
     * @throws IllegalArgumentException Si la cantidad que se pretende consumir
     * es mayor a la disponible.
     */
    @Override
    public void consumirEnergia(Integer wattsHora) throws IllegalArgumentException 
    {
        if(wattsHora > capacidadActual)
        {
           throw new IllegalArgumentException(); 
        }
    }

    /**
     * La energía se puede recargar, de la misma forma en que se consume.
     * En caso de que la cantidad de energía suministrada sea mayor a la 
     * capacidad del insumo, la energía del insumo quedará en capacidad máxima
     * (SIN arrojar excepción)
     * Puede arrojar un IllegalArgumentException si se introduce valores de
     * energía negativos 
     * @param wattsHora La cantidad de energía a recargar.
     * @throws IllegalArgumentException Si se introduce un valor de energía negativo.
     */
    @Override
    public void recargarEnergia(Integer wattsHora) throws IllegalArgumentException 
    {
        if(wattsHora > MAXCAPACIDAD)
        {
            capacidadActual = MAXCAPACIDAD;
        }
        
        if(wattsHora < 0)
        {
           throw new IllegalArgumentException(); 
        }
    }

    /**
     * Retorna la Capacidad Máxima actual.
     * @return La Capacidad Máxima actual.
     */
    public Integer getMaxCapacidad() 
    {
        return this.MAXCAPACIDAD;
    }

    /**
     * Cambia el valor de la capacidad actual.
     * @param capacidad Nuevo valor de capacidad.
     */
    public void setCapacidadActual(Integer capacidad) 
    {
        this.capacidadActual = capacidad;
    }

    /**
     * Retorna la Capacidad actual
     * @return
     */
    public Integer getCapacidadActual() 
    {
        return this.capacidadActual;
    }

}
