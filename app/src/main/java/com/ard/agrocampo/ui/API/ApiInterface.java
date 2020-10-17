package com.ard.agrocampo.ui.API;

import com.ard.agrocampo.ui.Noticias.Models.News;
import com.ard.agrocampo.ui.Noticias.Models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Encabezado")
    Call<News> getNews(

            @Query("pais") String pais,
            @Query("clave") String apikey
    );
}
Sl