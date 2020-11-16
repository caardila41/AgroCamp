package com.ard.agrocampo.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.Clases.Fecha;
import com.ard.agrocampo.Clases.Tarea;

import java.util.ArrayList;

public class CRUDTarea {

    SQLiteTareas admTareas;

    public CRUDTarea(Context context) {

        admTareas = new SQLiteTareas(context,"cultivos",null,1);
    }

    public void RegistrarTarea(Tarea t, Context context){

        SQLiteDatabase BaseDatos = admTareas.getWritableDatabase();

        String descripcion = t.getDescripcion();
        String nombre = t.getNombre();



        int diadesde=t.getFechaDesde().getDia();
        int mesdesde=t.getFechaDesde().getMes();
        int aniodesde=t.getFechaDesde().getAnno();

        int diahasta=t.getFechaHasta().getDia();
        int meshasta=t.getFechaHasta().getMes();
        int aniohasta=t.getFechaHasta().getAnno();

        if (!descripcion.isEmpty() && !nombre.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("descripcion",descripcion);
            registro.put("nombre",nombre);

            registro.put("diadesde",diadesde);
            registro.put("mesdesde",mesdesde);
            registro.put("aniodesde",aniodesde);

            registro.put("diahasta", diahasta);
            registro.put("meshasta", meshasta);
            registro.put("aniohasta",aniohasta);


            BaseDatos.insert("tareas",null,registro);
            BaseDatos.close();

            Toast.makeText(context,"Registrado",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context,"Digitar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }

    public void Cargar(Fecha f, ArrayAdapter<String>  adapter, ListView lista, Context context) {
        SQLiteDatabase BaseDatos = admTareas.getWritableDatabase();
        //Verificar consulta
            int numFecha=f.getAnno()+f.getMes()+f.getDia();

        try {
            Cursor fila = BaseDatos.rawQuery("select * from tareas", null);
            int dd,md,ad,dh,mh,ah;
             String descripcion,name;

            while (fila.moveToNext()) {


                name=fila.getString(1);

                dd=fila.getInt(2);
                md=fila.getInt(3);
                ad=fila.getInt(4);

                int numDesde=ad+md+dd;

                dh=fila.getInt(5);
                mh=fila.getInt(6);
                ah=fila.getInt(7);

                int numHasta=ah+mh+dh;

                descripcion=fila.getString(8);
                if(numDesde<=numFecha && numHasta>=numFecha){


                    adapter.add(name+" desde "+ad+"/"+md+"/"+dd+" hasta "+ah+"/"+mh+"/"+dh+" descripción "+descripcion);

                    lista.setAdapter(adapter);
                }


            }
            //     Toast.makeText(context, "Entro",Toast.LENGTH_SHORT).show();
            BaseDatos.close();
        }catch (Exception e){
            Toast.makeText(context,"Error "+ e.getMessage(),Toast.LENGTH_LONG).show();
        }



    }




}
