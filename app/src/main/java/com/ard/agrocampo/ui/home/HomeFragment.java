package com.ard.agrocampo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ard.agrocampo.AsistenteVirtual;
import com.ard.agrocampo.CreacionProyecto;
import com.ard.agrocampo.Noticias;
import com.ard.agrocampo.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
Button btnNewP;
ImageButton btnAsisV, btnNoticias;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnNewP=(Button) root.findViewById(R.id.crearProyecto);





        btnNewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), CreacionProyecto.class);
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


}