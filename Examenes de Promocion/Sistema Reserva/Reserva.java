import java.time.LocalDateTime;
/**
 * Completa los métodos indicados de la clase Reserva según la documentación
 * 
 * - Implementar el método toString con formato: "Reserva de <nombre_sala> por <usuario> desde <fecha_hora_inicio> por <duracion>h".
 * - Implementar el método seSuperpone(...) para verificar si una reserva se superpone con otra en función del horario.
 * 
 * El sistema utiliza la clase LocalDateTime de la biblioteca java.time para representar fechas y horas. 
 * Esta clase permite expresar momentos como “2025-06-15T10:00” y sumar horas usando el método plusHours(int). 
 * También pueden compararse con operadores >, <, o utlizando el método isBefore(LocalDateTime).
 * 
 * No es necesario considerar zonas horarias ni diferencias geográficas. Todos los horarios se interpretan como locales.
 */

public class Reserva {
    protected Sala sala;
    protected Usuario usuario;
    protected LocalDateTime inicio;
    protected int duracionHoras;

    public Reserva(Sala sala, Usuario usuario, LocalDateTime inicio, int duracionHoras) {
        this.sala = sala;
        this.usuario = usuario;
        this.inicio = inicio;
        this.duracionHoras = duracionHoras;
    }

    public Sala getSala() {
        return sala; 
    }
    
    public Usuario getUsuario() {
        return usuario; 
    }
    
    public LocalDateTime getInicio() { 
        return inicio; 
    }
    
    public int getDuracionHoras() { 
        return duracionHoras; 
    }
    
    /**
     * indica si el horario de esta Reserva se superpone con otro horario y duración
     * pasada como parámetro
     * 
     * Por ejemplo, si esta reserva es de 9 a 11,
     *  otroInicio 10, otrasHoras 1 -> true
     *  otroInicio 8, otrasHoras 2 -> True
     *  otroInicio 8, otrasHoras 1 -> false
     * 
     * horario: otroInicio
     * duracion: otrasHoras
     */
    public boolean seSuperpone(LocalDateTime otroInicio, int otrasHoras) {
        LocalDateTime fin = this.getInicio().plusHours(this.getDuracionHoras());
        LocalDateTime proxFin = otroInicio.plusHours(otrasHoras);
        
            /** 
             * Retorna true si se superponen.
               * Dos intervalos [A, B) y [C, D) se superponen si y solo si:
               * C empieza antes de que termine A (C < B), y
               * A empieza antes de que termine C (A < D)
            */
        return (otroInicio.isBefore(fin) && this.getInicio().isBefore(proxFin));
    }

    @Override
    /**
     * Retorna un string que representa la Reserva con el formato
     * "Reserva de <nombre_sala> por <usuario> desde <hora_inicio> por <duracion> horas"" 
     * Ej
     *  "Reserva de Uritorco por ]Juan Perez <jp@perez.com> desde 17:00 por 1 horas"
     */
    public String toString() {
        String info = "Reserva de " + this.getSala().getNombre()
                    + " por " + this.getUsuario().toString()
                    + " desde " + this.getInicio()
                    + " por " + this.getDuracionHoras() + "h";
        return info;
    }
}