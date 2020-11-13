package com.ard.agrocampo.FragmentsProcesos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ard.agrocampo.CRUD.CRUDCereales;
import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.Clases.Proceso;
import com.ard.agrocampo.R;
import com.ard.agrocampo.ui.Adaptadores.AdapterRecyclerGestion;
import com.ard.agrocampo.ui.Adaptadores.RecyclerAdapater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaGestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaGestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    RecyclerView recyclerproductos;
    ArrayList<Cultivos> cultivos;

    CRUDCereales crudCereales;
    public ListaGestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaGestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaGestionFragment newInstance(String param1, String param2) {
        ListaGestionFragment fragment = new ListaGestionFragment();
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

        View vista=inflater.inflate(R.layout.fragment_lista_gestion, container, false);


;

        recyclerproductos=vista.findViewById(R.id.ListaGestion);

        recyclerproductos.setLayoutManager(new LinearLayoutManager(getContext()));
        cultivos=new ArrayList<>();
        crudCereales=new CRUDCereales(getContext());

        cultivos=crudCereales.Cargar();

        if(!cultivos.isEmpty()){
            AdapterRecyclerGestion adapater=new AdapterRecyclerGestion(cultivos);


            recyclerproductos.setAdapter(adapater);
        }

        // Inflate the layout for this fragment
        return vista;




    }


}