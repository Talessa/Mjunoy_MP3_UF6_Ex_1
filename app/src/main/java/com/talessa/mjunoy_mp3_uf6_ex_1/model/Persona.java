package com.talessa.mjunoy_mp3_uf6_ex_1.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject {

    @PrimaryKey
    long id;

    String nombre;
    String apellidos;
    int edad;
    String genero;
    String email;

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
