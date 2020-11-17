package com.ard.agrocampo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.ard.agrocampo.Activitys.GestionActivity;
import com.ard.agrocampo.Activitys.NewProjects;
import com.ard.agrocampo.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
Button btnNewP,btnGestionP,btnAsist,btntiendas;
ImageButton btnAsisV, btnNoticias;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnNewP=(Button) root.findViewById(R.id.crearProyecto);
        btnGestionP=(Button)root.findViewById(R.id.gestionProyecto);




        btnGestionP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), GestionActivity.class);
                startActivity(i);
            }
        });


        btnNewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), NewProjects.class);
                startActivity(i);
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAsist=(Button) view.findViewById(R.id.btnAsistente);
        btntiendas=(Button) view.findViewById(R.id.btntienda);

        btnAsist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.asistente_Fragment);
            }
        });

        btntiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.tiendaFragment);

            }
        });
    }



}