package com.ard.agrocampo.CRUD;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdministradorSQLite extends SQLiteOpenHelper {


    public AdministradorSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table cereal(codigo INTEGER PRIMARY KEY AUTOINCREMENT , descripcion text,  nombre text,tipo text, foto integer, area real,dia integer,mes integer, anno integer,NombreProyecto text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}