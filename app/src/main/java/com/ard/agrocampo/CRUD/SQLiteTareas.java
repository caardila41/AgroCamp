package com.ard.agrocampo.CRUD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQLiteTareas extends SQLiteOpenHelper {

    private String  sql="create table tareas(idTarea int primary key autoincrement,nombre varchar(50),fechadesde date,fechahasta date,descripcion text) ";


    public SQLiteTareas(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
