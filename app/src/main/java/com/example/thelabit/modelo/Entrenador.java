package com.example.thelabit.modelo;

public class Entrenador extends Usuario{

    private String Formacion;

    public String getFormacion() {
        return Formacion;
    }

    public void setFormacion(String formacion) {
        Formacion = formacion;
    }

    public Entrenador() {
        super();
    }

    public Entrenador(String idUsuario, String nombre, String fechaNacimiento, String ciudad, String pais, String email, String comentario, String formacion) {
        super(idUsuario, nombre, fechaNacimiento, ciudad, pais, email, comentario);
        Formacion = formacion;
    }
}
