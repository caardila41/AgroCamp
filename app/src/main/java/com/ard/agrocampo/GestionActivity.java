package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ard.agrocampo.FragmentsProcesos.FragmentSelecionProyectos;
import com.ard.agrocampo.FragmentsProcesos.ListaGestionFragment;

public class GestionActivity extends AppCompatActivity {

    ListaGestionFragment gestionFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        gestionFragment=new ListaGestionFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.ContenerdorFragments,gestionFragment).commit();

    }
}