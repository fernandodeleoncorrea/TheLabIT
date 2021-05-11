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

        queryCrearTabla = "CREATE TABLE FEEDBACK(IDACTIVIDAD INTEGER, FRESHNESS INTEGER, DUREZA INTEGER, RECUPERACION INTEGER, COMENTARIO STRING)";
        db.execSQL(queryCrearTabla);

        queryCrearTabla = "CREATE TABLE DETALLE_ACTIVIDADES(IDACTIVIDAD INTEGER, LON DOUBLE, LAT DOUBLE, ELE DOUBLE, TIME STRING, HR INTEGER, CAD INTEGER)";
        db.execSQL(queryCrearTabla);

        //INSERTO UNOS DATOS DE PRUEBA
        //INSERT DE USUARIOS Y PASSWORD
        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('111', 'pwfernando')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('222', 'pwadrian')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('333', 'pwjoaquin')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('444', 'pwmario')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('555', 'pwcarol')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('111', 'FERNANDO', '01/01/1985', 'DURAZNO', 'URUGUAY', 'fernando@gmail.com', 'CORREDOR DE FONDO')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('222', 'ADRIAN', '01/01/1990', 'MONTEVIDEO', 'URUGUAY', 'adrian@gmail.com', 'ME GUSTA ENTRENAR')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('333', 'JOAQUIN', '01/01/1986', 'ROSARIO', 'ARGENTINA', 'joaquin@gmail.com', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('444', 'MARIO', '01/01/1990', 'MONTEVIDEO', 'URUGUAY', 'mario@gmail.com', 'SIEMPRE LISTO')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('555', 'CAROL', '01/01/1999', 'MONTEVIDEO', 'URUGUAY', 'carol@gmail.com', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('666', 'HUGO', '01/01/1962', 'PANDO', 'URUGUAY', 'hugo@gmail.com', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('777', 'MARIA', '01/01/1993', 'CORDOBA', 'ARGENTINA', 'maria@gmail.com', '')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ENTRENADORES(USERNAME, FORMACION) VALUES ('111', 'LIC. ED FISICA')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES(USERNAME, FORMACION) VALUES ('444', 'LIC. ED FISICA - TECNICO DEPORTIVO')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('222', '75', 'MASCULINO', '185', '58', '190', '21K', '1H40M')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('333', '70', 'MASCULINO', '175', '60', '183', 'BAJAR DE PESO', '')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('555', '61', 'FEMENINO', '169', '63', '175', '5 Y 10K', '20MIN Y 40MIN')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('666', '72', 'MASCULINO', '163', '55', '186', '42K', '3H30')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('777', '55', 'FEMENINO', '159', '65', '179', 'MEJORAR', '-')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (1, 'PLAN 1 10K PRINCIPIANTE', '10K', '60 MIN', '8 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (2, 'PLAN 2 10K INTERMEDIO', '10K', '45 MIN', '12 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (3, 'PLAN 3 10K AVANZADO', '10K', 'SUB 40', '16 SEMANAS')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO PLANES_ENTRENAMIENTOS(ID, NOMBRE, DISTANCIA, OBJETIVO , COMENTARIO) VALUES (4, 'PLAN 4 PUESTA A PUNTO', '0', '0', 'MEJORA AEROBICA')";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (1, '1', '1', 'MAÑANA', '35M TROTE SUAVE', 1, 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (2, '1', '2', 'MAÑANA', '20M TROTE SUAVE + 5 CUESTAS DE 500M', 1, 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (3, '1', '3', 'TARDE', '5X1000M A 90% R2', 0, 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (4, '1', '4', 'NOCHE', '45M TROTE SUAVE', 0, 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (5, '1', '5', 'TARDE', '12K PROGRESIVO DE 50% A 95%', 0, 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (6, '2', '6', 'NOCHE', '60M FONDO RITMO COMODO', 0, 1)";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (7, '1', '1', 'MAÑANA', '60M TROTE SUAVE', 1, 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (8, '1', '2', 'MAÑANA', '40M TROTE SUAVE + 10 CUESTAS DE 300M', 1, 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (9, '1', '3', 'TARDE', '8X1000M A 90% R1M30', 0, 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (10, '1', '4', 'NOCHE', '45M TROTE SUAVE', 0, 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ACTIVIDADES(ID, SEMANA, DIA, TURNO , DESCRIPCION, COMPLETADA, IDPLAN) VALUES (11, '2', '6', 'NOCHE', '2(2X2000M) A 85% R2 r1', 0, 2)";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('111', '222', 1)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('111', '333', 3)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('444', '555', 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('444', '666', 2)";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO PLANES_DETALLE(IDENTRENADOR, IDCORREDOR, IDPLAN) VALUES ('444', '777', 4)";
        db.execSQL(queryInsert);


        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('111', '222')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('111', '333')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('444', '555')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('444', '666')";
        db.execSQL(queryInsert);
        queryInsert = "INSERT INTO ENTRENADORES_CORREDORES(IDENTRENADOR, IDCORREDOR) VALUES ('444', '777')";
        db.execSQL(queryInsert);

        queryInsert = "INSERT INTO FEEDBACK(IDACTIVIDAD, FRESHNESS, DUREZA, RECUPERACION, COMENTARIO) VALUES (1, 80, 55, 21, 'Inicié con algo de cansancio pero no fue una sesion muy dura')";
        db.execSQL(queryInsert);

        insertarActividades(db);
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
        Cursor cursor = db.rawQuery("SELECT T2.USERNAME, T2.NOMBRE " +
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
        Cursor cursor = db.rawQuery("SELECT T3.ID, T3.SEMANA, T3.DIA, T3.TURNO, T3.DESCRIPCION " +
                "FROM USUARIOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.USERNAME = T2.IDCORREDOR " +
                "JOIN ACTIVIDADES T3 ON T2.IDPLAN = T3.IDPLAN " +
                "WHERE T1.USERNAME = ? AND T2.IDPLAN = 1 AND T3.COMPLETADA = 1 " +
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

    public Cursor obtenerDatosCorredor(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.USERNAME, T1.NOMBRE, T1.FECHANACIMIENTO, T1.CIUDAD, T1.PAIS, T1.EMAIL, T1.COMENTARIO " +
                ",T2.PESO, T2.GENERO, T2.ALTURA, T2.FCREPOSO, T2.FCMAXIMA, T2.OBJETIVO, T2.TIEMPOESTIMADO " +
                "FROM USUARIOS T1 JOIN CORREDORES T2 ON T1.USERNAME = T2.USERNAME " +
                "WHERE T1.USERNAME = ? ",new String[]{user});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerDatosEntrenador(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.USERNAME, T1.NOMBRE, T1.FECHANACIMIENTO, T1.CIUDAD, T1.PAIS, T1.EMAIL, T1.COMENTARIO " +
                ",T2.FORMACION " +
                "FROM USUARIOS T1 JOIN ENTRENADORES T2 ON T1.USERNAME = T2.USERNAME " +
                "WHERE T1.USERNAME = ? ",new String[]{user});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Boolean guardarDatosCorredor(Corredor C){
        SQLiteDatabase db = this.getWritableDatabase();

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

        Boolean tbusuarios = db.update("USUARIOS", contenedor, "USERNAME = ?", new String[]{C.getIdUsuario()}) > 0;
        Boolean tbcorredores = db.update("CORREDORES", contenedor2, "USERNAME = ?", new String[]{C.getIdUsuario()}) > 0;

        if(tbusuarios == true & tbcorredores == true){
            return true;
        } else {
            return false;
        }
    }

    public Boolean guardarDatosEntrenador(Entrenador E){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_USUARIOS_USERNAME,E.getIdUsuario());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_NOMBRE, E.getNombre());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_FECHANACIMIENTO, E.getFechaNacimiento());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_CIUDAD, E.getCiudad());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_PAIS, E.getPais());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_EMAIL, E.getEmail());
        contenedor.put(ConstantesDB.TABLA_USUARIOS_COMENTARIO, E.getComentario());

        ContentValues contenedor2 = new ContentValues();
        contenedor2.put(ConstantesDB.TABLA_USUARIOS_USERNAME, E.getIdUsuario());
        contenedor2.put(ConstantesDB.TABLA_ENTRENADORES_FORMACION,E.getFormacion());


        Boolean tbusuarios = db.update("USUARIOS", contenedor, "USERNAME = ?", new String[]{E.getIdUsuario()}) > 0;
        Boolean tbcorredores = db.update("ENTRENADORES", contenedor2, "USERNAME = ?", new String[]{E.getIdUsuario()}) > 0;

        if(tbusuarios == true & tbcorredores == true){
            return true;
        } else {
            return false;
        }
    }

    public Cursor obtenerDatosBusquedaEnt(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T2.NOMBRE, T2.CIUDAD, T2.PAIS, T2.COMENTARIO, T1.FORMACION, T3.CANTIDAD " +
                "FROM ENTRENADORES T1 " +
                "JOIN USUARIOS T2 ON T1.USERNAME = T2.USERNAME " +
                "JOIN (SELECT IDENTRENADOR, COUNT(*) AS CANTIDAD  FROM ENTRENADORES_CORREDORES  GROUP BY IDENTRENADOR) T3 " +
                "ON T1.USERNAME = T3.IDENTRENADOR " +
                "WHERE T1.USERNAME = ?",new String[]{user});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerDatosBusquedaCorr(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.USERNAME, T1.NOMBRE, T1.FECHANACIMIENTO, T1.CIUDAD, T1.PAIS, T1.COMENTARIO " +
                ", T2.PESO, T2.GENERO, T2.ALTURA, T2.FCREPOSO, T2.FCMAXIMA, T2.OBJETIVO, T2.TIEMPOESTIMADO " +
                ", T4.NOMBRE AS ENTRENADOR_ACTUAL " +
                "FROM USUARIOS T1 JOIN CORREDORES T2 ON T1.USERNAME = T2.USERNAME " +
                "JOIN ENTRENADORES_CORREDORES T3 ON T1.USERNAME = T3.IDCORREDOR " +
                "JOIN USUARIOS T4 ON T3.IDENTRENADOR = T4.USERNAME " +
                "WHERE T1.USERNAME = ?",new String[]{user});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerListaEntrenadores(){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.USERNAME, T2.NOMBRE " +
                "FROM ENTRENADORES T1 " +
                "JOIN USUARIOS T2 ON T1.USERNAME = T2.USERNAME ",new String[]{});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Cursor obtenerListaCorredores(){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.USERNAME, T2.NOMBRE " +
                "FROM CORREDORES T1 " +
                "JOIN USUARIOS T2 ON T1.USERNAME = T2.USERNAME ",new String[]{});

        Integer largo = cursor.getCount();
        return cursor;
    }

    public Boolean insertarFeedback(Integer idActividad, FeedBack F){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_FEEDBACK_IDACTIVIDAD, idActividad);
        contenedor.put(ConstantesDB.TABLA_FEEDBACK_FRESHNESS, F.getFreshness());
        contenedor.put(ConstantesDB.TABLA_FEEDBACK_DUREZA, F.getDureza());
        contenedor.put(ConstantesDB.TABLA_FEEDBACK_RECUPERACION, F.getRecuperacion());
        contenedor.put(ConstantesDB.TABLA_FEEDBACK_COMENTARIO, F.getComentario());

        Boolean inserto = db.insert("FEEDBACK", null, contenedor) > 0;

        if (inserto){
            return true;
        }else
        {
            return false;
        }
    }

    public Cursor obtenerListadoActividades(Integer idPlan){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T1.ID, T1.SEMANA, T1.DIA, T1.TURNO, T1.DESCRIPCION, T1.COMPLETADA " +
                "FROM ACTIVIDADES T1 " +
                "WHERE T1.IDPLAN = ? ",new String[]{String.valueOf(idPlan)});
        Integer largo = cursor.getCount();
        return cursor;
    }

    public Boolean updateActividad(Actividad A){
        SQLiteDatabase db = this.getWritableDatabase();
        Boolean modificoOK = false;

        ContentValues contenedor = new ContentValues();
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_SEMANA, A.getSemana().toString());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_DIA, A.getDia().toString());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_TURNO, A.getTurno().toString());
        contenedor.put(ConstantesDB.TABLA_ACTIVIDADES_DESCRIPCION, A.getDescripcion().toString());

        modificoOK = db.update("ACTIVIDADES", contenedor, "ID = ?", new String[]{String.valueOf(A.getId())}) > 0;
        return modificoOK;
    }

    public String obtenerEntrenadorActual(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T2.USERNAME " +
                "FROM ENTRENADORES_CORREDORES T1 " +
                "JOIN USUARIOS T2 ON T1.IDENTRENADOR = T2.USERNAME " +
                "WHERE T1.IDCORREDOR = ?",new String[]{user});

        cursor.moveToNext();
        String username = cursor.getString(cursor.getColumnIndex("USERNAME"));
        return username;
    }

    public String obtenerNombrePlan(String user){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT DISTINCT T4.NOMBRE " +
                "FROM USUARIOS T1 " +
                "JOIN PLANES_DETALLE T2 ON T1.USERNAME = T2.IDCORREDOR " +
                "JOIN ACTIVIDADES T3 ON T2.IDPLAN = T3.IDPLAN " +
                "JOIN PLANES_ENTRENAMIENTOS T4 ON T3.IDPLAN = T4.ID " +
                "WHERE T1.USERNAME = ?",new String[]{user});

        cursor.moveToNext();
        String username = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        return username;
    }

    public Cursor leerActividad(String idActividad){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT IDACTIVIDAD, LON, LAT, ELE, TIME, HR, CAD " +
                "FROM DETALLE_ACTIVIDADES " +
                "WHERE IDACTIVIDAD = ?",new String[]{idActividad});

        return cursor;
    }

    public Cursor obtenerTotalPlanes(String ent, String corr){
        SQLiteDatabase db =  this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT T2.ID, T2.NOMBRE " +
                "FROM PLANES_DETALLE T1 JOIN PLANES_ENTRENAMIENTOS T2 ON T1.IDPLAN = T2.ID " +
                "WHERE T1.IDENTRENADOR = ?  AND T1.IDCORREDOR <> ? ",new String[]{ent, corr});

        Integer cantidad = cursor.getCount();
        return cursor;
    }


    public void insertarActividades(SQLiteDatabase db){
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467490,-34.9002240,25.7,'2021-03-31',91,57)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467310,-34.9002230,25.7,'2021-03-31',90,57)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467050,-34.9002290,25.7,'2021-03-31',91,57)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1466360,-34.9002370,25.6,'2021-03-31',94,57)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1465160,-34.9002540,25.4,'2021-03-31',97,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1464640,-34.9003070,24.5,'2021-03-31',100,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1464500,-34.9003270,24.3,'2021-03-31',101,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1464230,-34.9004360,23.6,'2021-03-31',105,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1464100,-34.9005010,23.2,'2021-03-31',108,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463980,-34.9005900,22.6,'2021-03-31',111,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463970,-34.9007290,21.6,'2021-03-31',114,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463780,-34.9009100,20.5,'2021-03-31',115,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463570,-34.9010900,19.6,'2021-03-31',116,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463180,-34.9012950,18.9,'2021-03-31',115,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462960,-34.9014980,18.9,'2021-03-31',116,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462800,-34.9015920,19.1,'2021-03-31',119,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462680,-34.9016770,19.2,'2021-03-31',123,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462550,-34.9017680,19.5,'2021-03-31',127,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462380,-34.9018640,19.8,'2021-03-31',130,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462400,-34.9019220,20.0,'2021-03-31',134,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462420,-34.9019780,20.2,'2021-03-31',137,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462450,-34.9020530,20.4,'2021-03-31',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1461860,-34.9022540,21.2,'2021-03-31',140,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1460890,-34.9024180,22.1,'2021-03-31',140,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1459910,-34.9025870,23.1,'2021-03-31',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1458760,-34.9026870,25.2,'2021-03-31',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1456320,-34.9027190,26.1,'2021-03-31',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1454220,-34.9028010,26.8,'2021-03-31',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1451890,-34.9028120,27.5,'2021-03-31',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1450970,-34.9028050,27.8,'2021-03-31',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1450490,-34.9029890,28.8,'2021-03-31',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449760,-34.9031910,28.9,'2021-03-31',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449600,-34.9033950,28.6,'2021-03-31',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449590,-34.9035810,28.0,'2021-03-31',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449410,-34.9037620,26.9,'2021-03-31',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1448880,-34.9039530,25.6,'2021-03-31',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1447940,-34.9041590,24.8,'2021-03-31',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1447570,-34.9043400,24.1,'2021-03-31',140,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1446630,-34.9045300,23.4,'2021-03-31',138,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1445760,-34.9047140,23.0,'2021-03-31',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1445380,-34.9049180,22.7,'2021-03-31',141,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1444740,-34.9050900,22.4,'2021-03-31',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1444120,-34.9052800,21.8,'2021-03-31',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1443410,-34.9054550,21.2,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1442570,-34.9056240,20.5,'2021-03-31',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1442190,-34.9058380,19.4,'2021-03-31',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1441700,-34.9060300,18.1,'2021-03-31',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1441320,-34.9062100,16.7,'2021-03-31',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1440880,-34.9063390,15.8,'2021-03-31',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1440650,-34.9064940,14.8,'2021-03-31',136,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1440230,-34.9066940,13.7,'2021-03-31',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1439300,-34.9068880,13.0,'2021-03-31',132,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1439200,-34.9070960,12.3,'2021-03-31',129,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438660,-34.9072890,11.7,'2021-03-31',129,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438420,-34.9074120,11.5,'2021-03-31',132,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438100,-34.9075350,11.3,'2021-03-31',135,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1437270,-34.9077300,11.0,'2021-03-31',136,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1436870,-34.9079250,10.9,'2021-03-31',135,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1436830,-34.9081210,10.9,'2021-03-31',136,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1435550,-34.9082970,10.9,'2021-03-31',139,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1434570,-34.9084750,11.2,'2021-03-31',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1433470,-34.9086320,11.5,'2021-03-31',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1432370,-34.9087950,11.4,'2021-03-31',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1430650,-34.9089470,11.4,'2021-03-31',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1429060,-34.9090960,11.2,'2021-03-31',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1427470,-34.9092430,11.0,'2021-03-31',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1426040,-34.9093860,10.7,'2021-03-31',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1424010,-34.9094830,11.0,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1422180,-34.9096230,14.9,'2021-03-31',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1420130,-34.9096830,15.0,'2021-03-31',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1417600,-34.9097040,15.0,'2021-03-31',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1415140,-34.9097460,15.0,'2021-03-31',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1412950,-34.9097800,14.9,'2021-03-31',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1410470,-34.9098140,14.7,'2021-03-31',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1408640,-34.9098470,14.5,'2021-03-31',147,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1406810,-34.9098760,14.1,'2021-03-31',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1404570,-34.9099120,13.7,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1402260,-34.9099710,13.2,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1400070,-34.9100300,12.9,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1397890,-34.9100880,12.6,'2021-03-31',156,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1395520,-34.9101680,12.9,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1393340,-34.9102370,14.1,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1391150,-34.9103000,15.4,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1388890,-34.9103520,16.6,'2021-03-31',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1386670,-34.9103990,17.6,'2021-03-31',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1384270,-34.9104280,18.6,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1381930,-34.9104320,18.8,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1379580,-34.9104130,19.1,'2021-03-31',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1377220,-34.9104210,19.3,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1374810,-34.9104160,19.5,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1372390,-34.9103970,19.5,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1370020,-34.9103620,19.5,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1367960,-34.9102950,19.4,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1366410,-34.9102590,19.3,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1364130,-34.9102070,19.1,'2021-03-31',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1361700,-34.9101590,18.9,'2021-03-31',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1359370,-34.9101090,18.7,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1357080,-34.9100580,18.3,'2021-03-31',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1354940,-34.9100140,17.9,'2021-03-31',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1352420,-34.9099730,17.6,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1350240,-34.9099260,17.4,'2021-03-31',150,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1348090,-34.9098660,17.1,'2021-03-31',151,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1346270,-34.9098100,16.7,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1344250,-34.9097350,16.1,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1342020,-34.9096240,15.5,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1339920,-34.9095620,14.9,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1339210,-34.9095410,14.8,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1337680,-34.9094040,14.3,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1336610,-34.9092320,13.9,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1335530,-34.9090550,13.6,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1334620,-34.9088570,13.4,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1334660,-34.9086510,13.2,'2021-03-31',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1334350,-34.9084950,13.1,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1334120,-34.9082970,13.0,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1333770,-34.9080890,13.0,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1333320,-34.9078900,13.1,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1332890,-34.9077080,13.3,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1332460,-34.9075090,13.5,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1331910,-34.9073140,13.6,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1331420,-34.9071290,13.7,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1330870,-34.9069320,13.7,'2021-03-31',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1330240,-34.9067430,13.6,'2021-03-31',154,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1329660,-34.9065460,13.6,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1329150,-34.9063440,13.4,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1328590,-34.9061440,13.2,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1327850,-34.9059560,13.2,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1326870,-34.9057770,13.1,'2021-03-31',149,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1326080,-34.9055870,13.0,'2021-03-31',149,44)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1325080,-34.9054130,13.0,'2021-03-31',150,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1324450,-34.9052970,13.2,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1323320,-34.9051360,13.6,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1322210,-34.9050060,14.0,'2021-03-31',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1320800,-34.9048530,14.5,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1319390,-34.9047640,15.1,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1317250,-34.9046500,15.9,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1315190,-34.9045690,16.5,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1313110,-34.9045020,17.1,'2021-03-31',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1310920,-34.9044600,17.6,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1308530,-34.9044180,18.1,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1306100,-34.9044130,18.5,'2021-03-31',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1303890,-34.9044280,18.7,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1301410,-34.9044800,18.8,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1299260,-34.9045200,18.6,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1297040,-34.9045640,18.2,'2021-03-31',158,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1295440,-34.9046690,17.6,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1293660,-34.9047870,17.0,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1291700,-34.9049220,16.3,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1290100,-34.9050160,15.7,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1287970,-34.9051030,15.1,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1285720,-34.9051790,14.4,'2021-03-31',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1283580,-34.9052730,13.8,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1281280,-34.9053540,13.3,'2021-03-31',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1278930,-34.9054240,12.9,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1276710,-34.9054820,12.7,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1274220,-34.9055290,12.5,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1271990,-34.9055690,12.4,'2021-03-31',154,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1269480,-34.9055930,12.1,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1267050,-34.9055890,12.0,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1264590,-34.9055570,11.8,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1262230,-34.9055130,11.7,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1259910,-34.9054730,11.6,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1257690,-34.9054210,11.5,'2021-03-31',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1255580,-34.9053400,11.4,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1253340,-34.9052610,11.4,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1251200,-34.9051910,11.5,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1249030,-34.9050960,11.5,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1246870,-34.9050070,11.3,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1244770,-34.9049040,11.2,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1242810,-34.9047650,11.1,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1240850,-34.9046380,10.9,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1238790,-34.9045220,10.8,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1236920,-34.9043990,10.8,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1235120,-34.9042690,10.9,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233630,-34.9041210,11.0,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232210,-34.9039590,11.0,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231190,-34.9037740,11.1,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1230650,-34.9035860,11.0,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1230440,-34.9033860,11.0,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1230640,-34.9031990,11.0,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231330,-34.9030230,11.0,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232490,-34.9028320,10.9,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233240,-34.9026540,7.6,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233280,-34.9026290,7.0,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233010,-34.9024920,3.5,'2021-03-31',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232330,-34.9023190,-0.5,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231420,-34.9021850,-1.3,'2021-03-31',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1230270,-34.9020310,-1.6,'2021-03-31',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1229050,-34.9018490,-1.9,'2021-03-31',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1227850,-34.9016730,-1.9,'2021-03-31',147,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1226580,-34.9015080,-1.7,'2021-03-31',147,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1225350,-34.9013470,-1.3,'2021-03-31',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1223970,-34.9011770,-0.9,'2021-03-31',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1222570,-34.9010090,-0.3,'2021-03-31',149,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1220950,-34.9008570,0.1,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1219080,-34.9007310,0.5,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1217170,-34.9006130,0.7,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1215290,-34.9005100,1.0,'2021-03-31',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1213380,-34.9003900,1.3,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1211550,-34.9002690,1.5,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1209650,-34.9001700,1.8,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1207790,-34.9000470,1.8,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1205930,-34.8999430,2.0,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1204260,-34.8998560,2.1,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1202290,-34.8997480,2.1,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1200310,-34.8996500,2.1,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1198370,-34.8995450,2.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1196400,-34.8994330,2.0,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1194390,-34.8993210,2.0,'2021-03-31',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1192480,-34.8992160,2.2,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1190500,-34.8991100,2.4,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1188440,-34.8990070,2.7,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1186320,-34.8989200,3.0,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1184210,-34.8988400,3.6,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1182180,-34.8987510,4.1,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1180170,-34.8986480,4.7,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1178060,-34.8985550,5.5,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1176010,-34.8984770,6.1,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1173800,-34.8983860,6.9,'2021-03-31',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1171790,-34.8982790,7.7,'2021-03-31',158,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1169560,-34.8982170,8.3,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1167260,-34.8981750,9.1,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1165000,-34.8981420,9.8,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1162750,-34.8981290,10.3,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1160460,-34.8981390,10.8,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1158220,-34.8981670,10.9,'2021-03-31',160,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1155820,-34.8981920,11.1,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1151290,-34.8980670,5.8,'2021-03-31',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1148940,-34.8980200,4.3,'2021-03-31',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1147260,-34.8979580,4.7,'2021-03-31',163,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1145080,-34.8978820,7.2,'2021-03-31',162,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1142690,-34.8979000,8.1,'2021-03-31',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1140380,-34.8978960,6.1,'2021-03-31',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1138110,-34.8978620,4.8,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1135670,-34.8978140,3.4,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1133890,-34.8977670,2.5,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1132070,-34.8977040,2.1,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1131180,-34.8975170,2.9,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1130860,-34.8974610,3.0,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1129730,-34.8973950,3.2,'2021-03-31',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1127760,-34.8972770,4.0,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1125670,-34.8972100,3.5,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1123710,-34.8971080,6.0,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1122730,-34.8970780,5.8,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1121470,-34.8971720,4.7,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1119810,-34.8973010,3.3,'2021-03-31',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1117490,-34.8973390,2.5,'2021-03-31',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1115080,-34.8973640,1.7,'2021-03-31',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1112630,-34.8973560,1.0,'2021-03-31',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1110370,-34.8973310,0.4,'2021-03-31',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1108040,-34.8973290,-0.1,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1105650,-34.8973350,-0.6,'2021-03-31',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1103260,-34.8973230,-1.0,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1100900,-34.8973180,-1.3,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1098640,-34.8972840,-1.4,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1096250,-34.8972770,-1.6,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1093770,-34.8972870,-1.7,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1091370,-34.8972950,-1.9,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1088890,-34.8973050,-2.2,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1086580,-34.8973050,-2.4,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1084390,-34.8972900,-2.5,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1082050,-34.8972960,-2.6,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1079780,-34.8973040,-2.8,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1077560,-34.8973040,-2.8,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1075320,-34.8973230,-2.8,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1073070,-34.8973350,-2.7,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1070820,-34.8973470,-2.6,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1068320,-34.8973450,-2.3,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1066000,-34.8973490,-2.1,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1063600,-34.8973540,-1.8,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1061380,-34.8973510,-1.6,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1059000,-34.8973190,-1.4,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1056470,-34.8973230,-1.2,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1054200,-34.8973230,-1.1,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1051810,-34.8973410,-1.0,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1049530,-34.8973600,-1.0,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1047140,-34.8974120,-1.1,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1044810,-34.8974140,-1.2,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1042550,-34.8974410,-1.2,'2021-03-31',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1040190,-34.8974660,-1.2,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1037880,-34.8975060,-1.2,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1035470,-34.8975700,-1.0,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1033200,-34.8976200,-0.8,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1031000,-34.8976740,-0.4,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1028470,-34.8977110,-0.1,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1026220,-34.8977730,0.1,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1023960,-34.8978330,0.3,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1021600,-34.8979060,0.3,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1019600,-34.8980100,0.1,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1017640,-34.8981130,-0.1,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1015790,-34.8982320,-0.4,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1014040,-34.8983420,-0.7,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1012490,-34.8984720,-1.2,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1011170,-34.8986280,-1.6,'2021-03-31',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1009190,-34.8987450,-2.1,'2021-03-31',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1006910,-34.8987380,-1.9,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1004580,-34.8986520,-1.7,'2021-03-31',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1002720,-34.8985310,-1.3,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1000940,-34.8983780,-0.8,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0999070,-34.8982330,-0.2,'2021-03-31',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0997470,-34.8980800,0.3,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0995710,-34.8979400,0.9,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0993850,-34.8978070,0.0,'2021-03-31',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0991890,-34.8976990,1.8,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0990010,-34.8976070,2.2,'2021-03-31',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0988990,-34.8975520,2.3,'2021-03-31',159,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0988870,-34.8975440,2.4,'2021-03-31',159,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0992440,-34.8976990,-0.9,'2021-03-31',109,52)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0992530,-34.8977080,-0.9,'2021-03-31',109,52)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0992940,-34.8977310,-0.6,'2021-03-31',111,52)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0995040,-34.8978430,1.3,'2021-03-31',112,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0996500,-34.8979390,0.9,'2021-03-31',115,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0997110,-34.8979760,0.8,'2021-03-31',118,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0998000,-34.8980420,0.5,'2021-03-31',121,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0998600,-34.8980900,0.4,'2021-03-31',124,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0999170,-34.8981360,0.3,'2021-03-31',127,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.0999760,-34.8981830,0.0,'2021-03-31',130,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1000680,-34.8982510,-0.1,'2021-03-31',133,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1001910,-34.8983290,-0.5,'2021-03-31',136,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1003830,-34.8984140,-0.7,'2021-03-31',140,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1005580,-34.8984690,-1.0,'2021-03-31',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1007410,-34.8984770,-1.0,'2021-03-31',146,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1009830,-34.8984110,-0.7,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1011880,-34.8983220,-0.5,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1013870,-34.8982320,-0.1,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1016020,-34.8981200,0.2,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1018190,-34.8980220,0.5,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1020590,-34.8979400,0.5,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1022670,-34.8978360,0.7,'2021-03-31',153,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1024880,-34.8977670,0.6,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1027260,-34.8977160,0.4,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1029590,-34.8976700,0.1,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1031930,-34.8976260,-0.3,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1034260,-34.8975820,-0.5,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1036660,-34.8975410,-0.8,'2021-03-31',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1039030,-34.8975180,-0.9,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1041370,-34.8974890,-1.0,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1043840,-34.8974650,-0.9,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1046320,-34.8974510,-0.8,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1048740,-34.8974320,-0.7,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1051030,-34.8973900,-0.7,'2021-03-31',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1053480,-34.8973580,-0.7,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1055920,-34.8973400,-0.8,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1058370,-34.8973270,-0.9,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1060780,-34.8973090,-1.1,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1063120,-34.8972880,-1.2,'2021-03-31',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1065400,-34.8972810,-1.4,'2021-03-31',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1067860,-34.8972840,-1.6,'2021-03-31',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1070240,-34.8972660,-1.9,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1072610,-34.8972240,-1.8,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1074930,-34.8971980,-1.9,'2021-03-31',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1077360,-34.8971830,-1.9,'2021-03-31',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1079770,-34.8971660,-1.8,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1082110,-34.8971720,-1.7,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1084500,-34.8971740,-1.6,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1086930,-34.8971970,-1.5,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1089390,-34.8972090,-1.3,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1091950,-34.8972380,-1.2,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1094420,-34.8972460,-1.0,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1096760,-34.8972270,-0.7,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1099160,-34.8972170,-0.5,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1101530,-34.8972170,-0.2,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1103860,-34.8972260,0.1,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1106270,-34.8972440,0.4,'2021-03-31',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1108680,-34.8972720,0.8,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1111020,-34.8972800,1.5,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1113350,-34.8973020,2.0,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1115700,-34.8973180,2.8,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1118110,-34.8973260,3.5,'2021-03-31',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1120370,-34.8972740,4.5,'2021-03-31',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1121330,-34.8971940,5.4,'2021-03-31',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1122510,-34.8971100,6.3,'2021-03-31',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1124520,-34.8971860,3.8,'2021-03-31',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1125510,-34.8972280,4.3,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1127840,-34.8972950,4.8,'2021-03-31',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1129670,-34.8974090,2.9,'2021-03-31',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1131480,-34.8975210,2.2,'2021-03-31',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1132660,-34.8976790,1.2,'2021-03-31',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1134450,-34.8977950,0.2,'2021-03-31',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1136660,-34.8978490,-0.1,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1139060,-34.8978810,-0.3,'2021-03-31',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1140480,-34.8978870,0.1,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1141940,-34.8978870,0.0,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1144190,-34.8978830,-1.3,'2021-03-31',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1145320,-34.8978740,-1.8,'2021-03-31',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1147340,-34.8979680,-4.1,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1149880,-34.8980080,-3.6,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1152210,-34.8980440,-1.5,'2021-03-31',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1154570,-34.8980960,-0.4,'2021-03-31',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1156760,-34.8981430,3.9,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1159080,-34.8981410,3.7,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1161460,-34.8981260,3.6,'2021-03-31',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1163870,-34.8981200,3.3,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1166280,-34.8981240,3.0,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1168770,-34.8981590,2.6,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1171190,-34.8981780,2.4,'2021-03-31',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1173590,-34.8982360,1.9,'2021-03-31',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1175850,-34.8983170,1.4,'2021-03-31',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1178050,-34.8983770,1.1,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1180320,-34.8984480,0.7,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1182500,-34.8985540,0.3,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1184600,-34.8986620,-0.1,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1186710,-34.8987700,-0.4,'2021-03-31',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1188750,-34.8988730,-0.6,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1190740,-34.8989770,-0.7,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1192620,-34.8990790,-0.7,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1194680,-34.8991810,-0.6,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1196640,-34.8992890,-0.4,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1198660,-34.8994050,-0.1,'2021-03-31',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1200640,-34.8995240,0.1,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1202590,-34.8996370,0.3,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1204490,-34.8997550,0.6,'2021-03-31',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1206430,-34.8998760,0.7,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1208340,-34.9000020,0.9,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1210330,-34.9001150,1.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1212300,-34.9002360,1.0,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1214240,-34.9003610,1.0,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1216090,-34.9004960,1.0,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1218010,-34.9006260,0.8,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1219790,-34.9007530,0.6,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1221310,-34.9008880,0.6,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1222950,-34.9010480,0.3,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1224550,-34.9011970,0.1,'2021-03-31',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1226070,-34.9013510,-0.1,'2021-03-31',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1227480,-34.9015020,-0.1,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1228710,-34.9016760,0.0,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1229970,-34.9018560,0.3,'2021-03-31',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231390,-34.9020270,1.0,'2021-03-31',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232690,-34.9021940,1.9,'2021-03-31',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233670,-34.9023660,3.0,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1234180,-34.9025540,6.7,'2021-03-31',158,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1234320,-34.9027490,10.2,'2021-03-31',157,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233560,-34.9029190,10.9,'2021-03-31',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232590,-34.9030890,11.0,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231590,-34.9032700,11.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1231510,-34.9034540,11.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232000,-34.9036340,11.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1232720,-34.9038160,11.1,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1233900,-34.9040000,11.0,'2021-03-31',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1235450,-34.9041550,11.0,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1236960,-34.9042970,10.8,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1238760,-34.9044310,10.8,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1240730,-34.9045440,10.8,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1242690,-34.9046650,11.0,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1244580,-34.9047860,11.2,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1246480,-34.9049050,11.2,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1248480,-34.9050030,11.4,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1250560,-34.9051110,11.5,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1252730,-34.9052030,11.4,'2021-03-31',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1254980,-34.9052700,11.4,'2021-03-31',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1257240,-34.9053380,11.5,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1259550,-34.9053880,11.5,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1261750,-34.9054410,11.7,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1264220,-34.9054710,11.8,'2021-03-31',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1266850,-34.9054970,11.9,'2021-03-31',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1269310,-34.9054930,12.1,'2021-03-31',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1271630,-34.9054840,12.3,'2021-03-31',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1273950,-34.9054670,12.5,'2021-03-31',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1276220,-34.9054170,12.7,'2021-03-31',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1278550,-34.9053610,12.9,'2021-03-31',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1280770,-34.9053000,13.2,'2021-03-31',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1282780,-34.9052030,13.7,'2021-03-31',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1284930,-34.9051170,14.4,'2021-03-31',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1287030,-34.9050340,15.0,'2021-03-31',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1289060,-34.9049330,15.7,'2021-03-31',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1291070,-34.9048350,16.3,'2021-03-31',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1293190,-34.9047320,17.0,'2021-03-31',168,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1295110,-34.9046310,17.6,'2021-03-31',170,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1296890,-34.9045090,18.2,'2021-03-31',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1297290,-34.9044960,18.3,'2021-03-31',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1299480,-34.9044440,18.6,'2021-03-31',168,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1301750,-34.9043940,18.8,'2021-03-31',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1304230,-34.9043720,18.6,'2021-03-31',168,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1306590,-34.9043540,18.4,'2021-03-31',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1309090,-34.9043530,18.1,'2021-03-31',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1311590,-34.9043780,17.5,'2021-03-31',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1314100,-34.9044280,17.0,'2021-03-31',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1316150,-34.9045050,16.4,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1318250,-34.9046100,15.7,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1320180,-34.9047390,15.0,'2021-03-31',161,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1321840,-34.9048680,14.4,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1323210,-34.9050120,13.9,'2021-03-31',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1324760,-34.9051780,13.5,'2021-03-31',161,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1325820,-34.9053480,13.1,'2021-03-31',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1326490,-34.9055530,13.0,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1327320,-34.9057210,13.1,'2021-03-31',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1328210,-34.9058940,13.1,'2021-03-31',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1328880,-34.9060780,13.2,'2021-03-31',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1329490,-34.9062730,13.3,'2021-03-31',160,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1330030,-34.9064670,13.5,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1330640,-34.9066590,13.6,'2021-03-31',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1331240,-34.9068530,13.7,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1331840,-34.9070640,13.7,'2021-03-31',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1332360,-34.9072650,13.6,'2021-03-31',163,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1332980,-34.9074500,13.5,'2021-03-31',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1333630,-34.9076390,13.4,'2021-03-31',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1334420,-34.9078350,13.1,'2021-03-31',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1335140,-34.9080400,13.0,'2021-03-31',166,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1335610,-34.9082190,13.0,'2021-03-31',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1336100,-34.9084050,13.1,'2021-03-31',167,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1336480,-34.9086160,13.2,'2021-03-31',166,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1336740,-34.9087960,13.3,'2021-03-31',167,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1337280,-34.9089950,13.6,'2021-03-31',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1338400,-34.9091630,13.9,'2021-03-31',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1339570,-34.9093310,14.3,'2021-03-31',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1340960,-34.9094750,14.8,'2021-03-31',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1342930,-34.9095950,15.4,'2021-03-31',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1344910,-34.9096820,15.9,'2021-03-31',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1347250,-34.9097130,16.5,'2021-03-31',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1347460,-34.9097030,16.6,'2021-03-31',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1348500,-34.9096050,17.0,'2021-03-31',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1348830,-34.9095930,17.0,'2021-03-31',161,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1351060,-34.9096380,17.4,'2021-03-31',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1352770,-34.9096640,17.6,'2021-03-31',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1354060,-34.9096960,16.3,'2021-03-31',153,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1354200,-34.9097030,16.3,'2021-03-31',153,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1355300,-34.9097300,16.5,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1355910,-34.9097480,16.6,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1357220,-34.9097750,16.7,'2021-03-31',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1359570,-34.9098210,16.8,'2021-03-31',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1361990,-34.9098670,17.0,'2021-03-31',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1364180,-34.9099120,17.1,'2021-03-31',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1366290,-34.9099710,17.4,'2021-03-31',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1368740,-34.9100130,17.8,'2021-03-31',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1371060,-34.9100470,18.0,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1373560,-34.9100530,18.4,'2021-03-31',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1375770,-34.9099810,18.5,'2021-03-31',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1377900,-34.9099260,18.5,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1380040,-34.9098820,18.5,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1382260,-34.9098400,18.3,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1384470,-34.9098330,18.0,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1386690,-34.9097760,17.8,'2021-03-31',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1389220,-34.9097440,17.5,'2021-03-31',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1391860,-34.9097480,16.8,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1394140,-34.9097120,16.2,'2021-03-31',151,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1396660,-34.9096550,15.5,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1399190,-34.9096060,15.0,'2021-03-31',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1401670,-34.9095530,14.6,'2021-03-31',156,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1403990,-34.9095010,14.4,'2021-03-31',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1406520,-34.9095070,14.0,'2021-03-31',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1409000,-34.9094640,13.6,'2021-03-31',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1411320,-34.9094400,13.2,'2021-03-31',151,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1413850,-34.9093960,12.7,'2021-03-31',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1416360,-34.9093820,12.4,'2021-03-31',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1418800,-34.9093610,12.0,'2021-03-31',150,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1421190,-34.9093350,11.5,'2021-03-31',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1423480,-34.9093130,11.1,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1425780,-34.9092500,10.9,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1426380,-34.9092170,11.0,'2021-03-31',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1427740,-34.9090540,11.2,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1429120,-34.9088870,11.4,'2021-03-31',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1430550,-34.9087410,11.4,'2021-03-31',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1432190,-34.9085880,11.5,'2021-03-31',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1432640,-34.9083930,11.2,'2021-03-31',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1434060,-34.9082290,10.9,'2021-03-31',139,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1435220,-34.9080650,10.9,'2021-03-31',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1435630,-34.9078690,11.0,'2021-03-31',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1435950,-34.9076870,11.1,'2021-03-31',139,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1436340,-34.9075210,11.3,'2021-03-31',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1436790,-34.9073400,11.6,'2021-03-31',140,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1437710,-34.9071730,11.9,'2021-03-31',138,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438110,-34.9070280,12.4,'2021-03-31',134,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438120,-34.9068400,13.1,'2021-03-31',131,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1438720,-34.9066490,13.8,'2021-03-31',132,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1439070,-34.9065880,14.1,'2021-03-31',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1439460,-34.9064310,15.0,'2021-03-31',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1439940,-34.9062390,16.3,'2021-03-31',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1440520,-34.9060640,17.7,'2021-03-31',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1441300,-34.9058900,19.0,'2021-03-31',143,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1441820,-34.9057450,19.8,'2021-03-31',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1442200,-34.9055560,20.7,'2021-03-31',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1442610,-34.9053760,21.4,'2021-03-31',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1443580,-34.9051850,22.1,'2021-03-31',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1444290,-34.9049930,22.5,'2021-03-31',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1445080,-34.9048190,22.8,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1445680,-34.9046130,23.2,'2021-03-31',147,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1445940,-34.9044300,23.6,'2021-03-31',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1446710,-34.9042430,24.4,'2021-03-31',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1447280,-34.9041740,24.7,'2021-03-31',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1447610,-34.9041100,24.9,'2021-03-31',143,63)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1448550,-34.9039400,25.7,'2021-03-31',144,59)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1448800,-34.9038390,26.4,'2021-03-31',141,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1448880,-34.9037710,26.8,'2021-03-31',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449300,-34.9036250,27.7,'2021-03-31',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449360,-34.9036070,27.8,'2021-03-31',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449240,-34.9034120,28.6,'2021-03-31',135,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449340,-34.9032120,28.9,'2021-03-31',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1449830,-34.9030320,28.9,'2021-03-31',136,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1450130,-34.9028520,28.6,'2021-03-31',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1450280,-34.9028240,28.0,'2021-03-31',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1451630,-34.9027170,27.4,'2021-03-31',131,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1451910,-34.9027240,27.3,'2021-03-31',129,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1454150,-34.9027020,26.7,'2021-03-31',127,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1456470,-34.9027040,26.0,'2021-03-31',126,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1458530,-34.9026270,23.4,'2021-03-31',125,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1459530,-34.9024490,22.3,'2021-03-31',124,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1460470,-34.9022690,21.3,'2021-03-31',125,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1461070,-34.9020960,20.7,'2021-03-31',126,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1461390,-34.9018910,19.9,'2021-03-31',128,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1461980,-34.9016890,19.3,'2021-03-31',130,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462270,-34.9015010,19.0,'2021-03-31',131,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462400,-34.9013140,18.9,'2021-03-31',133,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462500,-34.9011200,19.4,'2021-03-31',136,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462450,-34.9009310,20.3,'2021-03-31',138,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1462820,-34.9007450,21.3,'2021-03-31',140,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463180,-34.9006120,22.2,'2021-03-31',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463320,-34.9004800,23.1,'2021-03-31',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1463810,-34.9003630,23.9,'2021-03-31',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1464830,-34.9002420,24.7,'2021-03-31',146,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1465430,-34.9001960,25.1,'2021-03-31',143,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1465760,-34.9001770,25.3,'2021-03-31',140,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1466090,-34.9001580,25.5,'2021-03-31',137,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1466640,-34.9001430,25.6,'2021-03-31',134,58)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1466800,-34.9001370,25.6,'2021-03-31',133,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467180,-34.9001430,25.7,'2021-03-31',131,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467540,-34.9001410,25.7,'2021-03-31',128,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (1,-56.1467900,-34.9001570,25.8,'2021-03-31',125,60)"; db.execSQL(queryInsert);

        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1467840,-34.9001950,25.3,'2021-04-20',91,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1467650,-34.9001980,25.2,'2021-04-20',91,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1466140,-34.9002340,24.5,'2021-04-20',95,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1465160,-34.9002750,24.1,'2021-04-20',98,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464630,-34.9004360,23.1,'2021-04-20',108,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464640,-34.9004630,22.9,'2021-04-20',116,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464660,-34.9004960,22.7,'2021-04-20',123,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464700,-34.9005300,22.5,'2021-04-20',139,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464760,-34.9005640,22.3,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464790,-34.9006040,22.1,'2021-04-20',160,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464770,-34.9006720,21.7,'2021-04-20',157,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464690,-34.9007780,21.1,'2021-04-20',160,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464730,-34.9008670,20.6,'2021-04-20',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464650,-34.9009000,20.5,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464680,-34.9009360,20.3,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464580,-34.9010890,19.6,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464400,-34.9012710,19.0,'2021-04-20',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464330,-34.9013290,18.9,'2021-04-20',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464320,-34.9013570,18.9,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464150,-34.9013940,18.9,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464080,-34.9014300,18.9,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463820,-34.9015940,19.1,'2021-04-20',143,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463570,-34.9017220,19.3,'2021-04-20',139,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463110,-34.9019280,20.0,'2021-04-20',138,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462670,-34.9021350,20.7,'2021-04-20',140,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1461800,-34.9023100,21.5,'2021-04-20',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1461230,-34.9024520,22.2,'2021-04-20',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1460180,-34.9026160,23.2,'2021-04-20',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1458540,-34.9027390,25.2,'2021-04-20',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1456310,-34.9027360,26.1,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1455280,-34.9027450,26.3,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1453770,-34.9028360,26.8,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451620,-34.9028320,28.5,'2021-04-20',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450870,-34.9029970,28.8,'2021-04-20',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450970,-34.9030550,28.9,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451040,-34.9030980,28.9,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451010,-34.9031690,28.9,'2021-04-20',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450940,-34.9032900,28.8,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450910,-34.9033610,28.7,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450910,-34.9033980,28.6,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450810,-34.9034430,28.5,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450600,-34.9036550,27.6,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450400,-34.9038030,26.7,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450250,-34.9038870,26.1,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449880,-34.9039990,25.5,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449370,-34.9041830,24.8,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449060,-34.9042400,24.6,'2021-04-20',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448870,-34.9042700,24.5,'2021-04-20',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448450,-34.9044230,23.8,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447630,-34.9045920,23.3,'2021-04-20',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447500,-34.9046170,23.3,'2021-04-20',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447260,-34.9046430,23.2,'2021-04-20',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1446620,-34.9047290,23.0,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1446390,-34.9047870,22.9,'2021-04-20',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1446060,-34.9048720,22.8,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445790,-34.9049180,22.7,'2021-04-20',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444830,-34.9050820,22.4,'2021-04-20',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444180,-34.9052540,21.9,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443980,-34.9053620,21.6,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443830,-34.9054340,21.3,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443350,-34.9055170,21.0,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442520,-34.9056860,20.3,'2021-04-20',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442760,-34.9057750,19.8,'2021-04-20',143,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443070,-34.9059730,18.6,'2021-04-20',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442570,-34.9061580,17.3,'2021-04-20',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442590,-34.9061920,17.1,'2021-04-20',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442600,-34.9062210,16.9,'2021-04-20',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442480,-34.9062550,16.6,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441860,-34.9064380,15.4,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441540,-34.9065000,15.0,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440530,-34.9066670,14.0,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439650,-34.9068470,13.3,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439120,-34.9069290,13.0,'2021-04-20',144,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439810,-34.9070130,12.7,'2021-04-20',144,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440500,-34.9070970,12.3,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440520,-34.9071390,12.2,'2021-04-20',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440390,-34.9072410,11.9,'2021-04-20',141,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440270,-34.9072710,11.8,'2021-04-20',138,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440080,-34.9073040,11.7,'2021-04-20',138,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439960,-34.9073330,11.7,'2021-04-20',144,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439750,-34.9073630,11.6,'2021-04-20',147,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439510,-34.9073880,11.6,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439240,-34.9074100,11.5,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439310,-34.9074430,11.4,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439100,-34.9074960,11.4,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438980,-34.9075210,11.3,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438740,-34.9075700,11.2,'2021-04-20',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1437200,-34.9077190,11.0,'2021-04-20',162,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1437160,-34.9077920,11.0,'2021-04-20',158,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436680,-34.9078790,11.0,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436170,-34.9079590,10.9,'2021-04-20',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436030,-34.9079910,10.9,'2021-04-20',159,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435660,-34.9080520,10.9,'2021-04-20',164,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435360,-34.9082170,10.9,'2021-04-20',167,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435000,-34.9083650,10.9,'2021-04-20',168,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1434310,-34.9085710,11.5,'2021-04-20',170,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1434100,-34.9086030,11.5,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1433940,-34.9086410,11.5,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432750,-34.9087940,11.4,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432230,-34.9088550,11.4,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1431700,-34.9089090,11.4,'2021-04-20',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1431450,-34.9089330,11.4,'2021-04-20',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1431150,-34.9089580,11.4,'2021-04-20',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1430520,-34.9090030,11.3,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429850,-34.9091910,11.2,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429340,-34.9092910,11.1,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428160,-34.9094580,8.5,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428120,-34.9094750,10.2,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428220,-34.9095050,11.3,'2021-04-20',146,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428070,-34.9095250,12.2,'2021-04-20',141,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1427940,-34.9095750,12.9,'2021-04-20',138,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428010,-34.9095930,12.9,'2021-04-20',138,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429240,-34.9097020,12.9,'2021-04-20',138,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1431390,-34.9098030,12.7,'2021-04-20',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432110,-34.9098350,12.6,'2021-04-20',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432490,-34.9098570,12.6,'2021-04-20',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432850,-34.9098800,12.6,'2021-04-20',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1433500,-34.9099200,12.5,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435070,-34.9100390,12.4,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435330,-34.9100620,12.4,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435940,-34.9101030,12.3,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1437720,-34.9102530,12.3,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438000,-34.9102820,12.3,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438850,-34.9103590,12.3,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440330,-34.9104810,12.5,'2021-04-20',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440600,-34.9105060,12.5,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440910,-34.9105300,12.5,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441160,-34.9105540,12.6,'2021-04-20',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441460,-34.9105770,12.6,'2021-04-20',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441710,-34.9106010,12.7,'2021-04-20',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442470,-34.9106800,12.8,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443740,-34.9108090,13.0,'2021-04-20',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445460,-34.9109440,13.3,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447170,-34.9110740,13.5,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448380,-34.9111620,13.6,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448930,-34.9112050,13.6,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450220,-34.9113300,13.7,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450500,-34.9113560,13.7,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1452340,-34.9115010,13.9,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1454030,-34.9116460,14.1,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1454350,-34.9116690,14.1,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1455970,-34.9118090,14.3,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1457550,-34.9119510,14.4,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1459150,-34.9120950,14.4,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1460830,-34.9122490,14.4,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462460,-34.9123760,14.4,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1464100,-34.9125290,14.3,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1465530,-34.9126720,14.1,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1467110,-34.9128350,14.0,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1468660,-34.9130070,13.9,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1470140,-34.9131710,13.9,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1471480,-34.9133470,13.8,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1472940,-34.9135000,13.7,'2021-04-20',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1474650,-34.9136490,13.7,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1476350,-34.9137910,13.6,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1477930,-34.9139460,13.5,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1479460,-34.9141010,13.4,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1480880,-34.9142500,13.4,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1482630,-34.9143960,13.4,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484090,-34.9145380,13.3,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1485350,-34.9147090,13.2,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486140,-34.9148860,13.2,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486570,-34.9150840,13.3,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487320,-34.9152840,13.3,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487920,-34.9154820,13.3,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488600,-34.9156890,13.1,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489220,-34.9158930,12.8,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489740,-34.9160990,12.7,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489990,-34.9162960,12.8,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490240,-34.9165040,13.0,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490310,-34.9167190,13.3,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490210,-34.9169250,13.5,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490310,-34.9171120,13.5,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490140,-34.9173110,13.4,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489910,-34.9174990,13.4,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489450,-34.9177130,13.2,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488790,-34.9179200,13.0,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487910,-34.9181060,12.8,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487720,-34.9182820,12.6,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486840,-34.9184670,12.6,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486410,-34.9186690,12.6,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486540,-34.9188770,12.5,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486880,-34.9190820,12.6,'2021-04-20',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487660,-34.9192780,12.8,'2021-04-20',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488160,-34.9194780,12.8,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488620,-34.9196760,12.8,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489300,-34.9198650,12.7,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490170,-34.9200660,12.5,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490990,-34.9202600,12.4,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1491740,-34.9204530,12.7,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1492150,-34.9206550,12.9,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1492850,-34.9208380,13.0,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1494070,-34.9210120,13.1,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1495530,-34.9211690,13.2,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1497290,-34.9212970,13.4,'2021-04-20',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1498920,-34.9214360,13.5,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1500840,-34.9215580,13.7,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1502560,-34.9216970,13.8,'2021-04-20',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1504440,-34.9218210,13.7,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1506330,-34.9219490,13.7,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1508220,-34.9220890,13.7,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1509920,-34.9222330,13.8,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1511660,-34.9223580,13.8,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1513370,-34.9224730,13.8,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1515200,-34.9226020,13.8,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1517190,-34.9227350,13.9,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1519110,-34.9228690,13.9,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1520980,-34.9229930,13.9,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1522700,-34.9231300,13.9,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1524370,-34.9232640,13.9,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1526120,-34.9233960,13.9,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1528130,-34.9235160,13.9,'2021-04-20',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1530020,-34.9236540,13.9,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1531880,-34.9238020,13.9,'2021-04-20',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1533670,-34.9239480,13.9,'2021-04-20',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1535550,-34.9240750,13.9,'2021-04-20',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1537560,-34.9242120,13.9,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1539140,-34.9243370,13.9,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1540960,-34.9244750,14.0,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1542720,-34.9246080,14.0,'2021-04-20',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1544540,-34.9247390,14.0,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1546380,-34.9248520,14.0,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1548300,-34.9249850,14.0,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1550070,-34.9251240,14.1,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1551980,-34.9252580,14.2,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1553940,-34.9253980,14.2,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1556040,-34.9255190,14.2,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1557900,-34.9256550,14.0,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1559630,-34.9257980,13.9,'2021-04-20',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1561000,-34.9259070,13.8,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1562870,-34.9260430,13.7,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1564630,-34.9261750,13.7,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1566410,-34.9263110,13.8,'2021-04-20',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1568100,-34.9264400,13.9,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1569860,-34.9265730,13.9,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1571710,-34.9267030,13.9,'2021-04-20',159,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1573370,-34.9268350,13.7,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1575220,-34.9269810,13.6,'2021-04-20',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1576960,-34.9271260,13.5,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1578800,-34.9272710,13.5,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1580690,-34.9274030,13.6,'2021-04-20',158,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1582510,-34.9275450,13.5,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1584180,-34.9276650,13.4,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1585770,-34.9277890,13.4,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1587330,-34.9279180,13.4,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1589070,-34.9280650,13.4,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1590760,-34.9282120,13.3,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1592500,-34.9283500,13.2,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1593990,-34.9284580,13.1,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1595810,-34.9285970,13.0,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1597540,-34.9287120,12.9,'2021-04-20',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1599680,-34.9286960,10.9,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1601700,-34.9287730,10.7,'2021-04-20',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1603500,-34.9288840,10.6,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1605730,-34.9289320,10.6,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1607830,-34.9288510,10.6,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1610050,-34.9287880,10.8,'2021-04-20',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1612270,-34.9287530,11.0,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1613230,-34.9286870,13.6,'2021-04-20',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1613840,-34.9285840,14.6,'2021-04-20',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1613920,-34.9284000,15.3,'2021-04-20',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614020,-34.9282680,15.8,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614210,-34.9281260,16.3,'2021-04-20',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614280,-34.9280000,16.8,'2021-04-20',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614420,-34.9278600,17.4,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614720,-34.9276630,18.3,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614990,-34.9274690,19.1,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615330,-34.9272700,19.9,'2021-04-20',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615730,-34.9271210,20.4,'2021-04-20',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615690,-34.9269310,21.1,'2021-04-20',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615890,-34.9267340,21.8,'2021-04-20',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616180,-34.9265480,22.5,'2021-04-20',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616390,-34.9263510,23.2,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616520,-34.9261450,24.0,'2021-04-20',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616870,-34.9259460,24.7,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617370,-34.9257380,25.3,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617390,-34.9255440,25.8,'2021-04-20',171,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617650,-34.9253390,26.6,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617580,-34.9251350,27.4,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617870,-34.9249570,28.2,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617970,-34.9247570,28.9,'2021-04-20',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618160,-34.9245400,29.7,'2021-04-20',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618240,-34.9243550,30.4,'2021-04-20',169,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618450,-34.9241550,31.0,'2021-04-20',170,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618580,-34.9239630,31.7,'2021-04-20',170,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618520,-34.9237600,32.3,'2021-04-20',170,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618760,-34.9235640,32.9,'2021-04-20',170,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619210,-34.9233660,33.3,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619840,-34.9231630,33.7,'2021-04-20',171,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619890,-34.9231320,33.8,'2021-04-20',171,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620240,-34.9229360,34.1,'2021-04-20',171,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620700,-34.9227420,34.3,'2021-04-20',170,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620600,-34.9226590,34.4,'2021-04-20',167,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620620,-34.9226390,34.4,'2021-04-20',167,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620640,-34.9225960,34.4,'2021-04-20',164,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620770,-34.9225120,34.5,'2021-04-20',161,82)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621250,-34.9226020,34.4,'2021-04-20',160,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621170,-34.9226610,34.4,'2021-04-20',157,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621090,-34.9228090,34.2,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621170,-34.9229960,34.0,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620780,-34.9231990,33.6,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620600,-34.9233830,33.3,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620590,-34.9235700,32.9,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620430,-34.9237510,32.4,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620220,-34.9239560,31.7,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620230,-34.9241630,31.1,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620240,-34.9243730,30.4,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619870,-34.9245540,29.7,'2021-04-20',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619660,-34.9247370,29.0,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619820,-34.9249290,28.3,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619540,-34.9250880,27.7,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619390,-34.9252750,26.9,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619340,-34.9254650,26.2,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618860,-34.9256470,25.5,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618320,-34.9258440,25.1,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617680,-34.9260390,24.4,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617810,-34.9262310,23.7,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617780,-34.9264470,22.9,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617590,-34.9266300,22.2,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617390,-34.9268310,21.5,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617210,-34.9270430,20.7,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617220,-34.9272570,20.0,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616890,-34.9274630,19.2,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616890,-34.9276540,18.4,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616890,-34.9278350,17.6,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616790,-34.9280190,16.8,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616290,-34.9281970,16.1,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615650,-34.9283920,15.4,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615640,-34.9286050,14.0,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615910,-34.9287870,11.2,'2021-04-20',146,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614970,-34.9286940,13.2,'2021-04-20',145,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614710,-34.9285100,15.3,'2021-04-20',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614820,-34.9282970,15.7,'2021-04-20',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614710,-34.9281140,16.4,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614830,-34.9280180,16.8,'2021-04-20',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614620,-34.9278080,17.7,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614880,-34.9276250,18.5,'2021-04-20',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614920,-34.9274930,19.0,'2021-04-20',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614920,-34.9273840,19.4,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615280,-34.9272620,19.9,'2021-04-20',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615710,-34.9271020,20.5,'2021-04-20',168,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616050,-34.9269120,21.1,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616010,-34.9266970,21.9,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616470,-34.9265140,22.6,'2021-04-20',170,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616880,-34.9263000,23.5,'2021-04-20',170,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616830,-34.9261170,24.1,'2021-04-20',171,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617210,-34.9259280,24.8,'2021-04-20',172,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617570,-34.9257470,25.3,'2021-04-20',173,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617470,-34.9255650,25.8,'2021-04-20',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617310,-34.9253620,26.5,'2021-04-20',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617230,-34.9251650,27.3,'2021-04-20',174,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617340,-34.9249560,28.2,'2021-04-20',175,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617800,-34.9247710,28.8,'2021-04-20',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617650,-34.9245800,29.6,'2021-04-20',175,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617730,-34.9243740,30.3,'2021-04-20',177,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617920,-34.9241840,30.9,'2021-04-20',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618290,-34.9239870,31.6,'2021-04-20',178,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618500,-34.9237860,32.2,'2021-04-20',179,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618910,-34.9235800,32.8,'2021-04-20',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619360,-34.9233880,33.3,'2021-04-20',179,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619560,-34.9231890,33.6,'2021-04-20',178,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619860,-34.9230080,34.0,'2021-04-20',177,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620210,-34.9228120,34.2,'2021-04-20',177,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620500,-34.9226420,34.4,'2021-04-20',174,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620630,-34.9226290,34.4,'2021-04-20',173,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621100,-34.9227260,34.3,'2021-04-20',170,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621100,-34.9228060,34.2,'2021-04-20',169,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621110,-34.9228880,34.1,'2021-04-20',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620760,-34.9230720,33.9,'2021-04-20',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620630,-34.9232690,33.5,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620350,-34.9234590,33.2,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619940,-34.9236390,32.7,'2021-04-20',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619770,-34.9238420,32.1,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619810,-34.9240440,31.4,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619990,-34.9242360,30.8,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619720,-34.9244470,30.1,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619700,-34.9246610,29.3,'2021-04-20',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619520,-34.9248570,28.6,'2021-04-20',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619410,-34.9250400,27.9,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619240,-34.9252220,27.1,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618730,-34.9254350,26.3,'2021-04-20',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618340,-34.9256420,25.5,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617860,-34.9258300,25.1,'2021-04-20',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617780,-34.9260230,24.5,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617690,-34.9262060,23.8,'2021-04-20',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617740,-34.9263880,23.2,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617630,-34.9265740,22.4,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617320,-34.9267600,21.7,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617430,-34.9269730,21.0,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617330,-34.9271600,20.3,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617010,-34.9273410,19.6,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616650,-34.9275200,18.9,'2021-04-20',152,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616610,-34.9277080,18.2,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616540,-34.9279160,17.3,'2021-04-20',151,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616390,-34.9281130,16.4,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615930,-34.9283240,15.7,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615890,-34.9285120,15.3,'2021-04-20',150,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615850,-34.9287190,15.3,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616060,-34.9287500,15.3,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615670,-34.9287720,15.3,'2021-04-20',146,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615380,-34.9287570,15.3,'2021-04-20',143,61)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614900,-34.9286810,15.3,'2021-04-20',140,61)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614530,-34.9284950,15.3,'2021-04-20',139,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614470,-34.9283410,15.6,'2021-04-20',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614590,-34.9282600,15.9,'2021-04-20',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614890,-34.9281390,16.3,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615210,-34.9280480,16.7,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615510,-34.9278590,17.5,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615600,-34.9277010,18.2,'2021-04-20',156,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615720,-34.9275150,18.9,'2021-04-20',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616000,-34.9273860,19.4,'2021-04-20',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616210,-34.9271840,20.2,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616340,-34.9269640,21.0,'2021-04-20',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616260,-34.9267550,21.7,'2021-04-20',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616340,-34.9265370,22.5,'2021-04-20',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616760,-34.9263460,23.3,'2021-04-20',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616820,-34.9261610,24.0,'2021-04-20',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617050,-34.9259710,24.6,'2021-04-20',171,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617350,-34.9257890,25.2,'2021-04-20',171,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617530,-34.9255950,25.6,'2021-04-20',171,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617510,-34.9253840,26.4,'2021-04-20',172,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617510,-34.9251910,27.2,'2021-04-20',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617470,-34.9250030,28.0,'2021-04-20',174,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617730,-34.9247910,28.8,'2021-04-20',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617860,-34.9245970,29.5,'2021-04-20',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618210,-34.9244150,30.2,'2021-04-20',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618510,-34.9242050,30.9,'2021-04-20',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618880,-34.9240000,31.6,'2021-04-20',178,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619210,-34.9237910,32.2,'2021-04-20',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619490,-34.9236020,32.8,'2021-04-20',175,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619750,-34.9234140,33.3,'2021-04-20',175,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620050,-34.9232070,33.6,'2021-04-20',175,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620370,-34.9230100,34.0,'2021-04-20',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620440,-34.9228320,34.2,'2021-04-20',172,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620550,-34.9227530,34.3,'2021-04-20',169,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620800,-34.9226290,34.4,'2021-04-20',166,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621130,-34.9227050,34.3,'2021-04-20',164,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621240,-34.9229010,34.2,'2021-04-20',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621200,-34.9230490,33.9,'2021-04-20',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620740,-34.9232340,33.6,'2021-04-20',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620700,-34.9234290,33.2,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620390,-34.9236360,32.7,'2021-04-20',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620370,-34.9238430,32.1,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620650,-34.9240340,31.5,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620520,-34.9242210,30.9,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619840,-34.9244300,30.1,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619400,-34.9246100,29.5,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619200,-34.9247980,28.8,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618780,-34.9249960,28.0,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618730,-34.9252080,27.2,'2021-04-20',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618030,-34.9254120,26.3,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618070,-34.9256080,25.6,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617510,-34.9258050,25.2,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617430,-34.9259900,24.6,'2021-04-20',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617610,-34.9262240,23.8,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617470,-34.9264060,23.1,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617260,-34.9265920,22.4,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616740,-34.9268090,21.5,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616710,-34.9270090,20.8,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616560,-34.9272060,20.2,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616430,-34.9274040,19.4,'2021-04-20',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616230,-34.9276150,18.6,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616480,-34.9278090,17.7,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616480,-34.9280260,16.8,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616430,-34.9280550,16.7,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616310,-34.9281890,16.2,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616210,-34.9283900,15.4,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615570,-34.9285850,14.6,'2021-04-20',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615650,-34.9287040,13.0,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615640,-34.9287600,11.6,'2021-04-20',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614680,-34.9286740,13.1,'2021-04-20',144,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614740,-34.9284860,15.3,'2021-04-20',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614720,-34.9282990,15.7,'2021-04-20',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614840,-34.9280990,16.5,'2021-04-20',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614860,-34.9279050,17.3,'2021-04-20',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615090,-34.9277230,18.1,'2021-04-20',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615410,-34.9275340,18.8,'2021-04-20',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615640,-34.9273340,19.6,'2021-04-20',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615890,-34.9271510,20.3,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616140,-34.9269670,21.0,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616250,-34.9267860,21.6,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616300,-34.9265950,22.3,'2021-04-20',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616320,-34.9263840,23.1,'2021-04-20',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616450,-34.9261840,23.9,'2021-04-20',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616880,-34.9259750,24.6,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617360,-34.9257790,25.2,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617530,-34.9255920,25.7,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617760,-34.9253970,26.4,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617600,-34.9251990,27.2,'2021-04-20',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617530,-34.9249880,28.0,'2021-04-20',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617900,-34.9248020,28.7,'2021-04-20',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617980,-34.9245960,29.5,'2021-04-20',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618190,-34.9243900,30.2,'2021-04-20',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618350,-34.9242030,30.9,'2021-04-20',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618660,-34.9240140,31.5,'2021-04-20',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619170,-34.9238270,32.1,'2021-04-20',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619420,-34.9236280,32.7,'2021-04-20',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619900,-34.9234290,33.2,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619880,-34.9232450,33.5,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620380,-34.9230520,33.9,'2021-04-20',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620730,-34.9228530,34.2,'2021-04-20',163,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620860,-34.9226680,34.4,'2021-04-20',162,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620740,-34.9225520,34.5,'2021-04-20',159,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620940,-34.9225180,34.4,'2021-04-20',158,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621560,-34.9225640,34.4,'2021-04-20',155,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621630,-34.9226190,34.4,'2021-04-20',155,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621820,-34.9228010,34.2,'2021-04-20',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621900,-34.9229830,34.0,'2021-04-20',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621420,-34.9231810,33.6,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621000,-34.9233870,33.3,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620980,-34.9235890,32.8,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621060,-34.9237950,32.3,'2021-04-20',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620850,-34.9239970,31.6,'2021-04-20',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620690,-34.9241850,31.0,'2021-04-20',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1621000,-34.9243890,30.3,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620870,-34.9245970,29.6,'2021-04-20',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1620720,-34.9248010,28.8,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619920,-34.9249950,28.1,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619560,-34.9252060,27.2,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1619130,-34.9253890,26.4,'2021-04-20',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1618620,-34.9256060,25.6,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617740,-34.9257720,25.2,'2021-04-20',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617590,-34.9259610,24.7,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617740,-34.9261050,24.2,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617800,-34.9262880,23.5,'2021-04-20',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617770,-34.9264970,22.7,'2021-04-20',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617340,-34.9266990,22.0,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617260,-34.9269040,21.2,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1617130,-34.9270890,20.6,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616400,-34.9272790,19.9,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616380,-34.9273220,19.7,'2021-04-20',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616440,-34.9275180,18.9,'2021-04-20',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616570,-34.9277110,18.2,'2021-04-20',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616390,-34.9278920,17.4,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616400,-34.9280970,16.5,'2021-04-20',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616530,-34.9282790,15.8,'2021-04-20',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1616300,-34.9284720,15.3,'2021-04-20',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1615670,-34.9286220,13.8,'2021-04-20',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1614000,-34.9287480,11.1,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1612190,-34.9288770,10.9,'2021-04-20',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1610200,-34.9289870,10.7,'2021-04-20',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1607970,-34.9290360,10.6,'2021-04-20',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1605700,-34.9290220,10.6,'2021-04-20',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1603330,-34.9290570,13.5,'2021-04-20',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1600870,-34.9290550,12.8,'2021-04-20',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1598840,-34.9289440,12.9,'2021-04-20',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1596960,-34.9287970,13.0,'2021-04-20',151,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1595330,-34.9286650,13.1,'2021-04-20',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1593580,-34.9285230,13.2,'2021-04-20',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1591960,-34.9283810,13.2,'2021-04-20',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1590550,-34.9282540,13.2,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1588920,-34.9281110,13.2,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1587290,-34.9279770,13.2,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1585560,-34.9278280,13.2,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1583880,-34.9276970,13.1,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1582040,-34.9275670,13.0,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1580200,-34.9274450,13.0,'2021-04-20',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1578290,-34.9273110,13.0,'2021-04-20',164,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1576680,-34.9271760,13.0,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1574990,-34.9270360,13.0,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1573300,-34.9269090,13.1,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1571580,-34.9267650,13.1,'2021-04-20',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1569780,-34.9266280,13.1,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1568040,-34.9264810,13.2,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1566210,-34.9263590,13.2,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1564500,-34.9262240,13.3,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1562570,-34.9260810,13.3,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1560830,-34.9259670,13.3,'2021-04-20',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1559070,-34.9258560,13.3,'2021-04-20',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1557120,-34.9257190,13.3,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1555170,-34.9255860,13.3,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1553500,-34.9254610,13.4,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1551640,-34.9253110,13.4,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1549680,-34.9251730,13.5,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1547950,-34.9250410,13.6,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1546140,-34.9249030,13.6,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1544210,-34.9247590,13.5,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1542320,-34.9246190,13.6,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1540560,-34.9245020,13.7,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1538710,-34.9243630,13.8,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1537070,-34.9242420,13.8,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1535280,-34.9241150,13.8,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1533510,-34.9239770,13.9,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1531600,-34.9238620,14.0,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1529880,-34.9237170,14.1,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1528030,-34.9236010,14.1,'2021-04-20',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1526300,-34.9234740,14.1,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1524470,-34.9233530,14.1,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1522770,-34.9232400,14.1,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1520860,-34.9231040,14.2,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1519000,-34.9229670,14.3,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1517140,-34.9228350,14.3,'2021-04-20',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1515130,-34.9227150,14.4,'2021-04-20',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1513090,-34.9225960,14.4,'2021-04-20',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1511580,-34.9224640,14.4,'2021-04-20',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1509920,-34.9222980,14.5,'2021-04-20',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1508370,-34.9221660,14.5,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1506620,-34.9220380,14.6,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1504720,-34.9219320,14.7,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1503000,-34.9217800,14.7,'2021-04-20',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1501330,-34.9216210,15.1,'2021-04-20',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1499460,-34.9214870,15.2,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1497610,-34.9213680,15.3,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1495840,-34.9212490,15.3,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1494010,-34.9211170,15.3,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1492520,-34.9209820,15.3,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1491360,-34.9208200,15.5,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1490410,-34.9206240,16.1,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1489730,-34.9204340,14.9,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488940,-34.9202430,13.7,'2021-04-20',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487690,-34.9200810,13.0,'2021-04-20',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486920,-34.9199070,13.9,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486290,-34.9197160,14.9,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1485630,-34.9195330,15.8,'2021-04-20',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484940,-34.9193390,15.9,'2021-04-20',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484410,-34.9191460,15.8,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484000,-34.9189520,15.7,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1483800,-34.9187520,15.6,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1483870,-34.9185570,15.6,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484730,-34.9183690,15.5,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1485550,-34.9181880,15.3,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486230,-34.9180040,15.1,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486850,-34.9178270,15.0,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487520,-34.9176500,14.8,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487880,-34.9174490,14.7,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487870,-34.9172550,14.8,'2021-04-20',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1488120,-34.9170720,14.8,'2021-04-20',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487790,-34.9168800,14.7,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487760,-34.9166780,14.6,'2021-04-20',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487740,-34.9164800,14.6,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487800,-34.9162860,14.6,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1487430,-34.9160820,14.6,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486950,-34.9158920,14.5,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1486340,-34.9157070,14.5,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1485710,-34.9155090,14.5,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1485210,-34.9153270,14.5,'2021-04-20',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1484530,-34.9151250,14.5,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1483930,-34.9149250,14.5,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1483240,-34.9147410,14.6,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1482370,-34.9145660,14.6,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1480840,-34.9144330,14.7,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1479530,-34.9142530,14.8,'2021-04-20',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1477990,-34.9141000,14.8,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1476460,-34.9139370,14.9,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1475080,-34.9137840,15.0,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1473590,-34.9136250,15.0,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1472140,-34.9134780,15.1,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1470720,-34.9133380,15.2,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1469400,-34.9131890,15.3,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1468000,-34.9130190,15.5,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1466650,-34.9128540,15.6,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1465390,-34.9127040,15.7,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463740,-34.9125650,15.7,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1461940,-34.9124300,15.7,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1460250,-34.9123040,15.7,'2021-04-20',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1458540,-34.9121590,15.6,'2021-04-20',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1456870,-34.9120180,15.5,'2021-04-20',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1455290,-34.9118660,15.3,'2021-04-20',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1453770,-34.9117030,15.2,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451980,-34.9115490,15.0,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450360,-34.9113970,14.7,'2021-04-20',162,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448780,-34.9112500,14.5,'2021-04-20',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447100,-34.9110980,14.2,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445780,-34.9109410,13.9,'2021-04-20',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445200,-34.9108760,13.8,'2021-04-20',159,48)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445320,-34.9107830,13.7,'2021-04-20',156,49)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445300,-34.9107650,13.6,'2021-04-20',156,49)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444860,-34.9107150,13.6,'2021-04-20',152,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444730,-34.9106890,13.5,'2021-04-20',151,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444740,-34.9106520,13.5,'2021-04-20',148,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444290,-34.9105580,13.3,'2021-04-20',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443780,-34.9105030,13.3,'2021-04-20',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442380,-34.9103470,13.2,'2021-04-20',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441160,-34.9102150,9.1,'2021-04-20',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439460,-34.9100730,9.2,'2021-04-20',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438030,-34.9099130,9.3,'2021-04-20',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436070,-34.9097930,9.4,'2021-04-20',140,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1434120,-34.9096570,9.5,'2021-04-20',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432130,-34.9095630,9.7,'2021-04-20',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1430390,-34.9094140,10.0,'2021-04-20',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428700,-34.9092810,11.0,'2021-04-20',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1428590,-34.9092740,11.0,'2021-04-20',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429120,-34.9090580,11.2,'2021-04-20',133,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429430,-34.9090150,11.3,'2021-04-20',130,62)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1429870,-34.9088280,11.4,'2021-04-20',129,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1430490,-34.9087330,11.4,'2021-04-20',129,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1431600,-34.9085590,11.5,'2021-04-20',127,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1432780,-34.9083970,11.2,'2021-04-20',129,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1433410,-34.9083640,11.1,'2021-04-20',129,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1433470,-34.9083190,11.0,'2021-04-20',129,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1434670,-34.9081590,10.9,'2021-04-20',130,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435930,-34.9079990,10.9,'2021-04-20',132,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436570,-34.9078190,11.0,'2021-04-20',133,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435670,-34.9076280,11.1,'2021-04-20',133,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1435550,-34.9074880,11.3,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1436070,-34.9072880,11.6,'2021-04-20',133,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1437050,-34.9071000,12.1,'2021-04-20',133,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1437500,-34.9068890,12.8,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1438650,-34.9067270,13.5,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439540,-34.9066480,13.9,'2021-04-20',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1439670,-34.9065590,14.3,'2021-04-20',135,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440330,-34.9064070,15.3,'2021-04-20',138,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1440870,-34.9062120,16.7,'2021-04-20',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441050,-34.9061360,17.2,'2021-04-20',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441650,-34.9059580,18.6,'2021-04-20',143,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1441870,-34.9059280,18.8,'2021-04-20',143,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442420,-34.9057670,19.8,'2021-04-20',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1442800,-34.9055740,20.7,'2021-04-20',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443300,-34.9053910,21.4,'2021-04-20',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443670,-34.9051910,22.1,'2021-04-20',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1443940,-34.9050100,22.5,'2021-04-20',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1444630,-34.9048210,22.8,'2021-04-20',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1445280,-34.9046300,23.1,'2021-04-20',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1446560,-34.9044920,23.5,'2021-04-20',143,42)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447010,-34.9044230,23.7,'2021-04-20',141,59)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1447590,-34.9043290,24.1,'2021-04-20',138,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448010,-34.9042660,24.4,'2021-04-20',135,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448570,-34.9040890,25.1,'2021-04-20',133,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1448830,-34.9040290,25.3,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449260,-34.9038890,26.1,'2021-04-20',136,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449290,-34.9038520,26.3,'2021-04-20',136,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449860,-34.9037220,27.2,'2021-04-20',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450450,-34.9035760,28.0,'2021-04-20',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450540,-34.9035440,28.2,'2021-04-20',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450010,-34.9033220,28.8,'2021-04-20',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450000,-34.9032700,28.8,'2021-04-20',140,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450050,-34.9030850,28.9,'2021-04-20',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449950,-34.9028830,28.7,'2021-04-20',136,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1449980,-34.9028030,28.6,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450030,-34.9027980,28.5,'2021-04-20',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450200,-34.9027970,28.5,'2021-04-20',133,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1450610,-34.9027770,28.4,'2021-04-20',131,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451440,-34.9027270,27.6,'2021-04-20',128,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1451860,-34.9027240,27.5,'2021-04-20',128,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1452690,-34.9027250,27.2,'2021-04-20',125,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1453360,-34.9027090,27.0,'2021-04-20',122,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1454260,-34.9026930,26.7,'2021-04-20',119,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1456460,-34.9027100,26.0,'2021-04-20',120,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1458090,-34.9027200,25.2,'2021-04-20',121,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1459530,-34.9025480,22.9,'2021-04-20',123,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1460240,-34.9023760,21.9,'2021-04-20',124,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1460950,-34.9022210,21.2,'2021-04-20',127,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1461450,-34.9020410,20.5,'2021-04-20',128,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462020,-34.9018640,19.8,'2021-04-20',128,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462570,-34.9016670,19.2,'2021-04-20',130,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462530,-34.9015230,19.0,'2021-04-20',133,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462810,-34.9013230,18.9,'2021-04-20',135,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1462850,-34.9011310,19.4,'2021-04-20',135,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463130,-34.9010270,19.9,'2021-04-20',138,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463510,-34.9008670,20.7,'2021-04-20',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (2,-56.1463620,-34.9008090,21.1,'2021-04-20',143,86)"; db.execSQL(queryInsert);

        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1475780,-34.9002400,26.0,'2021-04-16',88,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1476160,-34.9002520,25.9,'2021-04-16',91,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1476740,-34.9002580,25.9,'2021-04-16',95,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1477630,-34.9002570,25.7,'2021-04-16',99,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1478420,-34.9002550,25.5,'2021-04-16',102,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1479660,-34.9002500,25.0,'2021-04-16',106,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1480810,-34.9002390,24.4,'2021-04-16',109,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1481580,-34.9002380,24.0,'2021-04-16',112,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1482800,-34.9002500,23.3,'2021-04-16',115,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1483970,-34.9002460,22.6,'2021-04-16',119,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1485140,-34.9002590,22.0,'2021-04-16',122,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1487000,-34.9002820,21.2,'2021-04-16',125,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1489440,-34.9003460,20.4,'2021-04-16',126,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1491730,-34.9003330,19.6,'2021-04-16',126,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1493720,-34.9003160,18.9,'2021-04-16',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1494120,-34.9003320,18.7,'2021-04-16',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1495840,-34.9003680,17.9,'2021-04-16',131,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1498270,-34.9004120,16.8,'2021-04-16',131,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1499970,-34.9004250,16.2,'2021-04-16',134,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1502020,-34.9004160,15.5,'2021-04-16',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1504410,-34.9004320,15.3,'2021-04-16',138,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1506640,-34.9004730,15.8,'2021-04-16',138,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1508860,-34.9004720,16.7,'2021-04-16',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510500,-34.9003570,18.5,'2021-04-16',138,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511750,-34.9001960,18.8,'2021-04-16',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512840,-34.9000250,19.2,'2021-04-16',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513600,-34.8998520,19.4,'2021-04-16',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514580,-34.8996630,19.9,'2021-04-16',143,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514900,-34.8994620,20.4,'2021-04-16',144,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515400,-34.8993710,20.5,'2021-04-16',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516510,-34.8991890,20.6,'2021-04-16',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517580,-34.8990280,20.7,'2021-04-16',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518460,-34.8988320,20.9,'2021-04-16',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519220,-34.8986630,21.1,'2021-04-16',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519660,-34.8984530,21.4,'2021-04-16',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519480,-34.8982590,21.6,'2021-04-16',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518940,-34.8980830,21.5,'2021-04-16',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518960,-34.8978940,21.4,'2021-04-16',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517990,-34.8977040,21.9,'2021-04-16',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517140,-34.8975100,22.4,'2021-04-16',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516240,-34.8973420,23.0,'2021-04-16',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515230,-34.8971740,23.7,'2021-04-16',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514170,-34.8970080,24.5,'2021-04-16',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513550,-34.8968290,25.3,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513670,-34.8966180,26.0,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513680,-34.8965870,26.1,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513920,-34.8964050,26.6,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514010,-34.8962210,27.9,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513140,-34.8960370,29.1,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511950,-34.8958820,29.8,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510810,-34.8957260,30.2,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510370,-34.8955380,31.1,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510350,-34.8953450,32.0,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510850,-34.8951650,32.9,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511020,-34.8949780,33.8,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511210,-34.8947750,34.8,'2021-04-16',159,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511220,-34.8945870,35.6,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511140,-34.8943920,36.5,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511360,-34.8941860,37.3,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512000,-34.8939890,38.0,'2021-04-16',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512670,-34.8937960,38.6,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514070,-34.8936500,39.1,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515850,-34.8935430,39.3,'2021-04-16',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517680,-34.8934230,39.6,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519750,-34.8933020,39.8,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521870,-34.8932010,40.0,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1523990,-34.8930890,40.2,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1525960,-34.8929700,40.3,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1528080,-34.8928590,40.4,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1530110,-34.8927430,40.6,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1532190,-34.8926470,40.8,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1534240,-34.8925590,41.0,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1536340,-34.8924750,41.1,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1538310,-34.8923770,41.3,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1540290,-34.8922740,42.0,'2021-04-16',153,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542330,-34.8921800,42.6,'2021-04-16',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1543570,-34.8921350,42.8,'2021-04-16',151,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1545450,-34.8920410,42.9,'2021-04-16',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1547520,-34.8919500,43.2,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1549630,-34.8918870,43.5,'2021-04-16',153,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1551470,-34.8917780,43.8,'2021-04-16',153,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1553520,-34.8916690,44.1,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1555900,-34.8915900,44.2,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1558440,-34.8916210,43.9,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1560590,-34.8916990,43.5,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1562930,-34.8917870,42.9,'2021-04-16',151,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1565440,-34.8918250,42.2,'2021-04-16',148,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1567860,-34.8918500,41.6,'2021-04-16',148,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570240,-34.8918840,41.0,'2021-04-16',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1572590,-34.8919100,40.8,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1574780,-34.8919550,40.5,'2021-04-16',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1576790,-34.8920000,40.2,'2021-04-16',146,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1578860,-34.8920800,39.9,'2021-04-16',146,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1580970,-34.8921830,39.9,'2021-04-16',148,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1582920,-34.8923040,40.1,'2021-04-16',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1584440,-34.8924400,39.3,'2021-04-16',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585350,-34.8926420,38.7,'2021-04-16',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586090,-34.8928430,38.1,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586890,-34.8930430,37.8,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587680,-34.8932160,37.5,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588480,-34.8933680,37.2,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589240,-34.8935570,36.9,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589980,-34.8937580,36.5,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590500,-34.8939440,36.1,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591380,-34.8941460,35.8,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592170,-34.8943470,35.6,'2021-04-16',154,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593070,-34.8945340,35.5,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593660,-34.8947120,35.8,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593690,-34.8949130,36.1,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593340,-34.8951140,36.5,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592840,-34.8953010,36.8,'2021-04-16',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592180,-34.8955000,36.8,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591060,-34.8956660,36.8,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590220,-34.8958400,36.8,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590360,-34.8960460,36.8,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590750,-34.8962460,36.7,'2021-04-16',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590290,-34.8964310,36.6,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589950,-34.8966350,36.3,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589600,-34.8968260,35.8,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588710,-34.8970020,35.3,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587120,-34.8971430,34.5,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585230,-34.8972760,33.5,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1583510,-34.8974210,32.3,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581560,-34.8975640,31.1,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579830,-34.8976980,30.3,'2021-04-16',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1578160,-34.8978400,29.4,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1576510,-34.8979740,28.8,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1576170,-34.8979880,28.8,'2021-04-16',148,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1574840,-34.8979790,28.5,'2021-04-16',145,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573710,-34.8981190,28.0,'2021-04-16',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1572280,-34.8982660,27.3,'2021-04-16',147,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570270,-34.8983940,26.5,'2021-04-16',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568470,-34.8985370,25.7,'2021-04-16',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1566540,-34.8986820,25.0,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1564400,-34.8987500,24.6,'2021-04-16',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1562110,-34.8987660,24.3,'2021-04-16',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1559880,-34.8987780,24.1,'2021-04-16',149,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1557630,-34.8987820,23.9,'2021-04-16',148,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1555070,-34.8987410,23.7,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1552530,-34.8987220,23.6,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1550030,-34.8986800,23.2,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1547760,-34.8986380,22.9,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1545240,-34.8986210,22.5,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542700,-34.8986040,22.1,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1540470,-34.8985890,21.9,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1538290,-34.8985450,21.6,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1535740,-34.8984990,21.4,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1533260,-34.8984550,21.2,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1531180,-34.8983950,21.1,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1528850,-34.8983790,20.9,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1526480,-34.8983870,20.8,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1524190,-34.8983390,20.8,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1522520,-34.8982190,20.9,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521250,-34.8980480,21.0,'2021-04-16',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519930,-34.8978810,21.4,'2021-04-16',160,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518790,-34.8977120,21.8,'2021-04-16',160,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518060,-34.8975270,22.3,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517100,-34.8973590,22.9,'2021-04-16',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516110,-34.8971950,23.5,'2021-04-16',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514920,-34.8970110,24.4,'2021-04-16',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514030,-34.8968120,25.3,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513800,-34.8966180,26.0,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513970,-34.8964180,26.6,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514090,-34.8962250,27.9,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513580,-34.8960280,29.1,'2021-04-16',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512450,-34.8958660,29.8,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511270,-34.8957010,30.3,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510490,-34.8955110,31.2,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510390,-34.8953080,32.2,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510470,-34.8951090,33.2,'2021-04-16',169,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510610,-34.8949230,34.1,'2021-04-16',169,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510830,-34.8947320,35.0,'2021-04-16',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511080,-34.8945480,35.8,'2021-04-16',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511260,-34.8943560,36.6,'2021-04-16',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511520,-34.8941710,37.3,'2021-04-16',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512130,-34.8939860,38.0,'2021-04-16',168,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512690,-34.8937890,38.7,'2021-04-16',170,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514360,-34.8936270,39.1,'2021-04-16',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516250,-34.8935180,39.4,'2021-04-16',169,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518040,-34.8934100,39.6,'2021-04-16',168,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1520270,-34.8933060,39.9,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1522350,-34.8932080,40.1,'2021-04-16',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1524460,-34.8930860,40.2,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1526710,-34.8929960,40.3,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1529000,-34.8928930,40.5,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1531170,-34.8927940,40.7,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1533380,-34.8926920,40.9,'2021-04-16',167,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1535520,-34.8925900,41.1,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1537310,-34.8924720,41.2,'2021-04-16',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1539400,-34.8923710,41.6,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1541250,-34.8922600,42.3,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1543010,-34.8921700,42.7,'2021-04-16',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1543300,-34.8921310,42.7,'2021-04-16',164,79)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1543460,-34.8921220,42.7,'2021-04-16',163,79)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1545350,-34.8920450,42.9,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1547590,-34.8919800,43.2,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1549880,-34.8918920,43.5,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1551970,-34.8917930,43.9,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1554060,-34.8916860,44.1,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1556450,-34.8916350,44.2,'2021-04-16',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1558750,-34.8916480,43.9,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1561010,-34.8917230,43.4,'2021-04-16',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1563240,-34.8917960,42.8,'2021-04-16',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1565740,-34.8918380,42.1,'2021-04-16',161,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568070,-34.8918860,41.5,'2021-04-16',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570260,-34.8918820,41.0,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1572640,-34.8919200,40.7,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575080,-34.8919660,40.4,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1577430,-34.8920200,40.1,'2021-04-16',153,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579710,-34.8920900,39.9,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581860,-34.8921890,40.0,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1583740,-34.8923030,39.7,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585150,-34.8924570,39.2,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585930,-34.8926290,38.7,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586430,-34.8928170,38.2,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587310,-34.8930210,37.8,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588240,-34.8932150,37.5,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588990,-34.8934100,37.2,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589600,-34.8935890,36.8,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590320,-34.8937620,36.4,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590910,-34.8939430,36.0,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591670,-34.8941370,35.8,'2021-04-16',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592410,-34.8943340,35.6,'2021-04-16',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593110,-34.8945200,35.5,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593490,-34.8947230,35.8,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593480,-34.8949050,36.1,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593350,-34.8951200,36.5,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592960,-34.8953300,36.8,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592380,-34.8955320,36.8,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591000,-34.8957100,36.8,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590190,-34.8959090,36.8,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590440,-34.8961150,36.8,'2021-04-16',156,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590440,-34.8963000,36.7,'2021-04-16',157,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589930,-34.8964960,36.5,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589450,-34.8966890,36.1,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589040,-34.8968920,35.6,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587960,-34.8970620,35.0,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586350,-34.8971840,34.1,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1584550,-34.8972880,33.2,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1582640,-34.8974340,32.0,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581060,-34.8975700,31.0,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579360,-34.8977210,30.1,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1577640,-34.8978430,29.3,'2021-04-16',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575950,-34.8979290,28.8,'2021-04-16',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1574700,-34.8980250,28.4,'2021-04-16',145,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1572940,-34.8981510,27.8,'2021-04-16',142,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1571330,-34.8982750,27.1,'2021-04-16',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1569740,-34.8984020,26.3,'2021-04-16',145,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568850,-34.8984770,25.9,'2021-04-16',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1567300,-34.8986070,25.2,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1565220,-34.8986940,24.7,'2021-04-16',150,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1562940,-34.8987300,24.4,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1560660,-34.8987390,24.2,'2021-04-16',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1558460,-34.8987370,24.0,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1556280,-34.8987160,23.8,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1554090,-34.8986930,23.7,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1551730,-34.8986330,23.4,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1549490,-34.8986160,23.1,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1546940,-34.8986040,22.8,'2021-04-16',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1544350,-34.8985970,22.4,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1541910,-34.8985630,22.0,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1539410,-34.8985190,21.7,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1536800,-34.8984910,21.5,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1534260,-34.8984700,21.3,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1532070,-34.8984570,21.1,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1529910,-34.8984480,21.0,'2021-04-16',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1527510,-34.8984200,20.8,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1525230,-34.8983890,20.8,'2021-04-16',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1523140,-34.8982850,20.8,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521780,-34.8981220,21.0,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1520780,-34.8979600,21.2,'2021-04-16',156,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519510,-34.8977680,21.6,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518400,-34.8976050,22.1,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517090,-34.8974320,22.7,'2021-04-16',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516210,-34.8972910,23.1,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515330,-34.8970980,24.0,'2021-04-16',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514250,-34.8969290,24.8,'2021-04-16',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513650,-34.8967360,25.7,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513810,-34.8965390,26.2,'2021-04-16',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514230,-34.8963460,27.1,'2021-04-16',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514390,-34.8962350,27.9,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514280,-34.8961830,28.2,'2021-04-16',164,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514070,-34.8960180,29.2,'2021-04-16',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513570,-34.8959720,29.4,'2021-04-16',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512130,-34.8958200,29.9,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510710,-34.8956470,30.6,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510200,-34.8954540,31.5,'2021-04-16',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510400,-34.8952610,32.4,'2021-04-16',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510720,-34.8950780,33.3,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510920,-34.8948890,34.2,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511300,-34.8946980,35.1,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511440,-34.8945020,36.0,'2021-04-16',168,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511680,-34.8943040,36.8,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512200,-34.8941120,37.5,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513150,-34.8939260,38.2,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513830,-34.8937360,38.9,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515720,-34.8935920,39.3,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517670,-34.8934590,39.6,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519680,-34.8933310,39.8,'2021-04-16',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521950,-34.8932360,40.0,'2021-04-16',167,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1524260,-34.8931530,40.2,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1526390,-34.8930530,40.3,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1528190,-34.8929470,40.4,'2021-04-16',166,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1530170,-34.8928110,40.6,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1532030,-34.8926920,40.8,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1534170,-34.8925810,41.0,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1536180,-34.8925050,41.1,'2021-04-16',167,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1538310,-34.8924070,41.3,'2021-04-16',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1540410,-34.8923210,41.9,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542370,-34.8922150,42.6,'2021-04-16',167,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1544360,-34.8921050,42.8,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1546620,-34.8920280,43.0,'2021-04-16',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1548750,-34.8919630,43.3,'2021-04-16',168,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1550780,-34.8918540,43.6,'2021-04-16',168,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1552830,-34.8917490,44.0,'2021-04-16',169,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1555040,-34.8916610,44.2,'2021-04-16',169,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1557200,-34.8916100,44.1,'2021-04-16',168,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1559430,-34.8916250,43.8,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1561730,-34.8916980,43.2,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1564200,-34.8917630,42.6,'2021-04-16',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1566500,-34.8918030,41.9,'2021-04-16',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568460,-34.8918540,41.4,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570660,-34.8918430,41.0,'2021-04-16',162,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1572540,-34.8918730,40.8,'2021-04-16',159,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575010,-34.8919210,40.5,'2021-04-16',159,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1577370,-34.8919750,40.1,'2021-04-16',160,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579630,-34.8920430,39.9,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581670,-34.8921530,39.9,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1583770,-34.8922850,39.7,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585040,-34.8924540,39.2,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585700,-34.8926370,38.7,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586220,-34.8928210,38.2,'2021-04-16',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587200,-34.8930140,37.9,'2021-04-16',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588150,-34.8932010,37.5,'2021-04-16',158,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588970,-34.8933810,37.2,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589540,-34.8935580,36.9,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590140,-34.8937610,36.4,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590810,-34.8939600,36.0,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591480,-34.8941620,35.8,'2021-04-16',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592240,-34.8943510,35.6,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592740,-34.8945270,35.5,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593070,-34.8947380,35.8,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593000,-34.8949360,36.2,'2021-04-16',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592820,-34.8951210,36.5,'2021-04-16',161,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592440,-34.8953200,36.8,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591900,-34.8954970,36.8,'2021-04-16',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590570,-34.8956710,36.8,'2021-04-16',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589850,-34.8958780,36.8,'2021-04-16',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590030,-34.8960780,36.8,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590160,-34.8962800,36.7,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589890,-34.8964700,36.5,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589520,-34.8966690,36.2,'2021-04-16',162,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589000,-34.8968700,35.7,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588070,-34.8970460,35.1,'2021-04-16',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586560,-34.8971840,34.2,'2021-04-16',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1584720,-34.8972860,33.3,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1583140,-34.8973840,32.3,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581190,-34.8975330,31.1,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579360,-34.8976700,30.3,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1577550,-34.8977890,29.4,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575220,-34.8978280,28.9,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573430,-34.8977790,28.7,'2021-04-16',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573180,-34.8978760,28.4,'2021-04-16',149,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573380,-34.8980600,28.1,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1571920,-34.8982200,27.4,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570210,-34.8983550,26.6,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568110,-34.8984840,25.7,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1566300,-34.8986140,25.0,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1564150,-34.8986840,24.6,'2021-04-16',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1561960,-34.8987110,24.3,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1559760,-34.8987120,24.1,'2021-04-16',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1557230,-34.8986940,23.9,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1554740,-34.8986910,23.7,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1552440,-34.8986970,23.5,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1549980,-34.8986720,23.2,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1547410,-34.8986450,22.9,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1544840,-34.8986300,22.4,'2021-04-16',156,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542280,-34.8985970,22.1,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1539840,-34.8985720,21.8,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1537510,-34.8985340,21.6,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1535110,-34.8985130,21.4,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1532500,-34.8984870,21.2,'2021-04-16',155,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1529990,-34.8984700,21.0,'2021-04-16',154,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1527670,-34.8984410,20.9,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1525240,-34.8984140,20.8,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1522850,-34.8983270,20.8,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521380,-34.8981900,20.9,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1520450,-34.8980190,21.1,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519700,-34.8978350,21.5,'2021-04-16',159,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519110,-34.8976640,21.9,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518190,-34.8974800,22.4,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517110,-34.8972940,23.0,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515910,-34.8971330,23.7,'2021-04-16',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514850,-34.8969720,24.5,'2021-04-16',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513810,-34.8967780,25.5,'2021-04-16',164,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513840,-34.8965760,26.1,'2021-04-16',166,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514100,-34.8963910,26.8,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514270,-34.8963680,27.0,'2021-04-16',167,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515340,-34.8962690,27.7,'2021-04-16',160,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515140,-34.8962060,28.1,'2021-04-16',157,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514750,-34.8961230,28.5,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514510,-34.8960680,28.8,'2021-04-16',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513690,-34.8959620,29.4,'2021-04-16',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512420,-34.8958040,29.9,'2021-04-16',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511120,-34.8956500,30.5,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510650,-34.8954570,31.5,'2021-04-16',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510990,-34.8952550,32.5,'2021-04-16',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510970,-34.8950700,33.3,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510940,-34.8948840,34.3,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511120,-34.8946770,35.2,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511470,-34.8944730,36.1,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1511660,-34.8943180,36.8,'2021-04-16',160,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512230,-34.8941350,37.5,'2021-04-16',160,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512880,-34.8939600,38.1,'2021-04-16',160,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513880,-34.8937920,38.8,'2021-04-16',161,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515260,-34.8936320,39.2,'2021-04-16',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517330,-34.8935090,39.5,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519320,-34.8934020,39.7,'2021-04-16',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521440,-34.8933150,39.9,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1523460,-34.8932100,40.1,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1525550,-34.8930950,40.3,'2021-04-16',161,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1527730,-34.8929880,40.3,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1529880,-34.8928840,40.5,'2021-04-16',163,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1531720,-34.8927550,40.8,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1533860,-34.8926490,40.9,'2021-04-16',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1535890,-34.8925560,41.1,'2021-04-16',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1537970,-34.8924620,41.2,'2021-04-16',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1540050,-34.8923590,41.8,'2021-04-16',163,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542170,-34.8922580,42.5,'2021-04-16',164,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1544310,-34.8921790,42.8,'2021-04-16',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1546330,-34.8920730,43.0,'2021-04-16',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1548520,-34.8919920,43.2,'2021-04-16',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1550530,-34.8918900,43.6,'2021-04-16',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1552470,-34.8917840,43.9,'2021-04-16',166,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1554490,-34.8916760,44.2,'2021-04-16',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1556610,-34.8916190,44.2,'2021-04-16',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1559260,-34.8916390,43.8,'2021-04-16',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1561620,-34.8917070,43.2,'2021-04-16',165,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1563850,-34.8917650,42.7,'2021-04-16',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1566200,-34.8917910,42.0,'2021-04-16',163,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568540,-34.8918230,41.4,'2021-04-16',161,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1570830,-34.8918640,40.9,'2021-04-16',158,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573370,-34.8919270,40.7,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575810,-34.8919700,40.3,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1578330,-34.8920280,40.0,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1580630,-34.8921130,39.9,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1582570,-34.8922260,40.1,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1584300,-34.8923570,39.5,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585400,-34.8925530,38.9,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586100,-34.8927340,38.4,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586820,-34.8929080,38.0,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1587420,-34.8930880,37.7,'2021-04-16',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588100,-34.8932670,37.4,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588980,-34.8934460,37.1,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589820,-34.8936470,36.7,'2021-04-16',154,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590450,-34.8938450,36.2,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591250,-34.8940450,35.9,'2021-04-16',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591920,-34.8942240,35.7,'2021-04-16',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592630,-34.8944270,35.6,'2021-04-16',153,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593290,-34.8946280,35.6,'2021-04-16',153,43)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1593320,-34.8948270,36.0,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592950,-34.8950290,36.4,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1592410,-34.8952250,36.7,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1591710,-34.8954020,36.8,'2021-04-16',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1590660,-34.8955870,36.8,'2021-04-16',157,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589500,-34.8957670,36.8,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589210,-34.8959500,36.8,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589750,-34.8961390,36.8,'2021-04-16',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589580,-34.8963390,36.6,'2021-04-16',157,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589300,-34.8965450,36.4,'2021-04-16',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1589070,-34.8967550,36.0,'2021-04-16',159,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1588450,-34.8969500,35.4,'2021-04-16',159,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1586900,-34.8970890,34.7,'2021-04-16',157,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1585180,-34.8972170,33.7,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1583480,-34.8973460,32.7,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1581520,-34.8974890,31.4,'2021-04-16',155,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1579720,-34.8976430,30.4,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1578070,-34.8977810,29.6,'2021-04-16',152,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1576360,-34.8978950,29.0,'2021-04-16',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1575140,-34.8980010,28.5,'2021-04-16',148,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1573490,-34.8981180,28.0,'2021-04-16',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1571750,-34.8982540,27.2,'2021-04-16',144,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1569940,-34.8983880,26.4,'2021-04-16',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1568160,-34.8985150,25.7,'2021-04-16',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1566130,-34.8986390,24.9,'2021-04-16',146,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1563940,-34.8987000,24.5,'2021-04-16',147,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1561700,-34.8987410,24.3,'2021-04-16',148,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1559310,-34.8988290,24.1,'2021-04-16',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1557190,-34.8988830,23.9,'2021-04-16',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1554800,-34.8988540,23.7,'2021-04-16',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1552330,-34.8988230,23.8,'2021-04-16',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1549900,-34.8987900,23.5,'2021-04-16',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1547450,-34.8987920,23.3,'2021-04-16',149,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1544890,-34.8987970,23.1,'2021-04-16',150,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1542470,-34.8987750,22.8,'2021-04-16',151,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1539900,-34.8987580,22.4,'2021-04-16',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1537690,-34.8987490,22.1,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1535220,-34.8987180,22.0,'2021-04-16',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1532800,-34.8986750,21.8,'2021-04-16',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1530200,-34.8986410,21.7,'2021-04-16',154,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1527870,-34.8986110,21.6,'2021-04-16',155,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1525340,-34.8985940,21.5,'2021-04-16',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1523250,-34.8985670,21.4,'2021-04-16',159,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1521760,-34.8984950,21.4,'2021-04-16',157,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1520680,-34.8984390,21.3,'2021-04-16',134,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1520460,-34.8984480,21.3,'2021-04-16',135,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519950,-34.8984670,21.3,'2021-04-16',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519650,-34.8985000,21.3,'2021-04-16',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519630,-34.8985670,21.2,'2021-04-16',136,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1519330,-34.8986690,21.1,'2021-04-16',133,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518980,-34.8988590,20.9,'2021-04-16',132,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518680,-34.8990660,20.7,'2021-04-16',134,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1518220,-34.8992490,20.5,'2021-04-16',137,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1517420,-34.8994400,20.5,'2021-04-16',136,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1516910,-34.8996330,20.1,'2021-04-16',136,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515940,-34.8997960,19.7,'2021-04-16',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1515100,-34.8999790,19.3,'2021-04-16',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1514370,-34.9001730,19.0,'2021-04-16',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1513530,-34.9003450,18.7,'2021-04-16',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1512480,-34.9005200,18.4,'2021-04-16',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1510570,-34.9006000,17.7,'2021-04-16',142,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1508130,-34.9005860,16.6,'2021-04-16',144,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1505750,-34.9005690,15.6,'2021-04-16',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1504980,-34.9005670,15.5,'2021-04-16',142,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1504670,-34.9005770,15.4,'2021-04-16',141,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1503330,-34.9005760,15.2,'2021-04-16',137,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1502500,-34.9005620,15.3,'2021-04-16',134,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1501380,-34.9005590,15.6,'2021-04-16',131,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1499170,-34.9005280,16.4,'2021-04-16',129,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1496910,-34.9005020,17.3,'2021-04-16',129,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1495700,-34.9004950,17.9,'2021-04-16',132,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1494200,-34.9004630,18.6,'2021-04-16',135,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1492500,-34.9004490,19.3,'2021-04-16',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (3,-56.1491720,-34.9004410,19.6,'2021-04-16',138,85)"; db.execSQL(queryInsert);


        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1466430,-34.9002410,25.0,'2021-04-11',82,68)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1466080,-34.9002450,24.8,'2021-04-11',85,68)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1465810,-34.9002510,24.7,'2021-04-11',88,68)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1465100,-34.9003050,24.2,'2021-04-11',89,68)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464810,-34.9003640,23.9,'2021-04-11',95,82)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464730,-34.9003910,23.7,'2021-04-11',95,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464570,-34.9005710,22.5,'2021-04-11',95,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464510,-34.9007660,21.3,'2021-04-11',97,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464440,-34.9008990,20.5,'2021-04-11',100,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464410,-34.9009650,20.2,'2021-04-11',104,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464390,-34.9010310,19.9,'2021-04-11',108,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464300,-34.9011830,19.2,'2021-04-11',111,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1464140,-34.9013430,18.9,'2021-04-11',114,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463310,-34.9015150,19.0,'2021-04-11',116,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463200,-34.9016800,19.2,'2021-04-11',119,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463260,-34.9017360,19.4,'2021-04-11',122,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463260,-34.9018500,19.7,'2021-04-11',125,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463210,-34.9019030,19.9,'2021-04-11',128,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463030,-34.9020130,20.3,'2021-04-11',131,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462990,-34.9020990,20.6,'2021-04-11',134,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462720,-34.9021890,20.9,'2021-04-11',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1461910,-34.9023630,21.7,'2021-04-11',140,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1460800,-34.9025370,22.7,'2021-04-11',142,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1459420,-34.9026950,25.1,'2021-04-11',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1458540,-34.9027240,25.4,'2021-04-11',145,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1456000,-34.9027320,26.1,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1453650,-34.9027450,26.9,'2021-04-11',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1452580,-34.9027630,27.2,'2021-04-11',148,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1452380,-34.9027810,27.3,'2021-04-11',148,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1451200,-34.9028400,28.6,'2021-04-11',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450600,-34.9028950,28.7,'2021-04-11',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450400,-34.9029580,28.8,'2021-04-11',138,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449850,-34.9031550,28.9,'2021-04-11',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449860,-34.9032080,28.9,'2021-04-11',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449840,-34.9032370,28.9,'2021-04-11',142,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449790,-34.9033240,28.8,'2021-04-11',141,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449410,-34.9035200,28.2,'2021-04-11',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449280,-34.9036140,27.8,'2021-04-11',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449260,-34.9038310,26.5,'2021-04-11',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1448700,-34.9040230,25.3,'2021-04-11',140,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447820,-34.9042210,24.6,'2021-04-11',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447070,-34.9044000,23.8,'2021-04-11',139,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1446210,-34.9046000,23.2,'2021-04-11',140,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1445660,-34.9047980,22.9,'2021-04-11',142,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1445010,-34.9049980,22.5,'2021-04-11',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1444440,-34.9051860,22.1,'2021-04-11',144,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1443630,-34.9053540,21.6,'2021-04-11',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442750,-34.9055280,20.9,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442480,-34.9057240,20.0,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442040,-34.9059180,18.9,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1441910,-34.9061200,17.5,'2021-04-11',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1441580,-34.9062910,16.2,'2021-04-11',145,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1441000,-34.9064730,14.9,'2021-04-11',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1440670,-34.9066570,13.9,'2021-04-11',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439780,-34.9068320,13.2,'2021-04-11',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439600,-34.9070320,12.5,'2021-04-11',140,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439560,-34.9071070,12.2,'2021-04-11',137,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438950,-34.9073020,11.7,'2021-04-11',137,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438530,-34.9074660,11.4,'2021-04-11',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438230,-34.9076240,11.2,'2021-04-11',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1437490,-34.9078060,11.0,'2021-04-11',144,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436830,-34.9079750,10.9,'2021-04-11',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436270,-34.9081800,10.9,'2021-04-11',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435620,-34.9083730,10.9,'2021-04-11',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1434690,-34.9085380,11.3,'2021-04-11',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1433230,-34.9086990,11.4,'2021-04-11',153,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1432950,-34.9087260,11.4,'2021-04-11',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1431400,-34.9088770,11.4,'2021-04-11',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1430310,-34.9089900,11.3,'2021-04-11',156,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429430,-34.9090650,11.3,'2021-04-11',157,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1428570,-34.9092350,11.1,'2021-04-11',155,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1428430,-34.9092510,11.0,'2021-04-11',155,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1427720,-34.9093930,10.8,'2021-04-11',144,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1427670,-34.9094190,10.4,'2021-04-11',139,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1427640,-34.9094800,10.3,'2021-04-11',136,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1428090,-34.9095590,10.1,'2021-04-11',133,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429670,-34.9096570,9.8,'2021-04-11',131,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1432100,-34.9097410,9.6,'2021-04-11',134,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1433400,-34.9098060,9.5,'2021-04-11',136,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1434860,-34.9099020,9.4,'2021-04-11',138,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435720,-34.9099850,9.4,'2021-04-11',141,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436810,-34.9100660,9.3,'2021-04-11',143,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1437120,-34.9100970,9.3,'2021-04-11',144,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438810,-34.9102310,9.2,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439180,-34.9102550,9.2,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439490,-34.9102820,9.2,'2021-04-11',147,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1440170,-34.9103340,9.1,'2021-04-11',148,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1441800,-34.9104650,9.0,'2021-04-11',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1443580,-34.9106230,8.9,'2021-04-11',150,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1444960,-34.9107250,9.0,'2021-04-11',153,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1446200,-34.9108300,9.2,'2021-04-11',156,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447930,-34.9109850,9.5,'2021-04-11',158,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449600,-34.9111480,9.8,'2021-04-11',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1451300,-34.9113030,10.0,'2021-04-11',163,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1452870,-34.9114410,10.2,'2021-04-11',165,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1454730,-34.9115780,10.4,'2021-04-11',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1456590,-34.9117350,10.7,'2021-04-11',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1458170,-34.9119040,10.9,'2021-04-11',166,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1459940,-34.9120540,11.0,'2021-04-11',167,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1461970,-34.9121920,11.2,'2021-04-11',168,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463890,-34.9123340,11.4,'2021-04-11',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1465490,-34.9125070,11.4,'2021-04-11',167,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1467160,-34.9126750,11.3,'2021-04-11',165,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1468590,-34.9128450,11.2,'2021-04-11',165,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1470030,-34.9129910,11.2,'2021-04-11',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1471630,-34.9131380,11.1,'2021-04-11',164,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1472950,-34.9132920,10.9,'2021-04-11',165,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1474360,-34.9134390,10.6,'2021-04-11',164,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1475790,-34.9135920,10.5,'2021-04-11',163,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1477570,-34.9137330,10.4,'2021-04-11',164,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1479130,-34.9139020,10.3,'2021-04-11',161,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1480640,-34.9140490,10.2,'2021-04-11',162,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1482000,-34.9141940,10.2,'2021-04-11',163,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1483460,-34.9143710,10.1,'2021-04-11',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484900,-34.9145140,10.1,'2021-04-11',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486030,-34.9146910,10.3,'2021-04-11',162,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486260,-34.9148880,13.2,'2021-04-11',163,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486230,-34.9150780,13.3,'2021-04-11',165,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486480,-34.9152650,13.3,'2021-04-11',166,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487130,-34.9154450,13.3,'2021-04-11',168,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487530,-34.9156320,13.1,'2021-04-11',169,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488020,-34.9158140,12.9,'2021-04-11',169,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488400,-34.9159990,12.8,'2021-04-11',170,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488500,-34.9162080,12.7,'2021-04-11',169,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489060,-34.9164110,12.9,'2021-04-11',169,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489650,-34.9166150,13.2,'2021-04-11',169,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489860,-34.9168220,13.4,'2021-04-11',170,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489790,-34.9170370,13.5,'2021-04-11',170,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489450,-34.9172360,13.4,'2021-04-11',172,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489050,-34.9174370,13.4,'2021-04-11',173,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488910,-34.9175200,13.4,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488300,-34.9176980,13.2,'2021-04-11',175,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487580,-34.9179000,13.0,'2021-04-11',174,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486550,-34.9181040,12.7,'2021-04-11',174,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486440,-34.9181410,12.7,'2021-04-11',175,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486000,-34.9182570,12.6,'2021-04-11',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485260,-34.9184500,12.6,'2021-04-11',173,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485140,-34.9184880,12.6,'2021-04-11',173,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484820,-34.9186800,12.6,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484950,-34.9187080,12.6,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485150,-34.9188200,12.5,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485530,-34.9190140,12.6,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485640,-34.9190510,12.6,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486060,-34.9192350,12.7,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486770,-34.9194200,12.8,'2021-04-11',170,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487280,-34.9196080,12.8,'2021-04-11',169,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487940,-34.9197930,12.7,'2021-04-11',170,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488520,-34.9199830,12.6,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489240,-34.9201720,12.5,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489960,-34.9203490,12.5,'2021-04-11',171,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1490690,-34.9205350,12.8,'2021-04-11',173,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1491250,-34.9207180,12.9,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1492630,-34.9208980,13.0,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1494330,-34.9210560,13.1,'2021-04-11',173,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1495940,-34.9211830,13.3,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1497870,-34.9213140,13.4,'2021-04-11',170,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1499710,-34.9214640,13.6,'2021-04-11',169,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1501440,-34.9216080,13.8,'2021-04-11',169,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1503440,-34.9217310,13.7,'2021-04-11',171,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1505440,-34.9218710,13.7,'2021-04-11',173,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1507340,-34.9219960,13.7,'2021-04-11',173,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1509010,-34.9221330,13.7,'2021-04-11',174,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1510930,-34.9222660,13.8,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1512730,-34.9223980,13.8,'2021-04-11',174,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1514550,-34.9225350,13.8,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1516420,-34.9226650,13.9,'2021-04-11',175,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1518220,-34.9227940,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1519990,-34.9229170,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1521530,-34.9230520,14.0,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1523080,-34.9231790,13.9,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1524920,-34.9233070,13.9,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1526780,-34.9234180,13.9,'2021-04-11',174,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1528590,-34.9235300,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1530280,-34.9236500,13.9,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1531850,-34.9237820,13.9,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1533570,-34.9239050,13.9,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1535280,-34.9240270,13.9,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1536960,-34.9241480,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1538670,-34.9242690,13.9,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1540340,-34.9243980,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1541840,-34.9245320,14.0,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1543700,-34.9246840,14.0,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1545550,-34.9248310,14.0,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1547230,-34.9249530,14.0,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1548970,-34.9250790,14.1,'2021-04-11',176,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1550580,-34.9252090,14.2,'2021-04-11',176,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1552200,-34.9253340,14.2,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1553840,-34.9254610,14.2,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1555610,-34.9255810,14.2,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1557370,-34.9256950,14.0,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1559090,-34.9258220,13.9,'2021-04-11',176,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1561060,-34.9259610,13.8,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1562980,-34.9260730,13.7,'2021-04-11',178,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1564720,-34.9261880,13.7,'2021-04-11',177,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1566350,-34.9263100,13.8,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1568030,-34.9264320,13.9,'2021-04-11',178,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1569890,-34.9265860,13.9,'2021-04-11',178,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1571490,-34.9267110,13.9,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1573350,-34.9268190,13.7,'2021-04-11',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1575080,-34.9269320,13.6,'2021-04-11',176,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1576920,-34.9270810,13.5,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1578650,-34.9272310,13.5,'2021-04-11',176,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1580370,-34.9273810,13.6,'2021-04-11',176,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1582090,-34.9275010,13.5,'2021-04-11',177,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1584090,-34.9276440,13.4,'2021-04-11',178,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1586090,-34.9277660,13.4,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1587790,-34.9279160,13.4,'2021-04-11',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1589820,-34.9280510,13.4,'2021-04-11',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1591720,-34.9281920,13.3,'2021-04-11',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1593320,-34.9283190,13.2,'2021-04-11',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1595070,-34.9284490,13.0,'2021-04-11',175,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1596680,-34.9285780,12.9,'2021-04-11',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1598350,-34.9287200,12.8,'2021-04-11',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1600060,-34.9288430,12.7,'2021-04-11',172,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1601860,-34.9289720,12.6,'2021-04-11',172,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1603830,-34.9290830,12.5,'2021-04-11',173,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1606160,-34.9291470,12.5,'2021-04-11',173,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1608410,-34.9291820,12.5,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1610660,-34.9291610,12.5,'2021-04-11',172,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1613040,-34.9291140,12.4,'2021-04-11',172,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1615410,-34.9290300,12.3,'2021-04-11',171,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1617450,-34.9289200,12.1,'2021-04-11',171,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1619120,-34.9287680,12.0,'2021-04-11',172,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1620850,-34.9286140,12.0,'2021-04-11',173,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1622490,-34.9284760,11.9,'2021-04-11',174,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1624140,-34.9283330,11.8,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1625710,-34.9281870,11.6,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1627290,-34.9280450,11.5,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1628920,-34.9279090,11.3,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1630790,-34.9277590,11.2,'2021-04-11',174,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1632710,-34.9276300,11.1,'2021-04-11',173,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1634500,-34.9275090,11.1,'2021-04-11',174,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1636280,-34.9273880,10.9,'2021-04-11',174,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1637990,-34.9272700,10.8,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1639700,-34.9271390,10.8,'2021-04-11',175,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1641300,-34.9270120,10.9,'2021-04-11',176,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1643100,-34.9269020,11.0,'2021-04-11',176,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1644970,-34.9267760,11.1,'2021-04-11',174,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1647060,-34.9266470,11.2,'2021-04-11',173,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1648830,-34.9265400,11.2,'2021-04-11',172,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1650970,-34.9264240,11.1,'2021-04-11',173,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1653030,-34.9263060,11.0,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1654990,-34.9262170,10.9,'2021-04-11',171,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1656900,-34.9261220,10.9,'2021-04-11',172,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1658830,-34.9260350,10.9,'2021-04-11',174,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1661030,-34.9259270,11.0,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1663010,-34.9258420,11.1,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1665000,-34.9257650,11.2,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1667250,-34.9256680,11.2,'2021-04-11',173,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1669530,-34.9255820,11.1,'2021-04-11',172,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1671580,-34.9255160,11.1,'2021-04-11',173,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1673630,-34.9254450,11.0,'2021-04-11',174,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1675700,-34.9253750,11.0,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1678100,-34.9253020,11.1,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1680510,-34.9252620,11.2,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1682620,-34.9252030,11.3,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1684990,-34.9251400,11.5,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1687120,-34.9250840,11.5,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1689420,-34.9250240,11.5,'2021-04-11',175,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1691680,-34.9249650,11.4,'2021-04-11',175,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1693910,-34.9249250,11.2,'2021-04-11',175,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1696100,-34.9248700,11.1,'2021-04-11',176,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1698440,-34.9248360,11.1,'2021-04-11',176,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1700900,-34.9248010,11.1,'2021-04-11',177,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1703060,-34.9247580,11.1,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1705200,-34.9246960,11.2,'2021-04-11',177,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1707030,-34.9245940,11.1,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1708970,-34.9244630,10.8,'2021-04-11',177,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1709670,-34.9244170,10.8,'2021-04-11',177,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1709810,-34.9244100,10.8,'2021-04-11',110,55)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1709660,-34.9244260,10.8,'2021-04-11',111,55)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1709220,-34.9244690,10.8,'2021-04-11',114,55)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1708460,-34.9245510,10.8,'2021-04-11',118,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1707460,-34.9246410,10.8,'2021-04-11',121,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1705580,-34.9247410,10.8,'2021-04-11',131,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1704710,-34.9247790,10.8,'2021-04-11',134,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1704250,-34.9247920,10.7,'2021-04-11',136,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1702410,-34.9248420,10.7,'2021-04-11',138,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1700250,-34.9249000,10.7,'2021-04-11',136,0)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1697880,-34.9249510,10.8,'2021-04-11',136,95)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1695500,-34.9250000,10.9,'2021-04-11',139,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1694130,-34.9250290,10.9,'2021-04-11',142,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1692660,-34.9250630,10.9,'2021-04-11',145,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1692220,-34.9250750,10.9,'2021-04-11',146,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1690380,-34.9251300,11.0,'2021-04-11',149,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1688540,-34.9251790,10.9,'2021-04-11',153,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1686670,-34.9252230,10.9,'2021-04-11',156,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1684450,-34.9252870,10.9,'2021-04-11',160,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1682070,-34.9253580,10.9,'2021-04-11',162,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1680280,-34.9253980,10.9,'2021-04-11',165,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1678040,-34.9254650,10.9,'2021-04-11',167,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1675740,-34.9255360,10.9,'2021-04-11',168,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1673440,-34.9256190,11.0,'2021-04-11',170,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1671300,-34.9256850,11.1,'2021-04-11',171,94)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1669110,-34.9257610,11.1,'2021-04-11',173,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1667060,-34.9258360,11.0,'2021-04-11',174,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1664950,-34.9259210,10.9,'2021-04-11',175,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1662740,-34.9260050,10.8,'2021-04-11',176,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1660540,-34.9260950,10.8,'2021-04-11',176,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1658460,-34.9261860,10.8,'2021-04-11',177,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1656410,-34.9262850,10.9,'2021-04-11',176,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1654360,-34.9263840,11.0,'2021-04-11',177,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1652350,-34.9264920,11.1,'2021-04-11',176,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1650070,-34.9265940,11.1,'2021-04-11',177,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1648170,-34.9267080,11.2,'2021-04-11',178,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1646330,-34.9268110,11.2,'2021-04-11',177,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1644510,-34.9269130,11.2,'2021-04-11',177,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1642690,-34.9270320,11.2,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1640790,-34.9271430,11.2,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1638950,-34.9272680,11.2,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1637230,-34.9273950,11.2,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1635600,-34.9275210,11.3,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1633750,-34.9276670,11.4,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1632190,-34.9277980,11.4,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1630490,-34.9279210,11.4,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1628870,-34.9280500,11.5,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1627380,-34.9281910,11.7,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1625820,-34.9283210,12.1,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1624190,-34.9284510,12.3,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1622220,-34.9285600,12.4,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1620700,-34.9287150,12.5,'2021-04-11',177,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1619060,-34.9288610,12.7,'2021-04-11',177,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1617400,-34.9290030,13.0,'2021-04-11',178,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1615570,-34.9291260,13.2,'2021-04-11',178,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1613300,-34.9292100,13.3,'2021-04-11',178,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1610890,-34.9292490,13.3,'2021-04-11',179,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1608440,-34.9292700,13.3,'2021-04-11',180,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1605870,-34.9292650,13.2,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1603450,-34.9292160,13.2,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1601230,-34.9291290,13.2,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1599170,-34.9289960,13.2,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1597220,-34.9288460,13.2,'2021-04-11',180,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1595210,-34.9287010,13.2,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1593670,-34.9285770,13.3,'2021-04-11',180,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1591430,-34.9284800,13.3,'2021-04-11',180,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1591010,-34.9284540,13.2,'2021-04-11',180,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1590190,-34.9283980,13.2,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1588370,-34.9282500,13.3,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1587330,-34.9281640,13.3,'2021-04-11',180,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1585590,-34.9280210,13.2,'2021-04-11',181,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1583910,-34.9278630,13.2,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1582930,-34.9277740,13.2,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1581130,-34.9276450,13.1,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1579410,-34.9275200,13.0,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1577760,-34.9273920,13.0,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1576400,-34.9272830,13.0,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1575740,-34.9272320,13.0,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1573980,-34.9270990,13.0,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1572210,-34.9269680,13.0,'2021-04-11',180,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1570310,-34.9268400,13.1,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1568440,-34.9266940,13.1,'2021-04-11',182,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1566540,-34.9265570,13.1,'2021-04-11',183,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1564790,-34.9264230,13.2,'2021-04-11',183,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1562980,-34.9262830,13.2,'2021-04-11',184,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1561170,-34.9261460,13.3,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1559360,-34.9260160,13.3,'2021-04-11',180,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1557540,-34.9258760,13.3,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1557190,-34.9258490,13.3,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1555790,-34.9257420,13.3,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1555090,-34.9256900,13.3,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1553350,-34.9255600,13.4,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1551530,-34.9254300,13.4,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1549830,-34.9253030,13.4,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1548090,-34.9251780,13.5,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1546400,-34.9250540,13.5,'2021-04-11',180,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1544620,-34.9249210,13.7,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1542920,-34.9248040,13.8,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1541060,-34.9246880,13.8,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1539290,-34.9245620,13.8,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1537560,-34.9244310,13.9,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1535790,-34.9243070,13.9,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1534110,-34.9241750,14.0,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1532360,-34.9240380,14.0,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1530610,-34.9239110,14.1,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1529070,-34.9237820,14.2,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1527320,-34.9236530,14.3,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1525560,-34.9235180,14.3,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1523670,-34.9233850,14.3,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1521860,-34.9232570,14.3,'2021-04-11',178,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1520110,-34.9231310,14.3,'2021-04-11',179,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1518430,-34.9229980,14.3,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1516580,-34.9228670,14.4,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1514830,-34.9227480,14.4,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1513120,-34.9226230,14.4,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1511390,-34.9224910,14.4,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1509750,-34.9223610,14.5,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1507880,-34.9222260,14.5,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1506100,-34.9220880,14.6,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1504320,-34.9219630,14.7,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1502600,-34.9218390,14.7,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1500800,-34.9217060,15.4,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1499070,-34.9215730,15.2,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1497500,-34.9214140,15.2,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1495520,-34.9212760,15.3,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1493890,-34.9211350,15.3,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1492250,-34.9209830,15.3,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1491000,-34.9208150,15.6,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489990,-34.9206360,16.2,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1489170,-34.9204660,15.0,'2021-04-11',180,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488410,-34.9202890,13.8,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487700,-34.9201160,12.9,'2021-04-11',180,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486840,-34.9199180,13.9,'2021-04-11',179,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486050,-34.9197380,14.9,'2021-04-11',179,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485570,-34.9195370,15.8,'2021-04-11',179,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484990,-34.9193420,15.9,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484260,-34.9191540,15.8,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1483570,-34.9189520,15.7,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1483540,-34.9187460,15.6,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1483620,-34.9185330,15.6,'2021-04-11',182,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484150,-34.9183320,15.4,'2021-04-11',182,93)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484970,-34.9181420,15.2,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485770,-34.9179530,15.1,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486480,-34.9177640,14.9,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487030,-34.9175750,14.7,'2021-04-11',182,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487440,-34.9173850,14.7,'2021-04-11',182,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487650,-34.9171990,14.8,'2021-04-11',182,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487670,-34.9170090,14.8,'2021-04-11',181,92)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1488060,-34.9168270,14.7,'2021-04-11',180,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487940,-34.9166400,14.6,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487740,-34.9164510,14.6,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487430,-34.9162550,14.6,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1487120,-34.9160710,14.6,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486920,-34.9158880,14.5,'2021-04-11',179,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486550,-34.9157000,14.5,'2021-04-11',179,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1486020,-34.9155070,14.5,'2021-04-11',180,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1485520,-34.9153190,14.5,'2021-04-11',180,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484870,-34.9151340,14.5,'2021-04-11',180,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1484060,-34.9149640,14.5,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1483460,-34.9147810,14.6,'2021-04-11',180,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1482660,-34.9146120,14.6,'2021-04-11',179,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1481530,-34.9144490,14.7,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1480000,-34.9143030,14.8,'2021-04-11',179,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1478470,-34.9141590,14.8,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1476920,-34.9140200,14.9,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1475370,-34.9138750,14.9,'2021-04-11',181,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1473720,-34.9137350,15.0,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1472140,-34.9135850,15.1,'2021-04-11',179,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1470620,-34.9134300,15.2,'2021-04-11',180,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1469270,-34.9132840,15.3,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1467750,-34.9131290,15.4,'2021-04-11',181,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1466480,-34.9129630,15.6,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1465260,-34.9127940,15.7,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463760,-34.9126420,15.7,'2021-04-11',182,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462150,-34.9124780,15.7,'2021-04-11',181,88)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1460400,-34.9123240,15.7,'2021-04-11',182,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1458840,-34.9121900,15.6,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1457240,-34.9120510,15.5,'2021-04-11',182,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1455540,-34.9119030,15.3,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1453910,-34.9117610,15.2,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1452170,-34.9116160,15.0,'2021-04-11',183,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450410,-34.9114700,14.7,'2021-04-11',183,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1448840,-34.9113230,14.5,'2021-04-11',182,91)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447120,-34.9111820,14.2,'2021-04-11',181,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1445580,-34.9110440,13.9,'2021-04-11',179,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1444000,-34.9109090,13.6,'2021-04-11',178,90)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442440,-34.9107720,13.4,'2021-04-11',177,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1440800,-34.9106280,13.2,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439090,-34.9104900,13.2,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1437530,-34.9103510,13.3,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435960,-34.9102130,13.4,'2021-04-11',177,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1434390,-34.9100770,13.6,'2021-04-11',178,89)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1432950,-34.9099310,13.9,'2021-04-11',177,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1431780,-34.9098310,14.0,'2021-04-11',174,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1431590,-34.9098150,10.0,'2021-04-11',174,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429160,-34.9094290,13.9,'2021-04-11',140,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429210,-34.9093100,11.0,'2021-04-11',137,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429120,-34.9092760,11.1,'2021-04-11',134,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1429150,-34.9092490,11.1,'2021-04-11',131,60)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1430240,-34.9090910,11.3,'2021-04-11',133,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1431680,-34.9089560,11.4,'2021-04-11',133,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1432830,-34.9088410,11.4,'2021-04-11',136,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1433360,-34.9087430,11.4,'2021-04-11',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1433800,-34.9086410,11.5,'2021-04-11',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1434770,-34.9084580,11.1,'2021-04-11',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435310,-34.9082810,10.9,'2021-04-11',139,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436030,-34.9081140,10.9,'2021-04-11',139,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436320,-34.9079300,10.9,'2021-04-11',140,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435960,-34.9077220,11.0,'2021-04-11',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435590,-34.9075370,11.2,'2021-04-11',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1435800,-34.9073400,11.5,'2021-04-11',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1436310,-34.9071620,11.9,'2021-04-11',141,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1437070,-34.9069890,12.5,'2021-04-11',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438150,-34.9068100,13.2,'2021-04-11',140,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1438520,-34.9066550,13.8,'2021-04-11',143,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439450,-34.9064930,14.6,'2021-04-11',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1439910,-34.9063430,15.6,'2021-04-11',149,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1440790,-34.9061770,16.9,'2021-04-11',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1441780,-34.9060130,18.2,'2021-04-11',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442510,-34.9058360,19.4,'2021-04-11',149,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1442870,-34.9056550,20.4,'2021-04-11',149,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1443510,-34.9054880,21.1,'2021-04-11',152,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1444140,-34.9052840,21.8,'2021-04-11',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1444510,-34.9050940,22.4,'2021-04-11',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1445090,-34.9049760,22.6,'2021-04-11',152,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1445850,-34.9047820,22.9,'2021-04-11',151,87)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1446010,-34.9047280,23.0,'2021-04-11',151,86)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1446520,-34.9045340,23.4,'2021-04-11',150,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447100,-34.9043370,24.0,'2021-04-11',149,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1447920,-34.9041510,24.8,'2021-04-11',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1448940,-34.9039730,25.5,'2021-04-11',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449680,-34.9038020,26.7,'2021-04-11',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449720,-34.9037830,26.8,'2021-04-11',147,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1449960,-34.9035840,28.0,'2021-04-11',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450060,-34.9033970,28.6,'2021-04-11',146,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450030,-34.9032010,28.9,'2021-04-11',143,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450120,-34.9030090,28.8,'2021-04-11',142,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1450800,-34.9028290,28.5,'2021-04-11',141,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1452390,-34.9027070,27.3,'2021-04-11',138,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1453140,-34.9026970,27.1,'2021-04-11',135,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1454260,-34.9026860,26.7,'2021-04-11',132,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1456640,-34.9026990,25.2,'2021-04-11',130,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1458590,-34.9025820,23.1,'2021-04-11',130,84)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1459740,-34.9024130,22.1,'2021-04-11',129,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1460630,-34.9022350,21.2,'2021-04-11',130,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1461170,-34.9020410,20.4,'2021-04-11',130,83)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1461850,-34.9018710,19.8,'2021-04-11',130,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462430,-34.9016880,19.3,'2021-04-11',132,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462460,-34.9014980,18.9,'2021-04-11',133,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1462910,-34.9012970,18.9,'2021-04-11',134,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463210,-34.9011120,19.5,'2021-04-11',137,85)"; db.execSQL(queryInsert);
        queryInsert = "INSERT INTO DETALLE_ACTIVIDADES VALUES (4,-56.1463360,-34.9009980,20.0,'2021-04-11',139,86)"; db.execSQL(queryInsert);

    }
}
