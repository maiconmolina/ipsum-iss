package nfe.model;

import fornecedor.model.Fornecedor;

public class NFe {
    
    private Integer codigo;
    private Fornecedor fornecedor;
    
    public NFe(){
        
        this.codigo = null;
        this.fornecedor = new Fornecedor();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
