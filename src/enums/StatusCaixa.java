package enums;

public enum StatusCaixa {

    ABERTO("Aberto"),
    FECHADO("Fechado");

    private final String label;

    private StatusCaixa(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
