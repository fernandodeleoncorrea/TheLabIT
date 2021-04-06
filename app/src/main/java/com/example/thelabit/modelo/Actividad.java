package com.example.thelabit.modelo;

public class Actividad {
    private int id;
    private String Semana;
    private String Dia;
    private String Turno;
    private String Descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemana() {
        return Semana;
    }

    public void setSemana(String semana) {
        Semana = semana;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String turno) {
        Turno = turno;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Actividad() {

    }

    public Actividad(int id, String semana, String dia, String turno, String descripcion) {
        this.id = id;
        Semana = semana;
        Dia = dia;
        Turno = turno;
        Descripcion = descripcion;
    }
}
