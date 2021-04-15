package com.example.thelabit.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.thelabit.MainActivity;

public class DBTheLabIT extends SQLiteOpenHelper {

    public String queryCrearTabla;
    public String queryInsert, queryUpdate;


    public DBTheLabIT(@Nullable Context context) {
        super(context, "DBTheLabIT.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        queryCrearTabla = "CREATE TABLE LOGIN(USERNAME STRING PRIMARY KEY, PASSWORD STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE USUARIOS(USERNAME STRING PRIMARY KEY, NOMBRE STRING, FECHANACIMIENTO STRING, CIUDAD STRING, PAIS STRING, EMAIL STRING, COMENTARIO STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE ENTRENADORES(USERNAME STRING PRIMARY KEY, FORMACION STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE CORREDORES(USERNAME STRING PRIMARY KEY, PESO STRING, GENERO STRING, ALTURA STRING, FCREPOSO STRING, FCMAXIMA STRING, OBJETIVO STRING, TIEMPOESTIMADO STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE PLANES_ENTRENAMIENTOS(ID INTEGER PRIMARY KEY, NOMBRE STRING, DISTANCIA STRING, OBJETIVO STRING, COMENTARIO STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE ACTIVIDADES(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, SEMANA STRING, DIA STRING, TURNO STRING, DESCRIPCION STRING, COMPLETADA INTEGER, IDPLAN INTEGER)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE PLANES_DETALLE(IDENTRENADOR STRING, IDCORREDOR STRING, IDPLAN INT)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE ENTRENADORES_CORREDORES(IDENTRENADOR STRING, IDCORREDOR STRING)";
        db.execSQL(queryCrearTabla);

        //INSERTO UNOS DATOS DE PRUEBA
        //INSERT DE USUARIOS Y PASSWORD
        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('1', 'pwfernando')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('2', 'pwadrian')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('3', 'pwjoaquin')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('4', 'pwmario')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('5', 'pwcarol')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('1', 'FERNANDO1', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('2', 'FERNANDO2', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('3', 'FERNANDO3', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('4', 'FERNANDO4', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ENTRENADORES(USERNAME, FORMACION) VALUES ('1', 'ED FISICA')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES(USERNAME, FORMACION) VALUES ('4', 'ED FISICA')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('2', '70', 'MASCULINO2', '170', '60', '180', '10', '50')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('3', '70', 'MASCULINO3', '170', '60', '180', '10', '50')";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (1, 'PLAN 1 10K PRINCIPIANTE', '10K', '60 MIN', '8 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (2, 'PLAN 2 10K INTERMEDIO', '10K', '45 MIN', '12 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (3, 'PLAN 3 10K PRINCIPIANTE', '10K', '60 MIN', '8 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (4, 'PLAN 4 10K INTERMEDIO', '10K', '45 MIN', '12 SEMANAS')";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (1, '1', '1', 'MATUTINO', '30M TROTE SUAVE', 1, 1)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (2, '1', '2', 'VESPERTINO', '20M TROTE + 10 CUESTAS', 1, 1)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (3, '1', '3', 'MATUTINO', '30M TROTE SUAVE', 0, 1)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (4, '1', '4', 'VESPERTINO', '20M TROTE + 20CUESTAS', 0, 1)";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('4', '2', 1)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('1', '8', 3)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('4', '9', 2)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('1', '3', 4)";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('1', '2')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('1', '3')";
        db.execSQL(queryInsert);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS LOGIN");
        db.execSQL("DROP TABLE IF EXISTS USUARIOS");
        db.execSQL("DROP TABLE IF EXISTS ENTRENADORES");
        db.execSQL("DROP TABLE IF EXISTS CORREDORES");
    }


    public String chequearUsuarioPassword(Login login){
        String username = login.getUsername().toString();
        String password = login.getPassword().toString();

        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM LOGIN WHERE USERNAME = ? and PASSWORD = ?", new String[]{username, password});
        Cursor cursor_entrenador = db.rawQuery("SELECT * FROM ENTRENADORES WHERE USERNAME = ?", new String[]{username});
        Cursor cursor_corredor= db.rawQuery("SELECT * FROM CORREDORES WHERE USERNAME = ?", new String[]{username});

        if(cursor.getCount() > 0 & cursor_corredor.getCount() > 0)
            return "corredor";
        else if (cursor.getCount() > 0 & cursor_entrenador.getCount() > 0)
            return "entrenador";
        else
            return "sin_categoria";
    }

    public Boolean insertUsuario (String Tipo, Entrenador E, Corredor C, Login L){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean usu = false;
        Boolean ent = false;
        Boolean corr = false;
        Boolean log = false;

        if (Tipo == "Entrenador") {

            ContentValues contenedor = new ContentValues();
            contenedor.put(ConstantesDB.TABLA_USUARIOS_USERNAME, E.getIdUsuario());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_NOMBRE, E.getNombre());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_FECHANACIMIENTO, E.getFechaNacimiento());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_CIUDAD, E.getCiudad());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_PAIS, E.getPais());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_EMAIL, E.getEmail());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_COMENTARIO, E.getComentario());

            ContentValues contenedor2 = new ContentValues();
            contenedor2.put(ConstantesDB.TABLA_USUARIOS_USERNAME, E.getIdUsuario());
            contenedor2.put(ConstantesDB.TABLA_ENTRENADORES_FORMACION, E.getFormacion());

            usu = db.insert("USUARIOS", null, contenedor) > 0;
            ent = db.insert("ENTRENADORES", null, contenedor2) > 0;

        }else {

            ContentValues contenedor = new ContentValues();
            contenedor.put(ConstantesDB.TABLA_USUARIOS_USERNAME,C.getIdUsuario());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_NOMBRE, C.getNombre());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_FECHANACIMIENTO, C.getFechaNacimiento());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_CIUDAD, C.getCiudad());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_PAIS, C.getPais());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_EMAIL, C.getEmail());
            contenedor.put(ConstantesDB.TABLA_USUARIOS_COMENTARIO, C.getComentario());

            ContentValues contenedor2 = new ContentValues();
            contenedor2.put(ConstantesDB.TABLA_USUARIOS_USERNAME, C.getIdUsuario());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_PESO,C.getPeso());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_GENERO,C.getGenero());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_ALTURA,C.getAltura());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_FCREPOSO,C.getFCReposo());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_FCMAXIMA,C.getFCMaxima());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_OBJETIVO,C.getDistanciaObjetivo());
            contenedor2.put(ConstantesDB.TABLA_CORREDORES_TIEMPOESTIMADO,C.getTiempoEstimado());

            usu = db.insert("USUARIOS", null, contenedor) > 0;
            corr = db.insert("CORREDORES", null, contenedor2) > 0;
        }
        ContentValues contenedor3 = new ContentValues();
        contenedor3.put(ConstantesDB.TABLA_USUARIOS_USERNAME, L.getUsername());
        contenedor3.put(ConstantesDB.TABLA_LOGIN_PASSWORD, L.getPassword());

        log = db.insert("LOGIN", null, contenedor3) > 0;
        db.close();

        if (Tipo == "Entrenador" & usu == true & ent == true & log == true){
            return true;
        }else if (Tipo == "Corredor" & usu == true & corr == true & log == true){
            return true;
        }else {
            return false;
        }

    }

    public void inicio(){ }

    public Cursor obtenerCorredores(String ent){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T2.NOMBRE " +
                "FROM ENTRENADORES_CORREDORES T1 " +
                "JOIN USUARIOS T2 ON T1.IDCORREDOR = T2.USERNAME " +
                "WHERE T1.IDENTRENADOR = ?",new String[]{ent});
        return cursor;
    }

    public Cursor obtenerPlanes(String ent){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T1.NOMBRE AS NOMBRE " +
                        " FROM PLANES_ENTRENAMIENTOS T1 " +
                        "JOIN PLANES_DETALLE T2 ON T1.ID = T2.IDPLAN " +
                        "WHERE T2.IDENTRENADOR = ?",new String[]{ent});
        return cursor;
    }

    public PlanEntrenamiento obtenerPlan(String entrenador, String nombrePlan){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T1.ID, T1.NOMBRE, T1.DISTANCIA, T1.OBJETIVO, T1.COMENTARIO " +
                "FROM PLANES_ENTRENAMIENTOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.ID = T2.IDPLAN " +
                "WHERE T2.IDENTRENADOR = ? " +
                "AND T1.NOMBRE = ? ",new String[]{entrenador, nombrePlan});


        cursor.moveToNext();
        Integer id = cursor.getInt(cursor.getColumnIndex("ID"));
        String nomPlan = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        String distanciaPlan = cursor.getString(cursor.getColumnIndex("DISTANCIA"));
        String objetivoPlan = cursor.getString(cursor.getColumnIndex("OBJETIVO"));
        String comentarioPlan = cursor.getString(cursor.getColumnIndex("COMENTARIO"));

        PlanEntrenamiento plan = new PlanEntrenamiento(id, nomPlan, distanciaPlan, objetivoPlan, comentarioPlan);
        return plan;

    }

    public Actividad obtenerActividad(Integer idActividad){
        SQLiteDatabase db =  this.getWritableDatabase();
       Cursor cursor = db.rawQuery("SELECT T1.ID, T1.SEMANA, T1.DIA, T1.TURNO, T1.DESCRIPCION, T1.COMPLETADA, T1.IDPLAN " +
                "FROM ACTIVIDADES T1 " +
                "WHERE T1.ID = ? ",new String[]{String.valueOf(idActividad)});


        cursor.moveToNext();
        Integer id = cursor.getInt(cursor.getColumnIndex("ID"));
        String semana = cursor.getString(cursor.getColumnIndex("SEMANA"));
        String dia = cursor.getString(cursor.getColumnIndex("DIA"));
        String turno = cursor.getString(cursor.getColumnIndex("TURNO"));
        String descripcion = cursor.getString(cursor.getColumnIndex("DESCRIPCION"));
        Integer completada = cursor.getInt(cursor.getColumnIndex("COMPLETADA"));
        Integer idPlan = cursor.getInt(cursor.getColumnIndex("IDPLAN"));
        Actividad actividad = new Actividad(id,semana,dia,turno,descripcion,completada,idPlan);
        return actividad;

    }

    public Boolean insertNuevoPlan (PlanEntrenamiento P, String ent){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean plan = false;

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_PLANES_ID, P.getId());
        contenedor.put(ConstantesDB.TABLA_PLANES_NOMBRE, P.getNombre());
        contenedor.put(ConstantesDB.TABLA_PLANES_DISTANCIA, P.getDistancia());
        contenedor.put(ConstantesDB.TABLA_PLANES_OBJETIVO, P.getObjetivo());
        contenedor.put(ConstantesDB.TABLA_PLANES_COMENTARIO, P.getComentario());

        plan = db.insert("PLANES_ENTRENAMIENTOS", null, contenedor) > 0;
        db.close();

        return plan;
    }

    public Boolean insertActividad (Actividad A){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean actividad = false;

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_SEMANA, A.getSemana());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_DIA, A.getDia());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_TURNO, A.getTurno());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_DESCRIPCION, A.getDescripcion());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_COMPLETADA, A.getCompletada());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_IDPLAN, A.getIdPlan());

        actividad = db.insert("ACTIVIDADES", null, contenedor) > 0;
        db.close();

        return actividad;
    }

    public Boolean insertDetallePlan (String idEntrenador, String idCorredor, Integer idPlan){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean detalleplan = false;

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_PLANESDETALLE_IDENT, idEntrenador);
        contenedor.put(ConstantesDB.TABLA_PLANESDETALLE_IDCORR, idCorredor);
        contenedor.put(ConstantesDB.TABLA_PLANESDETALLE_IDPLAN, idPlan);

        detalleplan = db.insert("PLANES_DETALLE", null, contenedor) > 0;
        db.close();

        return detalleplan;
    }

    public Boolean modificarPlanCabezal(PlanEntrenamiento P){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean modificoOK = false;

        Integer id = P.getId();

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_PLANES_NOMBRE, P.getNombre());
        contenedor.put(ConstantesDB.TABLA_PLANES_DISTANCIA, P.getDistancia());
        contenedor.put(ConstantesDB.TABLA_PLANES_OBJETIVO, P.getObjetivo());
        contenedor.put(ConstantesDB.TABLA_PLANES_COMENTARIO, P.getComentario());

        modificoOK = db.update("PLANES_ENTRENAMIENTOS", contenedor, "ID = ?", new String[]{id.toString()}) > 0;
        return modificoOK;
    }

    public Boolean eliminarPlan(Integer idPlan) {
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean eliminoOK = false;

        eliminoOK = db.delete("PLANES_ENTRENAMIENTOS", "ID = ?", new String[]{idPlan.toString()}) > 0;
        eliminoOK = db.delete("PLANES_DETALLE", "IDPLAN = ?", new String[]{idPlan.toString()}) > 0;
        return eliminoOK;
    }

    public Cursor obtenerActividadesRecientes(String corr){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T3.SEMANA, T3.DIA, T3.TURNO, T3.DESCRIPCION " +
                "FROM USUARIOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.USERNAME = T2.IDCORREDOR " +
                "JOIN ACTIVIDADES T3 ON T2.IDPLAN = T3.IDPLAN " +
                "WHERE T1.NOMBRE = ? AND T2.IDPLAN = 1 AND T3.COMPLETADA = 0 " +
                "ORDER BY DIA DESC LIMIT 7",new String[]{corr});

        Integer cantidad = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerActividadesPendientes(String corr){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T3.ID, T3.SEMANA, T3.DIA, T3.TURNO, T3.DESCRIPCION " +
                "FROM USUARIOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.USERNAME = T2.IDCORREDOR " +
                "JOIN ACTIVIDADES T3 ON T2.IDPLAN = T3.IDPLAN " +
                "WHERE T1.USERNAME = ? AND T2.IDPLAN = 1 AND T3.COMPLETADA = 0 " +
                "ORDER BY DIA ASC LIMIT 7",new String[]{corr});

        Integer cantidad = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerPlanTotal(String corr){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T3.ID, T3.SEMANA, T3.DIA, T3.TURNO, T3.DESCRIPCION, T3.COMPLETADA " +
                "FROM USUARIOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.USERNAME = T2.IDCORREDOR " +
                "JOIN ACTIVIDADES T3 ON T2.IDPLAN = T3.IDPLAN " +
                "WHERE T1.USERNAME = ? " +
                "ORDER BY CAST(DIA AS INT) ASC ",new String[]{corr});

        Integer cantidad = cursor.getCount();
        return cursor;
    }

    public Boolean marcarActividadBD(String idActividad){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean modificoOK = false;


        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_COMPLETADA, 1);

        modificoOK = db.update("ACTIVIDADES", contenedor, "ID = ?", new String[]{idActividad}) > 0;
        return modificoOK;
    }


    public String obtenerNombre(String user){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT T1.NOMBRE " +
                "FROM USUARIOS T1 " +
                "WHERE T1.USERNAME = ? ",new String[]{String.valueOf(user)});

        cursor.moveToNext();
        String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        return nombre;

    }
}
