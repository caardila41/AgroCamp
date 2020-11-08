package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ard.agrocampo.FragmentsProcesos.FragmentCereales;
import com.ard.agrocampo.FragmentsProcesos.FragmentSelecionProyectos;

public class NewProjects extends AppCompatActivity implements IComunicacionFragment{

    FragmentSelecionProyectos SelecionFragment;
    FragmentCereales parametrosCereales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_projects);

        SelecionFragment=new FragmentSelecionProyectos();


        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFrgaments,SelecionFragment).commit();



    }

    @Override
    public void enviarProducto(Proceso proceso) {
parametrosCereales=new FragmentCereales();
Bundle bundle=new Bundle();
bundle.putSerializable("objeto",proceso);
parametrosCereales.setArguments(bundle);


//cargar fragment

        getSupportFragmentManager().beginTransaction().replace(R.id.ContenedorFrgaments,parametrosCereales).addToBackStack(null).commit();

    }
}