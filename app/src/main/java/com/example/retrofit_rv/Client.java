package com.example.retrofit_rv;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Retrofit retrofit;
private static String base_url="https://api.themoviedb.org/3/";

public static Retrofit getinstance(){
    if (retrofit == null) {
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
   // return retrofit;
  //  if(retrofit==null)
    //    retrofit=new retrofit2.Retrofit.Builder().baseUrl(base_url).addConverterFactory(new GsonConverterFactory().create()).build();
}
}
