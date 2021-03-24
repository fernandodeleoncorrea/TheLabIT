package com.example.thelabit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBTheLabIT extends SQLiteOpenHelper {

    public static final String DBNAME = "DBTheLabIT.db";
    public String queryTablaLogin;
    public String queryInsert;


    public DBTheLabIT(@Nullable Context context) {
        super(context, "DBTheLabIT.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        queryTablaLogin = "CREATE TABLE LOGIN(USERNAME STRING PRIMARY KEY, PASSWORD STRING)";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('fernando', 'pwfernando')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('adrian', 'pwadrian')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('joaquin', 'pwjoaquin')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('mario', 'pwmario')";
        db.execSQL(queryTablaLogin);

        queryTablaLogin = "INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES ('carol', 'pwcarol')";
        db.execSQL(queryTablaLogin);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS LOGIN");
    }


    public Boolean chequearUsuarioPassword(String username, String password){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LOGIN WHERE USERNAME = ? and PASSWORD = ?", new String[]{username, password});
        if(cursor.getCount()>0 )
            return true;
        else
            return false;
    }
}
