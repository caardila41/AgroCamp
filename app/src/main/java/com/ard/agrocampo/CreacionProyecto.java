package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class CreacionProyecto extends AppCompatActivity {

    SearchView srv;
    RecyclerView lst;
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
        lst=(RecyclerView) findViewById(R.id.lista);





    }


}