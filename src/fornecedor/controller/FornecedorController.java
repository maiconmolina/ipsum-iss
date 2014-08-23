package fornecedor.controller;

import Util.ReturnValidate;
import Util.Util;
import fornecedor.model.Fornecedor;
import fornecedor.model.FornecedorDAOImpl;
import usuario.controller.UsuarioController;

public class FornecedorController {
    
    public static ReturnValidate InsereFornecedor(Fornecedor forn){
        String retorno = "";
        
        if (forn.getRazao().equals("")){
            retorno += "Campo 'Razao Social' não pode ser vazio\n";
        }
        
        if (!Util.ValidateCnpj(forn.getCnpj())) {
            retorno += "CNPJ inválido\n";
        }
        
        if (forn.getTelefone().equals("")){
            retorno += "Campo 'Telefone' não pode ser vazio\n";
        }
        
        if (forn.getCep().equals("")){
            retorno += "Campo 'CEP' não pode ser vazio\n";
        }
        
        if (forn.getEndereço().equals("")){
            retorno += "Campo 'Endereco' não pode ser vazio\n";
        }
        
        if (forn.getNumero().equals("")){
            retorno += "Campo 'Numero' não pode ser vazio\n";
        }
        
        if (forn.getCidade().equals("")){
            retorno += "Campo 'Cidade' não pode ser vazio\n";
        }
        
        ReturnValidate validacaoUsuario = UsuarioController.InsereUsuario(forn);
        if (!validacaoUsuario.isValid()) {
            retorno += validacaoUsuario.getMessage();
        }
        if (retorno.equals("")) {
            FornecedorDAOImpl a = new FornecedorDAOImpl();
            a.save(forn);
        }
        return  new ReturnValidate(retorno);
    }
}
