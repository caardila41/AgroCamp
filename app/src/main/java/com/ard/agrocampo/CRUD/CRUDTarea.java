package com.ard.agrocampo.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.Clases.Tarea;

public class CRUDTarea {

    SQLiteTareas admTareas;

    public CRUDTarea(Context context) {
        admTareas = new SQLiteTareas(context,"cultivos",null,1);
    }

    public void RegistrarTarea(Tarea t, Context context){

        SQLiteDatabase BaseDatos = admTareas.getWritableDatabase();

        String descripcion = t.getDescripcion();
        String nombre = t.getNombre();
        String fechaDesde=t.getFechaDesde().toString();
        String fechaHasta=t.getFechaDesde().toString();
        if (!descripcion.isEmpty() && !nombre.isEmpty() && !fechaDesde.isEmpty()  && !fechaHasta.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("descripcion",descripcion);
            registro.put("nombre",nombre);
            registro.put("fechadesde", fechaDesde);
            registro.put("fechahasta", fechaHasta);


            BaseDatos.insert("tareas",null,registro);
            BaseDatos.close();

            Toast.makeText(context,"Registrado",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context,"Digitar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }




}
