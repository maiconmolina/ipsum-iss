package enums;

public enum TipoLancamento {

    ENTRADA("Entrada comum"), SAIDA("Saída comum"), PAGAMENTO("Pagamento de Funcionário"), RECEBIMENTO("Recebimento do Fornecedor/Cliente");

    private final String label;

    TipoLancamento(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
