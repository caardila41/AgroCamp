package com.ard.agrocampo.ui.Tienda;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ard.agrocampo.R;
import com.ard.agrocampo.ui.Asistente.Words;
import com.ard.agrocampo.ui.Asistente.WordsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductosAdapter  extends RecyclerView.Adapter<ProductosAdapter.ViewHolderproductos>implements View.OnClickListener {

    ArrayList<Catalogo> listaproductos;
    private ArrayList <Catalogo> OriginalproItems;
    private View.OnClickListener listenerproductos;

    public ProductosAdapter(ArrayList<Catalogo> listaproductos) {
        this.listaproductos = listaproductos;
        this.OriginalproItems= new ArrayList<>();//Almacenera en el listado original
        OriginalproItems.addAll(listaproductos);
    }

    @NonNull
    @Override
    public ProductosAdapter.ViewHolderproductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tienda, null, false);

        v.setOnClickListener(this);

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
        return listaproductos.size();
    }

    public void setOnClickListener(View.OnClickListener listenerproductos){
        this.listenerproductos=listenerproductos;
    }

    @Override
    public void onClick(View v) {
        if(listenerproductos!=null) {
            listenerproductos.onClick(v);
        }
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


    //Recibira lo que se escribira en el SearchView
    public void filterproductos ( String strSearchp){
        if (strSearchp.length()==0){
            listaproductos.clear();
            listaproductos.addAll(OriginalproItems);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Catalogo> collect = OriginalproItems.stream()
                        .filter(i -> i.getNombreproducto().toLowerCase().contains(strSearchp))
                        .collect(Collectors.toList());//El collect devuelve listado de items

                listaproductos.clear();
                listaproductos.addAll(collect);
            }else {
                //Recorre el listado
                listaproductos.clear();
                for(Catalogo i : OriginalproItems){
                    if(i.getNombreproducto().toLowerCase().contains(strSearchp)){
                        listaproductos.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

}
