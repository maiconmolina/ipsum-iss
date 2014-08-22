package usuario.controller;

import Util.ReturnValidate;
import usuario.model.Usuario;

public class UsuarioController {

    public static boolean isUniqueLogin(String login) {
        //TODO
        return true;
    }

    public static ReturnValidate InsereUsuario(Usuario user) {
        String retorno = "";
        if (user.getLogin().equals("")) {
            retorno += "Campo 'Login' não pode ser vazio\n";
        }
        if (!UsuarioController.isUniqueLogin(user.getLogin())) {
            retorno += "O Login informado já está cadastrado no sistema\n";
        }
        if (user.getSenha().equals("")) {
            retorno += "Campo 'Senha' não pode ser vazio\n";
        }
        return new ReturnValidate(retorno);
    }
}
