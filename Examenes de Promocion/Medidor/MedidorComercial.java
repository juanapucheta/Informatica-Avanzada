import java.lang.String;
/**
 * Write a description of class MedidorComercial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedidorComercial extends Medidor
{
    private TipoMedidor tipo;
    /**
     * Constructor for objects of class MedidorComercial
     */
    public MedidorComercial(CoordenadaGPS coordenadas)
    {
        super(coordenadas);
        tipo= TipoMedidor.COMERCIAL;
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
	    s=s.concat(  ""+ getTipoMedidor() );
		return s;
	}
	
}
