package com.ard.agrocampo.ui.Noticias.Models;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ard.agrocampo.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.ard.agrocampo.R;
import com.ard.agrocampo.Utils;
import com.ard.agrocampo.ui.Noticias.Models.Articulo;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Articulo> articulos;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public Adapter(List<Articulo> articulos, Context context) {
        this.articulos = articulos;
        this.context = context;
    }

    public MyViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view , onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder  holders, int position) {
        final MyViewHolder holder = holders;
        Articulo model = articulos.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);

        holder.titulo.setText(model.getTitulo());
        holder.desc.setText(model.getDescripcion());
        holder.fuente.setText(model.getFuente().getNombre());
        holder.time.setText("\u2022"+ Utils.DateToTimeFormat(model.getPublicado()));
        holder.publicado_a.setText(Utils.DateFormat(model.getPublicado()));
        holder.autor.setText(model.getAutor());

    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnItemClick(View view , int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView titulo, desc, autor, publicado_a, fuente,time;
        ImageView imageView;
        ProgressBar progressBar;
        OnItemClickListener onItemClickListener;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(this);
            titulo = itemView.findViewById(R.id.titulo);
            desc = itemView.findViewById(R.id.desc);
            autor = itemView.findViewById(R.id.autor);
            publicado_a = itemView.findViewById(R.id.publicado);
            fuente = itemView.findViewById(R.id.fuente);
            time= itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.img);
            progressBar=itemView.findViewById(R.id.progress_circular);

            this.onItemClickListener= this.onItemClickListener;

        }

        @Override
        public void onClick(View view) {

            onItemClickListener.OnItemClick(view,getAdapterPosition());

        }
    }
}

