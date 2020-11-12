package com.ard.agrocampo.ui.Asistente;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ard.agrocampo.R;

import java.util.ArrayList;

public class Asistente_Fragment extends Fragment {

    private AsistenteViewModel mViewModel;
    private RecyclerView recyclerView;
    //private SearchView Search;
    ArrayList<Words> myDataset;


    public static Asistente_Fragment newInstance() {
        return new Asistente_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.asistente__fragment, container, false);

        recyclerView=(RecyclerView) root.findViewById(R.id.reyclerview);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Search= (SearchView) root.findViewById(R.id.Search);
        //initListener();


        //Se llena la lista
        myDataset=new ArrayList<>();

        myDataset.add(new Words("Cosecha","1"));
        myDataset.add(new Words("Agricultura","2"));
        myDataset.add(new Words("Productos","3"));
        myDataset.add(new Words("Campo","4"));
        myDataset.add(new Words("Desarrollo","5"));
        myDataset.add(new Words("Cultivos","6"));
        myDataset.add(new Words("Produccion","7"));

        //Especificar un adaptador donde se presentara como va a lucir la lista
        WordsAdapter wordsAdapater = new WordsAdapter(myDataset);
        recyclerView.setAdapter(wordsAdapater);
        return root;
    }

    /*public void initListener(){
        Search.setOnQueryTextListener(this);  }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AsistenteViewModel.class);
        // TODO: Use the ViewModel
    }
/*
    //Se ejecutara cuando se seleccione enter
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    //Detecta la letra en el searchView
    @Override
    public boolean onQueryTextChange(String newText) {
        //wordsAdapater.filter(newText);
        return false;
    }*/
}