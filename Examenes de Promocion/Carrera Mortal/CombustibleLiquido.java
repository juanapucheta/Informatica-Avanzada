class CombustibleLiquido extends Insumo {
    private Integer capacidadLitros;

    /**
     * En el caso del combustible la capacidad se mide en litros.
     * 1 litro de combustible equivale a 11.7 kilo Watt hora - 11.700 Wh
     */
    CombustibleLiquido(Integer capacidadLitros) {
        super((capacidadLitros * 11700));
        this.capacidadLitros = capacidadLitros;
    }

    public Integer getCapacidadLitros() {
        return this.capacidadLitros;
    }
}
