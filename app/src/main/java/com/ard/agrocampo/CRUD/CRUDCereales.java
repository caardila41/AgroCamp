package com.ard.agrocampo.CRUD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;

import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.Clases.Fecha;

import java.util.ArrayList;

public class CRUDCereales{

    AdministradorSQLite adm;


    public CRUDCereales(Context context){
        adm = new AdministradorSQLite(context,"cultivos",null,1);

    }



    /////// REGISTRAT
    public void Registrar(Cultivos p, Context context){

        SQLiteDatabase BaseDatos = adm.getWritableDatabase();

        String descripcion = p.getDescripcion();
        String nombre = p.getNombre();
        String tipo = p.getTipo();

        int foto = p.getFoto();
        double area=p.getArea();
        int dia = p.getFechainicio().getDia();
        int mes =p.getFechainicio().getMes();
        int anno =p.getFechainicio().getAnno() ;

        String pnombre=p.getProyectoNombre();

        if (!descripcion.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty()  && !pnombre.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("descripcion",descripcion);
            registro.put("nombre",nombre);
            registro.put("tipo", tipo);
            registro.put("foto", foto);
            registro.put("area", area);
            registro.put("dia", dia);
            registro.put("mes", mes);
            registro.put("anno", anno);
            registro.put("NombreProyecto", pnombre);

            BaseDatos.insert("cereal",null,registro);
            BaseDatos.close();

            Toast.makeText(context,"Registrado",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context,"Digitar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar (Cultivos p, Context context){
        //AdministradorSQLite adm=  new AdministradorSQLite(this, "Empresa",null,1 );
        SQLiteDatabase BaseDatos =adm.getWritableDatabase();

        String descripcion = p.getDescripcion();
        String nombre = p.getNombre();
        String tipo = p.getTipo();
        String dia = String.valueOf(p.getFechainicio().getDia());
        String mes = String.valueOf(p.getFechainicio().getDia());
        String anno = String.valueOf(p.getFechainicio().getDia());
        String area=String.valueOf(p.getArea());
        String pnombre=p.getProyectoNombre();

        if (!descripcion.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty() && dia.isEmpty()&& mes.isEmpty() && anno.isEmpty() && area.isEmpty() && pnombre.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("nombre",nombre);
            registro.put("descripcion",descripcion);
            registro.put("tipo", tipo);
            registro.put("dia", dia);
            registro.put("anno", anno);
            registro.put("mes", mes);
            registro.put("area", area);
            registro.put("NombreProyecto", pnombre);

            int cont =BaseDatos.update("cereal",registro, "NombreProyecto="+pnombre, null);
            BaseDatos.close();

            if (cont==1){
                Toast.makeText(context, "Modicación realizada",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "No existe el articulo",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(context, "Digitar los campos",Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar (EditText nombre , EditText precio, String codigo, Context context){

        SQLiteDatabase BaseDatos =adm.getWritableDatabase();
        if(!codigo.isEmpty() ){
            //Verificar consulta
            Cursor fila= BaseDatos.rawQuery("select nombre, precio from articulos where codigo ="+codigo,null);
            if(fila.moveToFirst()){
                nombre.setText(fila.getString(0));
                precio.setText(fila.getString(1));
                BaseDatos.close();

            }else{
                Toast.makeText(context, "No existe el producto",Toast.LENGTH_SHORT).show();
                BaseDatos.close();
            }

        }else {
            Toast.makeText(context, "Digitar el campo de código",Toast.LENGTH_SHORT).show();
        }

    }

    public void Eliminar (Cultivos p, Context context){
        SQLiteDatabase BaseDatos =adm.getWritableDatabase();

        String pnombre =p.getProyectoNombre();
        String tipo =p.getTipo();
        if(!pnombre.isEmpty() ){
            int cont= BaseDatos.delete(tipo,"NombreProyecto="+pnombre,null);
            BaseDatos.close();

            if(cont ==1){
                Toast.makeText(context, "Articulo eliminado",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Articulo no existe",Toast.LENGTH_SHORT).show();
            }

        }else
            Toast.makeText(context, "Digitar el código",Toast.LENGTH_SHORT).show();
    }


    public ArrayList<Cultivos> Cargar(){
        SQLiteDatabase BaseDatos =adm.getReadableDatabase();
        //Verificar consulta
        Cursor fila= BaseDatos.rawQuery("select * from cereal",null);
      ArrayList<Cultivos> lista=new ArrayList<>();
        Cultivos cul=null;



      while (fila.moveToNext()){


          Fecha fecha=new Fecha();
          fecha.setDia(fila.getInt(6));
          fecha.setMes(fila.getInt(7));
          fecha.setAnno(fila.getInt(9));
          cul=new Cultivos(fila.getString(1),fila.getString(2),fila.getString(3),fila.getInt(4),fila.getDouble(5),fecha,fila.getString(9));
         lista.add(cul);
      }
       //     Toast.makeText(context, "Entro",Toast.LENGTH_SHORT).show();
            BaseDatos.close();

      return  lista;
        }
}

