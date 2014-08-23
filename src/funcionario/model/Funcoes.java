package funcionario.model;

public enum Funcoes {

    COSTUREIRO("Costureiro(a)"), GERENTE("Gerente");

    private final String label;

    Funcoes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
