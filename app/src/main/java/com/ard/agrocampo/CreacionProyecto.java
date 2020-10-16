package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class CreacionProyecto extends AppCompatActivity {

    SearchView srv;
    ListView lst;
    ArrayList<String> List;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_proyecto);
    }

    public  void  volver(View view){
        Intent i=new Intent(this, Inicio.class);
        startActivity(i);
        srv=(SearchView)findViewById(R.id.buscardor);
        lst=(ListView)findViewById(R.id.lista);
        List=new ArrayList<String>();

        List.add("Papa");
        List.add("Tomate");
        List.add("Bovinos");
        List.add("Equinos");
        List.add("Porcionos");
        List.add("Gallinas");
        List.add("Pollos");
        List.add("Bovinos");
        List.add("Cabras");
        List.add("Zanahoria");


        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lst);
        lst.setAdapter(adapter);
        srv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
            adapter.getFilter().filter(s);
                return false;
            }
        });




    }


}