package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcao extends Entidade implements Serializable {
    
    @Column(length = 255, name = "NOME_FUNCAO", nullable = false)
    private String nomeFuncao;
    
}
