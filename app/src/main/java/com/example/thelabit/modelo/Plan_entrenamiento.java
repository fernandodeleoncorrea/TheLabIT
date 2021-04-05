package com.example.thelabit.modelo;

public class Plan_entrenamiento {

    private int id;
    private String Nombre;
    private String Distancia;
    private String Objetivo;
    private String Comentario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String objetivo) {
        Objetivo = objetivo;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public Planes_entrenamiento(int id, String nombre, String distancia, String objetivo, String comentario) {
        this.id = id;
        Nombre = nombre;
        Distancia = distancia;
        Objetivo = objetivo;
        Comentario = comentario;
    }
}
