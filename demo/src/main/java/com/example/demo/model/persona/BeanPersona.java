package com.example.demo.model.persona;

public class BeanPersona {
    private long id;
    private String nombre;
    private String surname;
    private String curp;
    private String cumple;









    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    public BeanPersona() {
    }

    public BeanPersona(long id, String nombre, String surname, String curp, String cumple) {
        this.id = id;
        this.nombre = nombre;
        this.surname = surname;
        this.curp = curp;
        this.cumple = cumple;
    }



}