package com.example.quranapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("quran/id.indonesian")
    Call getData();

    @GET("quran/quran-uthmani")
    Call getDataArab();

    @GET("quran/{lang}")
    Call getCek (@Path("lang") String lang);

    @GET("surah/1/id.indonesian")
    Call getSuratTerjemahan (/*@Path("id")int id*/);

    //id.indonesian.
}
