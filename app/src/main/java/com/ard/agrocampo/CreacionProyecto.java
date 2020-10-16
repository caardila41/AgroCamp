package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

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
        recyclerAdapater=new RecyclerAdapater(prodiuctos);


        // recyclerView.setLayoutManager();

        recyclerView.setAdapter(recyclerAdapater);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

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


}