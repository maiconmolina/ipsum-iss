package lancamento.model;

public enum TipoDeLancamento {

    ENTRADA("Entrada"), SAIDA("Saída");

    private final String label;

    TipoDeLancamento(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
