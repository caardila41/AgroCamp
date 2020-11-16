package com.ard.agrocampo.ui.Tienda;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ard.agrocampo.R;
import com.ard.agrocampo.ui.Asistente.WordsAdapter;

import java.util.ArrayList;

public class TiendaFragment extends Fragment {

    private TiendaViewModel mViewModel;
    ArrayList<Catalogo> listaproductos;
    private ProductosAdapter productosAdapter;
    RecyclerView recyclerT;

    public static TiendaFragment newInstance() {
        return new TiendaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

         View root =inflater.inflate(R.layout.tienda_fragment, container, false);
         recyclerT=(RecyclerView) root.findViewById(R.id.reyclerview);
         recyclerT.setLayoutManager(new LinearLayoutManager(getContext()));


        //Se llena la lista
        listaproductos=new ArrayList<>();

        listaproductos.add(new Catalogo("Fertilizante","73800","Productos",9 ,R.drawable.fertilizante) );
        listaproductos.add(new Catalogo("Cinta Riego","26800","Productos",9 ,R.drawable.cintariego) );
        listaproductos.add(new Catalogo("Semilla maíz","23000","Semillas",9 ,R.drawable.semillamaiz) );
        listaproductos.add(new Catalogo("Semilla Trigo","12000","Semillas",9 ,R.drawable.semillatrigo) );


        productosAdapter = new ProductosAdapter(listaproductos);
        recyclerT.setAdapter(productosAdapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TiendaViewModel.class);
        // TODO: Use the ViewModel
    }

}