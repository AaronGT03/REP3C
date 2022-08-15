package com.example.demo.service.persona;
import com.example.demo.model.persona.BeanPersona;
import com.example.demo.model.persona.DaoPersona;
import com.example.demo.utils.ResultAction;
import java.util.List;
public class ServicePersona {
    static DaoPersona daoPersona = new DaoPersona();

    public List<BeanPersona> getAll(){
        return daoPersona.findAll();
    }

    public ResultAction save(BeanPersona persona){
        ResultAction result = new ResultAction();
        if (daoPersona.save(persona)){
            result.setResult(true);
            result.setMessage("Persona registrada correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
    public ResultAction update(BeanPersona persona){
        ResultAction result = new ResultAction();
        if (daoPersona.update(persona)){
            result.setStatus(200);
            result.setResult(false);
            result.setMessage("Persona actualizado correctamente");
        }else{
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }
    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try{
            if (daoPersona.delete(Long.parseLong(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Persona eliminado correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Ocurrió un error");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }

    public BeanPersona getPersona(long id){
        return daoPersona.findOne(id);
    }





}
