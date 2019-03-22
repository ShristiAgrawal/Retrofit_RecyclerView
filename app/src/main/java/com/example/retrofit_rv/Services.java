package com.example.retrofit_rv;

import com.google.gson.annotations.Expose;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {
    @GET("/photos")
   Call <List<RetroPhoto>> getphoto();
}
