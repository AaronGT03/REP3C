package com.example.demo.model.ability;

public class BeanAbility {
    private long id;
    private String name;
    private String surname;
    private String abilityType;

    public BeanAbility() {
    }

    public BeanAbility(String nombre, String surname, String abilityType) {
        this.name = name;
        this.surname = surname;
        this.abilityType = abilityType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType;
    }
}
