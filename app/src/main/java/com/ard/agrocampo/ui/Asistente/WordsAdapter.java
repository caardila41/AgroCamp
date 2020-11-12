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

import androidx.recyclerview.widget.RecyclerView;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {
    private ArrayList<Words> mDataset;
    //private ArrayList <Words> OriginalItems;

    /*public WordsAdapter(ArrayList<Words> mDataset, ArrayList<Words> originalItems) {
        this.mDataset = mDataset;
       // OriginalItems = originalItems;
    }*/

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView numerobusqueda;
        public TextView palabra;

        public MyViewHolder(View v) {
            super(v);
            numerobusqueda=(TextView) v.findViewById(R.id.Numerobusqueda);
            palabra=(TextView) v.findViewById(R.id.Palabra);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WordsAdapter(ArrayList<Words> myDataset) {
        mDataset = myDataset;
    }


   /* public void filter( String strSearch){
        if (strSearch.length()==0){
            mDataset.clear();
            mDataset.addAll(OriginalItems);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Words> collect = mDataset.stream().filter(i -> i.getNumerobusqueda().toLowerCase().contains(strSearch))
                                 .collect(Collectors.toList());

                mDataset.clear();
                mDataset.addAll(collect);
            }else {
                //Recorre el listado
                mDataset.clear();
                for(Words i : OriginalItems){
                    if(i.getNumerobusqueda().toLowerCase().contains(strSearch)){
                        mDataset.add(i);
                    }
                }
            }
        }
    }*/



    // Create new views (invoked by the layout manager)
    @Override
    public WordsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_palabras, null, false);

        //MyViewHolder vh = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.numerobusqueda.setText(mDataset.get(position).getNumerobusqueda());
        holder.palabra.setText(mDataset.get(position).getPalabra());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
