package com.ard.agrocampo.ui.Asistente;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ard.agrocampo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {
    private ArrayList<Words> mDataset;
    private ArrayList <Words> OriginalItems;


    public WordsAdapter(ArrayList<Words> mDataset) {
        this.mDataset = mDataset;
        this.OriginalItems= new ArrayList<>();//Almacenera en el listado original
        OriginalItems.addAll(mDataset);
    }

    //Enlazar adpatador con el archivo item_palabras

    @NonNull
    @Override
    public WordsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_palabras, null, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.MyViewHolder holder, int position) {
        holder.numerobusqueda.setText(mDataset.get(position).getNumerobusqueda());
        holder.palabra.setText(mDataset.get(position).getPalabra());
    }

    //Retorna el tamaño del Dataset
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
          public TextView numerobusqueda;
          public TextView palabra;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numerobusqueda=(TextView) itemView.findViewById(R.id.Numerobusqueda);
            palabra=(TextView) itemView.findViewById(R.id.Palabra);
        }

    }


    //Recibira lo que se escribira en el SearchView
    public void filter( String strSearch){
        if (strSearch.length()==1){
            mDataset.clear();
            mDataset.addAll(OriginalItems);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Words> collect = OriginalItems.stream()
                        .filter(i -> i.getPalabra().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());//El collect devuelve listado de items

                mDataset.clear();
                mDataset.addAll(collect);
            }else {
                //Recorre el listado
                mDataset.clear();
                for(Words i : OriginalItems){
                    if(i.getPalabra().toLowerCase().contains(strSearch)){
                        mDataset.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

}
