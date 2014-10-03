package enums;

public enum SituacaoLancamento {

    BAIXADO("Baixado"), 
    ESTORNADO("Estornado"), 
    AGENDADO("Agendado");

    private final String label;

    SituacaoLancamento(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
