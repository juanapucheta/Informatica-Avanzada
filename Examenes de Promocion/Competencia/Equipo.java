/**
 * 
 *
 */
public class Equipo 
{
    private String nombre;
    
    
    /**
     * Constructor con parametros. El nombre del equipo debe ser 
     * convertido a mayusculas y sin prefijos o sufijos en blanco. 
     * 
     * @param nombre El nombre del equipo
     * @throws IllegalArgumenException cuando el nombre es null o vacío
     */
    public Equipo (String nombre) 
    {
        if(nombre == null || nombre == "")
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.nombre = nombre.toUpperCase().trim();
        }
    }
    
    
    /**
     * 
     */
    //Como no aclara nada supongo que solamente pide convertir el nombre en String y mostrarlo por pantalla
    public String toString()
    {
        String mensaje = "";
        mensaje += nombre;
        return mensaje;
    }

    /**
     * REtorna el nombre de este equipo
     * @return el nombre del equipo
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Retorna true cuando el nombre de este Equipo
     * coincide con el nombre del otro equipo
     */
    public boolean equals (Object o)
     {
        if(o instanceof Equipo)
        {
           Equipo e = (Equipo) o;
           
           if(e.getNombre()== nombre)
           {
               return true;
           }
        }
        return false;
    }
}
