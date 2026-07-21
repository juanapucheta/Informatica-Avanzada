import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


abstract class Vehiculo 
{    
    private List<Insumo> insumos;
    private Map<String, Armamento> armamentos;
    private Billetera billetera;
    private Integer puntosDeVida;
    private Integer puntosDeDefensa;
    private String nombre;

    /**
     * Se inicializan los objetos relacionadas a la clase.
     * @param nombre Nombre que llevara el vehiculo.
     * @param puntosDeVida Puntos de vida iniciales.
     * @param puntosDeDefensa Puntos de defensa iniciales.
     */
    public Vehiculo(String nombre, Integer puntosDeVida, Integer puntosDeDefensa) 
    {
        this.nombre = nombre ;
        this.puntosDeVida = puntosDeVida ;
        this.puntosDeDefensa = puntosDeDefensa ;
        insumos = new ArrayList<Insumo>();
        armamentos = new HashMap<String,Armamento>();
        billetera = new Billetera(); //Cuando existe un objeto debe crearse y ponerle parentesis al final
    }
    
    /** 
     * Devuelve la cantidad de motores 
     * Las clases que deriven de vehículo 
     * estan obligadas a implementar
     * este método
     * */
    public abstract Integer getCantidadMotores();

    /**
     * Aumenta los puntos de defensa de un vehiculo
     * @param puntos Los puntos de defensa a incrementar.
     */
    public void aumentarDefensa(final Integer puntos) 
    {
        puntosDeDefensa+= puntos;
    }

    /**
     * El vehiculo es atacado por un oponente.
     * Si el vehiculo tiene puntos de defensa primero se reducirán estos.
     * Si el ataque supera las defensas empezará a costarle puntos de vida.
     * Si el vehículo se queda sin vida imprimirá el siguiente mensaje por
     *  pantalla: "Vehiculo destruido!"
     * 
     * @param puntos Los puntos de daño.
     */
    public void recibirAtaque(Integer puntos) 
    {
        if(puntos<puntosDeDefensa)
        {
           puntosDeDefensa -= puntos; 
        }
        if(puntos > puntosDeDefensa  && puntos<puntosDeDefensa+puntosDeVida )
        {
           puntosDeVida = (puntosDeDefensa+puntosDeVida) - puntos;
           puntosDeDefensa = 0;
        }
        if(puntos >= puntosDeDefensa+puntosDeVida)
        {
            puntosDeVida = 0;
            puntosDeDefensa = 0;
            System.out.println("Vehiculo destruido!");
        }
    }

    /**
     * Retorna los datos del vehiculo de la siguiente forma: 
     *  "Vehiculo. Vida: {vida} Defensa: {defensa}" 
     * Donde vida equivale a puntosDeVida y defensa equivale a
     * puntosDeDefensa
     */
    public String toString() 
    {
        String mensaje = "Vehiculo. Vida: ";
        mensaje = mensaje + puntosDeVida + " Defensa: " + puntosDeDefensa ;
        
        return mensaje;
    }


    public String getNombre() 
    {
        return this.nombre;
    }

    /**
     * Agrega un nuevo tipo de armamento. No se puede agregar 2 veces
     * la misma clase de Armamento. Si se intenta hacerlo,
     * se lanza IllegalArgumentException.
     * 
     * @param armamento El armamento a agregar.
     * @throws IllegalArgumentExceptionEn caso que el armamento exista.
     */
    public void agregarArmamento(final Armamento armamento) 
    {
        if(armamentos.containsValue(armamento))
        {
           throw new IllegalArgumentException(); 
        }
        else
        {
           armamentos.put(armamento.toString(), armamento); // empleo el toString para conseguir la llave del contenido que si tengo
        }
        
    }

    /**
     * Utiliza todos los armamentos disponibles que sean OFENSIVOS
     * en el vehiculo objetivo.
     * 
     * @param objetivo vehiculo a atacar.
     */
    public void utilizarArmamentos(Vehiculo objetivo) 
    {
        
        for( Armamento a : armamentos.values())
        {
            if(a.getTipo() == TipoArmamento.OFENSIVO)
            {
                a.usar(objetivo);
            }
        }
    }

    /**
     * Se descuenta la cantidad de dolares de la billetera para
     * comprar un determinado insumo y se lo agrega a la lista de insumos.
     * 
     * - Si la cantidad de dinero no se encuentra disponible lanza 
     * IllegalArgumentException con el siguiente string:
     *  "El precio del insumo es mayor al disponible".
     * 
     * - Por otro lado, si el precio es negativo lanza una Exception
     * (Aclaración: clase Exception) con el siguiente string:
     *  "Precio Inválido"
     * @param insumo El insumo a comprar.
     * @param precioDolares El precio del insumo.
     * @throws IllegalArgumentException Si no se tiene suficiente dinero.
     * @throws Exception Si el precio es negativo.
     */
    public void comprarInsumo(Insumo insumo, Integer precioDolares) throws Exception 
    {
       
        if(precioDolares > billetera.getDolares())
        {
           throw new  IllegalArgumentException("El precio del insumo es mayor al disponible");
        }
        
        if(precioDolares < 0)
        {
           throw new  Exception("Precio Inválido"); 
        }
        
        if(precioDolares<= billetera.getDolares())
        {
            
           billetera.gastar(precioDolares); // convierte una cadena de texto en un numero entero
           insumos.add(insumo);
        }
    }

    /**
     * Devuelve una lista con todos los armamentos.
     * @return La lista con todos los armamentos.
     */
    public List<Armamento> getArmamento() 
    {
        ArrayList soloArmas = new ArrayList<Armamento>();
        soloArmas = (ArrayList) armamentos.values();
        return soloArmas;
    }

    /**
     * Devuelve la cantidad de puntos de defensa
     * @return
     */
    public Integer getPuntosDeDefensa() 
    {
        return this.puntosDeDefensa;
    }

    /**
     * Obtiene la billetera
     * @return
     */
    public Billetera getBilletera() 
    {
        return this.billetera;
    }

    /**
     * Devuelve la lista de insumos
     * @return
     */
    public List<Insumo> getInsumos() 
    {
        return this.insumos;
    }
};
