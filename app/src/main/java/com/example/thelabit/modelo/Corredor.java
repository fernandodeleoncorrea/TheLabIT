package com.example.thelabit.modelo;



public class Corredor extends Usuario{

    private String Genero;
    private String Altura;
    private String FCReposo;
    private String FCMaxima;
    private String DistanciaObjetivo;
    private String TiempoEstimado;
    private String Peso;

    public String getGenero() {
        return Genero;
    }

    public String getAltura() {
        return Altura;
    }

    public String getFCReposo() {
        return FCReposo;
    }

    public String getFCMaxima() {
        return FCMaxima;
    }

    public String getDistanciaObjetivo() {
        return DistanciaObjetivo;
    }

    public String getTiempoEstimado() {
        return TiempoEstimado;
    }

    public String getPeso() {
        return Peso;
    }


    public void setGenero(String genero) {
        Genero = genero;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }

    public void setFCReposo(String FCReposo) {
        this.FCReposo = FCReposo;
    }

    public void setFCMaxima(String FCMaxima) {
        this.FCMaxima = FCMaxima;
    }

    public void setDistanciaObjetivo(String distanciaObjetivo) {
        DistanciaObjetivo = distanciaObjetivo;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        TiempoEstimado = tiempoEstimado;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public Corredor(){

    }

    public Corredor(String genero, String altura, String FCReposo, String FCMaxima, String distanciaObjetivo, String tiempoEstimado, String peso) {
        Genero = genero;
        Altura = altura;
        this.FCReposo = FCReposo;
        this.FCMaxima = FCMaxima;
        DistanciaObjetivo = distanciaObjetivo;
        TiempoEstimado = tiempoEstimado;
        Peso = peso;
    }

    public Corredor(String idUsuario, String nombre, String fechaNacimiento, String ciudad, String pais, String email, String comentario, String genero, String altura, String FCReposo, String FCMaxima, String distanciaObjetivo, String tiempoEstimado, String peso) {
        super(idUsuario, nombre, fechaNacimiento, ciudad, pais, email, comentario);
        Genero = genero;
        Altura = altura;
        this.FCReposo = FCReposo;
        this.FCMaxima = FCMaxima;
        DistanciaObjetivo = distanciaObjetivo;
        TiempoEstimado = tiempoEstimado;
        Peso = peso;
    }
}
