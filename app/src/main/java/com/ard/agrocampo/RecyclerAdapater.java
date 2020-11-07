package com.ard.agrocampo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.ViewHolder> implements Filterable,View.OnClickListener {
private static final String TAG="RegistrarCorreo";



    ArrayList<Proceso>  procesos;


    private  View.OnClickListener listener;

    public RecyclerAdapater(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    @NonNull
    @Override



    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,null,false);
        ViewHolder viewHolder=new ViewHolder(view);

        view.setOnClickListener(this);



        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.producto.setText(procesos.get(position).getNombre());
        holder.tipo.setText(procesos.get(position).getTipo());
        holder.imageView.setImageResource(procesos.get(position).getFoto());


    }


    public  void setOnClickListener(View.OnClickListener Listener){
        this.listener=Listener;
    }
    @Override
    public int getItemCount() {

        return procesos.size();
    }

   /* @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter=new Filter() {

        //atras
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<String> filtered=new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filtered.addAll(productoslista);

            }else {
                for (String product: productoslista){
                    if(product.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filtered.add(product);
                    }
                }

            }
            
            FilterResults filterResults=new FilterResults();
            filterResults.values=filtered;

            return filterResults;
        }
//UI
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            productoslista.clear();
            productoslista.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();

        }
    };*/

    @Override
    public void onClick(View v) {


        if(listener!=null){
            listener.onClick(v);
        }

    }

    @Override
    public Filter getFilter() {
        return null;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
