import java.lang.String;
/**
 * Write a description of class MedidorIndustrial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedidorIndustrial extends Medidor
{
    private TipoMedidor tipo;

    /**
     * Constructor for objects of class MedidorIndustrial
     */
    public MedidorIndustrial(CoordenadaGPS coordenadas)
    {
        super(coordenadas);
        tipo= TipoMedidor.INDUSTRIAL;
    }

    
	/**
	 * 
	 * @return el TipoMedido
	 */
	public TipoMedidor getTipoMedidor() {
	    
	    return tipo;
	   }
	    
	
	
	/**
	 * @return la DESCRIPCION del Medidor
	 */
	public String toString(){
		String s= ("");
	    s=s.concat( ""+ getTipoMedidor());
		return s;
	}
}
