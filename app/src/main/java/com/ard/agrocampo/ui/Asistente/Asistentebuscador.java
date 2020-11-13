package com.ard.agrocampo.ui.Asistente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ard.agrocampo.R;

public class Asistentebuscador extends AppCompatActivity implements IComunicaFragments{

    Asistente_Fragment fragmentasistente;
    Detallepalabrafragment detallepalabrafragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistentebuscador);

        fragmentasistente=new Asistente_Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_view_tag,fragmentasistente).commit();
    }

    @Override
    public void enviardatos(Words words) {
        detallepalabrafragment= new Detallepalabrafragment();
        Bundle bundleEnvio= new Bundle();
        bundleEnvio.putSerializable("objeto",words);
        detallepalabrafragment.setArguments(bundleEnvio);

        //cargar Fragment en el activity

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,detallepalabrafragment).addToBackStack(null).commit();
    }
}