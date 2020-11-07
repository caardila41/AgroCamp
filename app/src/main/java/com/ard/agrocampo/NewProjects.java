package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ard.agrocampo.FragmentsProcesos.FragmentSelecionProyectos;

public class NewProjects extends AppCompatActivity {

    FragmentSelecionProyectos SelecionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_projects);

        SelecionFragment=new FragmentSelecionProyectos();

        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFrgaments,SelecionFragment).commit();



    }
}