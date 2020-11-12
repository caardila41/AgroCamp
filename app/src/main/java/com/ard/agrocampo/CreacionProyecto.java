package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.ard.agrocampo.ui.Adaptadores.RecyclerAdapater;

import java.util.ArrayList;
import java.util.List;


public class CreacionProyecto extends AppCompatActivity {

    SearchView srv;
    RecyclerView recyclerView;
    RecyclerAdapater recyclerAdapater;

    List<String> prodiuctos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_proyecto);
        srv=(SearchView)findViewById(R.id.buscardor);
        recyclerView=(RecyclerView) findViewById(R.id.lista);
        recyclerView.setHasFixedSize(true);

        prodiuctos=new ArrayList<>();



        // recyclerView.setLayoutManager();

        recyclerView.setAdapter(recyclerAdapater);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerAdapater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"BIen pelao",Toast.LENGTH_SHORT).show();
            }
        });

        prodiuctos.add("Arroz");
        prodiuctos.add("Papa");
        prodiuctos.add("Cerdos");
        prodiuctos.add("Vacas");
        prodiuctos.add("Pollos");
        prodiuctos.add("Gallinas");
        prodiuctos.add("Manzanas");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");
        prodiuctos.add("Arroz");




    }

    public  void  volver(View view){
        Intent i=new Intent(this, Inicio.class);
        startActivity(i);


    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.buscado_productos,menu);
        MenuItem item=menu.findItem(R.id.action_search);
         SearchView searchView=(SearchView) item.getActionView();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String s) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 //recyclerAdapater.getFilter().filter(newText);
                 return false;
             }
         });

        return super.onCreateOptionsMenu(menu);
    }*/
}