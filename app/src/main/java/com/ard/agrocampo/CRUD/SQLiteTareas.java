package com.ard.agrocampo.CRUD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQLiteTareas extends SQLiteOpenHelper {

  //  private String  sql="create table tareas(idTarea int primary key autoincrement,nombre varchar(50),fechadesde date,fechadesde,descripcion text) ";


    public SQLiteTareas( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

db.execSQL("create table tareas(idTarea INTEGER primary key autoincrement,nombre text, diadesde int,mesdesde int, aniodesde int, diahasta int,meshasta int,aniohasta int, descripcion text) ");    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
