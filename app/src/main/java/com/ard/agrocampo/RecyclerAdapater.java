package com.ard.agrocampo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.ViewHolder> {
private static final String TAG="RegistrarCorreo";


    List<String> productos;

    public RecyclerAdapater(List<String> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override



    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.productos,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);



        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.producto.setText(productos.get(position));
    }

    @Override
    public int getItemCount() {

        return productos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView producto,tipo;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.imagePro);
            producto=itemView.findViewById(R.id.tvproducto);
            tipo=itemView.findViewById(R.id.tvtipo);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
