package usuario.controller;

import Util.ReturnValidate;
import usuario.model.Usuario;

public class UsuarioController {

    public static ReturnValidate InsereUsuario(Usuario user) {
        return user.isValid();
    }
}
