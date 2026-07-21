import java.lang.String;
public class Llamada {
    protected TipoDeLlamada saliente;
    protected int duracionEnSegundos;
    protected String numero ;
    protected Fecha fecha;
    
    /**
     * Constructor sin parametros
     */
    public Llamada (){
        
        
    }
    
    /**
     * Constructor con parametros.
     * @param numero - Numero de destino/origen. Numero valido debe tener 10 digitos (elimina espacios inicial/final)
     * @param fecha - Fecha de la llamada. No puede ser null
     * @param duracion - Duración de la llamada, en segundos. Una duraci�n negativa es invalida
     * @param tipo - Tipo de llamada (saliente/entrante). No puede ser null
     * 
     * @throws IllegalArgumentException cuando alguno de os parametros es invalid
     */
    public Llamada (String numero, Fecha fecha, int duracion, TipoDeLlamada tipo){
        if(numero.length()==10){
        this.numero= numero.trim();
    }
    else{
        throw new IllegalArgumentException ("los parametros son invalidos");
    }
    if(fecha!=null)
    {
        this.fecha= fecha;
    }
     else{
        throw new IllegalArgumentException ("los parametros son invalidos");
    }
    if(duracion>=0){
        this.duracionEnSegundos=duracion;
    }
     else{
        throw new IllegalArgumentException ("los parametros son invalidos");
    }
    if(tipo!=null)
    {
        this.saliente= tipo;
    }
    else{
        throw new IllegalArgumentException ("los parametros son invalidos");
    }
}
    public TipoDeLlamada getTipoDeLlamada() {
        return saliente;
    }

    public int getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public String getNumero() {
        return numero;
    }

    public Fecha getFecha() {
        return fecha;
    }
    
    
    /**
     * Retorna la duración en un string con formato <mm:ss>
     * Ejemplos: "03:15", "12:03", "110:45"
     * 
     * @return
     */
    public String getDuracion() {
        int minutos= 0;
        String duracion= ("");
        int segundos= duracionEnSegundos;
        if(segundos>59)
        {
            minutos ++;
            segundos= segundos - 59;
            
        }
        duracion= duracion.concat(minutos + ":" + segundos );
        return duracion;
    }

    /**
     * Retorna un String con el siguiente formato:
     * 
     * <aaaa/mm/dd> <hh:mm>, <numero>, <SALIENTE|ENTRANTE>, <duracion>
     *       
     * Ej. "2013/05/06 21:44, 3514801234, ENTRANTE, 05:12"
     * "2013/01/30 01:14, 1161293091, SALIENTE, 12:00"
     * 
     */
        
    public String toString(){
        String caracteristicas =("");
        if(numero!=null )
        {
        caracteristicas= caracteristicas.concat(fecha.toString() + "," + numero + "," + saliente + getDuracion()); 
   }        
        
        return caracteristicas;
    }
}
