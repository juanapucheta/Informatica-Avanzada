class PinchaRuedas extends Armamento {
    private static Integer ATAQUE = 20;

    PinchaRuedas() {
        super(TipoArmamento.OFENSIVO, ATAQUE);
    }

    @Override
    public void usar(Vehiculo v) {
        System.out.print("Atacando con Pincha Rueda: ");
        super.usar(v);
        v.recibirAtaque(ATAQUE);
    }

    @Override
    public String toString() {
        return "Pincha Ruedas";
    }
}
