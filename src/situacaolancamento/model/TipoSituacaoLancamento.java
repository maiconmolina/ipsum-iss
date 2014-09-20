
package situacaolancamento.model;


public enum TipoSituacaoLancamento {

    BAIXADO("Baixado"), ESTORNADO("Estornado"), AGENDADO("Agendado");

    private final String label;

    TipoSituacaoLancamento(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
