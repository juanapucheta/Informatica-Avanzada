import java.util.ArrayList;
import java.util.List;
public class Utils {
    /**
     * Valida una lectura en una lista de lecturas
     * La lectura es valida si la fecha es posterior a la fecha de la ultima lectura de la lista,
     * y si el consumo de la lectura es mayor al consumo de la ultima lectura de la lista.
     * 
     * @param lectura
     * @param lista
     * @return true si la lectura es valida, false en caso contrario
     * 
     */
    public static boolean validarLectura(Lectura lectura, List<Lectura> lista) {
        if (! lista.isEmpty()){
            Lectura ultima = lista.get(lista.size()-1);
            if (lectura.getFechaDeLectura().compareTo(ultima.getFechaDeLectura()) < 0 
                    || lectura.getValorDeLectura() < ultima.getValorDeLectura()) 
                return false;
        }    
        return true;
    }
    
    /**
     * Devuelve una lista con las lecturas comprendidas entre las fechas "desde" - "hasta" de la lista
     * de lecturas pasadas como argunmento.
     * Si la fecha "desde" es null, considera todas las lecturas hasta la fecha "hasta"
     * Si la fecha "hasta" es null, considera todas las lecturas desde la fecha "desde"
     * Si ambas fechas son null, todas las fechas se consideran dentro del periodo 
     * 
     * @param lecturas la lista de lecturas original
     * @param desde la fecha desde la cual se considera el periodo
     * @param hasta la fecha hasta que se considera el periodo
     * @return la lista de fechas incluidas en el periodo.
     */
    public static List<Lectura> filtrarLecturasPorFecha (List<Lectura> lecturas, Fecha desde, Fecha hasta){
        List<Lectura> lecturasDelPeriodo = new ArrayList<Lectura>();
        
        if (desde == null && hasta == null){
            lecturasDelPeriodo.addAll(lecturas);
        } else if (desde == null) {
            for (Lectura l : lecturas){
                if (l.getFechaDeLectura().compareTo(hasta) <= 0 ) 
                lecturasDelPeriodo.add(l);
            }
        } else if (hasta == null) {
            for (Lectura l : lecturas){
                if (l.getFechaDeLectura().compareTo(desde) > 0 ) 
                lecturasDelPeriodo.add(l);
            }
        } else {
            for (Lectura l : lecturas){
                if (l.getFechaDeLectura().compareTo(desde) > 0   
                    && l.getFechaDeLectura().compareTo(hasta) <= 0 ) 
                lecturasDelPeriodo.add(l);
            }
        }
        return lecturasDelPeriodo;

    }
}