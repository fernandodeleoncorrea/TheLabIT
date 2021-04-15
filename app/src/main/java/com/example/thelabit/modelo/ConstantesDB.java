package com.example.thelabit.modelo;

public final class ConstantesDB {

    public static final String TABLA_USUARIOS_USERNAME = "USERNAME";
    public static final String TABLA_USUARIOS_NOMBRE = "NOMBRE";
    public static final String TABLA_USUARIOS_FECHANACIMIENTO = "FECHANACIMIENTO";
    public static final String TABLA_USUARIOS_CIUDAD = "CIUDAD";
    public static final String TABLA_USUARIOS_PAIS = "PAIS";
    public static final String TABLA_USUARIOS_EMAIL = "EMAIL";
    public static final String TABLA_USUARIOS_COMENTARIO = "COMENTARIO";
    public static final String TABLA_ENTRENADORES_FORMACION = "FORMACION";
    public static final String TABLA_LOGIN_PASSWORD = "PASSWORD";
    public static final String TABLA_CORREDORES_PESO = "PESO";
    public static final String TABLA_CORREDORES_GENERO = "GENERO";
    public static final String TABLA_CORREDORES_ALTURA = "ALTURA";
    public static final String TABLA_CORREDORES_FCREPOSO = "FCREPOSO";
    public static final String TABLA_CORREDORES_FCMAXIMA = "FCMAXIMA";
    public static final String TABLA_CORREDORES_OBJETIVO = "OBJETIVO";
    public static final String TABLA_CORREDORES_TIEMPOESTIMADO = "TIEMPOESTIMADO";

    //TABLA PLANES ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO
    public static final String TABLA_PLANES_ID = "ID";
    public static final String TABLA_PLANES_NOMBRE = "NOMBRE";
    public static final String TABLA_PLANES_DISTANCIA = "DISTANCIA";
    public static final String TABLA_PLANES_OBJETIVO = "OBJETIVO";
    public static final String TABLA_PLANES_COMENTARIO = "COMENTARIO";

    //TABLA ACTIVIDADES
    public static final String TABLA_ACTIVIDADES_ID = "ID";
    public static final String TABLA_ACTIVIDADES_SEMANA = "SEMANA";
    public static final String TABLA_ACTIVIDADES_DIA = "DIA";
    public static final String TABLA_ACTIVIDADES_TURNO = "TURNO";
    public static final String TABLA_ACTIVIDADES_DESCRIPCION = "DESCRIPCION";
    public static final String TABLA_ACTIVIDADES_COMPLETADA = "COMPLETADA";
    public static final String TABLA_ACTIVIDADES_IDPLAN = "IDPLAN";

    //TABLA PLANES DETALLE IDENTRENADOR STRING, IDCORREDOR STRING, IDPLAN INT
    public static final String TABLA_PLANESDETALLE_IDENT = "IDENTRENADOR";
    public static final String TABLA_PLANESDETALLE_IDCORR = "IDCORREDOR";
    public static final String TABLA_PLANESDETALLE_IDPLAN = "IDPLAN";

    //TABLA FEEDBACK
    public static final String TABLA_FEEDBACK_IDACTIVIDAD = "IDACTIVIDAD";
    public static final String TABLA_FEEDBACK_FRESHNESS = "FRESHNESS";
    public static final String TABLA_FEEDBACK_DUREZA = "DUREZA";
    public static final String TABLA_FEEDBACK_RECUPERACION = "RECUPERACION";
    public static final String TABLA_FEEDBACK_COMENTARIO = "COMENTARIO";
}
