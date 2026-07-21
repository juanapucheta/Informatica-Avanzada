/* Esta clase modela al personaje principal de un juego de rol
 */

public class Heroe 
{
    // La bolsa con los objetos recolectados
    private Bolsa bolsa;
    // El nivel de vida actual y su valor maximo
    private Integer vida, maxVida;
    // Objeto que tiene en la mano
    private Objetos objeto; //sirve para guardar el objeto que tiene actualmente en la mano, como la espada por eje

    /** Inicializa al heroe con el maximo nivel de vida.
    *   El objeto seleccionado inicial es la espada de acero.
    *   La espada de acero es la única arma que persiste durante
    *   todo el juego y no puede quitarse de la bolsa.
    */
    public Heroe () 
    {
       bolsa = new Bolsa();
       objeto = bolsa.getEspada();
       maxVida = 1000;
       vida = maxVida;
          
    }

    /** Recolecta un objeto y lo agrega a la bolsa siempre y
     *  cuando haya lugar suficiente.
     *  @param obj El objeto para agregar en la bolsa
    */
    public void TomarObjetoDelSuelo(Objetos obj)  
    {
       try
       {
          bolsa.addObjeto(obj); 
       }
       catch(BolsaLlenaException e)
       {
       }
    }


    /** Permite cambiar el arma que tiene el héroe en sus manos.
     *  Si el arma elegida no está en la bolsa, mantiene en sus
     *  manos el arma actual.
     *  @param nombre El nombre del arma a tomar de la bolsa.
     */
    public void ElegirArma(String nombre) 
    {
        for(Objetos i: bolsa.getObjetosEnLaBolsa())
        {
          if(i.getNombre().equals(nombre))
          {
             if(i instanceof Armas && objeto!=null)
             {
                  try
                 {
                     objeto = bolsa.getObjeto(nombre);
                     bolsa.addObjeto(i);
                 }
                 catch (BolsaLlenaException ble)
                 {
                     ble.printStackTrace();
                 }
                 
             }
             
          }
          
        }
        
    }

    /** Hace que el héroe ataque a un enemigo. Solo es viable cuando
     *  tiene un arma lista para usar en sus manos.
     *  @throws NoEsArmaException Cuando no tiene un arma en sus manos.
     *  @throws ArmaDescargadaException Cuando el arma no tiene municiones.
      */
    public void Atacar() throws NoEsArmaException, ArmaDescargadaException 
    {
        if(objeto!=null && objeto instanceof Armas )
        {
            if(objeto instanceof Espada)
            { 
                Espada aux;
               aux= (Espada) objeto;
               aux.Atacar();
            }
            else if(objeto instanceof Ballesta)
            {
                Ballesta ballesta;
                ballesta = (Ballesta) objeto;
                ballesta.Atacar();
            }
            
            
        }
        else
            {
                throw new NoEsArmaException("No es Arma");
            }
       
    }

    /** Permite cambiar la munición del arma que tiene el héroe en sus manos.
     *  Si es posible el cambio, la munición del arma se guarda en la bolsa y
     *  se establece la nueva munición. En caso contrario, se deja el arma
     *  como estaba.
     *  @param nombre La munición a buscar en la bolsa.
     */
    public void RecargarArma (String nombre) 
    {
       if(objeto instanceof Ballesta )
       {
           Ballesta b= (Ballesta) objeto;
           for(Objetos i: bolsa.getObjetosEnLaBolsa())
           {
               if(i instanceof Flechas && i.getNombre()==nombre)
               {
                   try
                   {
                       b.RecargarArma(i);
                       objeto=b;
                   }
                   catch (ArmaNoRecargableException e)
                   {
                       
                   } 
                   catch(CombinacionNoPermitidaException e)
                   {
                       
                   }
               }
               
           }
       }
         
    }

    public Objetos getObjeto() 
    {
        return objeto;
    }

    public void setObjeto(Objetos objeto) 
    {
        this.objeto = objeto;
    }
    
    public Bolsa getBolsa() 
    {
        return bolsa;
    }
}
