package com.ard.agrocampo.ui.Asistente;

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

import java.util.ArrayList;

public class Asistente_Fragment extends Fragment {

    private AsistenteViewModel mViewModel;
    private WordsAdapter wordsAdapater;
    RecyclerView recyclerView;


    public static Asistente_Fragment newInstance() {
        return new Asistente_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root= inflater.inflate(R.layout.asistente__fragment, container, false);

        recyclerView=(RecyclerView) root.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Se llena la lista
        ArrayList<Words> myDataset =new ArrayList<>();

        myDataset.add(new Words("Especialidad","1"));
        myDataset.add(new Words("Agricultura","2"));
        myDataset.add(new Words("Productos","3"));
        myDataset.add(new Words("Campo","4"));
        myDataset.add(new Words("Desarrollo","5"));
        myDataset.add(new Words("Cultivos","6"));
        myDataset.add(new Words("Produccion","7"));

        //Especificar un adaptador donde se presentara como va a lucir la lista
        wordsAdapater = new WordsAdapter(myDataset);
        recyclerView.setAdapter(wordsAdapater);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AsistenteViewModel.class);
        // TODO: Use the ViewModel
    }

}