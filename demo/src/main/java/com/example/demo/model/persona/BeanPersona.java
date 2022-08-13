package com.example.demo.model.persona;
import java.util.List;

import com.example.demo.model.ability.BeanAbility;
public class BeanPersona {
    private int id;
    private String nombre;
    private String surname;
    private String curp;
    private String cumple;
    private List<BeanAbility> abilities;






    public BeanPersona(int id, String nombre, String surname, String curp, String cumple) {
        this.id = id;
        this.nombre = nombre;
        this.surname = surname;
        this.curp = curp;
        this.cumple = cumple;
    }

    @Override
    public String toString() {
        return "BeanPersona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", surname='" + surname + '\'' +
                ", curp='" + curp + '\'' +
                ", cumple='" + cumple + '\'' +
                '}';
    }

    public BeanPersona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }



}