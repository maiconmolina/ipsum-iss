package funcionario.model;

public enum NivelHabilidade {

    INICIANTE("Iniciante"), INTERMEDIARIO("Intermediário"), EXPERIENTE("Experiente");

    private final String nivel;

    NivelHabilidade(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }

    @Override
    public String toString() {
        return this.nivel;
    }
}
