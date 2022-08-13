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
            result.setMessage("Pokemon registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public BeanPersona getPersona(int id){
        return daoPersona.findOne(id);
    }





}
