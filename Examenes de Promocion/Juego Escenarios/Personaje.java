
public abstract class Personaje {
    private String nombre;
    private Bolsa  bolsa;
    private Integer vida;


    Personaje (String nombre, Integer vida){
        this.nombre = nombre;
        this.bolsa = new Bolsa(10);
        this.vida = vida;
    }

    public void recibirDanio (Integer danio) {
      vida -= danio;
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }
}
