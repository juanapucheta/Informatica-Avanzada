/**
 * La clase Ballesta a completar.
 * 
 * Nota: Ninguna de las clases mencionadas en este inciso se encuentran en el proyecto lo cual no tiene sentido alguno. Esta implementación fue
 * encontrada en algún proyecto de exámen final que contenga dichas clases y fue copiada y pegada tal cual. Esta implementación no es mía y por
 * lo tanto desconozco de donde están los bugs. Sospecho que la implementación de RecargarArma es bastante pobre y debería verse con más cuidado
 * una vez encontrado el proyecto original al que pertenece esta clase.
 * 
 * @author  Resuelto por anonimo.
 * @version 1.0 
 *                                              PUNTAJE: 13/20
 */
public class Ballesta extends Armas
{
    private Flechas flecha;

    /**
     * Constructor
     */
    public Ballesta()
    {
        setPeso(5);
        setAlcance(5);
        setDanio(0);
    }

    public Flechas getFlechas()
    {
        return flecha;
    }

    /**
     * Carga las nuevas flechas en la ballesta.
     * Debe actualizarse el daño a producir.
     * 
     * @param flecha    Las flechas a cargar
     */
    public void setFlechas(Flechas flecha)
    {
        // Implementar
        this.flecha = flecha;
        setDanio(flecha.getDanio());
    }

    /**
     * Ejecuta el ataque descargando una flecha de la ballesta. Si no hay más
     * flechas lanza ArmaDescargadaException.
     * 
     * @throws ArmaDescargadaException Cuando no hay flechas para disparar.
     */
    public void Atacar() throws ArmaDescargadaException
    {
        // Implementar
        if(flecha == null)
        {
            throw new IllegalArgumentException("Ballesta");
        }
        flecha.UsarFlecha();
    }

    /**
     * Carga la ballesta con las flechas indicadas. Si la ballesta 
     * tiene  flechas, las devuelve a la bolsa.
     * 
     * @param   obj     Las flechas a cargar.
     * @return          Las flechas que estaban en la ballesta.
     */
    @Override
    public Objetos RecargarArma(Objetos obj) throws ArmaNoRecargableException, CombinacionNoPermitidaException
    {
        Flechas flechaAux = flecha;
        Flechas objeto = (Flechas) obj;
        if(obj instanceof Flechas)
        {
            if((flecha.getCantidad() < objeto.getCantidad())||(flecha == null))
            {
                flecha = (Flechas) obj;
            }
            else
            {
                return objeto;
            }
            
        }
        else
        {
            throw new CombinacionNoPermitidaException("");
        }
        return flechaAux;
        // Implementar
    }
}