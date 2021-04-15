package com.example.thelabit.modelo;

public class FeedBack {

    private Integer Freshness;
    private Integer Dureza;
    private Integer Recuperacion;
    private String Comentario;

    public Integer getFreshness() {
        return Freshness;
    }

    public void setFreshness(Integer freshness) {
        Freshness = freshness;
    }

    public Integer getDureza() {
        return Dureza;
    }

    public void setDureza(Integer dureza) {
        Dureza = dureza;
    }

    public Integer getRecuperacion() {
        return Recuperacion;
    }

    public void setRecuperacion(Integer recuperacion) {
        Recuperacion = recuperacion;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public FeedBack() {
    }

    public FeedBack(Integer freshness, Integer dureza, Integer recuperacion, String comentario) {
        Freshness = freshness;
        Dureza = dureza;
        Recuperacion = recuperacion;
        Comentario = comentario;
    }
}
