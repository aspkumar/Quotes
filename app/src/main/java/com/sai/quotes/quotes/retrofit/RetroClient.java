package com.sai.quotes.quotes.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.Retrofit.Builder;

public class RetroClient {
 
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://api.myjson.com";
 
    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
 
    /**
     * Get API Service
     *
     * @return API Service
     */
    public static PictureInterface getApiService() {
        return getRetrofitInstance().create(PictureInterface.class);
    }
}