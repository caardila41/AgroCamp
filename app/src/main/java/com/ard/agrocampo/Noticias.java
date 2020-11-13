package com.ard.agrocampo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.ard.agrocampo.Activitys.MainActivity;
import com.ard.agrocampo.ui.API.ApiClient;
import com.ard.agrocampo.ui.API.ApiInterface;
import com.ard.agrocampo.ui.Noticias.Models.Adapter;
import com.ard.agrocampo.ui.Noticias.Models.Articulo;
import com.ard.agrocampo.ui.Noticias.Models.News;

import java.util.ArrayList;
import java.util.List;

public class Noticias extends AppCompatActivity {

    public static final String API_KEY="7b03f4766f6b4b999477297a7c4ada8a";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Articulo> articulos = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);
        layoutManager= new LinearLayoutManager(Noticias.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        Load();
    }

    public void Load (){

        ApiInterface apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        String country = Utils.getCountry();

        Call<News> call;
        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticulos() != null){
                    if(!articulos.isEmpty()){
                        articulos.clear();
                    }

                    articulos= response.body().getArticulos();
                    adapter = new Adapter(articulos, Noticias.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } else{
                    Toast.makeText(Noticias.this, "No hay resultado",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }
}