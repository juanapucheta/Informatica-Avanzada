public class Municion
{
    private TipoMunicion tipo;
    private Integer danio;

    public Municion(TipoMunicion tipo, Integer danio)
    {
        this.tipo = tipo;
        this.danio = danio;
    }

    public TipoMunicion getTipo()
    {
        return tipo;
    }

    public Integer getDanio()
    {
        if(tipo == TipoMunicion.EXPLOSIVA)
        {
            return danio*2;
        }
        if(tipo == TipoMunicion.HUMO)
        {
            return danio/2;
        }
        return danio;
    }
}