import java.util.List;
import java.util.*;
import java.lang.*;

public class Cliente {
    protected String nombre;
    protected Medidor medidor;
    protected List<Lectura> lecturas;
    /**
     * Constructor.1: Inicializa la variable "nombre" del cliente,
     * crea la lista de lecturas e inicializa la variable
     * "lecturas"
     * 
     * @param nom Nombre del cliente. El nombre debe persistir en
     *        minusculas y sin espacios al principio o fin de la cadena.
     */
    public Cliente (String nom){
        this.nombre = nom.toLowerCase().trim();
        lecturas = new ArrayList<>();
    }
    
    /**
     * Retorna el nombre del cliente
     * @return
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * 
     * @return el Medidor asociado al cliente (null si no tiene)
     */
    public Medidor getMedidorAsociado(){
        return medidor;
    }
    
    /**
     * 
     * @return La lista de Lecturas realizadas sobre el medidor
     * del cliente
     */
    public List<Lectura> getLecturas(){
        return lecturas;
    }

    /**
     * Este metodo:
     * 1. Crea una nueva lectura con la fecha indicada y el
     *    consumo del medidor asociado.
     * 2. Si la nueva lectura es valida, la agrega a la lista de
     *    lecturas del cliente.
     *
     * (Puede utilizar los metodos de la clase Utils para validar la lectura)
     * 
     * @param f Fecha de la lectura a agregar
     * @throws IllegalStateException Cuando el cliente no tiene
     *         medidor asociado.
     * @throws LecturaInconsistenteException Cuando la lectura es
     *         anterior a la ultima lectura de la lista o cuando el
     *         valor leido es inferior al valor de la ultima lectura
     */
    public void registrarNuevaLectura (Fecha f) throws LecturaInconsistenteException{
        if(this.medidor == null){
            throw new IllegalStateException();
        }
        
        Lectura nuevaLectura = new Lectura (this.medidor.getConsumoAcumulado(), f);
        
        if(!Utils.validarLectura(nuevaLectura, lecturas)){
            throw new LecturaInconsistenteException("");
        }
        
        lecturas.add(nuevaLectura);
    }
    
    /**
     * Asocia un medidor a este cliente, si es que no tiene ningun
     * medidor asociado.  
     * Si el cliente ya tiene un medidor
     * asociado, ignora esta nueva asociacion.
     *
     * @param m El Medidor a asociar
     * @return true si se pudo asociar el medidor, false si el
     *         cliente ya tiene un medidor asociado.
     */
    public boolean asociarMedidor(Medidor m){
        if(this.medidor != null){
            return false;
        }
        
        this.medidor = m; 
        return true;         
    }
    
    /**
     *  Remueve el medidor asociado a este cliente, y limpia la
     *  lista de lecturas asociadas
     */
    public void removerMedidor(){
        this.medidor = null; 
        this.lecturas.clear();        
    }
    
    /**
     * Obtiene el consumo para un periodo determinado. Si hay
     * varias lecturas dentro del periodo indicado, retorna el
     * consumo total entre la primera y la ultima lectura dentro
     * del periodo.
     * (Puede utilizar los metodos de la clase Utils para obtener
     * la lista con las lecturas comprendidas en el periodo
     * especificado, y en base a ellas calcular el consumo)
     * 
     * Ej: Si las lecturas del cliente son
     * Fecha (dia-anio)  | Consumo
     *         20-2015   |  200
     *         50-2015   |  350
     *         85-2015   |  470
     *        120-2015   |  610
     *        150-2015   |  770
     * 
     * Si se solicita el consumo del periodo 30-2015 al 130-2015,
     * las lecturas del periodo seran
     * Fecha (dia-anio)  | Consumo
     *         50-2015   |  350
     *         85-2015   |  470
     *        120-2015   |  610
     * 
     * y el consumo del periodo sera 260
     * 
     * Si se solicita el consumo del periodo 30-2015 al 40-2015
     * lanza IllegalStateException
     *
     * Si se solicita el consumo del periodo 50-2015 al 40-2015
     * lanza IllegalArgumentException
     *  
     * @param desde Fecha inicial
     * @param hasta Fecha final
     * @return El consumo
     * @throws IllegalArgumentException Si la fecha desde es
     *         posterior a la fecha hasta
     * @throws IllegalStateException Si no hay lecturas en el
     *         periodo
     */
    public int consumoPeriodo (Fecha desde, Fecha hasta){
        if(desde.compareTo(hasta) < 0){
            throw new IllegalArgumentException();
        }
        
        List<Lectura> lecturasHechas = Utils.filtrarLecturasPorFecha (lecturas, desde, hasta);
        if(lecturasHechas.isEmpty()){
            throw new IllegalStateException();
        }
        
        Lectura primera = lecturasHechas.get(0);
        Lectura ultima = lecturasHechas.get(lecturasHechas.size() - 1);
        
        // @return El consumo
        return (ultima.getValorDeLectura() - primera.getValorDeLectura());
    }
    
    /**
     * Retorna un string con el siguiente formato:
     * 1) cuando tiene un medidor asociado
     *   "Cliente: <nombre_del_cliente> - Medidor: SN_<Medidor_SerialNumber>"
     * 2) cuando no tienen un medidor asociado
     *   "Cliente: <nombre_del_cliente> - Medidor: N/A"
     * 
     * ej. "Cliente: juan perez - Medidor: N/A" o
     *     "Cliente: juan perez - Medidor: SN_12"
     *
     */
    public String toString() {
        String info = "";
        if(this.medidor == null){
            info = "Cliente: " + this.getNombre() + " - Medidor: N/A";
        }
        
        else{
            info = "Cliente: " + this.getNombre() + " - Medidor: SN_" + this.medidor.getSerialNumber();
        }
        
        return info;
    }
}
