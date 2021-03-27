package com.example.thelabit.modelo;

public abstract class Usuario {

    private String IdUsuario;
    private String Nombre;
    private String FechaNacimiento;
    private String Ciudad;
    private String Pais;
    private String Email;
    private String Comentario;

    public String getIdUsuario() {
        return IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public String getEmail() {
        return Email;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public Usuario(){
    }

    public Usuario(String idUsuario, String nombre, String fechaNacimiento, String ciudad, String pais, String email, String comentario) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        FechaNacimiento = fechaNacimiento;
        Ciudad = ciudad;
        Pais = pais;
        Email = email;
        Comentario = comentario;
    }
}
