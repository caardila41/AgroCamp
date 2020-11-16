package com.ard.agrocampo.ui.Tienda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ard.agrocampo.R;
import com.ard.agrocampo.ui.Asistente.WordsAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductosAdapter  extends RecyclerView.Adapter<ProductosAdapter.ViewHolderproductos> {

    ArrayList<Catalogo> listaproductos;

    public ProductosAdapter(ArrayList<Catalogo> listaproductos) {
        this.listaproductos = listaproductos;
    }

    @NonNull
    @Override
    public ProductosAdapter.ViewHolderproductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tienda, null, false);

        return new ViewHolderproductos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosAdapter.ViewHolderproductos holder, int position) {
        holder.nombreproducto.setText(listaproductos.get(position).getNombreproducto());
        holder.precio.setText(listaproductos.get(position).getPrecio());
        holder.categoria.setText(listaproductos.get(position).getCategoria());
        holder.calidad.setRating(listaproductos.get(position).getCalidad());
        holder.imagenproducto.setImageResource(listaproductos.get(position).getFotoproducto());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderproductos extends RecyclerView.ViewHolder {
        public TextView nombreproducto;
        public TextView precio;
        public TextView categoria;
        public RatingBar calidad;
        public ImageButton imagenproducto;

        public ViewHolderproductos(@NonNull View itemView) {
            super(itemView);
            nombreproducto=(TextView) itemView.findViewById(R.id.nproducto);
            precio=(TextView) itemView.findViewById(R.id.idprecio);
            categoria=(TextView) itemView.findViewById(R.id.idcategoria);
            calidad=(RatingBar) itemView.findViewById(R.id.idcalidad);
            imagenproducto =(ImageButton) itemView.findViewById(R.id.idimageproducto);

        }
    }
}
