package com.ard.agrocampo.ui.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ard.agrocampo.Clases.Cultivos;
import com.ard.agrocampo.R;
import java.util.ArrayList;

public class AdapterRecyclerGestion  extends RecyclerView.Adapter<AdapterRecyclerGestion.ViewHolderGestion> implements  View.OnClickListener{



    ArrayList<Cultivos> cultivos;
    private View.OnClickListener listener;


    public AdapterRecyclerGestion(ArrayList<Cultivos> cultivos) {
        this.cultivos = cultivos;
    }

    @NonNull
    @Override
    public ViewHolderGestion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproceso,null,false);
        view.setOnClickListener(this);
        return new ViewHolderGestion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGestion holder, int position) {

        holder.asigarnardatos(cultivos.get(position));



    }

    @Override
    public int getItemCount() {

        return cultivos.size();
    }

    public  void setOnClickListener(View.OnClickListener Listener){
        this.listener=Listener;
    }

    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }


    }

    public class ViewHolderGestion extends RecyclerView.ViewHolder {

        ImageView fotoProducto;
        TextView descripcion,nombre;


        public ViewHolderGestion(@NonNull View itemView) {
            super(itemView);

            fotoProducto=(ImageView) itemView.findViewById(R.id.imgenProducto);
            descripcion=(TextView) itemView.findViewById(R.id.descripcionP);
            nombre=(TextView)itemView.findViewById(R.id.nombreProyecto);


        }

        public void asigarnardatos(Cultivos cultivos) {

            fotoProducto.setImageResource(cultivos.getFoto());
            descripcion.setText(cultivos.getDescripcion());
            nombre.setText(cultivos.getProyectoNombre());

        }
    }
}
