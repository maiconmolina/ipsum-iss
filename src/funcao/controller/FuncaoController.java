package funcao.controller;

import Util.ReturnValidate;
import funcao.model.Funcao;
import funcao.model.FuncaoDaoImpl;
import java.util.List;

public class FuncaoController {

    public static ReturnValidate save(Funcao entity) {
        try {
            FuncaoDaoImpl func = new FuncaoDaoImpl();
            func.save(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
        return new ReturnValidate("");
    }
    
    public static List<Funcao> getAllActive(){
        FuncaoDaoImpl func = new FuncaoDaoImpl();
        return func.getAllActive();
    }

    public static ReturnValidate Inativar(Integer cod) {
        try{
            FuncaoDaoImpl func = new FuncaoDaoImpl();
            return func.inativa(cod);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
    }

    public static ReturnValidate Reativar(Integer cod) {
        try{
            FuncaoDaoImpl func = new FuncaoDaoImpl();
            func.reativa(cod);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ReturnValidate(ex.getMessage());
        }
        return new ReturnValidate(null);
    }

    public static List<Funcao> getAll() {
        FuncaoDaoImpl func = new FuncaoDaoImpl();
        return func.getAll(Funcao.class);
    }
}
