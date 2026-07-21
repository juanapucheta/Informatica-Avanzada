/* Esta clase es abstracta para que no se pueda instanciar.
 * Las pruebas debe realizarlas mediante las subclases.
 */
abstract class Armamento implements Comparable<Armamento> 
{
    private TipoArmamento tipo;
    private Integer puntaje;

    /**
     * Inicializa un armamento segun tipo y puntaje.
     * @param tipo Si es defensivo u ofensivo.
     * @param puntaje El puntaje inicial.
     */
    public Armamento(TipoArmamento tipo, Integer puntaje) 
    {
        this.tipo = tipo;
        this.puntaje = puntaje;
    }

    /**
     * Devuelve:
     * -1 : El puntaje del armamento introducido es mayor al propio
     *  0 : El puntaje del armamento introducido es igual al propio
     *  1 : El puntaje del armamento introducido es menor al propio
     * @param armamento El armamento contra el cual comparar.}
     * @return El valor correspondiente.
     */
    public int compareTo(Armamento armamento) 
    {
        int m = 0;
        
        if(armamento.getPuntaje() > puntaje)
        {  m = -1;  }
        
        if(armamento.getPuntaje().equals(armamento))
        {  m = 0;  }
        
       if(armamento.getPuntaje() < puntaje)
        {  m = 1;   }
        
        return m;
    }

    /**
     * Cada armamento aplica algún efecto sobre un vehículo.
     * Los armamentos pueden ser defensivos, en cuyo caso se aplicarán
     * sobre el vehículo propio.
     * También, pueden ser ofensivos, en cuyo caso se aplicarán sobre 
     * el vehículo enemigo.
     * 
     * Debe imprimir en pantalla el mensaje:
     *   "Aplicando a {vehiculo} el armamento"
     * donde vehiculo es el nombre.
     * 
     * @param v vehículo propio o enemigo.
     */
    public void usar(Vehiculo v) 
    {
       System.out.println("Aplicando a " + v.getNombre() + " el armamento");
    }

    /**
     * Devuelve el puntaje del armamento. El puntaje es:
     * - El ataque en el caso de un armamento del tipo ofensivo
     * - La defensa en el caso de un armamento del tipo defensivo
     * @return El puntaje correspondiente.
     */
    public Integer getPuntaje() 
    {
        return this.puntaje;
    }

    /**
     * Devuelve el tipo de armamento
     * @param tipo
     */
    public TipoArmamento getTipo() 
    {
        return tipo;
    }

    /**
     * Cambia el tipo de armamento
     * @param tipo
     */
    public void setTipo(TipoArmamento tipo) 
    {
        this.tipo = tipo;
    }

}
