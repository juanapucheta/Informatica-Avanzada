class Ametralladora extends Armamento {
    private static Integer ATAQUE = 30;

    Ametralladora() {
        super(TipoArmamento.OFENSIVO, ATAQUE);
    }

    @Override
    public void usar(Vehiculo v) {
        System.out.print("Atacando con Ametralladora: ");
        super.usar(v);
        v.recibirAtaque(ATAQUE);
    }

    @Override
    public String toString() {
        return "Ametralladora";
    }
}
