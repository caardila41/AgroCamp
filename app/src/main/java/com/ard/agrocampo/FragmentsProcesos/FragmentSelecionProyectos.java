package com.ard.agrocampo.FragmentsProcesos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ard.agrocampo.Proceso;
import com.ard.agrocampo.R;
import com.ard.agrocampo.RecyclerAdapater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSelecionProyectos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSelecionProyectos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerproductos;

    ArrayList<Proceso>  procesos;
    public FragmentSelecionProyectos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSelecionProyectos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSelecionProyectos newInstance(String param1, String param2) {
        FragmentSelecionProyectos fragment = new FragmentSelecionProyectos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista=inflater.inflate(R.layout.fragment_selecion_proyectos, container, false);

        procesos=new ArrayList<>();


        recyclerproductos=vista.findViewById(R.id.lista);

        recyclerproductos.setLayoutManager(new LinearLayoutManager(getContext()));


        llnearlista();

        RecyclerAdapater adapater=new RecyclerAdapater(procesos);
        adapater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"birnd",Toast.LENGTH_SHORT).show();

            }
        });
        recyclerproductos.setAdapter(adapater);




        return vista;
    }

    private void llnearlista() {

        procesos.add(new Proceso("trigo","","Cereal",R.drawable.trigo));
        procesos.add(new Proceso("Maiz","","Cereal",R.drawable.maiz));
        procesos.add(new Proceso("Cebada","","Cereal",R.drawable.cebada));



    }
}