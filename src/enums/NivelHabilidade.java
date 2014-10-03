package enums;

public enum NivelHabilidade {

    INICIANTE("Iniciante"), INTERMEDIARIO("Intermediário"), EXPERIENTE("Experiente");

    private final String nivel;

    NivelHabilidade(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return this.nivel;
    }
}
