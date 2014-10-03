package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Nfe extends Entidade implements Serializable {

    @OneToOne(fetch = FetchType.EAGER)
    private Fornecedor fornecedor;

}
