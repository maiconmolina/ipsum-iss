package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Entidade implements Serializable {

    @Column(length = 255, name = "LOGIN", nullable = false)
    private String login;

    @Column(length = 255, name = "SENHA", nullable = false)
    private String senha;
}
