package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade implements Serializable {

    @TableGenerator(name = "Entidade",
            table = "Entidade",
            pkColumnName = "Entidade",
            pkColumnValue = "Entidade")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer codigo;

    @Column(nullable = false)
    protected boolean ativo;

    public Entidade() {
        this.codigo = null;
        this.ativo = true;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
