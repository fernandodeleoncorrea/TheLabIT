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

    public String queryTablaLogin;


    public DBTheLabIT(@Nullable Context context) {
        super(context, "DBTheLabIT.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        queryTablaLogin = "CREATE TABLE LOGIN(USERNAME STRING PRIMARY KEY, PASSWORD STRING)";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "CREATE TABLE USUARIOS(USERNAME STRING PRIMARY KEY, NOMBRE STRING, FECHANACIMIENTO STRING, CIUDAD STRING, PAIS STRING, EMAIL STRING, COMENTARIO STRING)";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "CREATE TABLE ENTRENADORES(USERNAME STRING PRIMARY KEY, FORMACION STRING)";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "CREATE TABLE CORREDORES(USERNAME STRING PRIMARY KEY, PESO STRING, GENERO STRING, ALTURA STRING, FCREPOSO STRING, FCMAXIMA STRING, OBJETIVO STRING, TIEMPOESTIMADO STRING)";
        db.execSQL(queryTablaLogin);

        //INSERTO UNOS DATOS DE PRUEBA
        //INSERT DE USUARIOS Y PASSWORD
        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('1', 'pwfernando')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('2', 'pwadrian')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('3', 'pwjoaquin')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('4', 'pwmario')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('5', 'pwcarol')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('2', 'FERNANDO2', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryTablaLogin);
        queryTablaLogin = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('3', 'FERNANDO3', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryTablaLogin);
        queryTablaLogin = "INSERT INTO USUARIOS(USERNAME, NOMBRE, FECHANACIMIENTO, CIUDAD, PAIS, EMAIL, COMENTARIO ) VALUES ('4', 'FERNANDO4', '01/01/2021', 'MONTEVIDEO', 'URUGUAY', 'HOLA@HOLA.COM', '')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO ENTRENADORES(USERNAME, FORMACION) VALUES ('1', 'ED FISICA')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('2fernando', '70', 'MASCULINO2', '170', '60', '180', '10', '50')";
        db.execSQL(queryTablaLogin);
        queryTablaLogin = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('3adrian', '70', 'MASCULINO3', '170', '60', '180', '10', '50')";
        db.execSQL(queryTablaLogin);
        queryTablaLogin = "INSERT INTO CORREDORES(USERNAME, PESO, GENERO, ALTURA, FCREPOSO, FCMAXIMA, OBJETIVO, TIEMPOESTIMADO ) VALUES ('4joaquin', '70', 'MASCULINO4', '170', '60', '180', '10', '50')";
        db.execSQL(queryTablaLogin);

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

    public Boolean insertEntrenador (Entrenador E){

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

        SQLiteDatabase db = this.getWritableDatabase();

        Boolean usu = db.insert("USUARIOS", null, contenedor) > 0;

        Boolean ent = db.insert("ENTRENADORES", null, contenedor2) > 0;
        db.close();

        if (usu == true & ent == true){
            return true;
        }else {
            return false;
        }

    }

    public void inicio(){ }

    public Cursor obtenerCorredores(String ent){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT USERNAME FROM USUARIOS", null);
        return cursor;
    }
}
