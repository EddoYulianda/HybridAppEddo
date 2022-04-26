package com.eddo.hybridappeddo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    private static final String baseURL = "https://eddoyulianda.000webhostapp.com/";
    private static Retrofit retrofit = null;

    public static SelectAPI getselectAPI(){
        if (retrofit == null){

            retrofit =new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(SelectAPI.class);

    }
}
