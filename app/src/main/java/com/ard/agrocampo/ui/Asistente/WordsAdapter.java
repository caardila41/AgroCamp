package com.ard.agrocampo.ui.Asistente;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ard.agrocampo.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {
    private ArrayList<Words> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Numerobusqueda;
        public TextView Palabra;

        public MyViewHolder(View v) {
            super(v);
            Numerobusqueda=(TextView) v.findViewById(R.id.Numerobusqueda);
            Palabra=(TextView) v.findViewById(R.id.Palabra);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WordsAdapter(ArrayList<Words> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WordsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_words, parent, false);

        //MyViewHolder vh = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.Numerobusqueda.setText(mDataset.get(position).getNumerobusqueda());
        holder.Palabra.setText(mDataset.get(position).getPalabra());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
