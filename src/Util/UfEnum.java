package Util;

public enum UfEnum {
    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PR("Paraná"),
    PB("Paraíba"),
    PA("Pará"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondonia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("São Paulo"),
    TO("Tocantins");   
    
    private final String nomeEstado;
    
    UfEnum(String nomeEstado){
        this.nomeEstado = nomeEstado;
    }
    
    public String getNomeEstado(){
        return this.nomeEstado;
    }
    
    @Override
    public String toString(){
        return this.nomeEstado;
    }
}