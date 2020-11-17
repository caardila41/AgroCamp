package com.ard.agrocampo.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    public ArrayList<String[]> Cargar(Fecha f, ArrayAdapter<String>  adapter, ListView lista, Context context) {
        SQLiteDatabase BaseDatos = admTareas.getWritableDatabase();
        //Verificar consulta
            int numFecha=f.getAnno()+f.getMes()+f.getDia();
            ArrayList<String[]> dato=new ArrayList<>();


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


                    String aux1=String.valueOf(dd);
                    String aux2=String.valueOf(md);
                    String aux3=String.valueOf(ad);
                    String aux4=String.valueOf(dh);
                    String aux5=String.valueOf(mh);
                    String aux6=String.valueOf(ah);






                    String item[]=new String[]{name,aux1,aux2,aux3,aux4,aux5,aux6,descripcion};
                    dato.add(item);

                }


              }
            //     Toast.makeText(context, "Entro",Toast.LENGTH_SHORT).show();
            BaseDatos.close();
        }catch (Exception e){

            Toast.makeText(context,"Error "+ e.getMessage(),Toast.LENGTH_LONG).show();

        }
        lista.setAdapter(adapter);

        return  dato;

    }

        public ArrayList<String[]> borrarTareas(Context context,ArrayAdapter<String>  adapter,ArrayList<String[]> datos,String aux2,ListView lista,Fecha f,int p){
            SQLiteDatabase BaseDatos = admTareas.getWritableDatabase();
        //String sql="delete  from tareas where nombre = "+datos.get(p)[0]+" and diadesde = "+datos.get(p)[1]+" and mesdesde = "+datos.get(p)[2]+" and aniodesde = "+datos.get(p)[3]+" and diahasta = "+datos.get(p)[4]+" and meshasta = "+datos.get(p)[5]+" and aniohasta = "+datos.get(p)[6]+" and descripcion = "+datos.get(p)[7];
            int numFecha=f.getAnno()+f.getMes()+f.getDia();
            ArrayList<String[]> dato=new ArrayList<>();
            BaseDatos.delete("tareas","nombre = '"+datos.get(p)[0]+"' and diadesde = '"+datos.get(p)[1]+"' and mesdesde = '"+datos.get(p)[2]+"' and aniodesde = '"+datos.get(p)[3]+"' and diahasta = '"+datos.get(p)[4]+"' and meshasta = '"+datos.get(p)[5]+"' and aniohasta = '"+datos.get(p)[6]+"' and descripcion = '"+datos.get(p)[7]+"'",null);
         try {


                  adapter.remove(aux2);


             Cursor fila = BaseDatos.rawQuery("select * from tareas", null);
             int dd,md,ad,dh,mh,ah;
             String descripcion,name;


              lista.setAdapter(adapter);
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

                     String aux1=String.valueOf(dd);
                     String aux22=String.valueOf(md);
                     String aux3=String.valueOf(ad);
                     String aux4=String.valueOf(dh);
                     String aux5=String.valueOf(mh);
                     String aux6=String.valueOf(ah);


                     String item[]=new String[]{name,aux1,aux22,aux3,aux4,aux5,aux6,descripcion};
                     dato.add(item);

                 }

             }



         }catch (Exception e){

             Toast.makeText(context,"Error "+ e.getMessage(),Toast.LENGTH_LONG).show();

         }
            BaseDatos.close();
            return  dato;
        }



}
