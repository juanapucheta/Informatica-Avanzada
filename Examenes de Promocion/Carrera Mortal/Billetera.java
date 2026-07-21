public class Billetera 
{
    // Los dolares se almacen en centavos, es decir,
    // el valor 1278 representa 12 dolares con 78 centavos.
    Integer dolares;
    // Cada cupon se obtiene durante la carrera y tiene un
    // valor de 10 dolares. No se puede fraccionar el valor.
    Integer cupones;

    public Billetera () 
    {
        dolares = 0;
        cupones = 0;
    }

    /**
     * Agrega dolares a la billetera.
     * En caso de recibir un valor menor o igual a cero
     * ignora la accion.
     * @param dolares La cantidad de dolares a agregar.
     */
    public void agregarDolares(Integer dolares) 
    {
        if( dolares>0 )
        {
           this.dolares = dolares; 
        }
        else
        {}
        
    }

    /**
     * Agrega cupones a la billetera.
     * En caso de recibir un valor menor o igual a cero
     * ignora la accion.
     * @param cupones La cantidad de cupones a agregar.
     */
    public void agregarCupones (Integer cupones) 
    {
        if(cupones > 0)
        {
            this.cupones = cupones;
        }
        else
        {}
        
    }

    /**
     * Calcula la cantidad de cupones en relacion al monto ingresado.
     * Siempre devuelve un valor menor o igual a los cupones disponibles
     * en la billetera (Cada cupon tiene un valor de 10 dolares)
     * Por ejempo
     * - si el monto es 20 dolares y solo se tiene un cupon
     * en la billetera el metodo devolvera 1.
     * - si el monto es 10 y tenemos 2 cupones el metodo devolvera 1.
     * @param monto El monto sobre el cual calcular cantidad de cupones
     *              (recuerde que los montos se almacenan en centavos)
     * @return La cantidad de cupones a usar de la billetera.
     */
    public Integer cantidadCupones (Integer monto) 
    {
        if( monto > 0  ||   (monto/1000) > cupones )
        {
           return cupones;
        }
        else
        {
            return monto/1000;
        }
        
       
    }

    /**
     * Intenta realizar una compra. Se utiliza la mayor cantidad
     * posible de cupones (no se puede fraccionar) y se completa
     * el resto con dolares.
     * Ej: Se tienen 3 cupones y 12.75 dolares y el monto de la compra
     *     es 34.25 dolares. Como la compra se puede realizar el saldo
     *     final es de 0 cupones y 8.50 dolares.
     * Recordar que 1 dolar se representa con el entero 100.
     * 
     * Si el monto a gastar es mayor a los fondos disponibles, lanza
     * la excepción DineroInsuficienteException.
     * En cambio, si la cantidad de dolares a gastar es negativa
     * lanza IllegalArgumentException.
     * 
     * @param monto El monto en dolares a gastar.
     * @throws DineroInsuficienteException Cuando el valor es mayor al dinero disponible.
     * @throws IllegalArgumentException Cuando la cantidad es menor igual a cero.
     */
    public void gastar(Integer monto) throws DineroInsuficienteException 
    {
        if( monto > (cupones*10)+(dolares) )
        {
            throw new DineroInsuficienteException();
        }
        
        if( monto <= 0)
        {
            throw new IllegalArgumentException();
        }
        
        else
        {
            dolares -= ( monto % (cupones*10) );
            cupones -= (monto/cupones); 
        }
    }

    /**
     * Imprime lo siguiente:
     * 
     * "Billetera -> {cupones} cupones y {dolares}" 
     * 
     * Donde se remplaza los corchetes por el valor de la variable.
     * Ej:
     * 
     * "Billetera -> 3 cupones y 10.25"
     */
    public String toString() 
    {
        String mensaje = "Billetera -> " + cupones + " y " + dolares;
        
        return mensaje;
    }

    public Integer getDolares() 
    {
        return dolares;
    }

    public Integer getCupones() 
    {
        return cupones;
    }

}
