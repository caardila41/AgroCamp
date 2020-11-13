package com.ard.agrocampo.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ard.agrocampo.Clases.Cultivos;

import com.ard.agrocampo.FragmentsProcesos.ListaGestionFragment;
import com.ard.agrocampo.FragmentsProcesos.PlanFragment;
import com.ard.agrocampo.Interfaces.IComunicaCultivos;
import com.ard.agrocampo.R;

public class GestionActivity extends AppCompatActivity implements IComunicaCultivos  {

    ListaGestionFragment gestionFragment;
    PlanFragment plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        gestionFragment=new ListaGestionFragment();


        getSupportFragmentManager().beginTransaction().add(R.id.ContenerdorFragments,gestionFragment).commit();

    }


    @Override
    public void enviarCultivo(Cultivos cultivos) {
        plan=new PlanFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable("objeto",cultivos);
        plan.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.ContenerdorFragments,plan).addToBackStack(null).commit();

    }
}