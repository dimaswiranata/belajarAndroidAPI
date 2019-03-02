package com.anangkur.belajarandroid.API;

import com.anangkur.belajarandroid.model.RespondAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("top-headlines?country=us&apiKey=261d82dd7e26494e841fb1039a4fdaf7")
    Call<RespondAPI>getAllData();
}
